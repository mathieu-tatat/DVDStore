import { Component, OnInit } from '@angular/core';
import { NavService } from '../services/nav.service';
import { AuthService } from '../services/auth.service';

export interface Dvd{  
  name : string,
  genre : string,
  quantity : number,
  prix: number; 
  photo: string;
  id? : number,
}
export interface AuthRequestDto{
  password: string,
  username: string,
  id?: number,
}
export interface Response{
  token: string,
}

export interface RecupTokenRoleDto{
  token: string,
  role: string,
  id?: number,
}
@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})

export class NavComponent implements OnInit{
[x: string]: any;
user:any=[];
response!: { token: string; };

  isAuthenticated: boolean = false;

  constructor(private navService: NavService, private authService: AuthService) { 
  }
  
  ngOnInit() {
    this.authService.isAuthenticated().subscribe((auth: boolean)=>{
      this.isAuthenticated = auth;
    }
    );
  }

  logout() {
    this.authService.logout();
    // Redirigez l'utilisateur vers la page de connexion ou une autre page après la déconnexion
  
  }
}
