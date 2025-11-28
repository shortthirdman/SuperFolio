import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'welcome-tour',
  templateUrl: './welcome-tour.component.html',
  styleUrls: ['./welcome-tour.component.scss']
})
export class WelcomeTourComponent implements OnInit {
  
  readonly appTitle: string = 'MyProfile';

  constructor() { }

  ngOnInit(): void {
  }

}
