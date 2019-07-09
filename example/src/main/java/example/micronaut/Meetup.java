package example.micronaut;

import io.micronaut.core.annotation.Introspected;

@Introspected 
public class Meetup {

    private String name;

    public Meetup(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
