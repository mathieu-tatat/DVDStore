import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router, UrlSegment } from '@angular/router';
import { Observable } from 'rxjs';


export interface DvdGetDto{
  name : string,
  genre : string,
  quantity : number,
  prix: number;
  photo: string;
  description: string;
  pathPhoto: string | undefined;
  id? : number,
}

@Injectable({
  providedIn: 'root'
})
export class NewdvdService {

  detail: any;
  constructor(private http: HttpClient, private router: Router) {

    this.router.events.subscribe( (val: any) => {
      if(val.url){
      var id = val.url.split('=')[1];
      this.detail=id;
      }});
      console.log(this.detail);
    }

  getDvdById(id: number): Observable<DvdGetDto>{
    return this.http.get<DvdGetDto>(`http://localhost:80/dvds/${id}`);
  }

  addOrUpdate(dvd: DvdGetDto): Observable<DvdGetDto>{
    if (this.detail){
      return this.update(dvd);
    } else {
      return this.add(dvd);
    }
  }

  private add(newDvd: DvdGetDto): Observable<DvdGetDto>{
    return this.http.post(`http://localhost:80/dvds`, newDvd ) as Observable<DvdGetDto>;
  }

  private update(dvd: DvdGetDto ): Observable<DvdGetDto>{ 
    return this.http.put(`http://localhost:80/dvds/${dvd.id}`, dvd)as Observable<DvdGetDto>;
  }

  delete(id: number): Observable<DvdGetDto[]>{
    return this.http.delete<DvdGetDto[]>(`http://localhost:80/dvds/delete/${id}`);
  }
}
