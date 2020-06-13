# https://medium.com/zolo-engineering/deploying-active-mq-in-a-kubernetes-cluster-3674f4fd6210
FROM openjdk:8-jre-alpine
WORKDIR /home/alpine
RUN apk update && apk add wget
RUN wget -O amq.tar.gz http://apachemirror.wuchna.com//activemq/5.15.13/apache-activemq-5.15.13-bin.tar.gz && tar -xvf amq.tar.gz
EXPOSE 8161 61616 5672 61613 1833
CMD ["/bin/sh","apache-activemq-5.15.13/bin/activemq","console"]