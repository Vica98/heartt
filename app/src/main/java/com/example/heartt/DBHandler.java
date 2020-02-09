package com.example.heartt;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context c) {
        super(c,"heart",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String query = "CREATE TABLE userInfo (username varchar(20) PRIMARY KEY, password varchar(20))";
    db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void signup(String username, String password){

        String query = "INSERT INTO userInfo values(?,?)";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(query,new String[]{username, password});
        db.close();
    }

    public boolean login(String username, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT password from userInfo WHERE username = ?";
        Cursor c = db.rawQuery(query,new String[]{username});
        if(c!=null)
        {
            c.moveToFirst();
        }
        if(c.getCount()> 0){
        String pass = c.getString(0);
            if(pass.equals(password)){
                return true;
            }
        }
        return false;
    }


}
