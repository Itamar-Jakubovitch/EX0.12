package com.example.ex012;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultsActivity extends AppCompatActivity {

    private TextView tvWinner, tvBlueScore, tvRedScore;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        tvWinner = findViewById(R.id.tvWinner);
        tvBlueScore = findViewById(R.id.tvBlueScore);
        tvRedScore = findViewById(R.id.tvRedScore);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        int blueScore = intent.getIntExtra("BLUE_SCORE", 0);
        int redScore = intent.getIntExtra("RED_SCORE", 0);

        tvBlueScore.setText("שחקן כחול: " + blueScore + " נקודות");
        tvRedScore.setText("שחקן אדום: " + redScore + " נקודות");

        if (blueScore > redScore) {
            tvWinner.setText("המנצח הוא הכחול!");
            tvWinner.setTextColor(Color.parseColor("#1E88E5"));
        } else if (redScore > blueScore) {
            tvWinner.setText("המנצח הוא האדום!");
            tvWinner.setTextColor(Color.parseColor("#E53935"));
        } else {
            tvWinner.setText("תיקו!");
            tvWinner.setTextColor(Color.parseColor("#37474F"));
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}