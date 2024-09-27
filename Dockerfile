## 设置基础镜像
FROM openjdk:17

## 设置进入容器时的工作目录
WORKDIR /root/app
## 将本地目录复制进容器目录中
COPY ./ruoyi-admin/target/ruoyi-admin.jar /root/app/app.jar

EXPOSE 8088

## 容器启动时执行的命令
ENTRYPOINT ["java","-jar","/root/app/app.jar"]

