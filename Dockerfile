FROM java:8
RUN curl -L -o /mysql-connector-java-8.0.13.jar https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.13/mysql-connector-java-8.0.13.jar
ENV CLASSPATH=/mysql-connector-java-8.0.13.jar:${CLASSPATH}
COPY ./myCode/db.java ./
RUN javac db.java
CMD java db
