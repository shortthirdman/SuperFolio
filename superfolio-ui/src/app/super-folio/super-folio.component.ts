import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'super-folio',
  templateUrl: './super-folio.component.html',
  styleUrls: ['./super-folio.component.scss']
})
export class SuperFolioComponent implements OnInit {

  constructor() {
    const bodyTag = document.getElementsByTagName('body').item(0);
    bodyTag.id = "top";
  }

  ngOnInit(): void {
  }

}
