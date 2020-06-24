package br.com.local.gridviewplanetaetec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecebePlaneta_Activity extends AppCompatActivity {

    TextView nomePlaneta;
    ImageView imgPlaneta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recebe_planeta_layout);

        nomePlaneta = findViewById(R.id.txtRecebePaneta);
        imgPlaneta = findViewById(R.id.imgRecebePlaneta);

        Intent intent = getIntent();

        String nomeP = intent.getStringExtra("name");
        int imagemP = intent.getIntExtra("image",0);

        nomePlaneta.setText(nomeP);
        imgPlaneta.setImageResource(imagemP);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}