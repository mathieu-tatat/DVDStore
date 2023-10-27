import { Component } from '@angular/core';
import { AuthService, RecupTokenRoleDto } from '../services/auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';


export interface retour{

  token: string;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  retour: any | undefined;
  
  constructor(private authService: AuthService, private router: Router , private http: HttpClient ) {}

  send = (form: NgForm) => {
    if (form.valid) {
      this.authService.send(form.value).subscribe(
        (response: RecupTokenRoleDto) => {
          console.log("connexion réussie");
          sessionStorage.setItem('token', response.token);
          this.router.navigate(['/home']);
          console.log(response.token);
          console.log(response.role);
        },
        (error) => {
          console.log(error);
          console.log("connexion échouée");
        }
    )}
  }

  logout() {
    this.authService.logout();
    // Redirigez l'utilisateur vers la page de connexion ou une autre page après la déconnexion
    this.router.navigate(['/login']);
  }
}
