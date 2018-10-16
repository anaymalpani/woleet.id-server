import { Injectable } from '@angular/core';
import { Router, Params } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { serverURL } from './config';
import { BootService } from '@services/boot';


@Injectable({ providedIn: 'root' })
export class AuthService {

  private user: ApiUserDTOObject = null;

  constructor(
    private http: HttpClient,
    private router: Router,
    private bootService: BootService
  ) {

    const user = localStorage.getItem('user');

    if (user) {
      try {
        this.user = JSON.parse(user);
      } catch { }
    }
  }

  async logout(request = true) {
    this.user = null;
    localStorage.removeItem('user');
    if (request) {
      this.http.get(`${serverURL}/logout/`).toPromise().catch(() => null);
    }

    this.router.navigate(['login']);
    this.bootService.restart();
  }

  async login(user: BasicAuthObject): Promise<ApiUserDTOObject | null> {
    const headers = (new HttpHeaders()).append('Authorization', 'Basic ' + btoa(`${user.username}:${user.password}`));
    const auth: AuthResponseObject = await this.http.get<AuthResponseObject>(`${serverURL}/login/`, { headers })
      .toPromise()
      .catch(() => null);

    if (!auth) {
      return null;
    }

    this.user = auth.user;
    localStorage.setItem('user', JSON.stringify(auth.user));

    return this.user;
  }

  getUser(): ApiUserDTOObject {
    return this.user;
  }

  isAuthenticated(): boolean {
    return !!this.user;
  }

  isAdmin(): boolean {
    return this.isAuthenticated() && this.user.role === 'admin';
  }

  async openid() {
    document.location.href = `${serverURL}/oauth/login`;
  }

  async forwardOAuth(params: Params) {
    const auth: AuthResponseObject = await this.http.get<AuthResponseObject>(`${serverURL}/oauth/callback`, { params })
      .toPromise();

    if (!auth) {
      return null;
    }

    this.user = auth.user;
    localStorage.setItem('user', JSON.stringify(auth.user));

    return auth.user;
  }

}
