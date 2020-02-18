package com.example.projectandroidtechsavvy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddNote extends AppCompatActivity {


    EditText noteTitle,NoteText;
    String title,text;
    Button save;
    DatabaseHelper mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        noteTitle = findViewById(R.id.note_title);
        NoteText = findViewById(R.id.note_text);
        save = findViewById(R.id.btn_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = noteTitle.getText().toString();
                text = NoteText.getText().toString();
                addnotes();
            }
        });

    }


    private void addnotes() {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String date = sdf.format(calendar.getTime());

        if (mDatabase.addNote(title,text))
            Toast.makeText(this, "Note added "+title, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Note not added", Toast.LENGTH_SHORT).show();

    }


}
