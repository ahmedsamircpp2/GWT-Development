package com.interview.development.test.client.application.firsthobbypage;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.interview.development.test.client.application.home.HomePagePresenter;
import com.interview.development.test.client.place.NameTokens;
public class FirstHobbyPagePresenter extends Presenter<FirstHobbyPagePresenter.MyView,FirstHobbyPagePresenter.MyProxy>  {
    interface MyView extends View  {
    }

    @NameToken(NameTokens.firstHobby)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<FirstHobbyPagePresenter> {
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent
				.fire(this,
						com.interview.development.test.client.application.home.HomePagePresenter.SLOT_mainContentSlot,
						this);
	}
    @Inject
    FirstHobbyPagePresenter(
            EventBus eventBus,
            MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);
        
    }
    
    
}