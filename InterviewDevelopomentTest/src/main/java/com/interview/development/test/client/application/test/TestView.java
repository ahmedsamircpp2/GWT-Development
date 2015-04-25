package com.interview.development.test.client.application.test;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class TestView extends ViewImpl implements TestPresenter.MyView {
    interface Binder extends UiBinder<Widget, TestView> {
    }

    @UiField
    SimplePanel main;

    @Inject
    TestView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == TestPresenter.SLOT_Test) {
            main.setWidget(content);
        } else {
            super.setInSlot(slot, content);
        }
    }
}