package entity;

import java.util.List;

/**
 * create by Lee
 */

public class ExtInfo {
    private String title;
    private List<String> values;
    private String desc;
    private int defineType;

    public ExtInfo(String title, List<String> values, String desc, int defineType) {
        this.title = title;
        this.values = values;
        this.desc = desc;
        this.defineType = defineType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getDefineType() {
        return defineType;
    }

    public void setDefineType(int defineType) {
        this.defineType = defineType;
    }
}
