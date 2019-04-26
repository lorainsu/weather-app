## Before we start
Please modify those settings before compile the application

- Dockerfile<br>
  - modify the address of openjdk:<br>
  >  FROM 172.22.242.81:20202/cpe-tools/openjdk:8-jdk-alpine

- Jenkinsfile<br>
  - modify variable ```software_repo```
  - modify variable ```repo_namespace```
  - modify docker images names:tag to the real one in ```containers```
  - change the git addr to your own in Stage ```CodeCheckout```,  and make sure the credentialsId exist in jenkins:<br>
  > userRemoteConfigs: [[credentialsId: 'lorainsu', url: 'https://github.com/lorainsu/weather-app.git']]])
  
- Add tag to one or more nodes in FusionStage "Project Management > Node" webpage with:
  > tool.jenkins-slave: jenkins-slave
