package io.adell.typicodephotos;

/**
 * Created by Adell on 9/13/2017.
 */

public interface BasePresenter<T> {
  void takeView(T view);

  void dropView();

  void destroy();
}
