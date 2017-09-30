package com.khilman.customrecyclerview;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class DetailActivity extends AppCompatActivity {

    // deklarasi
    ImageView imageBuah;
    TextView namaBuah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // inisialisasi widget
        imageBuah = (ImageView) findViewById(R.id.imageBuah);
        namaBuah = (TextView) findViewById(R.id.namaBuah);

        // mendapatkan data dari intent
        String nama_buah = getIntent().getStringExtra("nb");
        int gambar_buah = getIntent().getIntExtra("gb", 0);
        final int suara_buah = getIntent().getIntExtra("sb", 0);

        // set value widget
        namaBuah.setText(nama_buah);
        imageBuah.setImageResource(gambar_buah);

        // event on click untuk widget imageview

        imageBuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putarAudio(suara_buah);
            }
        });
    }
    private void putarAudio(int suara_buah) {
        // Media player
        MediaPlayer mediaPlayer = new MediaPlayer();
        // dapatkan lokasi file
        Uri lokasi_audio = Uri.parse("android.resource://" + getPackageName() + "/"  + suara_buah);
        // set audio manager
        mediaPlayer.setAudioSessionId(AudioManager.STREAM_MUSIC);
        // set data lokasi audio / resource ke mediaplayer
        try {
            mediaPlayer.setDataSource(getApplicationContext(), lokasi_audio);
            mediaPlayer.prepare();
            mediaPlayer.start(); // putar audio
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
