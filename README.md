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



## Lab Instructions

##### SSH Connection
Note that once you have downloaded the access pack, you should be able to access your assigned instance with SSH. To verify that the instance is correct, try checking the version of ```Java```as follows.

```
$ ssh -i /path/to/id_rsa.txt opc@<server_host>

[opc@javaociinstance ~]$ java -version
java version "1.8.0_212"
Java(TM) SE Runtime Environment (build 1.8.0_212-b31)
Java HotSpot(TM) GraalVM EE 19.0.0 (build 25.212-b31-jvmci-19-b01, mixed mode)
```

You should see that GraalVM is already installed on the instance.

**Note**: For Windows users accessing the instance with Putty, you need to [convert the provided key to Putty format](https://devops.ionos.com/tutorials/use-ssh-keys-with-putty-on-windows/).

##### (Optional) Enabling VNC Server

You do not require VNC connection to complete the workshop. However, if you want to connect and use a GUI for the Linux desktop, enable the VNC Server and connect to it using a VNC client.

```
$ ssh -i /path/to/id_rsa.txt opc@<server_host>
$ Last login: Thu Jul 11 06:35:22 2019
$ vncserver
xauth:  file /home/opc/.Xauthority does not exist

New 'graalmeetup-1-0:1 (opc)' desktop is graalmeetup-1-0:1

Creating default config /home/opc/.vnc/config
Starting applications specified in /home/opc/.vnc/xstartup
Log file is /home/opc/.vnc/graalmeetup-1-0:1.log
```

Next connect your VNC client to it ```<HOST_IP>:1```. When prompted, use password ```welcome1```.


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
$ git clone https://github.com/oracle-apac-user-group/graalvm-polyglot.git
```

## Supplementary Labs

You can learn how to extend on the lab exercises here to [develop microservices with GraalVM Micronaut on Oracle Cloud](https://medium.com/@jeff.salleh/developing-microservices-with-graalvm-micronaut-on-oracle-cloud-b46b0674fe0c).

## Credits

The labs and materials are referenced to official GraalVM resources.
- https://guides.micronaut.io/micronaut-creating-first-graal-app/guide/index.html
- https://www.graalvm.org/docs/getting-started/
- https://www.graalvm.org/docs/getting-started/#native-images

