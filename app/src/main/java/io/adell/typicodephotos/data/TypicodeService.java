package io.adell.typicodephotos.data;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Adell on 9/13/2017.
 */

public interface TypicodeService {
  @GET("photos") Call<List<Photo>> getPhotos();
}
