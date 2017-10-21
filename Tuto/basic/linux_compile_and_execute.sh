rm JdbcTutorial.class
javac -classpath .:mysql-connector-java-5.1.38-bin.jar JdbcTutorial.java
java  -classpath .:mysql-connector-java-5.1.38-bin.jar JdbcTutorial jdbc:mysql://PC-TP-MYSQL.insa-lyon.fr:3306/EUROSTATS_EXTR CELV_78 TPSQL_2017
