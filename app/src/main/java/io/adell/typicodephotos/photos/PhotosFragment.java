package io.adell.typicodephotos.photos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import io.adell.typicodephotos.R;
import io.adell.typicodephotos.data.Photo;
import io.adell.typicodephotos.di.ActivityScoped;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Adell on 9/13/2017.
 */

@ActivityScoped public class PhotosFragment extends dagger.android.support.DaggerFragment
    implements PhotosContract.View {
  @Inject PhotosContract.Presenter presenter;
  private PhotosAdapter photosAdapter = new PhotosAdapter(new ArrayList<Photo>(0));

  @Inject public PhotosFragment() {
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.photos_fragment, container, false);

    ListView photosList = (ListView) root.findViewById(R.id.photos_list);
    photosList.setAdapter(photosAdapter);
    return root;
  }

  @Override public void onResume() {
    super.onResume();
    presenter.takeView(this);
  }

  @Override
  public void onDestroy() {
    presenter.dropView();
    super.onDestroy();
  }

  @Override public void showPhotos(List<Photo> photos) {
    photosAdapter.setPhotos(photos);
  }

  @Override public void showLoadPhotosFailure() {
    Toast.makeText(getActivity(), "Unable to load photos from network.", Toast.LENGTH_SHORT).show();
  }

  private class PhotosAdapter extends BaseAdapter {
    private List<Photo> photos;

    PhotosAdapter(List<Photo> photos) {
      this.photos = photos;
    }

    void setPhotos(List<Photo> photos) {
      this.photos = photos;
      notifyDataSetChanged();
    }

    @Override public int getCount() {
      return photos.size();
    }

    @Override public Photo getItem(int i) {
      return photos.get(i);
    }

    @Override public long getItemId(int i) {
      return i;
    }

    @Override public View getView(int i, View view, ViewGroup viewGroup) {
      View row = view;
      if (row == null) {
        row = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.photo_item, viewGroup, false);
      }

      final Photo photo = getItem(i);
      String title = i + " - " + photo.getTitle();

      ((AppCompatTextView) row.findViewById(R.id.photo_item_title)).setText(title);
      AppCompatImageView photoItemImage =
          (AppCompatImageView) row.findViewById(R.id.photo_item_image);

      Picasso.with(viewGroup.getContext())
          .load(photo.getThumbnailUrl())
          .resizeDimen(R.dimen.photo_item_image, R.dimen.photo_item_image)
          .into(photoItemImage);

      return row;
    }
  }
}
