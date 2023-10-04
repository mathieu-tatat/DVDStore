import { Component, OnInit, OnChanges, Optional } from '@angular/core';
import { NewdvdService } from '../services/newdvd.service';
import { ActivatedRoute, Router } from '@angular/router';
import { filter } from 'rxjs';
import { NgForm } from '@angular/forms';

export interface Dvd{  
  name : string,
  genre : string,
  quantity : number,
  prix: number; 
  photo: string;
  description: string;
  pathPhoto: string;
  id? : number,
}

@Component({
  selector: 'app-newdvd',
  templateUrl: './newdvd.component.html',
  styleUrls: ['./newdvd.component.css']
})

export class NewdvdComponent implements OnInit {
  
  dvd: any = [];
  detail: any;
  
  constructor(private router: Router, private newDvdService: NewdvdService,private route:ActivatedRoute) { 
  
    this.router.events.subscribe( (val: any) => {
      if(val.url){
      var id = val.url.split('=')[1];
      this.detail=id;
      }});
  }

  isUpdate: boolean = false;
  ngOnInit(){

    if(this.detail){
      this.newDvdService.getDvdById(this.detail).subscribe(data=> {
      data.pathPhoto= data.pathPhoto ? data.pathPhoto.replace(/\\/g, '/') as string : undefined
      this.dvd = data;
    })}

    
  
    if(this.detail){

      this.isUpdate = true;
      
      this.newDvdService.getDvdById(Number(this.detail)).subscribe((dvd)=> {
        this.dvd = dvd;});
    }
  }

  formulaire(form: NgForm){
    console.log(form.value);
    if(form.valid){
      this.newDvdService.addOrUpdate(this.dvd).subscribe(()=> {
        console.log('dvd modifié');
        this.router.navigate(['/home']);
      });
    }else{
      
      this.newDvdService.addOrUpdate(this.dvd).subscribe(()=> {
        console.log('dvd ajouté');
        this.router.navigate(['/home']);
      } );
    }
  }


  ngOnInit1(){
    
  }

  filterById(){
  this.route.params.subscribe(params => {
    const id = params['id'];
    if(this.router.url.endsWith(id)){
      this.filterDvdsById(id);
    } else {
      "aucun dvd ne correspond à cet id"
  }
  });}

  filterDvdsById(id: number) {
    this.dvd = this.dvd.filter((dvd: Dvd) => dvd.id === id);
  }
  


deleteDvd(id: number) {
  this.newDvdService.delete(id)
  .subscribe(data => {
    console.log(data);
    this.ngOnInit();
  });
}



}

