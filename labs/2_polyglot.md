# 2. GraalVM Polyglot API

In this lab you will get familiar with creating a polyglot application on GraalVM.


## Background

The GraalVM Polyglot API lets you embed and run code from guest languages in JVM-based host applications.

Throughout this section, you learn how to create a host application in Java that runs on GraalVM and directly calls a guest language. In the example below, we will be extending the Micronaut application we have created earlier by using the Polyglot API to embed```Ruby``` language.

We will be creating another service that does ```abs``` function based on the user input. This service returns the absolute value of an int value. If the argument is not negative, the argument is returned. If the argument is negative, the negation of the argument is returned.

### 1. Create another Service

Create a Service ```PolyglotAbsService.java```

src/main/java/example/micronaut/PolyglotAbsService.java

```
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
```

### 4. Create another Controller

Create a Controller ```PolyglotAbsController.java```.

src/main/java/example/micronaut/PolyglotAbsController.java

```
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
        }
        return "input is not integer";
    }

    @Get("/ruby/{value}")     
    public String rubyAbs(String value) {
        try{
            return polyglotAbsService.rubyAbs(Integer.parseInt(value));
        } catch (NumberFormatException ex){
        }
        return "input is not integer";
    }
}
```

