import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NewdvdComponent } from './newdvd/newdvd.component';
import { Router } from '@angular/router';



const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'newdvd',component:NewdvdComponent},
  {path:'newdvd/:id',component:NewdvdComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
