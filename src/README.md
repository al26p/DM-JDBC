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
### Alternative :
Vous pouvez directement lancer le script associée à votre SE (.bat => Windows | .sh => Linux)

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

## Evaluation du travail 

### Choix des requêtes :
Les requêtes suivantes ont été réalisées :
- Population par pays
- Espérance de vie par continent

Les résultats retournés par le programme Java est cohérent avec les données présentes dans les tables.

### Auto-évaluation :

CONFORME + 
- JavaDoc non demandée
- Choix de la BdD directement depuis la console (pas besoin de donner d'arguments)



© Sébastien FERRARI - Alban PRATS