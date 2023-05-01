import { Component, OnDestroy, OnInit } from '@angular/core';

import AOS from "aos";
import _ from 'lodash';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy {

  constructor() {
    AOS.init();
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
  }
}
