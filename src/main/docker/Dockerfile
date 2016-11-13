FROM java
ADD /libs/${name}-${version}.jar /${name}-${version}.jar
VOLUME /logs
ENTRYPOINT ["java", "-jar", "/${name}-${version}.jar"]