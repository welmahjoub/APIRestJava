
TP-Restlet

*****
* Objectif
*****

L'objectif principal de ce TP est de construire une API REST de type Twitter
en utilisant le framework Restlet. (http://restlet.com/).

*****
* Découverte
*****

Explorez les sources et familiarisez vous avec l'architecture de l'application.
Pour cela, vous pouvez suivre l'ordre suivant:
    - les objets interes
    - la base de données en mémoire
    - les ressources
    - l'application


La compilation des fichier sources et la génération du JAR de l'application
se fera �  travers l'outil maven. Si vous avez besoin de l'installer,
rendez-vous �  l'adresse https://maven.apache.org/.

Une fois maven installé, ouvrez le fichier 'pom.xml' et notez les dépendances.
C'est le moment d'utiliser la ligne de commande. Pour générer le JAR de
l'application, allez �  la racine du projet (l�  où se trouve le fichier
'pom.xml') et entrez la commande `mvn package`. Vous venez de créer le JAR de votre 
application, qui doit se trouver dans un nouveau répertoire 'target'. Vous
pouvez lancer le serveur avec la commande `java -jar uber-mta-0.0.1.jar` lancée
depuis l'intérieur du répertoire 'target'.

Le serveur doit maintenant tourner, et être prêt �  recevoir vos requêtes.
Essayons les requêtes suivantes, que vous pouvez lancer depuis un autre
terminal:


    // ajouter un user
    $ curl -X POST -H "Content-type:application/json" -H "Accept:application/json" -d "{\"name\":\"peter\", \"age\":30}" http://localhost:8124/users
    
    $ curl http://localhost:8124/users : //liste de tous les users
	$curl http://localhost:8124/users/0  : // afficher un user
	$curl -X DELETE http://localhost:8124/users/0 : //supprimer un user

	$curl http://localhost:8124/users/tweets  :  //liste de tous les tweets
	$curl http://localhost:8124/users/0/tweets : //liste de tous les tweets d'un user

    // ajouter un tweet
	$ curl -X POST -H "Content-type:application/json" -H "Accept:application/json" -d "{\"contenu\":\"myMessage\"}" http://localhost:8124/users/0/tweets

Vous pouvez ouvrir un navigateur et entrer l'adresse http://localhost:8124/users

Observez le résultat des requêtes du côté des clients (curl et navigateur) et
l'output côté serveur.


*****
* API
*****

Nous souhaitons mettre en place l'API suivante:

URI                     | commande   | description
--------------------------------------------------------------------
/users                  | GET        | retoure la liste des utilisateurs 
/users                  | POST       | ajoute un utilisateur
/users/{userId}         | GET        | retourne la description de l'utilisateur {userId} 
/users/{userId}         | DELETE     | supprime l'utilisateur {userId}
/users/{userId}/tweets  | POST       | ajoute un tweet �  la liste des tweets de l'utilisateur {userId}
/users/{userId}/tweets  | GET        | retourne la liste des tweets de l'utilisateur {userId}

Une partie de l'API est actuellement supportée par l'application. A vous de la compléter.


*****
* Roadmap primaire 
*****

* Ajouter la classe Tweet aux 'internals' et modifiez la classe User
pour qu'un utilisateur ait sa propre liste de tweets.

* Ajouter une classe TweetsResource vers laquelle les requêtes pour l'URI 
/users/{userId}/tweets seront dirigées 

* Rajoutez l'URI /users/{userId}/tweets et son mapping vers la classe
TweetsResource.

* Testez régulièrement

*****
* Roadmap secondaire
*****

* Ajouter la fonctionnalité de supression d'un utilisateur

* Ajouter une URI /users/tweets qui retourne l'ensemble des tweets de tous les
utilisateurs sur réception d'une requête de type GET
