package com.safeway.scanandgo.di.modules;

import android.content.Context;

import com.safeway.scanandgo.ScanAndGoApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    Context provideContext(ScanAndGoApp application) {
        return application.getApplicationContext();
    }

}
