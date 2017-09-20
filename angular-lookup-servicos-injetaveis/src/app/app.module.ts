import { NgModule, Injector } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { RestangularModule } from 'ngx-restangular';

import { AppComponent } from './app.component';
import { ProdutoService } from './services/produto.service';
import { InjectorUtils } from './utils/injector-utils';

export function setupRestangular(provider: any) {
    provider.setBaseUrl('http://localhost:8080/api/');
}

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        RestangularModule.forRoot(setupRestangular),
    ],
    providers: [
        InjectorUtils,
        ProdutoService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {

    constructor(injectorUtils: InjectorUtils, injector: Injector) {
        injectorUtils.setInstance(injector);
    }

}
