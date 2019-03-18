package no.woact.kveola13.application;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import no.woact.kveola13.R;
import no.woact.kveola13.application.database.DatabaseHelper;
import no.woact.kveola13.application.database.Match;
import no.woact.kveola13.application.database.MatchDataSource;

import static no.woact.kveola13.application.database.DatabaseHelper.Column1;
import static no.woact.kveola13.application.database.DatabaseHelper.Column2;
import static no.woact.kveola13.application.database.DatabaseHelper.ColumnID;
import static no.woact.kveola13.application.database.DatabaseHelper.TABLE_NAME;

public class MatchHistory extends AppCompatActivity {

    private MatchDataSource matchDataSource;
    private DatabaseHelper databaseHelper;
    private ListView listView;
    private ArrayAdapter<Match> matchArrayAdapter;
    private ArrayList<Match> matchArrayList;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_history);

        listView = findViewById(R.id.matchHistory);
        listView.setAdapter(matchArrayAdapter);
        databaseHelper = new DatabaseHelper(this);

        getMatchData();
    }

    public void getMatchData() {
        Cursor cursor = databaseHelper.getDataFromDatabase();
        ArrayList<String> dataArrayList = new ArrayList<>();
        while (cursor.moveToNext()){
            dataArrayList.add("Match " + cursor.getString(0) + ":");
            dataArrayList.add(cursor.getString(1));
            dataArrayList.add(cursor.getString(2));
        }
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataArrayList);
        listView.setAdapter(listAdapter);
    }
    //    public void initListView(){
//        listView = findViewById(R.id.matchHistory);
//        matchArrayList = new ArrayList<>();
//        matchDataSource = new MatchDataSource(this);
//        matchArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, matchArrayList);
//        listView.setAdapter(matchArrayAdapter);
//    }
//
//    public void logMatches(){
//        List<Match> matches = matchDataSource.getMatchList();
//        for (Match match : matches) {
//            Log.w("Match: ", "saved data: " + match);
//        }
//    }

}
