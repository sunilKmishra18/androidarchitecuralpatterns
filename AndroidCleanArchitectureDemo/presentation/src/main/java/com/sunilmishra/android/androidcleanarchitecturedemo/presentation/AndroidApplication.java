package com.sunilmishra.android.androidcleanarchitecturedemo.presentation;

import android.app.Application;

import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.BuildConfig;
import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.internal.di.components.ApplicationComponent;
import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.internal.di.components.DaggerApplicationComponent;
import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.internal.di.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Android Main Application
 */
public class AndroidApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override public void onCreate() {
    super.onCreate();
    this.initializeInjector();
    this.initializeLeakDetection();
  }

  private void initializeInjector() {
    this.applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  public ApplicationComponent getApplicationComponent() {
    return this.applicationComponent;
  }

  private void initializeLeakDetection() {
    if (BuildConfig.DEBUG) {
      LeakCanary.install(this);
    }
  }
}
