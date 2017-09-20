import { Injectable } from '@angular/core';
import { CrudService } from './crud.service';

@Injectable()
export class ProdutoService extends CrudService {

    constructor() {
        super('produto');
    }

}
