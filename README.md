# Douane Temporelle

Mini-projet (DS 1) - Programmation Mobile
3ème BI - FSEGT - Enseignant : Nidhal Jelassi

## Membres du groupe

| Prénom | Nom    | Groupe
|--------|--------|--------|
| KENZA    | ZOUABI |A06    |

## Description

Application Android simulant un poste de douane pour voyageurs du temps (3 activités) :
1. MainActivity : formulaire d'enregistrement
2. VerificationActivity : passeport + boutons Approuver / Refuser
3. ResultActivity : verdict (fond vert ou rouge) + bouton "Nouveau voyageur"

## Fonctionnalités supplémentaires

- Message d'alerte "Paradoxe détecté" quand l'approbation est bloquée
- Numéro de passeport aléatoire sur le billet
- Validation des années (entre 1800 et 3000)
- Affichage de la destination et du motif sur l'écran du verdict
- - Statistiques (voyageurs approuvés / refusés) sur l'écran d'accueil

## Contraintes respectées

- Intents explicites
- VerificationActivity : LinearLayout horizontal (ImageView 0.3 + RelativeLayout 0.7)
- Clés des putExtra préfixées par 9371, construites par des méthodes statiques (CleIntent)
- Bouton Approuver désactivé si "Modification du passé" et différence d'années première
- IDs avec les initiales (_kz)
- Code commenté en arabe (dialecte tunisien)