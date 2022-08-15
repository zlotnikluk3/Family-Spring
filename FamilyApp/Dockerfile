FROM openjdk:8
# Add a new user "zlot" with user id 8877
RUN useradd -u 8877 zlot
# Change to non-root privilege
USER zlot
ADD target/familyapp-docker-project.jar familyapp-docker-project.jar
ENTRYPOINT ["java", "-jar","familyapp-docker-project.jar"]
EXPOSE 9000