package com.example.pacman;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton facil = findViewById(R.id.facil);
        ImageButton facilOn = findViewById(R.id.facilOn);
        ImageButton intermedio = findViewById(R.id.intermedio);
        ImageButton intermedioOn = findViewById(R.id.intermedioOn);
        ImageButton dificil = findViewById(R.id.dificil);
        ImageButton dificilOn = findViewById(R.id.dificilOn);
        ImageButton jugar = findViewById(R.id.jugar);


        AtomicReference<String> nivelSeleccionado= new AtomicReference<>("");

        facil.setOnClickListener(v->{
            nivelSeleccionado.set("FACIL");
            jugar.setEnabled(true);
            jugar.setVisibility(VISIBLE);
            facilOn.setVisibility(VISIBLE);
            facil.setVisibility(INVISIBLE);

            intermedioOn.setVisibility(View.GONE);
            intermedio.setVisibility(View.VISIBLE);
            dificilOn.setVisibility(View.GONE);
            dificil.setVisibility(View.VISIBLE);
        });
        intermedio.setOnClickListener(v->{
            nivelSeleccionado.set("INTERMEDIO");
            jugar.setEnabled(true);
            jugar.setVisibility(VISIBLE);
            intermedioOn.setVisibility(VISIBLE);
            intermedio.setVisibility(INVISIBLE);

            facilOn.setVisibility(View.GONE);
            facil.setVisibility(View.VISIBLE);
            dificilOn.setVisibility(View.GONE);
            dificil.setVisibility(View.VISIBLE);
        });
        dificil.setOnClickListener(v->{
            nivelSeleccionado.set("DIFICIL");
            jugar.setEnabled(true);
            jugar.setVisibility(VISIBLE);
            dificilOn.setVisibility(VISIBLE);
            dificil.setVisibility(INVISIBLE);

            facilOn.setVisibility(View.GONE);
            facil.setVisibility(View.VISIBLE);
            intermedioOn.setVisibility(View.GONE);
            intermedio.setVisibility(View.VISIBLE);
        });

        jugar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Game.class);
            intent.putExtra("MODO", nivelSeleccionado.get());
            startActivity(intent);
        });
    }
}