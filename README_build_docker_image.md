

| **Dockerfile**            | **使用场景**                                     | **特点**                                                                 | **适用场景**                                                   |
|---------------------------|------------------------------------------------|--------------------------------------------------------------------------|---------------------------------------------------------------|
| **Dockerfile.jvm**        | 标准Java应用                                    | 使用JVM，标准的Java虚拟机环境                                             | 适合JVM性能满足需求的应用                                      |
| **Dockerfile.native**     | 本地镜像                                        | 使用GraalVM生成的本地镜像，启动快、内存占用低                              | 适合云原生、微服务，资源有限的环境                             |
| **Dockerfile.native-micro** | 极端资源限制的微服务                            | 针对极端资源限制优化，提供最低的内存占用和最快的启动时间                    | 适合在Kubernetes中部署性能要求严格的微服务                     |
| **Dockerfile.legacy-jar** | 传统JAR部署                                    | 用于传统系统，不需要容器优化                                              | 适合传统的JAR部署方式的系统                                    |
**推荐：** 在Kubernetes部署时，通常Dockerfile.native是最佳选择，平衡了性能和资源效率。对于极端资源限制的情况，推荐使用Dockerfile.native-micro。


Install minikube: https://minikube.sigs.k8s.io/docs/start/?arch=%2Fmacos%2Farm64%2Fstable%2Fhomebrew#Service


```shell
kubectl run sakila-db --image=restsql/mysql-sakila --port=3306 --restart=Never
kubectl expose pod sakila-db --type=NodePort --name=sakila-service
kubectl port-forward service/sakila-service 33066:3306
```

```properties
## Production environment
%prod.quarkus.datasource.jdbc.url=jdbc:mysql://10.101.184.30:3306/sakila
```


```shell
./mvnw package -Pnative -Dquarkus.container-image.build=true -DskipTests -Dquarkus.native.container-build=true -Dquarkus.profile=prod
```
1.	./mvnw package：使用 Maven Wrapper (mvnw) 来打包项目。这个命令会编译项目并打包成一个 JAR 文件或其他指定格式的可执行文件。
2.	-Pnative：激活 native Maven profile，用于生成原生镜像（GraalVM Native Image）。这会将应用程序编译为二进制可执行文件。
3.	-Dquarkus.container-image.build=true：指示 Quarkus 构建 Docker 镜像。这个选项会自动使用 Dockerfile 生成 Docker 镜像。
4.	-DskipTests：跳过单元测试阶段，加快构建速度，尤其在你确信代码没有问题时使用。
5.	-Dquarkus.native.container-build=true：指示在容器内进行原生镜像的构建。这个选项通常用于在没有本地安装 GraalVM 的情况下，利用容器环境来构建原生镜像。
6.  -Dquarkus.profile=prod 使用生产环境配置

```shell
minikube image load andrew/code-with-quarkus:1.0.0-SNAPSHOT
```

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: code-with-quarkus
spec:
  replicas: 1
  selector:
    matchLabels:
      app: code-with-quarkus
  template:
    metadata:
      labels:
        app: code-with-quarkus
    spec:
      containers:
        - name: code-with-quarkus
          image: andrew/code-with-quarkus:1.0.0-SNAPSHOT
          ports:
            - containerPort: 8080
```

```shell
kubectl apply -f deploy.yaml
kubectl expose deployment code-with-quarkus --type=NodePort --port=8080 --target-port=8080
kubectl port-forward service/code-with-quarkus 8085:8080

```