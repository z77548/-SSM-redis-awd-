#!/bin/sh
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)
rm -rf /usr/erbaoawd/team/* 