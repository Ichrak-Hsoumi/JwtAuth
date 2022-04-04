import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { ArticleListComponent } from './articles/article-list/article-list.component';
import { ArticleViewComponent } from './articles/article-view/article-view.component';
import { ArticleFormComponent } from './articles/article-form/article-form.component';
import { ArticleEditComponent } from './articles/article-edit/article-edit.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'articles', component: ArticleListComponent },
  { path: 'article/:articleId/view', component: ArticleViewComponent },
  { path: 'addArticle', component: ArticleFormComponent },
  { path: 'article/:articleId/edit', component: ArticleEditComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
