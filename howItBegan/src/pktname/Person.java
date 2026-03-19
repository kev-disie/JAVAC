package pktname;

import javax.naming.Name;

public class Person {
    private Name personName;
    public Person(Name personName){
        this.personName = personName;
    }
    public Person(){
        /*empty on purpose - defalut constructor
        */
    }

    public String shouldReturnYourName() {
        return "Hiiii";
    }

    public String hello(String name) {
        return "Hell Yeah "  + name;
    }
}
