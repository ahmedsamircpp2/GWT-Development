package com.interview.development.test.client.application.secondhobbypage;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class SecondHobbyPageModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            bindPresenterWidget(SecondHobbyPagePresenter.class, SecondHobbyPagePresenter.MyView.class, SecondHobbyPageView.class);
    }
}