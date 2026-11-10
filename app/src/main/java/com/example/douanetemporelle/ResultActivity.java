package com.example.douanetemporelle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        View root = findViewById(R.id.root_result_kz);
        TextView tvMessage = findViewById(R.id.tv_message_kz);
        Button btnNouveau = findViewById(R.id.btn_nouveau_kz);

        // nejbdou el verdict (boolean) w el nom men l'intent
        String m = CleIntent.MATRICULE;
        boolean approuve = getIntent().getBooleanExtra(CleIntent.cleVerdict(m), false);
        String nom = getIntent().getStringExtra(CleIntent.cleNom(m));

        if (approuve) {
            // approuvé -> fond vert + message "Bon voyage"
            root.setBackgroundColor(ContextCompat.getColor(this, R.color.vert_kz));
            tvMessage.setText(getString(R.string.msg_approuve, nom));
        } else {
            // refusé -> fond rouge + message arrestation
            root.setBackgroundColor(ContextCompat.getColor(this, R.color.rouge_kz));
            tvMessage.setText(getString(R.string.msg_refuse, nom));
        }

        btnNouveau.setOnClickListener(v -> {
            // nraj3ou lel MainActivity w nsakrou kol les activités li 9balha
            // NEW_TASK + CLEAR_TASK = nfas5ou el pile mta3 les activités lkol
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });
    }
}