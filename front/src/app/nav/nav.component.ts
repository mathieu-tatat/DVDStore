import { Component, OnInit } from '@angular/core';

export interface Dvd{  
  name : string,
  genre : string,
  quantity : number,
  prix: number; 
  photo: string;
  id? : number,
}
@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit{
[x: string]: any;

  constructor() { 
  }
  
  ngOnInit() {
  }

}
