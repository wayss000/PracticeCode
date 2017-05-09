#!/bin/bash

for i in {1..20}
do
    cp ./webtest.war ./tomcat-${i}/webapps
    echo "cp tomcat-${i} success"
done

