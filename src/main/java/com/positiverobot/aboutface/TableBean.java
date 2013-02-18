package com.positiverobot.aboutface;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collections;
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
public class TableBean implements Externalizable {

    private static final long serialVersionUID = 1L;

    static final Logger LOG = LoggerFactory.getLogger(TableBean.class);

    private transient List<Row> model;
    private transient List<String> keys;

    // I want a new one each time so don't serialise it
    @ManagedProperty(value = "#{tableDAO}")
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

        model = new ArrayList<Row>(10);
        keys = new ArrayList<String>(10);
        
        add(new Row("a", "Row 1"));
        add(new Row("b", "Row 2"));
        add(new Row("c", "Row 3"));
        add(new Row("d", "Row 4"));
        add(new Row("e", "Row 5"));
        add(new Row("f", "Row 6"));
        add(new Row("g", "Row 7"));
        add(new Row("h", "Row 8"));
        add(new Row("i", "Row 9"));
        add(new Row("j", "Row 10"));
    }

    private void add(Row row) {
        keys.add("key" + row.getKey());
        model.add(row);
    }

    public List<Row> getModel() {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
        
        if(model == null) {
            // I've been build from view state
            model = new ArrayList<Row>();
            
            for (String key : keys) {
                model.add(new Row(key, ""));
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
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
        return dao;
    }

    public void setDao(TableDAO dao) {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
        this.dao = dao;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
        out.writeObject(keys);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
        keys = (List<String>) in.readObject();
        
        // to check what happens if the result is in a different order
        Collections.shuffle(keys);
    }
}
