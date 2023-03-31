#!/bin/sh
echo $1
exec docker run --net=host bcgovimages/aries-cloudagent:py36-1.16-0_0.6.0 start --label Alice -it http 0.0.0.0 8000 -ot http --admin 0.0.0.0 11000 --admin-insecure-mode --genesis-url http://localhost:9000/genesis --seed $1 --endpoint http://localhost:8000/ --debug-connections --auto-provision --wallet-type indy --wallet-name Alice1 --wallet-key secret

