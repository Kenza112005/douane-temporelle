package com.example.douanetemporelle;

public class CleIntent {

    // 9371 = a5er 4 arkem men carte d'etudiant mte3i
    public static final String MATRICULE = "9371";

    // kol methode statique tosnaa clé w tet3ada bel matricule ka parametre
    // (ma n7ottouch el clé "hard-coded" fil activities)

    public static String cleNom(String matricule) {
        return matricule + "_NOM_VOYAGEUR";
    }

    public static String cleNaissance(String matricule) {
        return matricule + "_ANNEE_NAISSANCE";
    }

    public static String cleDestination(String matricule) {
        return matricule + "_ANNEE_DESTINATION";
    }

    public static String cleMotif(String matricule) {
        return matricule + "_MOTIF_VOYAGE";
    }

    public static String cleVerdict(String matricule) {
        return matricule + "_VERDICT";
    }
}