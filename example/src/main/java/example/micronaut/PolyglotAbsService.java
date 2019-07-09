package example.micronaut;

import javax.inject.Singleton;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.graalvm.polyglot.*;
import org.graalvm.polyglot.proxy.*;

@Singleton 
public class PolyglotAbsService {
   public static String javaAbs(int input){
       return ("running abs in Java -> " + Math.abs(input));
    }

    public static String rubyAbs(int input){
       try (Context context = Context.create("ruby")){
           return ("running abs in Ruby -> " + context.eval("ruby", input + ".abs"));
       }
    }
}
