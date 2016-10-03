#!/usr/bin/env bash
docker run -d --name=${applicationName} -p 21500-21599:21500-21599 <your docker user>/${applicationName}
