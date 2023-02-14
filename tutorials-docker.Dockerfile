FROM openjdk:19
COPY target/ValleInclanTutoriales-0.0.1-SNAPSHOT.jar /tutorialsapp.jar
CMD ["java", "-jar", "/tutorialsapp.jar"]