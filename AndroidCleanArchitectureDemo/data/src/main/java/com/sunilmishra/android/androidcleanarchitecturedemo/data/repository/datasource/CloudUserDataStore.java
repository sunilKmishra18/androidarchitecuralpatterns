package com.sunilmishra.android.androidcleanarchitecturedemo.data.repository.datasource;

import com.sunilmishra.android.androidcleanarchitecturedemo.data.cache.UserCache;
import com.sunilmishra.android.androidcleanarchitecturedemo.data.entity.UserEntity;
import com.sunilmishra.android.androidcleanarchitecturedemo.data.net.RestApi;
import io.reactivex.Observable;
import java.util.List;

/**
 * {@link UserDataStore} implementation based on connections to the api (Cloud).
 */
class CloudUserDataStore implements UserDataStore {

  private final RestApi restApi;
  private final UserCache userCache;

  /**
   * Construct a {@link UserDataStore} based on connections to the api (Cloud).
   *
   * @param restApi The {@link RestApi} implementation to use.
   * @param userCache A {@link UserCache} to cache data retrieved from the api.
   */
  CloudUserDataStore(RestApi restApi, UserCache userCache) {
    this.restApi = restApi;
    this.userCache = userCache;
  }

  @Override public Observable<List<UserEntity>> userEntityList() {
    return this.restApi.userEntityList();
  }

  @Override public Observable<UserEntity> userEntityDetails(final int userId) {
    return this.restApi.userEntityById(userId).doOnNext(CloudUserDataStore.this.userCache::put);
  }
}
