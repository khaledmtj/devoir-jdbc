# devoir-jdbc

Prérequis :

La base de donnée utilisée est MySQL qui est démarrée sur localhost. En installant MySQL, on peut ajouter Connector/J à l’installation qui le jdbc propre de MySQL (J’ai installé les dernières version 8.0.28).
Dans l'IDE j'ai ajouter aux "external libraries" le .jar file du Connector/J installé.

Après j’ai créé une database devoirjdbc et une table Etudiants :

create table Etudiants(
	ID_Etudiant INT NOT NULL,
	Departement VARCHAR(25),
	Prenom VARCHAR(25),
	Nom VARCHAR(25),
	Rang INT NOT NULL,
	PRIMARY KEY ( ID_Etudiant )
);

=============================================================

Code :

-Class.forName("com.mysql.cj.jdbc.Driver"); 

On utilize cette ligne pour s’assurer qu’on a le driver necessaire pour mysql.


-Connection con = DriverManager.getConnection(url, username, password);

C’est pour la connection avec la base de donnée, url est sous le format « jdbc : type_de_BD : adresse_de_BD(ici sur localhost) »


- rs.next()
Attribue à rs la ligne suivante du résultat de la requête.


- infoEtudiant += rs.getString(i) + " - ";
Ajoute à chaque iteration la i ème colonne de la table Etudiants au String infoEtudiant pour pouvoir afficher la ligne complète.


- String insert_query = "INSERT INTO Etudiants VALUES (" + id + ", 'EM', 'Khaled', 'Metlej', 10)";
s.executeUpdate(insert_query);

Ajoute l’étudiant Khaled Metlej à la table Etudiants avec un random id.






Résultat de démarrage du code plusieurs fois :

![image](https://user-images.githubusercontent.com/89912488/151709043-92e31d79-09cb-4a7f-8132-c81be8ef84ae.png)


En notant que la nouvelle ligne ajoutée avec l’opération INSERT exécutée dans chaque démarrage du code n’apparait pas mais sur la console mais elle s’effectue bien.

Et on peut s’assurer que les résultats sont correctes avec MySQL Workbench :

![image](https://user-images.githubusercontent.com/89912488/151709076-0c776e67-b2a5-4b17-b8d5-1d9aa61fdffc.png)

