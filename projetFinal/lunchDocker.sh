#!/bin/bash

mkdir -p /tmp/$USER
cp -r nginx /tmp/$USER/nginx

docker run -it --rm --name my-custom-nginx-container --network host -v /tmp/$USER/nginx/conf.d:/etc/nginx/conf.d:ro nginx
