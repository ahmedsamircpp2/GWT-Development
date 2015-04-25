package com.interview.development.test.client.application.home;

import javax.inject.Inject;

import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.interview.development.test.utils.Constants;

class HomePageView extends ViewImpl implements HomePagePresenter.MyView {
	interface Binder extends UiBinder<Widget, HomePageView> {
	}

	@UiField
	HTMLPanel mainPanel;
	@UiField
	HTMLPanel personalInfo;
	@UiField
	HTMLPanel menuItems;
	@UiField
	HTMLPanel menubar;
	@UiField
	HeadingElement myName;
	@UiField
	LIElement homeMenuItem;
	@UiField
	Anchor homeLink;
	@UiField
	Anchor hobby1;
	@UiField
	Anchor hobby2;
	@UiField
	HTMLPanel siteContent;
	@UiField
	HTMLPanel hLine;
	@UiField
	Image developerLogo;
	@UiField
	HTMLPanel footer;
	@UiField
	Anchor resetForm;

	@Inject
	HomePageView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
		initUIFields();
	}

	private void initUIFields() {
		/**
		 * Set Widgets Id's to take proper style attributes
		 */
		mainPanel.getElement().setId("main");
		personalInfo.getElement().setId("welcome");
		menuItems.getElement().setId("menu_items");
		menubar.getElement().setId("menubar");
		footer.getElement().setId("footer");
		/**
		 * Add Decoration to the menu Items
		 */
		homeLink.getElement()
				.setAttribute("style", "text-decoration:underline");
		hobby1.getElement().setAttribute("style", "text-decoration:underline");
		hobby2.getElement().setAttribute("style", "text-decoration:underline");
		resetForm.getElement().setAttribute("style",
				"text-decoration:underline");
		/**
		 * Left hand Widgets that contain MyName
		 */
		myName.setInnerText(Constants.DEVELOPER_NAME);
		// developerLogo.setUrl("/images/right.jpg");
		// developerLogo.setPixelSize(100, 60);
		/**
		 * this Class to change current tab color
		 */
		homeMenuItem.setClassName(Constants.MENU_ITEM_CLASS_FOR_COLOR);
		/**
		 * Adding Horizontal Line
		 */
		HTML html = new HTML("<hr  style=\"width:70%;\" />");
		hLine.add(html);

		siteContent.getElement().setId("site_content");
	}

	public Anchor getHomeLink() {
		return homeLink;
	}

	public Anchor getHobby1() {
		return hobby1;
	}

	public Anchor getHobby2() {
		return hobby2;
	}

	public HTMLPanel getSiteContent() {
		return siteContent;
	}

	public Anchor getResetForm() {
		return resetForm;
	}

	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if (slot == HomePagePresenter.SLOT_mainContentSlot) {
			siteContent.clear();
			if (content != null) {
				siteContent.add(content);
			}
		} else {
			super.setInSlot(slot, content);
		}

	}

}