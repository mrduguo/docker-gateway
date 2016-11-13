# API Gateway For Microservice with Docker/Consul [![Build Status](https://travis-ci.org/mrduguo/docker-gateway.svg?branch=master)](https://travis-ci.org/mrduguo/docker-gateway)


## run the docker image

```
docker run -it --rm --net=host mrduguo/docker-gateway
```

Then the gateway can be accessed from:

* [http://192.168.99.100/](http://192.168.99.100/) or [http://127.0.0.1/](http://127.0.0.1/)


## sample build command

#### build artifact locally

```
./gradlew
```

#### run locally

```
./gradlew run

Then the gateway can be accessed from:

* [http://192.168.99.100:8888/](http://192.168.99.100:8888/) or [http://127.0.0.1:8888/](http://127.0.0.1:8888/)

## continuous integration

https://travis-ci.org/mrduguo/docker-gateway
https://hub.docker.com/r/mrduguo/docker-gateway/

```