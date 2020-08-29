package com.alian.mybookapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alian.mybookapp.R;
import com.alian.mybookapp.database.DatabaseHelper;

public class UpdateActivity extends AppCompatActivity {

    EditText title_input, author_input, pages_input;
    Button update_button;
    String id, title, author, pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        title_input = findViewById(R.id.title_input2);
        author_input = findViewById(R.id.author_input2);
        pages_input = findViewById(R.id.pages_input2);
        update_button = findViewById(R.id.update_button);

        getAndSetIntentData();
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(UpdateActivity.this);
                title = title_input.getText().toString().trim();
                author = author_input.getText().toString().trim();
                pages = pages_input.getText().toString().trim();
                db.updateData(id, title, author, pages);
            }
        });
    }

    void getAndSetIntentData() {
        if (getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("author") && getIntent().hasExtra("pages")) {
            // Getting data from Intent
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            author = getIntent().getStringExtra("author");
            pages = getIntent().getStringExtra("pages");

            // Setting Intent Data
            title_input.setText(title);
            author_input.setText(author);
            pages_input.setText(pages);
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
}