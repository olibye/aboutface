package com.positiverobot.aboutface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "tableBean")
// View Scoped Or Ctor and PostConstruct are called each time
@ViewScoped
public class TableBean implements Serializable {

    private static final long serialVersionUID = 1L;

    static final Logger LOG = LoggerFactory.getLogger(TableBean.class);
    
    private List<Row> model = new ArrayList<Row>(10);
    
    // I want a new one each time so don't serialise it
    @ManagedProperty(value="#{tableDAO}")
    private transient TableDAO dao;

    public TableBean() {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
        model.add(new Row("1", "Row 1"));
        model.add(new Row("2", "Row 2"));
        model.add(new Row("3", "Row 3"));
        model.add(new Row("4", "Row 4"));
        model.add(new Row("5", "Row 5"));
        model.add(new Row("6", "Row 6"));
        model.add(new Row("7", "Row 7"));
        model.add(new Row("8", "Row 8"));
        model.add(new Row("9", "Row 9"));
        model.add(new Row("10", "Row 10"));
    }

    @PostConstruct
    public void postConstruct() {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
    }
    
    public List<Row> getModel() {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
        return model;
    }

    public void onEdit(RowEditEvent event) {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
    }

    public void onCancel(RowEditEvent event) {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
    }

    public TableDAO getDao() {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
        return dao;
    }

    public void setDao(TableDAO dao) {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
        this.dao = dao;
    }
}
