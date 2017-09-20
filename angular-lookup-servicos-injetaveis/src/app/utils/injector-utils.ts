import { Injectable, Injector, Type, InjectionToken } from '@angular/core';

@Injectable()
export class InjectorUtils {

    private static instance: Injector;

    public static lookup<T>(token: Type<T> | InjectionToken<T>, notFoundValue?: T): T {
        if (!InjectorUtils.instance) {
            throw new Error('You must set an Injector instance before try lookup a dependency!');
        }
        return InjectorUtils.instance.get(token, notFoundValue);
    }

    public setInstance(instance: Injector): void {
        if (!instance) {
            throw new Error('You cannot set a null instance of Injector!');
        }

        if (!!InjectorUtils.instance) {
            throw new Error('Another instance of Injector is already registred!');
        }

        InjectorUtils.instance = instance;
    }

}
