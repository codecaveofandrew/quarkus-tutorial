```shell
docker run --platform linux/amd64 -d --publish 33065:3306 --name sakila restsql/mysql-sakila
```

```properties
#General database config
quarkus.datasource.jdbc.driver=com.mysql.cj.jdbc.Driver
quarkus.datasource.jdbc.url=jdbc:mysql://localhost:33065/sakila
quarkus.datasource.username=root
quarkus.datasource.password=sakila
quarkus.datasource.db-version=5.7.0
# Hibernate config
quarkus.hibernate-orm.log.sql=true
```

docker run --platform linux/amd64 -d --publish 3306:3306 --name sakila restsql/mysql-sakila