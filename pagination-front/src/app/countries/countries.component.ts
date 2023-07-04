import { Component, OnInit } from '@angular/core';
import { CountriesService } from '../countries.service';

@Component({
  selector: 'app-countries',
  templateUrl: './countries.component.html',
  styleUrls: ['./countries.component.css']
})
export class CountriesComponent implements OnInit {

  countriesList: Array<any> = [];
  totalPages: Array<number> = [];

  page = 0;
  size = 10;
  order= 'id';
  asc  = true;

  isFirst = false;
  isLast = false;

  constructor(private countriesService: CountriesService) { }

  ngOnInit(): void {
    this.getCountries();
  }

  getCountries(){
    this.countriesService.countries(this.page, this.size, this.order, this.asc)
        .subscribe(data => {
          console.log(data.content);
          this.countriesList = data.content;
          this.isFirst = data.first;
          this.isLast = data.last;
          this.totalPages = new Array(data['totalPages']);
        }, err => {
          console.log(err);
        })
  }
  sort(): void {
    this.asc = !this.asc;
    this.getCountries();
  }

  back(){
    if(!this.isFirst){
      this.page--;
      this.getCountries();
    }
  }
  
  forward(){
    if(!this.isLast){
      this.page++;
      this.getCountries();
    }
  }
  
  setPage(page: number){
    this.page = page;
    this.getCountries()
  }
  
  setOrder(order: string){
    this.order = order;
    this.getCountries();
  }
}
