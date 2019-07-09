# Developer Meetup on GraalVM
The developer meetup provides an introduction to GraalVM and how it can be used to build simple polyglot applications. You will be going through a technical sharing on GraalVM and participating in a hands-on lab on building your own polyglot application on GraalVM.

## Agenda

- Introduction to GraalVM
- Accessing your development environment (Oracle Cloud Developer Image)
- Installing Micronaut
- Creating a Micronaut application with GraalVM
- Embedding Ruby languange into Java (Polyglot)
- Building the fatjar
- Building the native image

## Accessing Workshop Infrastructure

##### Prerequisites

- For this workshop, you need a laptop (e.g. windows, mac os, linux) with a SSH client. 
- Able to work in a Linux environment.

##### Cloud Developer Instance

A cloud compute instance ([Oracle Cloud Developer Image](https://cloudmarketplace.oracle.com/marketplace/en_US/listing/54030984)) has been provisioned and you should be able to access it via your laptop and use it throughout the duration of the workshop. 

##### Access Information

The access pack for the instance (host detail and SSH keys) will be emailed to you individually after registering with the lab assistants. Each individual will be allocated one dev instance for your usage throughout the duration of the workshop.

Access the instance with SSH key for **opc** user.

**Note**: For Windows users accessing the instance with Putty, you need to [convert the provided key to Putty format](https://devops.ionos.com/tutorials/use-ssh-keys-with-putty-on-windows/).

## Lab Instructions

Note that once you have downloaded the access pack, you should be able to access your assigned instance with SSH. To verify that the instance is correct, try checking the version of ```Java```as follows.

```
$ ssh -i /path/to/id_rsa.txt opc@<server_host>

[opc@javaociinstance ~]$ java -version
java version "1.8.0_212"
Java(TM) SE Runtime Environment (build 1.8.0_212-b31)
Java HotSpot(TM) GraalVM EE 19.0.0 (build 25.212-b31-jvmci-19-b01, mixed mode)
```

You should see that GraalVM is already installed on the instance.

## Hands-on Labs

The hands-on workshop is organized into the following sections in order. 

Estimated time: 45 min

- [1. Micronaut Graal Application](labs/1_micronaut.md)
- [2. Graal Polyglot API](labs/2_polyglot.md)
- [3. Building Native Image](labs/3_nativeImage.md)
- [4. Performance](labs/4_performance.md)

## Notes

We recommend you to follow the instructions above and create the app step by step. However, you can go right to the completed example by cloning the git repository.

```
$ git clone https://github.com/jweiming/graalvm-micronaut-polyglot
```

## Credits

The labs and materials are referenced to official GraalVM resources.
- https://guides.micronaut.io/micronaut-creating-first-graal-app/guide/index.html
- https://www.graalvm.org/docs/getting-started/
- https://www.graalvm.org/docs/getting-started/#native-images

