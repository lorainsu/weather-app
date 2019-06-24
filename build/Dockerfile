FROM {software_repo}/{repo_namespace}/openjdk:8-jdk-alpine
Volume /tmp
ADD sample.jar sample.jar
ENTRYPOINT ["java","-jar","/sample.jar"]
