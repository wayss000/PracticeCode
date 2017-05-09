#!/bin/bash

# start all tomcat
for i in {1..20}
  do
  	./tomcat-${i}/bin/startup.sh
  done
