package com.positiverobot.aboutface;

import javax.faces.context.FacesContext;

/**
 * Row bean also needs to be serializable/Externalizable
 */
public class Row {
    
    private static final long serIalVersionUID = 1L;
    String key;
    String value;
    
    public Row(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        TableBean.LOG.info("In Phase:{} Value:{}", FacesContext.getCurrentInstance().getCurrentPhaseId(), value);
        return value;
    }

    public void setValue(String value) {
        TableBean.LOG.info("In Phase:{} value:{}", FacesContext.getCurrentInstance().getCurrentPhaseId(), value);
        this.value = value;
    }

    public String getKey() {
        TableBean.LOG.info("In Phase:{} key:{}", FacesContext.getCurrentInstance().getCurrentPhaseId(), key);
        return key;
    }

    public void setKey(String key) {
        TableBean.LOG.info("In Phase:{} key:{}", FacesContext.getCurrentInstance().getCurrentPhaseId(), key);
        this.key = key;
    }

    @Override
    public String toString() {
        return "Row [key=" + key + ", value=" + value + "]";
    }
    
    
}