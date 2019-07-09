# 1. Creating a Micronaut application with GraalVM native image

This project contains the completed code for a Micronaut application that uses GraalVM native image. In this example, you will be building the Micronaut application with Gradle and compiling the native-image (AOT) using the guest language (Ruby) as a polyglot application.

### 1.1 What you will need

To complete the example, you will need the following:

- Some time on your hands
- Linux environment
- GraalVM ([Installation guide](https://www.graalvm.org/docs/getting-started/))

### 1.2 Installing guest language

Java runs the JVM with GraalVM's default compiler. The Ruby, Python executables become available only if you install the corresponding language engines. For this example, you need to install Ruby.

```
$ gu install ruby
```

### 1.3 Building the Micronaut application

The native-image tool was extracted from the base GraalVM distribution. 

```
$ cd graalvm-micronaut-polyglot/
$ ./gradlew assemble
```
The output fatjar will be in the ```./build/lib/``` directory.

### 1.4 Verifying the application (Optional)

You can run the jar file and execute GET calls to the service to verify the response.

```
$ java -jar ./build/lib/complete-0.1.jar
23:06:04.585 [main] INFO  io.micronaut.runtime.Micronaut - Startup completed in 996ms. Server Running: http://localhost:8080
```
Open another terminal tab and try the following ```curl``` commands.

```
$  curl localhost:8080/meetup/random
{"name":"Autonomous Data Warehouse"}

$  curl localhost:8080/abs/ruby/-99
running abs in Ruby -> 99
```
### 1.5 Building the native image

In this example, ```Ruby``` language is embedded into the Micronaut Java application. We will need to include it as a guest language in the following command. Do note that this process includes the AOT and builds the native image will take some time (up to 10 mins).

```
$ native-image --no-server --language:ruby -cp build/libs/complete-*.jar 
```
Once this process is completed, you can run the application.
```
$ ./complete
23:16:03.585 [main] INFO  io.micronaut.runtime.Micronaut - Startup completed in 541ms. Server Running: http://localhost:8080
```

### 1.6 Performance

##### 1.6.1 Hotspot JVM

```
$ java -jar ./build/lib/complete-0.1.jar
23:06:04.585 [main] INFO  io.micronaut.runtime.Micronaut - Startup completed in 996ms. Server Running: http://localhost:8080

$ time curl localhost:8080/meetup/random
{"name":"Autonomous Data Warehouse"}
real	0m0.136s
user	0m0.003s
sys	    0m0.001s

$ time curl localhost:8080/meetup/random
{"name":"Oracle Code One"}
real	0m0.012s
user	0m0.001s
sys	    0m0.004s

$ time curl localhost:8080/abs/java/-99
running abs in Java -> 99
real	0m0.012s
user	0m0.001s
sys	    0m0.003s

$ time curl localhost:8080/abs/ruby/-99
running abs in Ruby -> 99
real	0m1.510s
user	0m0.002s
sys	0m0.001s

```

##### 1.6.2 Native image

```
$ ./complete 
20:49:30.654 [main] INFO  io.micronaut.runtime.Micronaut - Startup completed in 91ms. Server Running: http://localhost:8080

$ curl localhost:8080/meetup/random
{"name":"GraalVM"}[joche@time curl localhost:8080/meetup/random
{"name":"Oracle Code One"}
real	0m0.008s
user	0m0.001s
sys	    0m0.002s

$ time curl localhost:8080/meetup/random
{"name":"Wercker"}
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
sys	    0m0.002s
```

### 1.6 References
- https://guides.micronaut.io/micronaut-creating-first-graal-app/guide/index.html
- https://www.graalvm.org/docs/getting-started/
- https://github.com/graalvm/graalvm-demos/tree/master/java-kotlin-aot


