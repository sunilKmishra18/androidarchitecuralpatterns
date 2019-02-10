package com.sunilmishra.android.androidcleanarchitecturedemo.presentation.internal.di.modules;

import android.content.Context;
import com.sunilmishra.android.androidcleanarchitecturedemo.data.cache.UserCache;
import com.sunilmishra.android.androidcleanarchitecturedemo.data.cache.UserCacheImpl;
import com.sunilmishra.android.androidcleanarchitecturedemo.data.executor.JobExecutor;
import com.sunilmishra.android.androidcleanarchitecturedemo.data.repository.UserDataRepository;
import com.sunilmishra.android.androidcleanarchitecturedemo.domain.executor.PostExecutionThread;
import com.sunilmishra.android.androidcleanarchitecturedemo.domain.executor.ThreadExecutor;
import com.sunilmishra.android.androidcleanarchitecturedemo.domain.repository.UserRepository;
import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.AndroidApplication;
import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.UIThread;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
  private final AndroidApplication application;

  public ApplicationModule(AndroidApplication application) {
    this.application = application;
  }

  @Provides @Singleton Context provideApplicationContext() {
    return this.application;
  }

  @Provides @Singleton ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
    return jobExecutor;
  }

  @Provides @Singleton PostExecutionThread providePostExecutionThread(UIThread uiThread) {
    return uiThread;
  }

  @Provides @Singleton UserCache provideUserCache(UserCacheImpl userCache) {
    return userCache;
  }

  @Provides @Singleton UserRepository provideUserRepository(UserDataRepository userDataRepository) {
    return userDataRepository;
  }
}
