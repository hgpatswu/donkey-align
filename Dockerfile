FROM donkeyhuang.tpddns.cn:5000/fast-align:2.0

USER root
WORKDIR /app
ARG JAR_FILE
COPY ${JAR_FILE} app.jar

ENTRYPOINT ./entrypoint.sh
