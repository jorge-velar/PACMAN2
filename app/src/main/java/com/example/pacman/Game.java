package com.example.pacman;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Game extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        ImageButton topBtn = findViewById(R.id.topBtn);
        ImageButton leftBtn = findViewById(R.id.leftBtn);
        ImageButton rightBtn = findViewById(R.id.rightBtn);
        ImageButton downBtn = findViewById(R.id.bottomBtn);

    }

}