package de.ronnyritscher.projekt_codesnippetcollectionapp;

public class MainRecyclerViewObject_DemoCode {

    //Member:
    private String name;
    private String description;
    private String className;


    public MainRecyclerViewObject_DemoCode(String name, String description, String className) {
        this.name = name;
        this.description = description;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
