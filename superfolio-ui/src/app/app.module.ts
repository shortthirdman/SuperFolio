import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule, DatePipe } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { VendorModule } from './vendor.module';
import { ComingSoonComponent } from './coming-soon/coming-soon.component';
import { WelcomeTourComponent } from './welcome-tour/welcome-tour.component';
import { SuperFolioComponent } from './super-folio/super-folio.component';

@NgModule({
  declarations: [
    AppComponent,
    ComingSoonComponent,
    WelcomeTourComponent,
    SuperFolioComponent
  ],
  exports: [
    ComingSoonComponent,
    WelcomeTourComponent,
    SuperFolioComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    VendorModule
  ],
  providers: [DatePipe],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  bootstrap: [AppComponent]
})
export class AppModule { }
