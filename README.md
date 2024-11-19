# Projet : Citronix 🌱🍋

## Contexte du Projet
Le projet **Citronix** vise à développer une application de gestion complète pour une ferme de citrons. L'objectif est d'aider les fermiers à suivre la production, la récolte, et la vente de leurs produits tout en optimisant la productivité des arbres en fonction de leur âge.

---

## Fonctionnalités Principales
### Gestion des Fermes
- Créer, modifier et consulter les informations d'une ferme :
    - Nom, localisation, superficie, date de création.
- **Recherche multicritère** (Criteria Builder).

### Gestion des Champs
- Associer des champs à une ferme avec une superficie définie.
- **Validation des superficies** :
    - La somme des superficies des champs d'une ferme doit être strictement inférieure à celle de la ferme.

### Gestion des Arbres
- Suivre les arbres avec :
    - Date de plantation, âge, et champ d'appartenance.
- Calculer automatiquement l'âge des arbres.
- Déterminer la **productivité annuelle** en fonction de l'âge des arbres :
    - Arbre jeune (< 3 ans) : 2,5 kg/saison.
    - Arbre mature (3-10 ans) : 12 kg/saison.
    - Arbre vieux (> 10 ans) : 20 kg/saison.

### Gestion des Récoltes
- Suivre les récoltes par saison (hiver, printemps, été, automne).
- Une seule récolte par saison (tous les 3 mois).
- Enregistrer :
    - Date de récolte.
    - Quantité totale récoltée.

### Détail des Récoltes
- Suivre la quantité récoltée par arbre pour une récolte donnée.
- Associer chaque détail de récolte à un arbre spécifique.

### Gestion des Ventes
- Enregistrer les ventes :
    - Date, prix unitaire, client, récolte associée.
- Calcul automatique du revenu :
    - **Revenu = quantité x prixUnitaire**.

---

## Contraintes
### Fermes & Champs
- **Superficie minimale** des champs : 0.1 hectare (1 000 m²).
- **Superficie maximale** des champs : 50% de la superficie totale de la ferme.
- **Nombre maximal** de champs : 10 par ferme.

### Arbres
- **Densité maximale** : 100 arbres/hectare.
- **Durée de vie maximale** : 20 ans (non productif au-delà).
- **Période de plantation** : Entre mars et mai uniquement.

### Récoltes
- Une récolte par saison et par champ.
- Un arbre ne peut être récolté plus d’une fois par saison.

---

## Exigences Techniques
- **Framework :** Spring Boot pour créer l'API REST.
- **Architecture en couches :** Controller, Service, Repository, Entity.
- **Validation des données :** Annotations Spring.
- **Utilisation d'interfaces et implémentation.**
- **Gestion des exceptions centralisée.**
- **Tests unitaires :** JUnit et Mockito.
- **Entités :**
    - Lombok et Builder Pattern pour simplifier la gestion.
- **Conversion entre entités et DTO :** MapStruct.

---

## Structure du Projet

### Planification
- Suivi avec **Jira** :
    - **Lien vers le board Jira** : *https://sanaajava.atlassian.net/jira/software/projects/CIT/boards/4*

### Présentation
*(::::::::::)*

### Conception UML
*![citronix.drawio.png](src%2Fmain%2Fresources%2Fstatic%2Fcitronix.drawio.png)*

---

## Installation et Exécution

### Prérequis
- **Java 17+**
- **Maven**
- **PostgreSQL**
- **Spring Boot**



(MapStruct
Spring Boot Starter Test
Criteria API (Inclus avec JPA)
Swagger/OpenAPI)

