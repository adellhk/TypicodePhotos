package io.adell.typicodephotos.photos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import io.adell.typicodephotos.R;

public class PhotosActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.photos_activity);

    PhotosFragment photosFragment = PhotosFragment.newInstance();
    getSupportFragmentManager().beginTransaction().add(R.id.content_frame, photosFragment).commit();
  }
}
