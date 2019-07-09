# 4. Performance

In this lab you will get familiar with the benefits of GraalVM by running the application faster by creating ahead-of-time compiled native images.

## Background

For existing Java applications, GraalVM can provide benefits by running them faster, providing extensibility via scripting languages, or creating ahead-of-time compiled native images. You can find more information here at [https://www.graalvm.org/docs/why-graal/](https://www.graalvm.org/docs/why-graal/)

### 1. Running on HotSpot JVM

Let's compare the server start up time and response times. Firstly, we will start up the application using HotSpot JVM method. It is important to notice the server start up time in this case.

```
$ java -jar .build/libs/complete-0.1.jar
23:06:04.585 [main] INFO  io.micronaut.runtime.Micronaut - Startup completed in 996ms. Server Running: http://localhost:8080
```
Now issue the following commands.
```
$ time curl localhost:8080/meetup/random
{"name":"Autonomous Data Warehouse"}
real	0m0.136s
user	0m0.003s
sys	    0m0.002s

$ time curl localhost:8080/abs/java/-99
running abs in Java -> 99
real	0m0.012s
user	0m0.002s
sys	    0m0.003s

$ time curl localhost:8080/abs/ruby/-99
running abs in Ruby -> 99
real	0m1.510s
user	0m0.002s
sys	0m0.001s
```

Notice that when we are running the ```Ruby``` service, it took much more time than usual, this is because GraalVM needs to initialize the ```Ruby``` engine to support the method call on runtime. Subsequent calls to it will be as normal time.

### 2. Running on Native Image

Now let's run the application on native image. Remember to terminate the previous application if you have not done so (```ctrl+c```)

```
$ sudo docker run -p 8080:8080 complete
20:49:30.654 [main] INFO  io.micronaut.runtime.Micronaut - Startup completed in 91ms. Server Running: http://localhost:8080
```
At this point, notice how much faster the server starts up now, as compared to running it on HotSpot JVM.

Now issue the following commands.

```
$ curl localhost:8080/meetup/random
{"name":"GraalVM"}[joche@time curl localhost:8080/meetup/random
{"name":"Oracle Code One"}
real	0m0.008s
user	0m0.001s
sys	    0m0.002s

$ time curl localhost:8080/abs/java/-99
running abs in Java -> 99
real	0m0.008s
user	0m0.000s
sys	    0m0.003s

$ time curl localhost:8080/abs/ruby/-99
running abs in Ruby -> 99
real	0m0.076s
user	0m0.001s
sys	    0m0.001s
```
That's all folks.

