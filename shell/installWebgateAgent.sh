#!/bin/bash

for i in {1..20}
  do
  	sed -i "111i \  " ./tomcat-${i}/bin/catalina.sh
	sed -i "112i \# webgate" ./tomcat-${i}/bin/catalina.sh
	sed -i "113i JAVA_OPTS=\"\$JAVA_OPTS -javaagent:/home/bes/webgate-agent/lib/webgate-agent.jar\"" ./tomcat-${i}/bin/catalina.sh
	echo "tomcat-${i} WebGate Agent Install Success"
  done
