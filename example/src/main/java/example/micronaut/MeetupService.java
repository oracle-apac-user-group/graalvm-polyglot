package example.micronaut;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Singleton 
public class MeetupService {

    private static final List<Meetup> MEETUPS = Arrays.asList(
            new Meetup("GraalVM"),
            new Meetup("Microservices"),
            new Meetup("Autonomous Data Warehouse"),
            new Meetup("Wercker"),
            new Meetup("Oracle Code One")
    );

    public Meetup randomMeetup() { 
        return MEETUPS.get(new Random().nextInt(MEETUPS.size()));
    }
}
