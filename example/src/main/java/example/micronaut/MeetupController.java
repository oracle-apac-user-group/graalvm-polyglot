package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/meetup") 
public class MeetupController {

    private final MeetupService meetupService;

    public MeetupController(MeetupService meetupService) { 
        this.meetupService = meetupService;
    }

    @Get("/random") 
    public Meetup randomMeetup() { 
        return meetupService.randomMeetup();
    }
}
