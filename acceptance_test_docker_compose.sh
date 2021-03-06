#!/bin/bash
#test $(curl --silent localhost:8090/sum?a=1\&b=2) -eq 3 || \    # true when it runs on host
#test $(curl --silent $(docker network inspect -f '{{range .IPAM.Config}}{{.Gateway}}{{end}}' bridge):8090/sum?a=1\&b=2) -eq 3  # true on docker
CALCULATOR_PORT=$(docker-compose port calculator 8090 | cut -d: -f2)
test $(curl --silent localhost:$CALCULATOR_PORT/sum?a=1\&b=2) -eq 3
echo $(curl --silent localhost:$CALCULATOR_PORT/sum?a=1\&b=2)
