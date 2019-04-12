package com.example.roomdatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.drawable.Drawable;

import java.io.Serializable;

@Entity
public class Task implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="task")
    private String task;
    @ColumnInfo(name="desc")
    private String desc;
    @ColumnInfo(name = "finish_by")
    private String finishBy;
    @ColumnInfo(name = "finished")
    private boolean finished;
    @ColumnInfo(name="profileimage")
    private byte[] myimage;

    //setters and getters

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id=id;
    }

    public String getTask()
    {
        return task;
    }


    public void setTask(String task)
    {
        this.task=task;
    }

    public String getDesc(){
        return desc;
    }
    public byte[] getMyimage(){return myimage;}

    public void setDesc(String desc)
    {
        this.desc=desc;
    }

    public String getFinishBy() {
        return finishBy;
    }

    public void setFinishBy(String finishBy) {
        this.finishBy = finishBy;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setMyimage(byte[] myimage ){this.myimage=myimage;}
}


