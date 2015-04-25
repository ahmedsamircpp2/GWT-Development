package com.interview.development.test.client.application.secondhobbypage;

import javax.inject.Inject;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.interview.development.test.utils.Constants;

class SecondHobbyPageView extends ViewImpl implements
		SecondHobbyPagePresenter.MyView {
	interface Binder extends UiBinder<Widget, SecondHobbyPageView> {
	}

	@UiField
	HTMLPanel main;
	@UiField
	FlexTable hobbies;

	@Inject
	SecondHobbyPageView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));

		hobbies.getElement().getStyle().setMarginTop(2, Unit.CM);
		/**
		 * creating hobbies images
		 */

		Image surfingInternet = new Image();
		surfingInternet.setPixelSize(Constants.IMAGE_WIDTH+150,
				Constants.IMAGE_HEIGHT+150);
		surfingInternet.setUrl("/images/surfingInternet.jpg");

		/**
		 * Hobbies header
		 */
		Label surfingIntenetHeader = new Label("Surfing Internet");

		/**
		 * hobbies Description
		 */
		TextArea surfingInternetDescription = new TextArea();
		surfingInternetDescription
				.setText("Exploration of the World Wide Web by following one interesting link to another, usually without a definite objective or search strategy.");
		surfingInternetDescription.setSize("250px", "210px");
		surfingInternetDescription.setReadOnly(true);

		/**
		 * Second Hobbie Design
		 */
		VerticalPanel verticalPanel_surfing = new VerticalPanel();

		hobbies.setWidget(0, 3, surfingInternet);
		hobbies.getFlexCellFormatter().setRowSpan(0, 3, 2);
		verticalPanel_surfing.add(surfingIntenetHeader);
		verticalPanel_surfing.add(surfingInternetDescription);
		hobbies.setWidget(0, 4, verticalPanel_surfing);
		hobbies.getFlexCellFormatter().setRowSpan(0, 4, 2);
	}

}