spring_docker_example
=====================

- run gradle distDocker => crates a Docker file in build/
- cd build/docker
- docker build . # creates docker image
- docker images #  newly created imaged should be visible
- docker run <image_id> as given from last command
- docker ps # show running docker images
- docker port <name_of_the_image> # show port number which have been forwarded
- boot2docker ip # show ip adresse of virtual box image (needed to connected to server)
- browser: http://192.168.59.103:49154/hello-world # go

