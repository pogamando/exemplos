import { InjectorUtils } from '../utils/injector-utils';
import { Restangular } from 'ngx-restangular';

export class CrudService {

    private _endpoint: Restangular;

    constructor(subResource: string) {
        const restangular = InjectorUtils.lookup(Restangular);
        this._endpoint = restangular.all(subResource);
    }

    public find(id: number | string): any {
        this.endpoint.get(id).toPromise();
    }

    public findAll(): any {
        this.endpoint.getList().toPromise();
    }

    public save(entity: any): any {
        if ('id' in entity) {
            return this.endpoint.customPUT(entity, entity.id).toPromise();
        }
        return this.endpoint.customPOST(entity).toPromise();
    }

    public delete(id: number | string): any {
        return this.endpoint.customDELETE(id).toPromise();
    }

    get endpoint() {
        return this._endpoint;
    }

}
