package com.positiverobot.aboutface;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("org.positiverobot.aboutfaces")
public class RowConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String key) throws ConverterException {
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object row) throws ConverterException {
        return null;
    }

}
