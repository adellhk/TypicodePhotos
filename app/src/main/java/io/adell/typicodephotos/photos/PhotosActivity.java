package io.adell.typicodephotos.photos;

import android.os.Bundle;
import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;
import io.adell.typicodephotos.R;
import javax.inject.Inject;

public class PhotosActivity extends DaggerAppCompatActivity {
  @Inject
  PhotosPresenter photosPresenter;
  @Inject
  Lazy<PhotosFragment> photosFragmentLazy;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.photos_activity);

    PhotosFragment photosFragment =
        (PhotosFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
    if (photosFragment == null) {
      photosFragment = photosFragmentLazy.get();
      getSupportFragmentManager().beginTransaction()
          .add(R.id.content_frame, photosFragment)
          .commit();
    }
  }
}
