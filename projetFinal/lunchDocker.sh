#!/bin/bash

cp nginx.conf /var/tmp/$USER/nginx.conf

docker run -it --rm --name my-custom-nginx-container --network host -v /var/tmp/$USER/nginx.conf:/etc/nginx.conf:ro nginx

