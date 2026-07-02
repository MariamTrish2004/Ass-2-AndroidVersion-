package com.example.simpledictionary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddEditActivity extends AppCompatActivity {

    EditText editWord, editMeaning;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        editWord = findViewById(R.id.editText_word);
        editMeaning = findViewById(R.id.editText_meaning);
        btnSave = findViewById(R.id.button_save);

        // إذا تعديل
        Intent intent = getIntent();
        String word = intent.getStringExtra("word");
        String meaning = intent.getStringExtra("meaning");

        if (word != null) {
            editWord.setText(word);
        }

        if (meaning != null) {
            editMeaning.setText(meaning);
        }

        // حفظ
        btnSave.setOnClickListener(v -> {

            Intent result = new Intent();
            result.putExtra("word", editWord.getText().toString());
            result.putExtra("meaning", editMeaning.getText().toString());

            setResult(RESULT_OK, result);
            finish();
        });
    }
}