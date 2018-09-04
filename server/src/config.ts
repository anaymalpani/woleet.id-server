// tslint:disable:radix

const env = process.env;

const defaultPort = parseInt(env.WOLEET_ID_SERVER_DEFAULT_PORT) || 3000;

export const ports = {
  signature: parseInt(env.WOLEET_ID_SERVER_SIGNATURE_PORT) || defaultPort,
  identity: parseInt(env.WOLEET_ID_SERVER_IDENTITY_PORT) || defaultPort,
  api: parseInt(env.WOLEET_ID_SERVER_API_PORT) || defaultPort
};

export const db = {
  host: env.POSTGRES_HOST || 'localhost',
  database: env.POSTGRES_DB || 'wid',
  username: env.POSTGRES_USER || 'pguser',
  password: env.POSTGRES_PASSWORD || 'pass'
};