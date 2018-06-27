import * as Joi from 'joi';

const userTypeEnum = ['user', 'admin'];
const userStatusEnum = ['active', 'blocked', 'removed'];

const Word = Joi.string().alphanum().min(3).max(30);
const RWord = Word.required();

const createUser = Joi.object().keys({
  type: Joi.string().valid(userTypeEnum),
  status: Joi.string().valid(userStatusEnum),
  email: Joi.string().email(),
  username: RWord,
  firstName: RWord,
  lastName: RWord,
  password: RWord
});

const updateUser = Joi.object().keys({
  type: Joi.string().valid(userTypeEnum),
  status: Joi.string().valid(userStatusEnum),
  email: Joi.string().email(),
  username: Word,
  firstName: Word,
  lastName: Word,
  password: Word
});

export { createUser, updateUser }