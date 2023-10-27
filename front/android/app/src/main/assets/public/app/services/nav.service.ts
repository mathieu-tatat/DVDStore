import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class NavService {


  constructor(private http: HttpClient, private authService: AuthService) { }
  logout() {
    sessionStorage.removeItem('token');
  }
}
