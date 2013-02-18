package com.positiverobot.aboutface;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "tableDAO")
// I want a new one each time
@RequestScoped
public class TableDAO {

    private static final TreeMap<String, Row> sModel = new TreeMap<String, Row>();

    static {
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

    public List<Row> getResults() {
        return new ArrayList<Row>(sModel.values());
    }
    
    public Row getResult(String key) {
        return sModel.get(key);
    }

    private static void add(Row row) {
        sModel.put(row.getKey(), row);
    }
}
