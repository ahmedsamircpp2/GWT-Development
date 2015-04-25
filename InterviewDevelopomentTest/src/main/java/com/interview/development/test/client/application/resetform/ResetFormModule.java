package com.interview.development.test.client.application.resetform;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ResetFormModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            bindPresenterWidget(ResetFormPresenter.class, ResetFormPresenter.MyView.class, ResetFormView.class);
    }
}