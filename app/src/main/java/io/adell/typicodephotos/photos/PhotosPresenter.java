package io.adell.typicodephotos.photos;

import android.support.annotation.Nullable;
import io.adell.typicodephotos.data.Photo;
import io.adell.typicodephotos.data.TypicodeService;
import io.adell.typicodephotos.di.ActivityScoped;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Adell on 9/13/2017.
 */

@ActivityScoped
public class PhotosPresenter implements PhotosContract.Presenter {
  @Nullable
  PhotosContract.View photosView;
  TypicodeService typicodeService;

  @Inject
  public PhotosPresenter(TypicodeService typicodeService) {this.typicodeService = typicodeService;}

  @Override
  public void takeView(PhotosContract.View view) {
    this.photosView = view;
    loadPhotos();
  }

  @Override
  public void loadPhotos() {
    typicodeService.getPhotos().enqueue(new Callback<List<Photo>>() {
      @Override
      public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
        if (!response.isSuccessful()) {
          photosView.showLoadPhotosFailure();
        } else {
          photosView.showPhotos(response.body());
        }
      }

      @Override
      public void onFailure(Call<List<Photo>> call, Throwable t) {
        photosView.showLoadPhotosFailure();
      }
    });
  }

  @Override
  public void dropView() {
    photosView = null;
  }
}
