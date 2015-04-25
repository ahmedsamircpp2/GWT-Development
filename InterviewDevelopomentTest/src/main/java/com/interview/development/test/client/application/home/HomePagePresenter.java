package com.interview.development.test.client.application.home;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import com.interview.development.test.client.application.ApplicationPresenter;
import com.interview.development.test.client.application.firsthobbypage.FirstHobbyPagePresenter;
import com.interview.development.test.client.application.resetform.ResetFormPresenter;
import com.interview.development.test.client.application.secondhobbypage.SecondHobbyPagePresenter;
import com.interview.development.test.client.place.NameTokens;

public class HomePagePresenter extends
		Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> {
	public interface MyView extends View {
		public Anchor getHomeLink();

		public Anchor getHobby1();

		public Anchor getHobby2();

		public HTMLPanel getSiteContent();

		public Anchor getResetForm();
	}

	@Inject
	PlaceManager manager;

	@Inject
	com.interview.development.test.client.application.homepage.HomePagePresenter homePagePresenter;
	@Inject
	FirstHobbyPagePresenter firstHobbyPresenter;
	@Inject
	SecondHobbyPagePresenter secondHobbyPresenter;
	@Inject
	ResetFormPresenter resetFormPreseter;

	@ContentSlot
	public static final Type<RevealContentHandler<?>> SLOT_mainContentSlot = new Type<RevealContentHandler<?>>();

	public static final Object firstHobbySlot = new Object();

	@ProxyStandard
	@NameToken(NameTokens.home)
	interface MyProxy extends ProxyPlace<HomePagePresenter> {
	}

	@Inject
	HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_SetMainContent);
	}

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		getView().getHomeLink().getElement().getStyle()
				.setCursor(Cursor.POINTER);
		getView().getHobby1().getElement().getStyle().setCursor(Cursor.POINTER);
		getView().getHobby2().getElement().getStyle().setCursor(Cursor.POINTER);
		getView().getResetForm().getElement().getStyle()
				.setCursor(Cursor.POINTER);

		getView().getHomeLink().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				History.newItem("homePage");
			}
		});

		getView().getHobby1().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				History.newItem("firstHobby");
			}
		});
		getView().getHobby2().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				History.newItem("secondHobby");

			}
		});

		getView().getResetForm().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// PlaceRequest place =new PlaceRequest(NameTokens.resetForm);
				// manager.revealPlace(place);
				// manager.buildHistoryToken(place);
				History.newItem("resetForm");

			}
		});
		addImagesAction();
		addHistoryHandler();
		History.newItem("homePage");
	}

	private void addHistoryHandler() {
		handleHistory(History.getToken());
		History.addValueChangeHandler(new ValueChangeHandler<String>() {

			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				handleHistory(event.getValue());
			}

		});
	}

	private void handleHistory(String str) {
		switch (str){
		case "firstHobby":
			setInSlot(SLOT_mainContentSlot, firstHobbyPresenter);
			break;
		case "secondHobby":
			setInSlot(SLOT_mainContentSlot, secondHobbyPresenter);
			break;
		case "homePage":
			setInSlot(SLOT_mainContentSlot, homePagePresenter);
			break;
		case "resetForm":
			setInSlot(SLOT_mainContentSlot, resetFormPreseter);
			break;
		default:
			break;
		}
	}

	private void addImagesAction() {
		homePagePresenter.getView().getSurfingInternet()
				.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						setInSlot(SLOT_mainContentSlot, secondHobbyPresenter);
					}
				});

		homePagePresenter.getView().getWorkOut()
				.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						setInSlot(SLOT_mainContentSlot, firstHobbyPresenter);
					}
				});
	}
}
