package com.interview.development.test.client.application.test;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
    import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.interview.development.test.client.application.home.HomePagePresenter;
import com.interview.development.test.client.place.NameTokens;
public class TestPresenter extends Presenter<TestPresenter.MyView, TestPresenter.MyProxy>  {
    interface MyView extends View  {
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_Test = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.ahmed)
    @ProxyCodeSplit
    interface MyProxy extends ProxyPlace<TestPresenter> {
    }

    @Inject
    TestPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, HomePagePresenter.SLOT_mainContentSlot);
        
    }
    
    @Override
    public void prepareFromRequest(PlaceRequest request) {
        super.prepareFromRequest(request);
    }
    
    @Override
    public boolean useManualReveal() {
        return true;
    }
    
    
}