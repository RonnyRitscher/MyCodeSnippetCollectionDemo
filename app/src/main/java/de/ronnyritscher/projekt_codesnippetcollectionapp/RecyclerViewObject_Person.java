package de.ronnyritscher.projekt_codesnippetcollectionapp;

public class RecyclerViewObject_Person {

    //MEMBER
    private String name;
    private String city;
    private int id;



    //CONSTRUCTOR`s
    public RecyclerViewObject_Person() {
    }

    public RecyclerViewObject_Person(String name, String city, int id) {
        this.name = name;
        this.city = city;
        this.id = id;
    }

    //GETTER und SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
