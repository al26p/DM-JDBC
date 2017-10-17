Ce dossier contient un exemple de requête SQL exécutée en utilisant du code Java en utilisant la bibliothèque JDBC.

Pour compiler et exécuter l'exemple, suivre les instructions décrites dans le document "JDBC instructions compilationTuto".

Commencez par tester la version présente dans le dossier "basic". Le dossier "advanced" présente une solution permettant d'avoir un meilleur affichage du résultat de la requête.

Voici une courte introduction au processus utilisé dans ces exemples :
1/ Création de la connexion avec le serveur contenant la base de donnée
2/ Création d'une string contenant la requête à exécuter. Dans cet exemple la requête est: Récupérez les informations concernant les pesticides utilisés au Royaume-Uni ==> select * from pesticides where geo='UK'
3/ Communication de la requête au serveur auquel nous nous sommes précédemment connectés
4/ Affichage des résultats


Il est plus que conseillé de tester ce tutoriel et de vérifier que vous comprenez le fonctionnement du code avant de commencer le DM. Si vous avez des questions n'hésitez pas à contacter votre enseignant.

Si vous avez des remarques pour améliorer ce tutoriel n'hésitez pas à les signaler (O,..,O)