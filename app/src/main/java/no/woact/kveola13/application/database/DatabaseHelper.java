package no.woact.kveola13.application.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "matches.db";
    public static final String TABLE_NAME = "MatchHistory";
    public static final String ColumnID = "id";
    public static final String Column1 = "player1";
    public static final String Column2 = "player2";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String initTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(" + ColumnID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Column1 + " text not null, " + Column2 + " text not null);";
        sqLiteDatabase.execSQL(initTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        onCreate(sqLiteDatabase);
    }

    public void writeMatchResult(String player1Result, String player2Result){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(3);
        contentValues.put(Column1, player1Result);
        contentValues.put(Column2, player2Result);

        database.insert(TABLE_NAME, null, contentValues);
    }
    public Cursor getDataFromDatabase(){
        SQLiteDatabase database = this.getWritableDatabase();
        onCreate(database);
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }
    public void resetDatabase(){
        SQLiteDatabase database = this.getWritableDatabase();
        String resetQuery = "DROP TABLE IF EXISTS " + TABLE_NAME;
        database.execSQL(resetQuery);
    }
}
