import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';
import { EvaluationComponent } from './evaluation/evaluation.component';
import { VotesComponent } from './votes/votes.component';
import { BadgesComponent } from './badges/badges.component';
import { ListVotesComponent } from './list-votes/list-votes.component';
import { BadgesListComponent } from './badges-list/badges-list.component';
import { AddBadgesComponent } from './add-badges/add-badges.component';


@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    ComponentsModule,
    NgbModule,
    RouterModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    AuthLayoutComponent,
    EvaluationComponent,
    BadgesComponent,
    VotesComponent,
    ListVotesComponent,
    BadgesComponent,
    BadgesListComponent,
    AddBadgesComponent
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
