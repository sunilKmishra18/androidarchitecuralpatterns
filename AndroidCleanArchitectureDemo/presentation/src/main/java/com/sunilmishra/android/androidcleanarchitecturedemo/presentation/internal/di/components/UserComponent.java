package com.sunilmishra.android.androidcleanarchitecturedemo.presentation.internal.di.components;

import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.internal.di.PerActivity;
import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.internal.di.modules.ActivityModule;
import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.internal.di.modules.UserModule;
import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.view.fragment.UserDetailsFragment;
import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.view.fragment.UserListFragment;
import dagger.Component;

/**
 * A scope {@link com.sunilmishra.android.androidcleanarchitecturedemo.presentation.internal.di.PerActivity} component.
 * Injects user specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent {
  void inject(UserListFragment userListFragment);
  void inject(UserDetailsFragment userDetailsFragment);
}
