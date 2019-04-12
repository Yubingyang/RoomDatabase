package com.example.roomdatabase;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

public class DatabaseClienet {
    private Context context;

    private static DatabaseClienet mInstance;

    //our app database object
    private AppDatabase appDatabase;

   public DatabaseClienet(Context context)
    {
        this.context=context;

    appDatabase= Room.databaseBuilder(context,AppDatabase.class,"MyRoomDB").build();
    }
    public static synchronized DatabaseClienet getInstance(Context context)
    {
        if(mInstance==null)
        {
            mInstance=new DatabaseClienet(context);
        }
        return mInstance;
    }

     public AppDatabase getAppDatabase(){
       return appDatabase;
     }


}

