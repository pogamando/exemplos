import { ProdutoService } from './services/produto.service';
import { Component } from '@angular/core';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {

    produto: any;

    constructor(private produtoService: ProdutoService) {
        this.produto = {};
    }

    public salvar(): void {
        this.produtoService.save(this.produto)
            .then(data => this.produto = data)
            .catch(err => console.log('Falha ao salvar!', err));
    }

    public cancelar(): void {
        this.produto = {};
    }

}
