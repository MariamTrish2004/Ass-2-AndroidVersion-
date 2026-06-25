package com.example.android_virsion;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AndroidVersionAdapter adapter;
    private List<AndroidVersion> versionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addData();

        adapter = new AndroidVersionAdapter(versionList);
        recyclerView.setAdapter(adapter);
    }

    private void addData() {
        versionList.add(new AndroidVersion(R.drawable.donut, "Donut", "1.6"));
        versionList.add(new AndroidVersion(R.drawable.eclair, "Eclair", "2.0 – 2.1"));
        versionList.add(new AndroidVersion(R.drawable.froyo, "Froyo", "2.2 – 2.2.3"));
        versionList.add(new AndroidVersion(R.drawable.gingerbread, "Gingerbread", "2.3 – 2.3.7"));
        versionList.add(new AndroidVersion(R.drawable.honeycomb, "Honeycomb", "3.0 – 3.2.6"));
        versionList.add(new AndroidVersion(R.drawable.icecream, "Ice Cream Sandwich", "4.0 – 4.0.4"));
        versionList.add(new AndroidVersion(R.drawable.jellybean, "Jelly Bean", "4.1 – 4.3.1"));
        versionList.add(new AndroidVersion(R.drawable.kitkat, "KitKat", "4.4 – 4.4.4"));
        versionList.add(new AndroidVersion(R.drawable.lollipop, "Lollipop", "5.0 – 5.1.1"));
        versionList.add(new AndroidVersion(R.drawable.marshmalloe, "Marshmallow", "6.0 – 6.0.1"));
        versionList.add(new AndroidVersion(R.drawable.nougat, "Nougat", "7.0 – 7.1.2"));
        versionList.add(new AndroidVersion(R.drawable.oreo, "Oreo", "8.0 – 8.1"));
    }
}