rm JdbcTutorial.class
javac -classpath .:mysql-connector-java-5.1.38-bin.jar JdbcTutorial.java
java  -classpath .:mysql-connector-java-5.1.38-bin.jar JdbcTutorial <<AdresseBD>> <<Login>> <<Password>>
