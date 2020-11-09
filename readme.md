# CRUD usuário WK-backend

Este é o banckend desenvolvido em Java com MySQL, veja tambem o frontend desenvolvido em Flutter nesse link https://github.com/leandrorochaadm/wk-frontend-flutter

**Gravei um video ensinando a configurar o ambiente no Linux... Clique na imagem abaixo e veja o video ensinando a configurar o ambiente de desenvolvimento com Eclipse, WindFly e MySQL**

[![](http://img.youtube.com/vi/Chq99u1Nvek/0.jpg)](http://www.youtube.com/watch?v=Chq99u1Nvek "Como configurar WildFly 20 com MySql 8 e Eclipse EE no Linux")



obs: Recomendamos instalar as mesmas versões que utilizamos nesse projeto.
* Java 11
* [MySQL 8.0.21](https://dev.mysql.com/downloads/connector/j/)
* [WildFly 20.0.1 ](https://www.wildfly.org/downloads/)
* [Eclipse IDE for Enterprise Java Developers ](https://www.eclipse.org/downloads/packages/release/2020-06/r/eclipse-ide-enterprise-java-developers)
* Maven 3.6.3

---
 ### Comando pra adicionar modulo MySQL

module add --name=com.mysql --resources="__caminho pro jar do Mysql__\mysql-connector-java-8.0.22.jar" --dependencies=javax.api,javax.transaction.api

### Comando pra adicionar o DataSource
´´´
/subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql,driver-module-name=com.mysql,driver-xa-datasource-class-name=com.mysql.cj.jdbc.MysqlXADataSource)
´´´