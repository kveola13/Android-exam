package no.woact.kveola13.application;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;

import no.woact.kveola13.R;
import no.woact.kveola13.application.database.DatabaseHelper;

public class PlayerDrawScreen extends AppCompatActivity {
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_draw_screen);
    }

    @Override
    protected void onStart() {
        super.onStart();

        String firstName = getIntent().getStringExtra("player1Name");
        String secondName = getIntent().getStringExtra("player2Name");


        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        databaseHelper.writeMatchResult(firstName + " Draw", secondName + " Draw");
        databaseHelper.close();

        new PlayerDrawScreen.DownloadImageTask((ImageView) findViewById(R.id.httpImage)).execute("https://i.imgur.com/PedMcqR.png");
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
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
