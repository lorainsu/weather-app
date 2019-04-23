# Weather APP Demo Based on Spring Boot

## Preconditions

1. Jenkins service deployed with those setting configured:
  - Auth with FusionStage IAM
  - SonarQube server with name ```sonarqube```
  - FusionStage CPE Plugin
2. Upload those docker images to FusionStage Software Repo with public property:
  - jnlp-slave
  - cpe-docker
  - maven
  - robotframework
  - openjdk
3. On default, JDK1.8 is needed.

## Getting Started

1. Compile and Deploy
    - Modify build script, please refer to [build/README.md](build/README.md)
    - Create pipeline job in jenkins using ```build/Jenkinsfile```
    - Create weather-app Application in FusionStage
    - [Optional] Create ```ClusterIP``` or ```NodePort``` service for weather-app
    
2. Integration Test 
    - Modify test script, please refer to [test/README.md](test/README.md)
    - Create pipeline job in jenkins using ```test/Jenkinsfile```

## Check your weather-app

1. broswer the webpage: [http://weather-service](http://weather-service)
2. get weather api data: [http://weather-service/api/weather/now/UK/London](http://weather-service/api/weather/now/UK/London)

