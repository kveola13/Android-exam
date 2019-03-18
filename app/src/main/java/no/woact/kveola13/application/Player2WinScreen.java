package no.woact.kveola13.application;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

import no.woact.kveola13.R;
import no.woact.kveola13.application.database.DatabaseHelper;

public class Player2WinScreen extends AppCompatActivity {
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player2_win_screen);
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView player2Name = (TextView) findViewById(R.id.player2Win);

        String firstName = getIntent().getStringExtra("player1Name");
        String secondName = getIntent().getStringExtra("player2Name");
        String player1Win = secondName + " wins!";
        player2Name.setText(player1Win);


        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.writeMatchResult(firstName + " Loss", secondName + " Win");
        databaseHelper.close();


        new Player2WinScreen.DownloadImageTask((ImageView) findViewById(R.id.httpImage)).execute("https://i.imgur.com/phyOkvN.png");
    }

    public void goToMainScreen(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bitMapImage;

        public DownloadImageTask(ImageView bitMapImage) {
            this.bitMapImage = bitMapImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urlDisplay = urls[0];
            Bitmap bitmap = null;
            try {
                InputStream in = new java.net.URL(urlDisplay).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap imageResult) {
            bitMapImage.setImageBitmap(imageResult);
        }
    }
}
