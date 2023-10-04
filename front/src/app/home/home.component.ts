import { AfterContentInit, AfterViewInit, Component,OnChanges,OnInit, SimpleChanges } from '@angular/core';
import { HomeService } from '../services/home.service';
import { ActivatedRoute, Router } from '@angular/router';

export interface Dvd{  
  name : string,
  genre : string,
  quantity : number,
  prix: number; 
  photo: string;
  description: string;
  id? : number,
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent {

  dvds: any[] = []
  genre: string='';


  constructor(private router: Router, private homeService: HomeService, private route:ActivatedRoute,) {
    this.router.events.subscribe( (val: any) => {
      if(val.url){
      var genre1 = val.url.split('=')[1];
      this.genre=genre1;
      }});
      
    
  }
  
  ngAfterContentInit(): void {
    this.homeService.getAll().subscribe(data=> {
      this.dvds = data;
  
      this.dvds.map((dvds: any) => ({
        ...dvds,
        pathPhoto: dvds.pathPhoto ? dvds.pathPhoto.replace(/\\/g, '/') : undefined
      }));
      if(this.genre)
      this.filterDvdsByGenre(this.genre);   
    })
  }
  
  

filterByGenre() {
  
  this.route.params.subscribe(params => {
    const genre = params['genre'];
    if (this.router.url.endsWith(genre)){
      this.filterDvdsByGenre(genre);
      
    } else {
        "aucun dvd ne correspond à ce genre"
    }
  });
}

filterDvdsByGenre(genre: string) {
  console.log(genre);
  console.log(this.dvds);
this.dvds = this.dvds.filter(value => value.genre === genre);
}
    
}

/* a mettre dans une fonction qui capte les changements dans l'url
  this.dvds = this.dvds.filter((value) => {
    return value.genre === genre
  })
  */

/*
  ngOnInit() {
    this.homeService.getAll().subscribe(data=> {
      this.dvd = data;

      this.dvd.map((dvds: any) => ({
        ...dvds,
        pathPhoto: dvds.pathPhoto ? dvds.pathPhoto.replace(/\\/g, '/') : undefined
      
      }))
      ;
  
  }
  )
  }
*/