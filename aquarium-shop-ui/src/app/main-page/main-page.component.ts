import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {

  chosenTab: string = "";

  constructor() { }

  ngOnInit(): void {
  }

  onChoose(tab: string) {
      this.chosenTab = tab;
  }

}
