package com.mvparchitecture.ui.main.fragment.home.di;

import com.mvparchitecture.applicationLevel.App;
import com.mvparchitecture.data.network.ApiCall;
import com.mvparchitecture.ui.main.fragment.home.HomeFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    HomeFragment fragment;

    public HomeModule(HomeFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    HomeFragment getFragment() {
        return fragment;
    }

    @Provides
    ApiCall getApiCall() {
        return App.get(fragment.getActivity()).getAppComponent().getApiCall();
    }
}
