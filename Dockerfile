# 使用官方Java运行时作为父镜像
FROM maven:3.8.6-openjdk-17 AS build

# 设置工作目录
WORKDIR /workspace

# 将Maven设置为非交互模式, 避免在构建过程中出现用户输入请求
ARG MAVEN_CLI_OPTS="--batch-mode --update-snapshots"

# 添加应用程序并执行构建
COPY . .
RUN mvn $MAVEN_CLI_OPTS clean package

# 转换阶段以构建最终镜像
FROM openjdk:17
VOLUME ["/tmp"]
COPY --from=build /workspace/ruoyi-admin/target/ruoyi-admin.jar app.jar

EXPOSE 8088

## 容器启动时执行的命令
ENTRYPOINT ["java","-jar","/app.jar","--server.port=8088"]

