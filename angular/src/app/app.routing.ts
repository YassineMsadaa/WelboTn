import { NgModule } from '@angular/core';
import { CommonModule, } from '@angular/common';
import { BrowserModule  } from '@angular/platform-browser';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { EvaluationComponent } from './evaluation/evaluation.component';
import { BadgesComponent } from './badges/badges.component';
import { ListVotesComponent } from './list-votes/list-votes.component';
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';
import { BadgesListComponent } from './badges-list/badges-list.component';
import { Badges } from './models/badges';
import { AddBadgesComponent } from './add-badges/add-badges.component';
const routes: Routes =[
  {path : 'evaluation', component : EvaluationComponent },
  {path : 'badges', component : BadgesComponent},
  { path: 'votes', component : ListVotesComponent },
  // {path: 'badgesList', component : BadgesListComponent},
  {path: 'badges', component : BadgesListComponent},
  {path: 'addbadges', component : AddBadgesComponent},
  {path: '', redirectTo: 'badges', pathMatch: 'full'},
  {
    path: '', redirectTo: 'dashboard', pathMatch: 'full',
  }, 

  {
    path: '', component: AdminLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: () => import('src/app/layouts/admin-layout/admin-layout.module').then(m => m.AdminLayoutModule)
      }
    ]
  }, {
    path: '', component: AuthLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: () => import('src/app/layouts/auth-layout/auth-layout.module').then(m => m.AuthLayoutModule)
      }
    ]
  },
  //  {
  //   path: '**',
  //   redirectTo: 'dashboard'
  // }
 ];

  @NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule.forRoot(routes,{
      useHash: true
    })
  ],
   exports: [ RouterModule
  ],
 })
export class AppRoutingModule { }
