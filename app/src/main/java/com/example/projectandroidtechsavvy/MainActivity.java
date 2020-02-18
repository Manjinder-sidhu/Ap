package com.example.projectandroidtechsavvy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mDataBase;
//
//    private GoogleMap mMap;
//    private final int REQUEST_CODE = 1;
//    Marker marker;
ListView listView;
List<NotesClass> notesList;
NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        notesList = new ArrayList<>();
        mDataBase =new DatabaseHelper(this);
        loadnotes();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
//        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add:
                //add the function to perform here
                Intent intent = new Intent(MainActivity.this, AddNote.class);
                startActivity(intent);
                return(true);

        }

        return super.onOptionsItemSelected(item);
    }



    private void loadnotes(){

        Cursor cursor = mDataBase.getAllNotes();
        if(cursor.moveToFirst()){
            do {
              notesList.add(new NotesClass(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                ));


            }while (cursor.moveToNext());
            cursor.close();
            //show item in a listView
            //we use a custom adapter to show employees

            notesAdapter = new NotesAdapter(this, R.layout.list_layout_res, notesList, mDataBase);
//            placeAdapter.notifyDataSetChanged();
            listView.setAdapter((ListAdapter) notesAdapter);

        }


    }
}
