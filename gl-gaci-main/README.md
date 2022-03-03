# GL-GACI  BANK Simplifié en version Francaise 

Ce depot contient du travail demandé pour GL

## Auteurs :
**GACI Noufel**



## Theme du Projet
- Il consiste a exploiter nos performances en java et d'utiliser le principe TDD , ce qui consiste a crée notre programme en commencant par les tests pour valider ensuite par du code. 
- Dans mon travail j'ai utilisé le logiciel Eclipse il me parait plus facile. 


## Explication de la mise en oeuvre des classes 
- `CompteGeneral` : j'ai mis en oeuvre le principe du **composite** pour mettre le CompteCourant et CompteEpargne en meme type CompteGeneral pour réduire la surchage du code vu qu'ils ont les 2 le meme principe de crediter et il se défferent juste en débits  . 
- `CompteCourant` : pour déffirencier du compteEpargne 
- `CompteEpargne` : pour déffirencier du CompteCourant car ya une déffirence quand on débite . 
- `Releve` :consiste la representation d'un Releve qui résume l'historisation des opérations de débit et crédit
- `Banque` : pour ensembler et mettre les comptes dans une seule liste. 
- `Différentes...Exception` : pour déclencher les exceptions. 

### Compilation et execution:

1. #### Recupertation du projet :
pour recuperer le projet executer la commande suivant sur votre terminal :
```bash
git clone https://gitlab-etu.fil.univ-lille1.fr/gaci/gl-gaci.git
```

2. #### compiler et executer les tests :
## Par les commandes de Maven : 
- il suffit d'éxécuter cette commande a la racine du projet : 
```bash 
mvn test #tous les test serront lancés automatiquement 
```

## Par Eclipse IDE :  
- 1ere Etape : cloner mon depot dans votre projet Maven 
- 2eme Etape : ajouter la librairies **Junit5** a votre project et le JDK11(ou bien JRE11 et de préférence le JDK11)
- 3eme Etape : recopier le pom.xml de mon depot 
- 3eme etape : tester directement avec Maven(maven Install puis Maven Test).
