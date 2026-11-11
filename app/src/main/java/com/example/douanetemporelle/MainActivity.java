package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // na3mlou les variables mta3 les composants
    private EditText etNom, etNaissance, etDestination;
    private RadioGroup rgMotif;
    private Button btnInspecter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // nraabtou el java m3a el layout XML
        setContentView(R.layout.activity_main);

        // nlawjou 3al composants bel id mte3hom
        etNom = findViewById(R.id.et_nom_kz);
        etNaissance = findViewById(R.id.et_naissance_kz);
        etDestination = findViewById(R.id.et_destination_kz);
        rgMotif = findViewById(R.id.rg_motif_kz);
        btnInspecter = findViewById(R.id.btn_inspecter_kz);

        // kif nenzlou 3al bouton nlanciw el methode inspecter
        btnInspecter.setOnClickListener(v -> inspecter());
    }

    private void inspecter() {
        // nejbdou el données elli ktebhom el user
        String nom = etNom.getText().toString().trim();
        String naissanceStr = etNaissance.getText().toString().trim();
        String destinationStr = etDestination.getText().toString().trim();

        // 1) nverifiw ken fama champ fer8
        if (nom.isEmpty() || naissanceStr.isEmpty() || destinationStr.isEmpty()) {
            Toast.makeText(this, R.string.err_champs, Toast.LENGTH_SHORT).show();
            return;
        }

        // 2) nverifiw ken el user 5tar motif
        int idChoisi = rgMotif.getCheckedRadioButtonId();
        if (idChoisi == -1) {
            Toast.makeText(this, R.string.err_motif, Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton rbChoisi = findViewById(idChoisi);
        String motif = rbChoisi.getText().toString();

        // 3) nbadlou el années men texte l int
        int naissance = Integer.parseInt(naissanceStr);
        int destination = Integer.parseInt(destinationStr);

        // 3.5) nverifiw el années 9rib lel waqe3 (binet 1800 w 3000)
        if (naissance < 1800 || destination > 3000) {
            Toast.makeText(this, R.string.err_plage, Toast.LENGTH_SHORT).show();
            return;
        }

        // 4) l'année de destination lazem tkoun akbar men naissance
        if (destination <= naissance) {
            Toast.makeText(this, R.string.err_annees, Toast.LENGTH_SHORT).show();
            return;
        }

        // 5) Intent explicite: nel9aw men MainActivity l VerificationActivity
        Intent intent = new Intent(MainActivity.this, VerificationActivity.class);

        // el clés yetsan3ou bel methodes statiques (mouch hard-coded)
        String m = CleIntent.MATRICULE;
        intent.putExtra(CleIntent.cleNom(m), nom);
        intent.putExtra(CleIntent.cleNaissance(m), naissance);
        intent.putExtra(CleIntent.cleDestination(m), destination);
        intent.putExtra(CleIntent.cleMotif(m), motif);

        // nbaathou l activité 2
        startActivity(intent);
    }
}