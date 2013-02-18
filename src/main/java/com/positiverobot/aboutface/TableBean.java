package com.positiverobot.aboutface;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "tableBean")
// View Scoped Or Ctor and PostConstruct are called each time
@ViewScoped
public class TableBean implements Externalizable {

    private static final long serialVersionUID = 1L;

    static final Logger LOG = LoggerFactory.getLogger(TableBean.class);

    private transient List<Row> model;
    private transient List<String> keys;

    // I want a new one each time so don't serialise it
    // can't used managed property as we can't inject @RequestScoped into
    // @ViewScoped beans
    private transient TableDAO dao;

    /**
     * Called in externalizable construction
     */
    public TableBean() {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
    }

    /**
     * Not called in externalizable/serializable construction
     */
    @PostConstruct
    public void postConstruct() {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());

        setModel(getDao().getResults());
    }

    private void setModel(List<Row> model) {
        this.model = model;
        keys = new ArrayList<String>(model.size());

        for (Row row : model) {
            keys.add(row.getKey());
        }
    }

    public List<Row> getModel() {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());

        if (model == null) {
            // I've been build from view state
            // look up each result by key
            model = new ArrayList<Row>(keys.size());
            for (String key : keys) {
                model.add(getDao().getResult(key));
            }
        }

        return model;
    }

    public void onEdit(RowEditEvent event) {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
    }

    public void onCancel(RowEditEvent event) {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
    }

    public TableDAO getDao() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        LOG.info("In Phase:{}", currentInstance.getCurrentPhaseId());

        if (dao == null) {
            dao = (TableDAO) currentInstance.getApplication().evaluateExpressionGet(currentInstance, "#{tableDAO}", TableDAO.class);
        }

        return dao;
    }


    public void writeExternal(ObjectOutput out) throws IOException {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
        out.writeObject(keys);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
        keys = (List<String>) in.readObject();
    }
}
