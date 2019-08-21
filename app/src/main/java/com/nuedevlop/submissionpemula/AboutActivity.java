package com.nuedevlop.submissionpemula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutActivity extends AppCompatActivity {

    CircleImageView gbrProfil;
    TextView txtTittle;
    String URL;
    ImageButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_about);

        gbrProfil=findViewById(R.id.gbrAboutProfil);
        URL = "https://www.dicoding.com/images/small/avatar/20190706001012ccc258b1db148c733206b13a1fe92975.JPG";
        Glide.with(this).load(URL).into(gbrProfil);
        txtTittle= findViewById(R.id.toolbarTittle);
        txtTittle.setText("Halaman About");
        btnHome = findViewById(R.id.toobalHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
}
