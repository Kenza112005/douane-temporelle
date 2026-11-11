package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class VerificationActivity extends AppCompatActivity {

    private TextView tvNom, tvAge, tvTrajet, tvMotif, tvAlerte, tvNumero;
    private Button btnApprouver, btnRefuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        tvNom = findViewById(R.id.tv_nom_kz);
        tvAge = findViewById(R.id.tv_age_kz);
        tvTrajet = findViewById(R.id.tv_trajet_kz);
        tvMotif = findViewById(R.id.tv_motif_kz);
        tvAlerte = findViewById(R.id.tv_alerte_kz);
        tvNumero = findViewById(R.id.tv_numero_kz);
        btnApprouver = findViewById(R.id.btn_approuver_kz);
        btnRefuser = findViewById(R.id.btn_refuser_kz);

        // nejbdou el données eli jéw mel activité 1 (bnafs el clés)
        String m = CleIntent.MATRICULE;
        Intent recu = getIntent();
        final String nom = recu.getStringExtra(CleIntent.cleNom(m));
        final int naissance = recu.getIntExtra(CleIntent.cleNaissance(m), 0);
        final int destination = recu.getIntExtra(CleIntent.cleDestination(m), 0);
        final String motif = recu.getStringExtra(CleIntent.cleMotif(m));

        // l'age temporel = l'année de destination - l'année de naissance
        int ageTemporel = destination - naissance;

        // n7ottou el données fil passeport
        tvNom.setText("Nom : " + nom);
        tvAge.setText("Âge temporel : " + ageTemporel + " ans");
        tvTrajet.setText("Trajet : " + naissance + " → " + destination);
        tvMotif.setText("Motif : " + motif);

        // n3amrou numéro passeport 3achwa2i (TT-1000 hatta TT-9999)
        int numero = 1000 + new Random().nextInt(9000);
        tvNumero.setText(getString(R.string.label_numero, "TT-" + numero));

        // CONDITION KHASSA: motif = "Modification du passé" W el far9 premier
        // ya3ni el bouton Approuver yet3attal (disabled) men awel ma yetfta7 el écran
        boolean modificationPasse = motif.equals(getString(R.string.motif_modification));
        if (modificationPasse && estPremier(ageTemporel)) {
            btnApprouver.setEnabled(false);
            // nthahrou rissala 7amra bech el douanier ya3ref 3lech el bouton mou3attal
            tvAlerte.setVisibility(View.VISIBLE);
        }

        // bouton Approuver -> verdict = true
        btnApprouver.setOnClickListener(v -> ouvrirResultat(true, nom, destination, motif));

        // bouton Refuser -> verdict = false
        btnRefuser.setOnClickListener(v -> ouvrirResultat(false, nom, destination, motif));
    }

    // methode elli tlanci l activité 3 w tbaath el verdict + el nom + destination + motif
    private void ouvrirResultat(boolean approuve, String nom, int destination, String motif) {
        String m = CleIntent.MATRICULE;
        Intent intent = new Intent(VerificationActivity.this, ResultActivity.class);
        intent.putExtra(CleIntent.cleVerdict(m), approuve);
        intent.putExtra(CleIntent.cleNom(m), nom);
        intent.putExtra(CleIntent.cleDestination(m), destination);
        intent.putExtra(CleIntent.cleMotif(m), motif);
        startActivity(intent);
    }

    // methode tchouf ken el 3adad premier (ya9bel el 9isma ken 3al 1 w 3al rou7ou)
    private boolean estPremier(int n) {
        if (n < 2) {
            return false; // 0 w 1 mouch premiers
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false; // l9ina 9asem -> mouch premier
            }
        }
        return true; // ma l9inech 9asem -> premier
    }
}