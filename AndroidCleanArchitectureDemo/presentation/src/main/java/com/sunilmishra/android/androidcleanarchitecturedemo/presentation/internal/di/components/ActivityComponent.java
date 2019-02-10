package com.sunilmishra.android.androidcleanarchitecturedemo.presentation.internal.di.components;

import android.app.Activity;
import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.internal.di.PerActivity;
import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.internal.di.modules.ActivityModule;
import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation:
 * {@link com.sunilmishra.android.androidcleanarchitecturedemo.presentation.internal.di.PerActivity}
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
interface ActivityComponent {
  //Exposed to sub-graphs.
  Activity activity();
}
