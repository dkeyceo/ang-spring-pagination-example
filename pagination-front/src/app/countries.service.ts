import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CountriesService {

  countriesURL = 'http://localhost:8080/pages?'; 
  
  constructor(private http: HttpClient) { }

  public countries(page: number, size: number, order: string, asc: boolean) : Observable<any> {
    return this.http.get<any>(this.countriesURL + `page=${page}&size=${size}&order=${order}&asc=${asc}`);
  }
}
