package io.adell.typicodephotos.photos;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import io.adell.typicodephotos.di.ActivityScoped;

/**
 * Created by Adell on 9/25/2017.
 */

@Module
public abstract class PhotosModule {
  @FragmentScoped
  @ContributesAndroidInjector
  abstract PhotosFragment photosFragment();

  @ActivityScoped
  @Binds
  abstract PhotosContract.Presenter photosPresenter(PhotosPresenter presenter);
}
