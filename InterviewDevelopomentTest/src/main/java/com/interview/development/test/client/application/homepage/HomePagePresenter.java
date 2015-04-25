package com.interview.development.test.client.application.homepage;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.interview.development.test.client.place.NameTokens;

public class HomePagePresenter extends
		Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {
	public interface MyView extends View {
		public FlexTable getHobbies();

		public HTMLPanel getMain();

		public Image getWorkOut();

		public Image getSurfingInternet();
	}

	@NameToken(NameTokens.homePage)
	@ProxyCodeSplit
	interface MyProxy extends ProxyPlace<HomePagePresenter> {
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent
				.fire(this,
						com.interview.development.test.client.application.home.HomePagePresenter.SLOT_mainContentSlot,
						this);
	}

	@Inject
	HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		Window.alert("heloooooooo");
	}

	@Override
	protected void onBind() {
		getView().getSurfingInternet().getElement().getStyle()
				.setCursor(Cursor.POINTER);
		getView().getWorkOut().getElement().getStyle()
				.setCursor(Cursor.POINTER);
	}

}