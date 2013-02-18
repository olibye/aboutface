package com.positiverobot.aboutface;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.event.RowEditEvent;

@ManagedBean(name="tableBean")
public class TableBean {

	private List<String> model = new ArrayList();

	{
		model.add("Row 1");
		model.add("Row 2");
		model.add("Row 3");
		model.add("Row 4");
		model.add("Row 5");
		model.add("Row 6");
		model.add("Row 7");
		model.add("Row 8");
		model.add("Row 9");
		model.add("Row 10");
	}

	public TableBean() {
	}

	public List<String> getModel() {
		System.out.println(FacesContext.getCurrentInstance().getCurrentPhaseId());
		return model;
	}

	public void onEdit(RowEditEvent event) {
	}

	public void onCancel(RowEditEvent event) {
	}
}
