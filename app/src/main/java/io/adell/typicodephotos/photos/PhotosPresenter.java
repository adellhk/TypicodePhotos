package io.adell.typicodephotos.photos;

import android.support.annotation.Nullable;
import io.adell.typicodephotos.data.Photo;
import io.adell.typicodephotos.data.TypicodeService;
import io.adell.typicodephotos.di.ActivityScoped;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

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
    Observable<List<Photo>> call = typicodeService.getPhotos();
    Disposable disposable = call
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(
            new DisposableObserver<List<Photo>>() {

              @Override
              public void onNext(@NonNull List<Photo> photos) {
                photosView.showPhotos(photos);
              }

              @Override
              public void onError(@NonNull Throwable e) {
                photosView.showLoadPhotosFailure();
              }

              @Override
              public void onComplete() {
                this.dispose();
              }
            });
    //.subscribeWith(DisposableObserver<List<Photo>>);

    //enqueue(new Callback<List<Photo>>() {
    //  @Override
    //  public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
    //    if (!response.isSuccessful()) {
    //      photosView.showLoadPhotosFailure();
    //    } else {
    //      photosView.showPhotos(response.body());
    //    }
    //  }
    //
    //  @Override
    //  public void onFailure(Call<List<Photo>> call, Throwable t) {
    //    photosView.showLoadPhotosFailure();
    //  }
    //});
  }

  @Override
  public void dropView() {
    photosView = null;
  }
}
