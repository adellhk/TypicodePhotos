package io.adell.typicodephotos.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.adell.typicodephotos.photos.PhotosActivity;
import io.adell.typicodephotos.photos.PhotosModule;

/**
 * Created by Adell on 9/24/2017.
 */

@Module
public abstract class ActivityBindingModule {
  @ActivityScoped
  @ContributesAndroidInjector(modules = PhotosModule.class)
  abstract PhotosActivity photosActivity();
}
