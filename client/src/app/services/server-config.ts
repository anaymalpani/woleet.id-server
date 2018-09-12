import { Injectable, OnDestroy } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { serverURL } from '@services/config';
import { Observable, BehaviorSubject } from 'rxjs';
import * as log from 'loglevel';
import { KeyService } from '@services/key';

@Injectable()
export class ServerConfigService {

  private isConfigSet = false;

  private _lock = 0;
  private isDoingSomething$: BehaviorSubject<boolean>;

  private config$: BehaviorSubject<ApiServerConfig> = null;

  private defaultKeyId: string;
  private defaultKey$: BehaviorSubject<ApiKeyObject>;

  private defaultKeyOwnerId: string;
  private defaultKeyOwner$: BehaviorSubject<ApiUserObject>;

  constructor(
    private http: HttpClient,
    private keyService: KeyService
  ) {
    this.config$ = new BehaviorSubject(null);
    this.config$.subscribe((cfg) => {
      log.debug('SUSCRIBED CONFIG', cfg);
      if (cfg && cfg.defaultKeyId) {
        this.setDefaultKey(cfg.defaultKeyId);
        this.setDefaultKeyOwner(cfg.defaultKeyId);
      }
    });

    this.isDoingSomething$ = new BehaviorSubject(false);

    this.defaultKey$ = new BehaviorSubject(null);
    this.defaultKey$.subscribe((e) => {
      log.debug('SUSCRIBED DEFAULT KEY', e);
    });

    this.defaultKeyOwner$ = new BehaviorSubject(null);
    this.defaultKeyOwner$.subscribe((e) => {
      log.debug('SUSCRIBED DEFAULT KEY OWNER', e);
    });
  }

  getConfig(): Observable<ApiServerConfig> {

    log.debug('getConfig');

    if (!this.isConfigSet) {
      log.debug('getConfig fisrt time');
      this.incrLock();
      const init$ = this.http.get<ApiServerConfig>(`${serverURL}/server-config`);
      init$.subscribe((up) => {
        log.debug('initialised', up);
        this.decrLock();
        this.config$.next(up);
      });
      this.isConfigSet = true;
    }

    log.debug('getConfig is set');

    return this.config$.asObservable();
  }

  private setDefaultKey(defaultKeyId) {
    if (defaultKeyId !== this.defaultKeyId) {
      this.incrLock();
      this.defaultKey$.next(null);
      this.keyService.getById(defaultKeyId)
        .then((key) => {
          this.defaultKey$.next(key);
          this.defaultKeyId = key.id;
        })
        .catch(() => {
          this.defaultKey$.next(null);
          this.defaultKeyId = null;
        })
        .then(() => this.decrLock());
    }
  }

  private setDefaultKeyOwner(defaultKeyId) {
    this.incrLock();
    this.defaultKeyOwner$.next(null);
    this.keyService.getOwner(defaultKeyId)
      .then((user) => {
        this.defaultKeyOwner$.next(user);
        this.defaultKeyOwnerId = user.id;
      })
      .catch(() => {
        this.defaultKey$.next(null);
        this.defaultKeyId = null;
      })
      .then(() => this.decrLock());
  }

  update(config: ApiServerConfigUpdate): void {
    this.incrLock();
    this.http.put<ApiServerConfig>(`${serverURL}/server-config`, config)
      .subscribe((up) => {
        this.decrLock();
        log.debug('updated', up);
        this.config$.next(up);
      });
  }

  isDoingSomething(): Observable<boolean> {
    return this.isDoingSomething$.asObservable();
  }

  getDefaultKey(): Observable<ApiKeyObject> {
    return this.defaultKey$.asObservable();
  }

  getDefaultKeyOwner(): Observable<ApiUserObject> {
    return this.defaultKeyOwner$.asObservable();
  }

  private incrLock() {
    this.isDoingSomething$.next(++this._lock !== 0);
  }

  private decrLock() {
    this.isDoingSomething$.next(--this._lock !== 0);
  }

}
