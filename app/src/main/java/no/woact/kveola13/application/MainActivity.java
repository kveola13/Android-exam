package no.woact.kveola13.application;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import no.woact.kveola13.R;
import no.woact.kveola13.application.database.DatabaseHelper;
import no.woact.kveola13.application.database.MatchDataSource;

import static no.woact.kveola13.application.database.DatabaseHelper.Column1;
import static no.woact.kveola13.application.database.DatabaseHelper.Column2;
import static no.woact.kveola13.application.database.DatabaseHelper.ColumnID;
import static no.woact.kveola13.application.database.DatabaseHelper.TABLE_NAME;

public class MainActivity extends AppCompatActivity {

    EditText textPlayer1;
    EditText textPlayer2;
    Button singlePlayerButton;
    Button multiPlayerButton;
    Button matchHistoryButton;
    MatchDataSource matchDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        initClick();
        matchDataSource = new MatchDataSource(this);
        matchDataSource.open();
    }

    public void initWidgets() {
        textPlayer1 = findViewById(R.id.player1Name);
        textPlayer2 = findViewById(R.id.player2Name);
        singlePlayerButton = findViewById(R.id.button_singlePlayer);
        multiPlayerButton = findViewById(R.id.button_multiPlayer);
        matchHistoryButton = findViewById(R.id.button_matchHistory);
    }

    private void initClick() {
        singlePlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSinglePlayer();
            }
        });
        multiPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMultiPlayer();
            }
        });
        matchHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMatchHistory();
            }
        });
    }

    public void goToSinglePlayer() {
        Intent intent = new Intent(this, ActivitySinglePlayer.class);
        Bundle bundle = new Bundle();
        String player1Name = textPlayer1.getText().toString();
        if (!player1Name.equals("")) {
            bundle.putString("player1Name", player1Name);
        } else {
            bundle.putString("player1Name", "Player 1");
        }
        bundle.putString("player2Name", "TTTBot");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void goToMultiPlayer() {
        Intent intent = new Intent(this, ActivityMultiPlayer.class);
        Bundle bundle = new Bundle();
        String player1String = textPlayer1.getText().toString();
        String player2String = textPlayer2.getText().toString();

        if (!player1String.equals("") && !player2String.equals("")) {
            bundle.putString("player1Name", player1String);
            bundle.putString("player2Name", player2String);
        } else if (!player1String.equals("") && player2String.equals("")) {
            bundle.putString("player1Name", player1String);
            bundle.putString("player2Name", "Player 2");
        } else if (!player2String.equals("") && player1String.equals("")) {
            bundle.putString("player2Name", player2String);
            bundle.putString("player1Name", "Player 1");
        } else {
            bundle.putString("player1Name", "Player 1");
            bundle.putString("player2Name", "Player 2");
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void goToMatchHistory() {
        Intent intent = new Intent(this, MatchHistory.class);
        startActivity(intent);
    }
}
