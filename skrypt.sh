#!bin/bash

while  java Db init -eq 0 ; do
	sleep 300s
done
