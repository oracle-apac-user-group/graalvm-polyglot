package example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/abs") 
public class PolyglotAbsController {

    private final PolyglotAbsService  polyglotAbsService;

    public PolyglotAbsController(PolyglotAbsService polyglotAbsService) { 
        this.polyglotAbsService = polyglotAbsService;
    }

    @Get("/java/{value}")
    public String javaAbs(String value) {
        try{
            return polyglotAbsService.javaAbs(Integer.parseInt(value));
        } catch (NumberFormatException ex){
            // do nothing
        }
        return "input is not integer";
    }

    @Get("/ruby/{value}")     
    public String rubyAbs(String value) {
        try{
            return polyglotAbsService.rubyAbs(Integer.parseInt(value));
        } catch (NumberFormatException ex){
            // do nothing
        }
        return "input is not integer";
    }
}
