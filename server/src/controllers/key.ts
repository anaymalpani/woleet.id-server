import { Key, User } from '../database';
import { NotFoundKeyError, NotFoundUserError } from '../errors';
import { Mnemonic, HDPrivateKey, KeyRing } from 'bcoin';
import { encrypt, decrypt } from './utils/encryption';

/**
 * Key
 * Request handlers for key.
 * @alias module:handlers.Key
 * @swagger
 *  tags: [authentication]
 */

/**
 * @swagger
 *  operationId: createKey
 * TODO: move to secure module
 */
export async function createKey(userId: string, key: ApiPostKeyObject): Promise<InternalKeyObject> {

  // Get new phrase
  const mnemonic = new Mnemonic();

  // Create an HD private key
  const master = HDPrivateKey.fromMnemonic(mnemonic);
  const xkey = master.derivePath('m/44\'/0\'/0\'');

  const compressed = true;
  const ring = KeyRing.fromPrivate(xkey.privateKey, compressed);

  const publicKey = ring.getAddress('base58');
  const privateKey = ring.getPrivateKey();

  const encryptedEntropy = encrypt(mnemonic.getEntropy());
  const encryptedPrivateKey = encrypt(privateKey);

  const newKey = await Key.create(Object.assign({}, key, {
    mnemonicEntropy: encryptedEntropy.toString('hex'),
    privateKey: encryptedPrivateKey.toString('hex'),
    compressed,
    publicKey,
    userId
  }));

  return newKey.toJSON();
}

/**
 * @swagger
 *  operationId: logout
 */
export async function updateKey(id: string, attrs: ApiPutKeyObject) {
  const key = await Key.update(id, attrs);

  if (!key) {
    throw new NotFoundKeyError();
  }

  return key.toJSON();
}

export async function getKeyById(id: string): Promise<InternalKeyObject> {
  const key = await Key.getById(id);

  if (!key) {
    throw new NotFoundKeyError();
  }

  return key.toJSON();
}

export async function getOwner(id): Promise<InternalUserObject> {
  const key = await Key.getByIdAndPullUser(id);

  if (!key) {
    throw new NotFoundKeyError();
  }

  return key.get('user').toJSON();
}

export async function getOwnerByPubKey(pubKey): Promise<InternalUserObject> {
  const key = await Key.getByPubKey(pubKey, null, true);

  if (!key) {
    throw new NotFoundKeyError();
  }

  return key.get('user').toJSON();
}

/**
 * TODO: move to secure module
 */
export async function exportKey(id: string): Promise<string> {
  const key = await Key.getById(id);

  if (!key) {
    throw new NotFoundKeyError();
  }

  const entropy = decrypt(key.get('mnemonicEntropy'));

  // Get key mnemonic
  const mnemonic = Mnemonic.fromEntropy(entropy);

  // Return phrase
  return mnemonic.getPhrase();
}

export async function getAllKeys(full = false): Promise<InternalKeyObject[]> {
  const keys = await Key.getAll({ full });
  return keys.map((key) => key.toJSON());
}

export async function getAllKeysOfUser(userId: string, full = false): Promise<InternalKeyObject[]> {

  const user = await User.getById(userId);

  if (!user) {
    throw new NotFoundUserError();
  }

  const keys = await Key.getAllKeysOfUser(userId, full);

  return keys.map((key) => key.toJSON());
}

export async function deleteKey(id: string): Promise<InternalKeyObject> {

  const key = await Key.delete(id);

  if (!key) {
    throw new NotFoundKeyError();
  }

  return key.toJSON();
}

