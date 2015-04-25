package com.interview.development.test.client.application.firsthobbypage;

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

class FirstHobbyPageView extends ViewImpl implements
		FirstHobbyPagePresenter.MyView {
	interface Binder extends UiBinder<Widget, FirstHobbyPageView> {
	}

	@UiField
	HTMLPanel main;
	@UiField
	FlexTable hobbies;

	@Inject
	FirstHobbyPageView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		

		
		hobbies.getElement().getStyle().setMarginTop(2, Unit.CM);

		/**
		 * creating hobbies images
		 */
		Image workOut = new Image();
		workOut.setUrl("/images/workout.jpg");
		workOut.setPixelSize(Constants.IMAGE_WIDTH+150, Constants.IMAGE_HEIGHT+150);

		/**
		 * Hobbies header
		 */
		Label workOutHeader = new Label("WorkOut");

		/**
		 * hobbies Description
		 */
		TextArea workOutDescription = new TextArea();
		workOutDescription.setReadOnly(true);
		workOutDescription.setSize("250px", "210px");
		workOutDescription
				.setText("Exercise in order to improve the strength and appearance of my body, Usually works out in the gym two or three times a week.");

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

	}

}