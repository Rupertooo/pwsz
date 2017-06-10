package sample;


import java.io.Serializable;

/**
 * Created by admin on 06.05.2017.
 */
public class Person implements Serializable {
    private String name;
    private String numer;

    Person(String name, String numer) {
        this.name = new String(name);
        this.numer = new String(numer);
    }

    public String getName() { return name; }
    public void setName(String fName) {
        name=fName;
    }
    public String getNumer() {
        return numer;
    }
    public void setNumer(String fName) {
        numer=fName;
    }

}