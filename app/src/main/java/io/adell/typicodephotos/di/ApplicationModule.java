package io.adell.typicodephotos.di;

import android.app.Application;
import android.content.Context;
import dagger.Binds;
import dagger.Module;

/**
 * Created by Adell on 9/24/2017.
 */
@Module
public abstract class ApplicationModule {
  @Binds
  abstract Context bindContext(Application application);
}
