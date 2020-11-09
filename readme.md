module add --name=com.mysql --resources="C:\Users\Leandro\.dev\wildfly-21.0.0.Final\mysql-connector-java-8.0.22.jar" --dependencies=javax.api,javax.transaction.api

/subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql,driver-module-name=com.mysql,driver-xa-datasource-class-name=com.mysql.cj.jdbc.MysqlXADataSource)