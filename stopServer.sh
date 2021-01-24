#!/bin/bash
echo 'Stoping servers..'
ps -ef | grep java | grep -v grep | awk '{print $2}' | xargs kill
echo 'Servsrs Stoped..'