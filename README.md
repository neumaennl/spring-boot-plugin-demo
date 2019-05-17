Spring Boot Plugin Demo
=======================

This project shows how to build an application that supports plugins using Spring Boot, Java 11, and maven.

To build the project, go into the `Builder` directory and execute `mvn clean package`. This will only work if you have maven 3.5+ and that maven can find a Java 11 JDK.

To run the application after it was built, execute `java -jar <path to>/CombinedApp/target/springBoot.plugin.demo.combinedApp-1.0.0-SNAPSHOT.jar`. The `java` binary has to be part of a Java 11 JVM.

Check the console output for the port the application is running on (usually port 8080) and then open a web browser and go to `localhost:<port>` (e.g. `localhost:8080`).

The application can be stopped by pressing `Ctrl+C` in the console window where the application was started.