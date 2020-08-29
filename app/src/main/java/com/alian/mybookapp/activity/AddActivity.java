package com.alian.mybookapp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.alian.mybookapp.R;
import com.alian.mybookapp.database.DatabaseHelper;

public class AddActivity extends AppCompatActivity {

    private EditText title_input, author_input, pages_input;
    private Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ui();

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = title_input.getText().toString().trim();
                String author = author_input.getText().toString().trim();
                int pages = Integer.valueOf(pages_input.getText().toString().trim());
                DatabaseHelper myDB = new DatabaseHelper(AddActivity.this);
                myDB.addBook(title, author, pages);
            }
        });
    }

    private void ui() {
        title_input = findViewById(R.id.title_input);
        add_button = findViewById(R.id.add_button);
        author_input = findViewById(R.id.author_input);
        pages_input = findViewById(R.id.pages_input);
    }

}