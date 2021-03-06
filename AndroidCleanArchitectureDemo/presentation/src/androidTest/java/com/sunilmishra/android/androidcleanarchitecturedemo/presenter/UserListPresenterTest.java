package com.sunilmishra.android.androidcleanarchitecturedemo.presenter;

import android.content.Context;
import com.sunilmishra.android.domain.interactor.GetUserList;
import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.mapper.UserModelDataMapper;
import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.presenter.UserListPresenter;
import com.sunilmishra.android.androidcleanarchitecturedemo.presentation.view.UserListView;
import io.reactivex.observers.DisposableObserver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserListPresenterTest {

  private UserListPresenter userListPresenter;

  @Mock private Context mockContext;
  @Mock private UserListView mockUserListView;
  @Mock private GetUserList mockGetUserList;
  @Mock private UserModelDataMapper mockUserModelDataMapper;

  @Before
  public void setUp() {
    userListPresenter = new UserListPresenter(mockGetUserList, mockUserModelDataMapper);
    userListPresenter.setView(mockUserListView);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testUserListPresenterInitialize() {
    given(mockUserListView.context()).willReturn(mockContext);

    userListPresenter.initialize();

    verify(mockUserListView).hideRetry();
    verify(mockUserListView).showLoading();
    verify(mockGetUserList).execute(any(DisposableObserver.class), any(Void.class));
  }
}
