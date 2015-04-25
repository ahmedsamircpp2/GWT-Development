package com.interview.development.test.client.application.firsthobbypage;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class FirstHobbyPageModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            bindSingletonPresenterWidget(FirstHobbyPagePresenter.class, FirstHobbyPagePresenter.MyView.class, FirstHobbyPageView.class);
    }
}