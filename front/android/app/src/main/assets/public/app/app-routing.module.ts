import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NewdvdComponent } from './newdvd/newdvd.component';
import { LoginComponent } from './login/login.component';
import { AuthGuardService } from './services/auth-guard.service';



const routes: Routes = [
  {path:'',redirectTo:'home',pathMatch:'full'},
  {path:'home',component:HomeComponent},
  {path:'newdvd',component:NewdvdComponent, canActivate: [AuthGuardService]},
  {path:'newdvd/:id',component:NewdvdComponent, canActivate: [AuthGuardService]},
  {path:'login',component:LoginComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
