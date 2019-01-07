import { BadRequest } from 'http-errors';
import * as Router from 'koa-router';

import { validate } from '../schemas';
import { getServerEventListByType, getAllServerEvents, getServerEventById } from '../../controllers/server-event';
import { serializeServerEvent } from '../serialize/server-event';
import { events as eventsConfig } from '../../config';

const vid = validate.param('id', 'uuid');

const serverEventTypes = eventsConfig.typesEnum;

/**
 * ServerEvent
 * Request handlers for logged server events token.
 * @swagger
 *  tags: [ServerEvent]
 */

const router = new Router({ prefix: '/server-event' });

/**
 * @route: /api-token/list
 * @swagger
 *  operationId: getServerEventList
 */
router.get('/list', async function (ctx) {
  const type = (ctx.query.type || '').toLowerCase() || null;

  if (type && !serverEventTypes.includes(type)) {
    throw new BadRequest(`Type must be one of ${serverEventTypes.join(', ')}`);
  }

  const ops = { };

  const events = await (type ? getServerEventListByType(type, ops) : getAllServerEvents(ops));
  ctx.body = events.map(serializeServerEvent);
});

/**
 * @route: /api-token/{id}
 * @swagger
 *  operationId: getServerEventById
 */
router.get('/:id', vid, async function (ctx) {
  const { id } = ctx.params;
  const event = await getServerEventById(id);
  ctx.body = serializeServerEvent(event);
});

export { router };
