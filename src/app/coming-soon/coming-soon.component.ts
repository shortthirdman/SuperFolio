import { DOCUMENT } from '@angular/common';
import { Component, Inject, OnDestroy, OnInit, Renderer2 } from '@angular/core';

import _ from 'lodash';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'coming-soon',
  templateUrl: './coming-soon.component.html',
  styleUrls: ['./coming-soon.component.scss']
})
export class ComingSoonComponent implements OnInit, OnDestroy {

  private endDate: any;
  private timer: any;
  currentYear: string = new Date().getFullYear().toString();

  constructor(@Inject(DOCUMENT) private document: Document) {
    this.endDate = Date.parse(environment.launchDate);
    console.log("Timer ends on", new Date(this.endDate));
    console.log("Current time", new Date(Date.now()));
  }

  ngOnInit(): void {
    this.timer = setInterval(() => {
      let now = Date.now();

      let timeRemaining = this.endDate - now;

      let daysRemaining = Math.floor(timeRemaining / (1000 * 60 * 60 * 24));
      let hoursRemaining = Math.floor((timeRemaining % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      let minutesRemaining = Math.floor((timeRemaining % (1000 * 60 * 60)) / (1000 * 60));
      let secondsRemaining = Math.floor((timeRemaining % (1000 * 60)) / (1000));

      document.getElementById("days").innerHTML = daysRemaining >= 10 ? daysRemaining.toString() : `0${daysRemaining}`;
      document.getElementById("hours").innerHTML = hoursRemaining >= 10 ? hoursRemaining.toString() : `0${hoursRemaining}`;
      document.getElementById("minutes").innerHTML = minutesRemaining >= 10 ? minutesRemaining.toString() : `0${minutesRemaining}`;
      document.getElementById("seconds").innerHTML = secondsRemaining >= 10 ? secondsRemaining.toString() : `0${secondsRemaining}`;

      if (timeRemaining < 0) {
        clearInterval(this.timer);
        document.getElementById("days").innerHTML = '00';
        document.getElementById("hours").innerHTML = '00';
        document.getElementById("minutes").innerHTML = '00';
        document.getElementById("seconds").innerHTML = '00';
        console.log("Thank you for your patience");
      }
    }, 1000);
  }

  ngOnDestroy(): void {
    clearInterval(this.timer);
  }
}
