package com.khilman.customrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    String namabuah[] = {"alpukat", "Apel", "Ceri", "Durian", "Jambu Air", "Manggis", "Strawberry"};
    int gambarbuah[] = {R.drawable.alpukat1,R.drawable.apel1,
            R.drawable.ceri1, R.drawable.duriani, R.drawable.jambuairi, R.drawable.manggisi, R.drawable.strawberrya};
    int suarabuah[] = {R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian, R.raw.jambuair, R.raw.manggis, R.raw.strawberry};

    /// Deklarasi
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // inisialisasi
        recyclerView = (RecyclerView) findViewById(R.id.listBuah);
        // panggil adapter
        CustomRecyclerAdapter adapter = new CustomRecyclerAdapter(this, namabuah, gambarbuah, suarabuah);
        recyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

    }
}
