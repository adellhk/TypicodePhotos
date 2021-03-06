package io.adell.typicodephotos.di;

import android.app.Application;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;
import io.adell.typicodephotos.TypicodePhotosApplication;
import io.adell.typicodephotos.data.DataModule;
import javax.inject.Singleton;

/**
 * Created by Adell on 9/24/2017.
 */

@Singleton
@Component(modules = {
    DataModule.class,
    ApplicationModule.class,
    ActivityBindingModule.class,
    AndroidSupportInjectionModule.class
})

public interface AppComponent extends AndroidInjector<DaggerApplication> {

  void inject(TypicodePhotosApplication application);

  @Override
  void inject(DaggerApplication instance);

  @Component.Builder
  interface Builder {

    @BindsInstance
    Builder application(Application application);

    Builder dataModule(DataModule dataModule);

    AppComponent build();
  }
}
