# Start with a base image containing Java runtime
FROM openjdk:21-jdk as build

# Information around who maintains the image
MAINTAINER github.com/julio-Pereira

# Add the application's jar to the image
COPY target/finance-accounts-24.1.1-SNAPSHOT.jar finance-accounts-24.1.1-SNAPSHOT.jar

# Execute the application
ENTRYPOINT ["java","-jar","finance-accounts-24.1.1-SNAPSHOT.jar"]
