# 1. Micronaut Graal Application 

In this lab you will get familiar with creating Micronaut Graal application on GraalVM.

## Pre-requisites
You should be able to access the cloud compute instance provided to you at this point. If you are having trouble accessing the instance, please request for assistance from one of our lab assistants.

## Background

Micronaut is a modern, JVM-based, full-stack framework for building modular, easily testable microservice and serverless applications. For this lab, we will be installing Micronaut and use it as a framework for creating a Graal application. We will not be going too deep into what Micronaut is and how to use it, etc, you can read it up further here at [https://micronaut.io/](https://micronaut.io/).

### 1. Install Micronaut

For a quick and effortless start, we will be installing Micronaut with SDKMAN! (The Software Development Kit Manager).

Open a new terminal and enter:

```
$ curl -s https://get.sdkman.io | bash
```
Follow the on-screen instructions to complete the installation.

Next, initialize SDKMAN! with the following command:

```
$ source "$HOME/.sdkman/bin/sdkman-init.sh"
```

Now we are ready to install Micronaut (latest stable version).

```
$ sdk install micronaut
```
If prompted, make this your default version. After installation is complete it can be tested with:

```
$ mn --version
```
### 2. Create a Micronaut Graal Application

Create an app using the Micronaut Command Line Interface.

```
$ mn create-app example.micronaut.complete --features=graal-native-image
$ cd complete
```

The previous command creates a micronaut app with the default package example.micronaut in a folder named complete and with support for Graal.

If you are using Java or Kotlin and IntelliJ IDEA make sure you have enabled annotation processing.

### 3. Create the Service

Create a POJO ```Meetup.java```

src/main/java/example/micronaut/Meetup.java

```
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
```

Create a Service ```MeetupService.java```

src/main/java/example/micronaut/MeetupService.java

```
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
```

### 4. Create the Controller

Create a Controller ```MeetupController.java```. Micronaut will convert it automatically to JSON in the response.

src/main/java/example/micronaut/MeetupController.java

```
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
```

