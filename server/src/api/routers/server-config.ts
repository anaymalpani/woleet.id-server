import * as Router from 'koa-router';
import * as body from 'koa-body';
import { BadRequest } from 'http-errors';
import { validate } from '../schemas';
import { getServerConfig, setServerConfig, updateTCU, defaultTCU } from '../../controllers/server-config';
import { store as event } from '../../controllers/server-event';
import { serializeServerConfig } from '../serialize/server-config';

/**
 * ServerConfig
 */

const router = new Router({ prefix: '/server-config' });

/**
 * @route: /config
 * @swagger
 *  operationId: getServerConfig
 */
router.get('/', function (ctx) {
  ctx.body = serializeServerConfig(getServerConfig());
});

/**
 * @route: /config
 * @swagger
 *  operationId: updateServerConfig
 */
router.put('/', validate.body('updateConfig'), async function (ctx) {
  let config;

  config = await setServerConfig(ctx.request.body);

  event.register({
    type: 'config.edit',
    authorizedUserId: ctx.session.user.get('id'),
    associatedTokenId: null,
    associatedUserId: null,
    associatedKeyId: null,
    data: ctx.request.body
  });

  ctx.body = serializeServerConfig(config);
});

router.post('/TCU', body({ multipart: true }), async function (ctx) {

  const file = ctx.request.files.file;
  try {
    await updateTCU(file);
  } catch {
    throw new BadRequest('Cannot upload this file');
  }

  event.register({
    type: 'config.edit',
    authorizedUserId: ctx.session.user.get('id'),
    associatedTokenId: null,
    associatedUserId: null,
    associatedKeyId: null,
    data: 'TCU updated'
  });

  ctx.body = { response: 'TCU updated' };
});

router.get('/TCU/default', async function (ctx) {

  await defaultTCU();

  event.register({
    type: 'config.edit',
    authorizedUserId: ctx.session.user.get('id'),
    associatedTokenId: null,
    associatedUserId: null,
    associatedKeyId: null,
    data: 'default TCU'
  });

  ctx.body = { response: 'default TCU' };
});

export { router };
