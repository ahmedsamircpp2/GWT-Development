package com.interview.development.test.client.application.resetform;

import java.util.Date;

import javax.inject.Inject;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.gwtplatform.mvp.client.ViewImpl;

class ResetFormView extends ViewImpl implements ResetFormPresenter.MyView {
	interface Binder extends UiBinder<Widget, ResetFormView> {
	}

	public final DatePicker datePicker = new DatePicker();

	@UiField
	HTMLPanel mainPanel;
	@UiField
	TextBox name;
	@UiField
	TextBox dateValue;
	@UiField
	Button login;

	PopupPanel dialog = new PopupPanel(true);

	@Inject
	ResetFormView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		mainPanel.getElement().getStyle().setMarginTop(2, Unit.CM);

		/**
		 * setting input text attributes
		 */
		name.getElement().setId("username");
		name.getElement().setAttribute("name", "username");
		name.getElement().setAttribute("type", "text");
		name.getElement().setAttribute("placeholder", "your name");

		dateValue.getElement().setId("emailsignup");
		dateValue.getElement().setAttribute("name", "emailsignup");
		// name.getElement().setAttribute("required ", "required");
		dateValue.getElement().setAttribute("placeholder", "MM/DD/YYYY");
		login.setText("Reset");
		login.getElement().getStyle().setPaddingLeft(24, Unit.PX);
		login.getElement().getStyle().setPaddingRight(24, Unit.PX);

		login.getElement().getStyle().setPaddingBottom(11, Unit.PX);
		login.getElement().getStyle().setPaddingTop(11, Unit.PX);

		dateValue.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				addDateToTextField();
			}
		});

		login.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				name.setText("");
				dateValue.setText("");

			}
		});
	}

	public void addDateToTextField() {

		datePicker.setVisible(true);
		datePicker.setValue(new Date());
		datePicker.setSize("200px", "200px");
		dialog.show();
		datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {

			@Override
			public void onValueChange(ValueChangeEvent<Date> event) {
				// SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				// "MM/DD/YYYY");
				DateTimeFormat fmt = DateTimeFormat.getFormat("MM/dd/yyyy");
				dateValue.setValue(fmt.format(event.getValue()));
				dialog.hide();
			}
		});

		dialog.add(datePicker);
		dialog.setPopupPosition(dateValue.getAbsoluteLeft(),
				dateValue.getAbsoluteTop());
		DOM.setIntStyleAttribute(dialog.getElement(), "zIndex", 101);
		dialog.show();
	}
}