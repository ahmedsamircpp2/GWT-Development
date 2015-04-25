package com.interview.development.test.client.application.homepage;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class HomePageModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            bindPresenterWidget(HomePagePresenter.class, HomePagePresenter.MyView.class, HomePageView.class);
    }
}