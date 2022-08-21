import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGardGuard implements CanActivate {
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.isAuthorized(route);
  }
  private isAuthorized(router:ActivatedRouteSnapshot):boolean{

    const roles=['Author']
    const expetedRoules=router.data.expetedRoules;
    const roleMatch=roles.findIndex(role=> expetedRoules.indexOf(-1));
    return (roleMatch < 0)? false : true;

  }
}
