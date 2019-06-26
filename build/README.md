## Before we start
Please modify those settings before compile the application

- Dockerfile<br>
  - modify the repo address and namespace of openjdk:<br>
  >  FROM 172.22.243.245:20202/cpe-tools/openjdk:8-jdk-alpine

- Jenkinsfile<br>
  - modify variable ```software_repo```
  - modify variable ```repo_namespace```
  - change the git addr to your own in Stage ```CodeCheckout```,  and make sure the credentialsId exist in jenkins:<br>
  > userRemoteConfigs: [[credentialsId: 'lorainsu', url: 'https://github.com/lorainsu/weather-app.git']]])

- Jenkins config
  - Jenkins slave
  
    Add tag to one or more nodes in FusionStage "Project Management > Node" webpage with:
    > tool.jenkins-slave: jenkins-slave
  - Jenkins master
    1. Enable FusionStage IAM Auth in "SystemManage>GlobalScurityConfig>enable Security", and login again.
    2. Config FusionStage CPE Plugin in "SystemManage>SystemConfig".
