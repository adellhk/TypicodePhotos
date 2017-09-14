package io.adell.typicodephotos.photos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import io.adell.typicodephotos.R;

/**
 * Created by Adell on 9/13/2017.
 */

public class PhotosFragment extends Fragment {

  public static PhotosFragment newInstance() {
    PhotosFragment photosFragment = new PhotosFragment();
    return photosFragment;
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.photos_fragment, container, false);

    ListView photosList = (ListView) root.findViewById(R.id.photos_list);
    return super.onCreateView(inflater, container, savedInstanceState);
  }
}
