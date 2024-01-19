FROM node:0.12.17  as build-stage1

WORKDIR /app
# COPY package*.json ./
# COPY *.js  ./
# COPY *.env.*  ./
COPY . ./

RUN npm install -g bower@1.8.14   && \
    npm install -g grunt@0.4.5  && \
    npm install -g grunt-cli@0.1.13  && \
    npm install

RUN grunt build
# RUN ls --recursive
# RUN find /app -name \*.war

FROM tomcat:9.0-jdk8 as production-stage

COPY --from=build-stage1 /app/build /usr/local/tomcat/webapps/build


ENV TZ=Asia/Taipei
