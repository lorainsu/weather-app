## Before We Start

#### Configuration for Helm deploy
1. Edit parameters in values.yaml
    - namespace
    - image
  
2. Add tag on node in FusionStage:
    > demo.weather: weather-app

#### Helm file package
``` shell
cd weather-app/build/helm
tar zcvf weatherapp-1.0.0.tgz weatherapp/
``` 
