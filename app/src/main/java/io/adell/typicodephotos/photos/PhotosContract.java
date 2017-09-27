package io.adell.typicodephotos.photos;

import io.adell.typicodephotos.BasePresenter;
import io.adell.typicodephotos.BaseView;
import io.adell.typicodephotos.data.Photo;
import java.util.List;

/**
 * Created by Adell on 9/13/2017.
 */

interface PhotosContract {
  interface View extends BaseView<Presenter> {

    void showPhotos(List<Photo> photos);

    void showLoadPhotosFailure();
  }

  interface Presenter extends BasePresenter<View> {

  void loadPhotos();
  }
}
