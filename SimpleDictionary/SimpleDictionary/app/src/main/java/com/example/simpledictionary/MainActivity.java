package com.example.simpledictionary;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fab;

    ArrayList<Word> wordList;
    WordAdapter adapter;

    int editPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView_words);
        fab = findViewById(R.id.fab_add);

        wordList = new ArrayList<>();

        adapter = new WordAdapter(wordList, new WordAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                // EDIT
                editPosition = position;

                Intent intent = new Intent(MainActivity.this, AddEditActivity.class);
                intent.putExtra("word", wordList.get(position).getWord());
                intent.putExtra("meaning", wordList.get(position).getMeaning());

                editLauncher.launch(intent);
            }

            @Override
            public void onLongClick(int position) {
                // DELETE
                wordList.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Word Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddEditActivity.class);
            addLauncher.launch(intent);
        });
    }

    // ADD
    ActivityResultLauncher<Intent> addLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {

                if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                    String word = result.getData().getStringExtra("word");
                    String meaning = result.getData().getStringExtra("meaning");

                    wordList.add(new Word(word, meaning));
                    adapter.notifyDataSetChanged();

                    Toast.makeText(this, "Word Added", Toast.LENGTH_SHORT).show();
                }
            });

    // EDIT
    ActivityResultLauncher<Intent> editLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {

                if (result.getResultCode() == RESULT_OK && result.getData() != null && editPosition != -1) {

                    String word = result.getData().getStringExtra("word");
                    String meaning = result.getData().getStringExtra("meaning");

                    wordList.set(editPosition, new Word(word, meaning));
                    adapter.notifyDataSetChanged();

                    Toast.makeText(this, "Word Updated", Toast.LENGTH_SHORT).show();
                }
            });
}