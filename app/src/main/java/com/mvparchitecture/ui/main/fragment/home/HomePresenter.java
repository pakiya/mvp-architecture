package com.mvparchitecture.ui.main.fragment.home;

import com.mvparchitecture.ui.base.BasePresenter;

import javax.inject.Inject;

public class HomePresenter extends BasePresenter {

    HomeFragment fragment;
    HomeRepository repository;

    @Inject
    public HomePresenter(HomeFragment fragment, HomeRepository repository) {
        this.fragment = fragment;
        this.repository = repository;
        repository.onAttach(this);
    }
}
