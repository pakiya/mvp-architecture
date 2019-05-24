package com.mvparchitecture.ui.main.fragment.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvparchitecture.R;
import com.mvparchitecture.ui.base.BaseFragment;
import com.mvparchitecture.ui.main.MainActivity;
import com.mvparchitecture.ui.main.fragment.home.di.DaggerHomeComponent;
import com.mvparchitecture.ui.main.fragment.home.di.HomeComponent;
import com.mvparchitecture.ui.main.fragment.home.di.HomeModule;

import butterknife.ButterKnife;

public class HomeFragment extends BaseFragment<MainActivity> implements HomeContract {

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public String createTag() {
        return HomeFragment.class.getSimpleName();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachParent((MainActivity) getActivity());
        ButterKnife.bind(this, view);
        injectHomeFragment();
        initViews();
    }

    private void injectHomeFragment() {
        HomeComponent component = DaggerHomeComponent.builder().homeModule(new HomeModule(this)).build();
        component.injectHomeFragment(this);
    }

    private void initViews() {

    }
}
