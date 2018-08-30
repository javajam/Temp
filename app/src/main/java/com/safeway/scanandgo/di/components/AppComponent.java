package com.safeway.scanandgo.di.components;

import com.safeway.scanandgo.ScanAndGoApp;
import com.safeway.scanandgo.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AndroidSupportInjectionModule.class,
        AppModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(ScanAndGoApp application);
        AppComponent build();
    }

    void inject(ScanAndGoApp app);
}
