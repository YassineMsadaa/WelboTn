import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';
import { FormsModule } from '@angular/forms'
import { ShowAllComponent } from './components/event/show-all/show-all.component';
import { ShowAllsComponent } from './components/competition/show-alls/show-alls.component';

import { ReactiveFormsModule } from '@angular/forms';
import { AddCompComponent } from './components/competition/add-Comp/add-comp.component';
import { AddEventComponent } from './components/event/add-event/add-event.component';
import { UpdateCompetitionComponent } from './components/competition/update-Competition/update-Competition.component';
import { ShopComponent } from './shop/shop.component';
import { RechercheParCategorieComponent } from './recherche-par-categorie/recherche-par-categorie.component';
import { RechercheParNomComponent } from './recherche-par-nom/recherche-par-nom.component';
import { SearchFilterPipe } from './search-filter.pipe';
import { AppsComponent } from './components/mail/apps/apps.component';


@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ComponentsModule,
    NgbModule,
    RouterModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    AuthLayoutComponent,
    ShowAllComponent,
    ShowAllsComponent,
    AddCompComponent,
    UpdateCompetitionComponent,
    AddEventComponent,
    ShopComponent,
    RechercheParCategorieComponent,
    RechercheParNomComponent,
    AppsComponent,
    
    SearchFilterPipe
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
 


}
