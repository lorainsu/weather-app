## Before we start

On default, JDK1.8 is needed. 
If you want to use JDK1.7, exec ```git apply jdk7.patch``` to enable it.


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
