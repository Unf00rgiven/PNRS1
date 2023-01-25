package com.example.databaseexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentDbHelper extends SQLiteOpenHelper {

    private final String TABLE_NAME = "student";
    public static final String COLUMN_FIRST_NAME = "FirstName";
    public static final String COLUMN_LAST_NAME = "LastName";
    public static final String COLUMN_INDEX = "IndexNumber";

    public StudentDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_FIRST_NAME + " TEXT, " +
                COLUMN_LAST_NAME + " TEXT, " +
                COLUMN_INDEX + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(Student student) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST_NAME, student.getFirstName());
        values.put(COLUMN_LAST_NAME, student.getLastName());
        values.put(COLUMN_INDEX, student.getIndex());

        db.insert(TABLE_NAME, null, values);
        close();
    }

    public void delete(String index) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_INDEX + " =?", new String[] {index});
        close();
    }

    public Student[] readStudents() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        if (cursor.getCount() <= 0) {
            return null;
        }
        Student[] students = new Student[cursor.getCount()];
        int i = 0;
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            students[i++] = createStudent(cursor);
        }

        close();
        return students;
    }

    public Student readStudent(String index) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_INDEX + " =?", new String[] {index}, null, null, null);

        if (cursor.getCount() <= 0) {
            return null;
        }

        cursor.moveToFirst();

        Student student = createStudent(cursor);

        close();
        return student;
    }

    private Student createStudent(Cursor cursor) {
        String firstName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FIRST_NAME));
        String lastName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LAST_NAME));
        String index = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_INDEX));

        return new Student(firstName, lastName, index);
    }
}
