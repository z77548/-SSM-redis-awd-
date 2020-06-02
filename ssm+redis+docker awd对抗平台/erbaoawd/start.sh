#!/bin/sh
docker start $(docker ps -a -q)
