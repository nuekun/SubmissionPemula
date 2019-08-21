package com.nuedevlop.submissionpemula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.nuedevlop.submissionpemula.adapter.LaptopAdapter;
import com.nuedevlop.submissionpemula.data.LaptopData;
import com.nuedevlop.submissionpemula.model.LaptopModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recLaptop;
    ArrayList<LaptopModel> listLaptop = new ArrayList<>();
    ImageButton btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        recLaptop = findViewById(R.id.mainRecLaptop);
        recLaptop.setHasFixedSize(true);
        btnAbout = findViewById(R.id.toobalAbout);

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(intent);
            }
        });

        listLaptop.addAll(LaptopData.getListLaptop());
        tampil();


    }

    private void tampil() {



        recLaptop.setLayoutManager(new LinearLayoutManager(this));
        LaptopAdapter laptopAdapter = new LaptopAdapter(MainActivity.this,listLaptop);
        recLaptop.setAdapter(laptopAdapter);

    }
}
