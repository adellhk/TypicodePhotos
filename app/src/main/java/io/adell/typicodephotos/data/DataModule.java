package io.adell.typicodephotos.data;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Adell on 9/27/2017.
 */

@Module
public class DataModule {
  String typicodeUrl;

  public DataModule(String typicodeUrl) {
    this.typicodeUrl = typicodeUrl;
  }

  @Provides
  @Singleton
  public TypicodeService provideTypicodeService() {
    return new Retrofit.Builder()
        .baseUrl(typicodeUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(TypicodeService.class);
  }
}
