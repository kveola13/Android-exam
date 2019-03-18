package no.woact.kveola13.application.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class MatchDataSource {

    private SQLiteDatabase database;
    private DatabaseHelper databaseHelper;
    private String [] getAllColumns = {
            DatabaseHelper.ColumnID, DatabaseHelper.Column1, DatabaseHelper.Column2
    };

    public MatchDataSource (Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException{
        database = databaseHelper.getWritableDatabase();
    }
    public void close () {
        databaseHelper.close();
    }

    public Match saveMatch(String player, String result){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.Column1, player);
        contentValues.put(DatabaseHelper.Column2, result);

        long matchID = database.insert(DatabaseHelper.TABLE_NAME, null, contentValues);

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME,
                getAllColumns,
                DatabaseHelper.ColumnID + " = " + matchID,
                null,
                null,
                null,
                null);
        cursor.moveToFirst();
        Match match = cursorToMatch(cursor);
        cursor.close();
        return match;
    }

    private Match cursorToMatch(Cursor cursor) {
        Match match = new Match();
        match.setId(cursor.getLong(0));
        match.setPlayer(cursor.getString(1));
        match.setResult(cursor.getString(2));
        return match;
    }

    public List<Match> getMatchList(){
        List<Match> matches = new ArrayList<Match>();

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME,
                getAllColumns,
                null,
                null,
                null,
                null,
                null);

        cursor.moveToFirst();
        while ((!cursor.isAfterLast())) {
            Match match = cursorToMatch(cursor);
            matches.add(match);
            cursor.moveToNext();
        }
        cursor.close();
        return matches;
    }
}
