package com.interview.development.test.client.application.resetform;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.interview.development.test.client.place.NameTokens;

public class ResetFormPresenter extends
		Presenter<ResetFormPresenter.MyView, ResetFormPresenter.MyProxy> {
	interface MyView extends View {
	}

	@NameToken(NameTokens.resetForm)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<ResetFormPresenter> {
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent
				.fire(this,
						com.interview.development.test.client.application.home.HomePagePresenter.SLOT_mainContentSlot,
						this);
	}

	@Inject
	ResetFormPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);

	}

	@Override
	protected void onReveal() {
		revealInParent();
	}

}