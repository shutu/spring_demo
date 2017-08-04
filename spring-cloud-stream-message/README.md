
# README

## 1. create rabbitmq vhost and user

```
# add vhost
sudo rabbitmqctl add_vhost demo

# Creating user
sudo rabbitmqctl add_user spring_demo password
sudo rabbitmqctl add_user spring_demo2 password

# Setting permissions
sudo rabbitmqctl  set_permissions -p demo spring_demo ".*" ".*" ".*"
sudo rabbitmqctl  set_permissions -p demo spring_demo2 ".*" ".*" ".*"
```



## 2. protocol-buf

download protobuf:

    https://github.com/google/protobuf/releases

    https://github.com/google/protobuf/releases/download/v3.2.0/protoc-3.2.0-osx-x86_64.zip

unzip and add to PATH.

```
protoc --java_out=./ ProtobufMessage.proto
```