package io.adell.typicodephotos.data;

import io.reactivex.Observable;
import java.util.List;
import retrofit2.http.GET;

/**
 * Created by Adell on 9/13/2017.
 */

public interface TypicodeService {
  @GET("photos")
  Observable<List<Photo>> getPhotos();
}
