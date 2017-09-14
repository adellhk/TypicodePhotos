package io.adell.typicodephotos.photos;

import io.adell.typicodephotos.data.Photo;
import io.adell.typicodephotos.data.TypicodeService;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Adell on 9/13/2017.
 */

public class PhotosPresenter implements PhotosContract.Presenter {
  private final String typicodePhotoUrl = "http://jsonplaceholder.typicode.com";
  private TypicodeService typicodeService;
  private PhotosContract.View photosView;

  public PhotosPresenter(PhotosContract.View photosView) {
    this.photosView = photosView;
  }

  @Override public void start() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(typicodePhotoUrl).build();

    if (typicodeService == null) {
      typicodeService = retrofit.create(TypicodeService.class);
    }
    loadPhotos();
  }

  @Override public void loadPhotos() {
    typicodeService.getPhotos().enqueue(new Callback<List<Photo>>() {
      @Override public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
        if (!response.isSuccessful()) {
          photosView.showLoadPhotosFailure();
        } else {
          photosView.showPhotos(response.body());
        }
      }

      @Override public void onFailure(Call<List<Photo>> call, Throwable t) {
        photosView.showLoadPhotosFailure();
      }
    });
  }
}
