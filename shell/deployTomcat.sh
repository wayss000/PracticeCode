!/bin/bash

# set some value
export sourceTomcat=./apache-tomcat-8.0.35

# copy tomcat
for i in {1..20}
  do 
	cp ${sourceTomcat} -r ./tomcat-${i}
	echo "copy tomcat-${i} success"
	let serverPort=7005+${i}
	echo "tomcat-${i} serverPort is ${serverPort}"
	sed -i -e "s:<Server port=\"8005\":<Server port=\"${serverPort}\":g" ./tomcat-${i}/conf/server.xml
	echo "replace Server Port success"
	let httpConnectorPort=8080+${i}
	echo "tomcat-${i} Http Connector Port is ${httpConnectorPort}"
	sed -i -e "s:<Connector port=\"8080\":<Connector port=\"${httpConnectorPort}\":g" ./tomcat-${i}/conf/server.xml
	echo "replace Http Connector Port success"
	let ajpConnectorPort=8009+${i}
	echo "tomcat-${i} Ajp Connector Port is ${ajpConnectorPort}"
	sed -i -e "s:<Connector port=\"8009\":<Connector port=\"${ajpConnectorPort}\":g" ./tomcat-${i}/conf/server.xml
	echo "replace Ajp Connector Port success"
	echo "SUCCESS tomcat-${i}!-------------------------------------------"
 done
