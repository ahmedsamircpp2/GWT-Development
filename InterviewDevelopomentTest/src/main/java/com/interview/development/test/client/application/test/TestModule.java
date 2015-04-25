package com.interview.development.test.client.application.test;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class TestModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(TestPresenter.class, TestPresenter.MyView.class, TestView.class, TestPresenter.MyProxy.class);
    }
}