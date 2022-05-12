 import { Routes } from '@angular/router';

import { DashboardComponent } from '../../pages/dashboard/dashboard.component';
import { IconsComponent } from '../../pages/icons/icons.component';
import { MapsComponent } from '../../pages/maps/maps.component';
import { UserProfileComponent } from '../../pages/user-profile/user-profile.component';
import { TablesComponent } from '../../pages/tables/tables.component';
import { ShowAllComponent } from '../../components/event/show-all/show-all.component';
import { ShowAllsComponent } from '../../components/competition/show-alls/show-alls.component';
import { AddCompComponent } from '../../components/competition/add-Comp/add-comp.component';
import { UpdateCompetitionComponent } from '../../components/competition/update-Competition/update-Competition.component';
import { RechercheParNomComponent } from '../../recherche-par-nom/recherche-par-nom.component';
import { AppsComponent } from '../../components/mail/apps/apps.component';
import { AddEventComponent } from '../../components/event/add-event/add-event.component';


export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard',      component: DashboardComponent },
    { path: 'user-profile',   component: UserProfileComponent },
    { path: 'tables',         component: TablesComponent },
    { path: 'icons',          component: IconsComponent },
    { path: 'maps',           component: MapsComponent },
    {path: "showAll", component : ShowAllComponent},
    {path: "showAlls", component : ShowAllsComponent},
    {path: "AddComp", component : AddCompComponent},
    {path: "AddEvent", component : AddEventComponent},
    {path:'competition/update-competition/:idCompetition', component: UpdateCompetitionComponent},
    {path: "rechercheParNom", component : RechercheParNomComponent},
    {path: "apps", component :AppsComponent },
];
