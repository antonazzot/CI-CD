
FROM openjdk:17
EXPOSE 8080
ADD target/kubernetec.jar kubernetec.jar
ENTRYPOINT ["java","-jar","/kubernetec.jar"]