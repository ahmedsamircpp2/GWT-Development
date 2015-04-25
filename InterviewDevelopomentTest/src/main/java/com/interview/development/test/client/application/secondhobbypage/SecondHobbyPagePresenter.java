package com.interview.development.test.client.application.secondhobbypage;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.interview.development.test.client.application.homepage.HomePagePresenter;
import com.interview.development.test.client.place.NameTokens;
public class SecondHobbyPagePresenter extends Presenter<SecondHobbyPagePresenter.MyView,SecondHobbyPagePresenter.MyProxy>  {
    interface MyView extends View  {
    }

    @NameToken(NameTokens.secondHobby)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<SecondHobbyPagePresenter> {
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent
				.fire(this,
						com.interview.development.test.client.application.home.HomePagePresenter.SLOT_mainContentSlot,
						this);
	}
	
    @Inject
    SecondHobbyPagePresenter(
            EventBus eventBus,
            MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);
    }
    
    
}