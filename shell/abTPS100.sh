#!/bin/bash

for i in {1..20}
do
    let serverPort=8080+${i}
    echo "tomcat-${i} starting..."
    ab -n100000 -c100 http://localhost:${serverPort}/webtest/TestSession?sleepSec=1 &
done
