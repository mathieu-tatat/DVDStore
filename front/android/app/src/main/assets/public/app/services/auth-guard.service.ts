import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{



  constructor(private authService: AuthService, private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    if (this.authService.isAuthenticated()) {
      return true; // L'utilisateur est authentifié, permet d'accéder à la route
    } else {
      this.router.navigate(['/login']); // Redirige vers la page de connexion si l'utilisateur n'est pas authentifié
      return false; // Empêche l'accès à la route
    }
  }
}
