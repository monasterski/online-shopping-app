FROM openjdk:8
ADD target/tai-app.war tai-app.war
ADD database.db database.db
ADD sequence sequence
CMD java -Dserver.port=$PORT -Xmx350m -jar tai-app.war