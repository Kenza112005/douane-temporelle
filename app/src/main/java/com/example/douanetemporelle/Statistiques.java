package com.example.douanetemporelle;

public class Statistiques {

    // el 3addedat (compteurs) elli ysajlou 9addech men voyageur t9bel w 9addech t7bes
    private static int approuves = 0;
    private static int refuses = 0;

    // methode tzid 1 fil compteur el mounaseb 7asb el verdict
    public static void enregistrer(boolean approuve) {
        if (approuve) {
            approuves++;
        } else {
            refuses++;
        }
    }

    public static int getApprouves() {
        return approuves;
    }

    public static int getRefuses() {
        return refuses;
    }
}