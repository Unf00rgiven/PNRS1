package ognjen.stojisavljevic.memorygame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

public class PlayerDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "memory_game_KT4.db";
    public static final int DATABASE_VERSION = 1;
    public final String TABLE_NAME = "GAMES";
    public static final String COLUMN_GAMEID = "GameID";
    public static final String COLUMN_USERNAME = "Username";
    public static final String COLUMN_GMAIL = "Gmail";
    public static final String COLUMN_POINTS = "Points";


    public PlayerDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_GAMEID + " TEXT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_GMAIL + " TEXT, " +
                COLUMN_POINTS + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(Element game) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_GAMEID, game.getGameID());
        values.put(COLUMN_USERNAME, game.getUsername());
        values.put(COLUMN_GMAIL, game.getEmail());
        values.put(COLUMN_POINTS, game.getPoints());

        db.insert(TABLE_NAME, null, values);
        close();
    }

    public void delete(String username) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_USERNAME + " =?", new String[] {username});
        close();
    }

    public void deleteBase() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        close();
    }

    public String[] readResultForPlayer(String username){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_USERNAME + " =?", new String[] {username}, null, null, null);

        if (cursor.getCount() <= 0) {
            return null;
        }

        String[] points = new String[cursor.getCount()];
        int i = 0;
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            points[i++] = createPoints(cursor);
        }

        close();
        return points;
    }

    private String createPoints(Cursor cursor) {

        String points = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_POINTS));

        return points;
    }

    public Map<String, String[]> dataBase(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        if (cursor.getCount() <= 0) {
            return null;
        }
        Map<String, String[]> map = new HashMap<>();

        int i = 0;
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            if(!map.containsKey(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USERNAME)))){
                map.put(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USERNAME)), readResultForPlayer(cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USERNAME))));
            }
        }

        return  map;
    }

}
