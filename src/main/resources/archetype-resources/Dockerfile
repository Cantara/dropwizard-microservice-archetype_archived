FROM azul/zulu-openjdk-centos:8
MAINTAINER Kim Christian Gaarder <kim.christian.gaarder@gmail.com>
RUN yum -y install yum-cron
RUN yum -y update
RUN yum -y install curl

# Install Application
RUN adduser ${applicationName}
ADD target/${applicationName}-application-*.jar /home/${applicationName}/${applicationName}-application.jar"
ADD docker/hello-world.yml /home/${applicationName}/${applicationName}.yml
RUN chown ${applicationName}:${applicationName} /home/${applicationName}/${applicationName}.yml
ADD docker/hello-world_override.properties /home/${applicationName}/${applicationName}-override.properties
RUN chown ${applicationName}:${applicationName} /home/${applicationName}/${applicationName}.properties

EXPOSE 21500:21599

WORKDIR "/home/${applicationName}"
CMD [ \
    "java", \
    "-Xdebug", \
    "-Xrunjdwp:transport=dt_socket,address=21515,server=y,suspend=n", \
    "-Dcom.sun.management.jmxremote.port=21516", \
    "-Dcom.sun.management.jmxremote.rmi.port=21516", \
    "-Dcom.sun.management.jmxremote.ssl=false", \
    "-Dcom.sun.management.jmxremote.local.only=false", \
    "-Dcom.sun.management.jmxremote.authenticate=false", \
    "-Djava.rmi.server.hostname=localhost", \
    "-jar", \
    "${applicationName}-application.jar" \
]
