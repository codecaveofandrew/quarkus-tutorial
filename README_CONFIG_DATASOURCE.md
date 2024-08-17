```xml
      <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-hibernate-orm-rest-data-panache</artifactId>
        </dependency>
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-jdbc-mysql</artifactId>
        </dependency>
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
quarkus.hibernate-orm.database.generation=update
quarkus.datasource.db-kind=mysql
```