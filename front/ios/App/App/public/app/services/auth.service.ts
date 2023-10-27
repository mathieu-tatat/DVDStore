import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, map } from 'rxjs';

export interface AuthRequestDto{
  username: string;
  password: string;
  role: string;
}

export interface RecupTokenRoleDto{
  token: string;
  role: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  response: {token: string} | undefined;
  private loggedIn = new BehaviorSubject<boolean>(false);

  constructor(private http: HttpClient) { 
    this.loggedIn.next(this.getToken() !== null);
  }

  send(authRequest: AuthRequestDto): Observable<RecupTokenRoleDto> {
    return this.http.post(`http://localhost:80/authorize`, authRequest).pipe(
      map((response: any) => {
        return response as RecupTokenRoleDto;

      })
    );
  }

  logout() {
    sessionStorage.removeItem('token');
    this.loggedIn.next(false);
  }

  getToken(): string | null {
    return sessionStorage.getItem('token');
  }

  isAuthenticated(): Observable<boolean> {
    return this.loggedIn.asObservable();
  }
}

