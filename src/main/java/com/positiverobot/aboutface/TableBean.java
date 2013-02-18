package com.positiverobot.aboutface;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name = "tableBean")
public class TableBean {

    private static final Logger LOG = LoggerFactory.getLogger(TableBean.class);

    private List<Row> model = new ArrayList();

    {
        model.add(new Row("Row 1"));
        model.add(new Row("Row 2"));
        model.add(new Row("Row 3"));
        model.add(new Row("Row 4"));
        model.add(new Row("Row 5"));
        model.add(new Row("Row 6"));
        model.add(new Row("Row 7"));
        model.add(new Row("Row 8"));
        model.add(new Row("Row 9"));
        model.add(new Row("Row 10"));
    }

    public class Row {
        String value;

        public Row(String value) {
            super();
            this.value = value;
        }

        public String getValue() {
            LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
            return value;
        }

        public void setValue(String value) {
            LOG.info("In Phase:{}", FacesContext.getCurrentInstance().getCurrentPhaseId());
            this.value = value;
        }
    }
    
    public TableBean() {
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
}
