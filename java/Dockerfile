FROM centos:centos7.9.2009
RUN yum install -y java-1.8.0-openjdk-headless-1.8.0.302.b08-0.el7_9.x86_64
COPY testdns.jar /

ENTRYPOINT ["java", "-jar", "/testdns.jar"]
