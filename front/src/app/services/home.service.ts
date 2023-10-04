import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Dvd{
  name : string,
  genre : string,
  quantity : number,
  prix: number;
  photo: string;
  description: string;
  id? : number,
}
@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient) { }



  
  getAll(): Observable<Array<Dvd>> {
  return this.http.get("http://localhost:80/dvds") as Observable<Array<Dvd>>;

  }

}
