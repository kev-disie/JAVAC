package pktname;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void shouldReturnYourName(){
        Person Kassandra = new Person();
        assertEquals("Hiiii",Kassandra.shouldReturnYourName());
    }

    @Test
    public void shouldReturnHellYeahMarcus(){
        Person person = new Person();
        assertEquals("Hell Yeah Marcus",person.hello("Marcus"));
    }


}