import { Component, EventEmitter, Output, Input } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { KeyService } from '@services/key';
import { ErrorMessageProvider } from '@components/util';
import { UserService } from '@services/user';

function nextYear() {
  const d = new Date();
  return new Date(d.getFullYear() + 1, d.getMonth(), d.getDate());
}

function emptyGMT(date) {
  if (!date) {
    return;
  }
  return new Date(date.valueOf() - date.getTimezoneOffset() * 60000);
}

@Component({
  selector: 'key-card-create',
  templateUrl: './index.html'
})
export class KeyCreateCardComponent extends ErrorMessageProvider {

  formLocked = false;

  @Input()
  userId: string;

  @Output()
  reset = new EventEmitter;

  @Output()
  create = new EventEmitter<ApiKeyObject>();

  keyName = new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(30)]);

  startDate = nextYear();

  expiration = new FormControl(null, []);

  setAsDefault = false;

  constructor(private keyService: KeyService, private userService: UserService) {
    super();
  }

  async createKey() {
    this.formLocked = true;
    const name = this.keyName.value;
    const expiration = +emptyGMT(this.expiration.value);

    const newKey = await this.keyService.create(this.userId, { name, expiration });

    if (this.setAsDefault) {
      await this.userService.update(this.userId, { defaultKeyId: newKey.id });
    }

    this.formLocked = false;
    this.keyName.reset();
    this.reset.emit();
    this.create.emit(newKey);
  }

  cancelKey() {
    this.keyName.reset();
    this.reset.emit();
  }

}
