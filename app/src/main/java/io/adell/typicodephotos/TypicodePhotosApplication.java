package io.adell.typicodephotos;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.adell.typicodephotos.data.DataModule;
import io.adell.typicodephotos.di.AppComponent;
import io.adell.typicodephotos.di.DaggerAppComponent;

/**
 * Created by Adell on 9/24/2017.
 */

public class TypicodePhotosApplication extends DaggerApplication {

  @Override
  protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    AppComponent appComponent = DaggerAppComponent.builder()
        .application(this)
        .dataModule(new DataModule("http://jsonplaceholder.typicode.com"))
        .build();

    appComponent.inject(this);
    return appComponent;
  }
}
