package com.positiverobot.aboutface;

import java.io.Serializable;

import javax.faces.context.FacesContext;

/**
 * Row bean also needs to be serializable
 */
public class Row implements Serializable {
    
    private static final long serialVersionUID = 1L;
    String key;
    String value;

    public Row(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        TableBean.LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
        return value;
    }

    public void setValue(String value) {
        TableBean.LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}