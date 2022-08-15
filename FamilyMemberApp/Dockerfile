FROM openjdk:8
# Add a new user "zlot" with user id 8877
RUN useradd -u 8877 zlot
# Change to non-root privilege
USER zlot
ADD target/familymemberapp-docker-project.jar familymemberapp-docker-project.jar
ENTRYPOINT ["java", "-jar","familymemberapp-docker-project.jar"]
EXPOSE 9100