package com.interview.development.test.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.interview.development.test.client.application.firsthobbypage.FirstHobbyPageModule;
import com.interview.development.test.client.application.home.HomeModule;
import com.interview.development.test.client.application.homepage.HomePageModule;
import com.interview.development.test.client.application.resetform.ResetFormModule;
import com.interview.development.test.client.application.secondhobbypage.SecondHobbyPageModule;
import com.interview.development.test.client.application.test.TestModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
	
    	
		install(new TestModule());
		install(new ResetFormModule());
		install(new SecondHobbyPageModule());
		install(new HomePageModule());
		install(new FirstHobbyPageModule());
		install(new HomeModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}