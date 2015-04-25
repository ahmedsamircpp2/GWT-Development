package com.interview.development.test.client.application.homepage;

import javax.inject.Inject;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.interview.development.test.utils.Constants;

class HomePageView extends ViewImpl implements HomePagePresenter.MyView {
	interface Binder extends UiBinder<Widget, HomePageView> {
	}

	@UiField
	HTMLPanel main;
	@UiField
	FlexTable hobbies;
	@UiField
	VerticalPanel verticalPanel;

	private final Image workOut = new Image();
	private final Image surfingInternet = new Image();

	@Inject
	HomePageView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));

		hobbies.getElement().getStyle().setMarginTop(2, Unit.CM);

		/**
		 * creating hobbies images
		 */

		workOut.setUrl("/images/workout.jpg");
		workOut.setPixelSize(Constants.IMAGE_WIDTH, Constants.IMAGE_HEIGHT);

		surfingInternet.setPixelSize(Constants.IMAGE_WIDTH,
				Constants.IMAGE_HEIGHT);
		surfingInternet.setUrl("/images/surfingInternet.jpg");

		/**
		 * Hobbies header
		 */
		Label workOutHeader = new Label("WorkOut");
		Label surfingIntenetHeader = new Label("Surfing Internet");

		/**
		 * hobbies Description
		 */
		TextArea workOutDescription = new TextArea();
		workOutDescription.setReadOnly(true);
		workOutDescription.setSize("150px", "110px");
		workOutDescription
				.setText("Exercise in order to improve the strength and appearance of my body, Usually works out in the gym two or three times a week.");

		TextArea surfingInternetDescription = new TextArea();
		surfingInternetDescription
				.setText("Exploration of the World Wide Web by following one interesting link to another, usually without a definite objective or search strategy.");
		surfingInternetDescription.setSize("150px", "110px");
		surfingInternetDescription.setReadOnly(true);

		/**
		 * adding Widgets to build flextable of Hobbies First Hobbie
		 */
		hobbies.setWidget(0, 0, workOut);
		hobbies.getFlexCellFormatter().setRowSpan(0, 0, 2);
		VerticalPanel verticalPanel_workOut = new VerticalPanel();
		verticalPanel_workOut.add(workOutHeader);
		verticalPanel_workOut.add(workOutDescription);
		hobbies.setWidget(0, 1, verticalPanel_workOut);
		hobbies.getFlexCellFormatter().setRowSpan(0, 1, 2);

		/**
		 * Separator
		 */
		hobbies.setWidget(0, 2, new HTML("<<<<>>>>"));
		hobbies.getFlexCellFormatter().setRowSpan(0, 2, 2);

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

	public HTMLPanel getMain() {
		return main;
	}

	public FlexTable getHobbies() {
		return hobbies;
	}

	public Image getWorkOut() {
		return workOut;
	}

	public Image getSurfingInternet() {
		return surfingInternet;
	}

}