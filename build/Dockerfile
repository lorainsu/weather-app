FROM {fusionstage_swr_host}/cpe-tools/openjdk:8-jdk-alpine
Volume /tmp
ADD sample.jar sample.jar
ENTRYPOINT ["java","-jar","/sample.jar"]
