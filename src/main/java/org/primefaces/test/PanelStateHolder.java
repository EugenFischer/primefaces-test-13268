package org.primefaces.test;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;

@Data
@Named
@ViewScoped
public class PanelStateHolder implements Serializable {

    private boolean collapsed = false;

    public void toggle() {
        collapsed = !collapsed;
    }

}
