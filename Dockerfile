FROM openjdk:8
ADD target/tai-app.war tai-app.war
ADD database.db database.db
ADD sequence sequence
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "tai-app.war"]