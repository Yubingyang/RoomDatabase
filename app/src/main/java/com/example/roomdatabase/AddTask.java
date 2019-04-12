package com.example.roomdatabase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class AddTask extends AppCompatActivity {

    EditText Task,Discription,Finishedby;
    Button SaveButton;
    byte[] myimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Task=findViewById(R.id.editTextTask1);
        Discription=findViewById(R.id.editTextDesc1);
        Finishedby=findViewById(R.id.editTextFinishBy1);
        SaveButton=findViewById(R.id.button_save1);

        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                saveTask();
            }
        });
    }


    private void saveTask() {
        final String sTask = Task.getText().toString().trim();
        final String sDesc = Discription.getText().toString().trim();
        final String sFinishBy = Finishedby.getText().toString().trim();
       final Bitmap Icon = BitmapFactory.decodeResource(getResources(), R.drawable.quran);

       myimage=getBytes(Icon);

        if (sTask.isEmpty()) {
            Task.setError("Task required");
            Task.requestFocus();
            return;
        }

        if (sDesc.isEmpty()) {
            Discription.setError("Desc required");
            Discription.requestFocus();
            return;
        }

        if (sFinishBy.isEmpty()) {
            Finishedby.setError("Finish by required");
            Finishedby.requestFocus();
            return;
        }

        class SaveTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {

                //creating a task
                Task task = new Task();
                task.setTask(sTask);
                task.setDesc(sDesc);
                task.setFinishBy(sFinishBy);
                task.setFinished(false);
                task.setMyimage(myimage);

                //adding to database
                DatabaseClienet.getInstance(getApplicationContext()).getAppDatabase()
                        .taskDao()
                        .insert(task);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        SaveTask st = new SaveTask();
        st.execute();
    }

    // convert from bitmap to byte array
    public static byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    // convert from byte array to bitmap
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}
