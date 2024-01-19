FROM gradle:6.9.4-jdk8 AS build 
COPY --chown=gradle:gradle . /home/gradle 
# COPY --chown=gradle:gradle [".git", "/home/gradle/.git"]

WORKDIR /home/gradle
# RUN ls -la --recursive /home/gradle/

RUN git config --global user.email "you@example.com"  &&  \
    git config --global user.name "Your Name"    &&   \
    git config --global init.defaultBranch develop  &&  \
    git config --global --add safe.directory /home/gradle  &&   \
    git add /home/gradle/src   &&  \
    git commit -m "test git version"   &&  \
    git rev-parse HEAD   
RUN gradle build --no-daemon  --stacktrace  
# RUN ls --recursive /home/gradle/ 
RUN find /home/gradle/ -name \*.war
# docker build -t test . --progress plain --no-cache

FROM registry.access.redhat.com/ubi8/openjdk-8:1.13
WORKDIR /deployments
VOLUME /tmp
COPY --from=build /home/gradle/build/libs/*.war /deployments/app.war

ENV TZ=Asia/Taipei
ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=docker $JAVA_OPTS -jar /deployments/app.war"]
# docker build -t test . 
# docker 