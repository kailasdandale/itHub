import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './Mycomponant/header/header.component';
import { AuthorComponent } from './Mycomponant/author/author.component';
import { NewauthorComponent } from './Mycomponant/newauthor/newauthor.component';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './Mycomponant/about/about.component';
import { WelcomeComponent } from './Mycomponant/welcome/welcome.component';
import { ReaderComponent } from './Mycomponant/reader/reader.component';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SearchComponent } from './Mycomponant/search/search.component';
import { AddBookComponent } from './Mycomponant/add-book/add-book.component';
import { FundsubscribebookComponent } from './Mycomponant/fundsubscribebook/fundsubscribebook.component';
import { HomeComponent } from './Mycomponant/home/home.component';
import { UpdateBookComponent } from './Mycomponant/update-book/update-book.component';
import { AuthGardGuard } from './auth-gard.guard';
 import { AuthInterceptor } from './interceptor/auth.interceptor';

const routes:Routes =[
 
  { path:'header',component:HeaderComponent},
  { path:'newauthor',component:NewauthorComponent},
  { path:'author',component:AuthorComponent},
  { path:'about',component:AboutComponent},
  { path:'welcome',component:WelcomeComponent},
  { path:'reader',component:ReaderComponent},
  { path:'reader/:id',component:ReaderComponent},
  { path:'search/:id',component:SearchComponent},
  {
     path:'addbook',component:AddBookComponent,
     canActivate:[AuthGardGuard],
     data:{
       expetedRoules:['Author']
     }
},
  { path:'home',component:HomeComponent},
  { path:'subscribe',component:FundsubscribebookComponent},
  { path:'updateBook',component:UpdateBookComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AuthorComponent,
    NewauthorComponent,
    AboutComponent,
    WelcomeComponent,
    ReaderComponent,
    SearchComponent,
    AddBookComponent,
    FundsubscribebookComponent,
    HomeComponent,
    UpdateBookComponent
    
  ],
  imports: [
    BrowserModule,HttpClientModule,RouterModule.forRoot(routes),FormsModule,ReactiveFormsModule
  ],
  providers: [
    // {
    //   provide:HTTP_INTERCEPTORS,
    //   useClass: AuthInterceptor,
    //   multi :true
    // }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
