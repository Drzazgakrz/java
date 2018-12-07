FROM java:8
RUN curl -L -o /mysql-connector-java-8.0.13.jar https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.13/mysql-connector-java-8.0.13.jar
COPY ./Db.java ./
COPY ./skrypt.sh ./skrypt.sh
RUN javac Db.java
RUN chmod 777 ./skrypt.sh
CMD [ "java", "-classpath","mysql-connector-java-8.0.13.jar", "Db", "init"]
RUN ./skrypt.sh
