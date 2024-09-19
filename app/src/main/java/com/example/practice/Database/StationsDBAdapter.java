package com.example.practice.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.practice.Model.Stations;

import java.util.ArrayList;

public class StationsDBAdapter extends DatabaseAssets {

    private static final String KEY_ID="Id";
    private static final String KEY_TITLE="Title";
    private static final String KEY_ENGLISH_TITLE="EnglishTitle";
    private static final String KEY_LINE="Line";
    private static final String KEY_ADDRESS="Address";
    private static final String KEY_LAT="Lat";
    private static final String KEY_LANG="Lang";
    private static final String KEY_DESCRIPTION="Description";
    /**
     * Constructor Takes and keeps a reference of the passed context in order to
     * access to the application assets and resources.
     *
     * @param context
     */
    public StationsDBAdapter(Context context) {
        super(context);
    }
    public void insert(Stations stations){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_TITLE,stations.getTitle());
        values.put(KEY_ENGLISH_TITLE,stations.getEnglishTitle());
        values.put(KEY_LINE,stations.getLine());
        values.put(KEY_ADDRESS,stations.getAddress());
        values.put(KEY_LAT,stations.getLat());
        values.put(KEY_LANG,stations.getLang());
        values.put(KEY_DESCRIPTION,stations.getDescription());
        db.insert(TABLE_STATIONS,null,values);
    }
    public ArrayList<Stations> getStations()
    {
        ArrayList<Stations> lst=new ArrayList<Stations>();
        String selectquery="SELECT * FROM "+TABLE_STATIONS;
        Stations stations=new Stations();
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery,null);


        for(;cursor.moveToNext();)
        {

            //read all data
            int id=cursor.getInt(0);
            String title=cursor.getString(1);
            String englishtitle=cursor.getString(2);
            int line=cursor.getInt(3);
            String address=cursor.getString(4);
            String lat=cursor.getString(5);
            String lang=cursor.getString(6);
            String description=cursor.getString(7);


            //set data to stations

           /* stations.setId(id);
            stations.setTitle(title);
            stations.setEnglishTitle(englishtitle);
            stations.SetLine(line);
            stations.setAddress(address);
            stations.setLat(lat);
            stations.setLang(lang);
            stations.setDescription(description);*/

            stations=new Stations(id,title,englishtitle,line,address,lat,lang,description);

            lst.add(stations);
        }
        return  lst;
    }
}
