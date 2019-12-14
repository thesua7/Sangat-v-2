package ahameds.com.sangatv12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;//Cursor
import android.database.sqlite.SQLiteDatabase;//SQLlite Lib
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import static android.util.Log.println;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "Sangat.db";
    public static String TABLE_NAME = "users";
    public static String Col_1 = "ID";
    public static String Col_2 = "NAME";
    public static String Col_3 = "EMAIL";
    public static String Col_4 = "CONTACTNUMBER";
    public static String Col_5 = "NATIONALITY";
    public static String Col_6 = "CITY";
    public static String Col_7 = "PASSPORT";
    public static String Col_8 = "ORGANIZATION";
    public static String Col_9 = "SPONSORSHIP";




    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,2);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, CONTACTNUMBER TEXT, EMAIL TEXT, NATIONALITY TEXT, CITY TEXT, PASSPORT TEXT, ORGANIZATION TEXT, SPONSORSHIP TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(String name,String email,String contactNumber,String nation,String city,String passport,String organization,String sponsorship){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2,name);

        contentValues.put(Col_3,email);
        contentValues.put(Col_4,contactNumber);
        contentValues.put(Col_5,nation);
        contentValues.put(Col_6,city);
        contentValues.put(Col_7,passport);
        contentValues.put(Col_8,organization);
        contentValues.put(Col_9,sponsorship);

        long success = db.insert(TABLE_NAME,null,contentValues);

        if(success == -1) {
            return false;
        }
        else{
            return true;
        }


    }


    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("select * from "+TABLE_NAME,null);
        return cur;
    }
}
