package org.primefaces.test;

import jakarta.el.ELException;
import jakarta.faces.component.FacesComponent;
import jakarta.faces.component.UINamingContainer;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.event.PostAddToViewEvent;

@FacesComponent("org.primefaces.test.PanelStateStuff")
public class PanelStateStuff extends UINamingContainer {

    public static final String COMPONENT_FAMILY = "org.primefaces.test";

    public PanelStateStuff() {
        subscribeToEvent(PostAddToViewEvent.class, this);
    }


    public void processEvent(ComponentSystemEvent event) throws AbortProcessingException, ELException {
        if (event instanceof PostAddToViewEvent) {

            Boolean defaultState = (Boolean)this.getAttributes().get("defaultState");

            FacesContext context = FacesContext.getCurrentInstance();
            PanelStateHolder panelStateHolder = context.getApplication().evaluateExpressionGet(context, "#{panelStateHolder}", PanelStateHolder.class);
            panelStateHolder.setCollapsed(defaultState);
        }
        super.processEvent(event);
    }

}
