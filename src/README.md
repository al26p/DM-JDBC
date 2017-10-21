# DM-JDBC final
Dossier contenant les fichiers JAVA du projet fini

## Execution du programme
Procédure pour lancer l'application :
### * Windows
Dans un terminal : 
```
java -classpath .;mysql-connector-java-5.1.38-bin.jar Main
```
### * Linux & OSX
Dans un terminal : 
```
java -classpath .:mysql-connector-java-5.1.38-bin.jar Main
```

## Re-compilation
Certains fichiers ont besoin d'un classpath spécifique pour être recompilés :
### * Windows:
Dans un terminal : 
```
javac -classpath .;mysql-connector-java-5.1.38-bin.jar InterrogBD.java
javac LibelleValeur.java
javac Main.java
```
### * Linux & OSX
Dans un terminal : 
```
javac -classpath .:mysql-connector-java-5.1.38-bin.jar InterrogBD.java
javac LibelleValeur.java
javac Main.java
```
