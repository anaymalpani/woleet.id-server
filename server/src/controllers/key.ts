import { Key } from "../database";
import { NotFoundKeyError } from "../errors";
import { Mnemonic, HDPrivateKey, KeyRing } from "bcoin";

/**
 * Key
 * Request handlers for key.
 * @alias module:handlers.Key
 * @swagger
 *  tags: [authentication]
 */

/**
 * @swagger
 *  operationId: addKey
 */
export async function createKey(userId: string, key: ApiPostKeyObject): Promise<InternalKeyObject> {

  // Get new phrase
  const mnemonic = new Mnemonic();

  // Create an HD private key
  const master = HDPrivateKey.fromMnemonic(mnemonic);
  const xkey = master.derivePath("m/44'/0'/0'");

  const ring = KeyRing.fromPrivate(xkey.privateKey, true);

  const publicKey = ring.getAddress('base58');
  const privateKey = ring.getPrivateKey().toString('hex');

  const newKey = await Key.create(Object.assign({}, key, {
    mnemonicEntropy: mnemonic.getEntropy().toString('hex'),
    privateKey,
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

  if (!key)
    throw new NotFoundKeyError();

  return key.toJSON();
}

export async function getKeyById(id: string): Promise<InternalKeyObject> {
  const key = await Key.getById(id);

  if (!key)
    throw new NotFoundKeyError();

  return key.toJSON();
}

export async function exportKey(id: string): Promise<string> {
  const key = await Key.getById(id);

  if (!key)
    throw new NotFoundKeyError();

  // Get key phrase phrase
  const mnemonic = Mnemonic.fromEntropy(Buffer.from(key.getDataValue('mnemonicEntropy'), 'hex'));

  return mnemonic.getPhrase()
}

export async function getAllKeys(): Promise<InternalKeyObject[]> {
  const keys = await Key.getAll();
  return keys.map((key) => key.toJSON());
}

export async function getAllKeysOfUser(userId: string, full: boolean): Promise<InternalKeyObject[]> {
  const keys = await Key.getAllKeysOfUser(userId, full);
  return keys.map((key) => key.toJSON());
}

export async function deleteKey(id: string): Promise<InternalKeyObject> {

  const key = await Key.delete(id);

  if (!key)
    throw new NotFoundKeyError();

  return key.toJSON();
}

