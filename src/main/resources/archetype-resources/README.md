# ${applicationName}
A runnable microservice devops-ready java application built on DropWizard, Spring IoC, and more

## Build
```
mvn install
```

## Run
```
java -jar target/${artifactId}-${version}.jar
or 
./run.sh 
or 
run.bat
```

## Validate

```
https://localhost:8080/${applicationName}
```

*Healthcheck*
```
http://localhost:8081/${applicationName}/healthcheck
```

