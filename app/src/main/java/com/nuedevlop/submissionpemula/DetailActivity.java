package com.nuedevlop.submissionpemula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView txtTipe,txtHarga,txtSpek,txtTittle;
    ImageView gbrPriview ;
    ImageButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String tipe = intent.getStringExtra("tipe");
        String harga = intent.getStringExtra("harga");
        String spek = intent.getStringExtra("spek");
        String gambar = intent.getStringExtra("gambar");

        txtTittle= findViewById(R.id.toolbarTittle);
        txtTittle.setText("Halaman Detail");

        txtHarga=findViewById(R.id.txtDetailHarga);
        txtSpek=findViewById(R.id.txtDetailSpek);
        txtTipe=findViewById(R.id.txtDetailTipe);
        gbrPriview=findViewById(R.id.gbrDetailPriview);

        Glide.with(this).load(gambar).into(gbrPriview);

        txtHarga.setText(harga);
        txtSpek.setText(spek);
        txtTipe.setText(tipe);

        btnHome = findViewById(R.id.toobalHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }
}
