#!/usr/bin/env bash
echo stopping ${applicationName}
docker stop ${applicationName}
echo removing ${applicationName}
docker rm ${applicationName}
echo list active docker containers
docker ps
