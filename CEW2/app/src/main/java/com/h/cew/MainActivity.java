package com.h.cew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class MainActivity extends AppCompatActivity {
    DatabaseReference refdata;
    Member member;
    long maxid=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        member = new Member();
        refdata = FirebaseDatabase.getInstance().getReference().child("Member");
        refdata.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        ImageView img1 = (ImageView) findViewById(R.id.img1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,retrieve.class);
                startActivity(intent);
                refdata.child(String.valueOf(maxid + 1)).setValue(member);

            }
        });

        ImageView img2 = (ImageView) findViewById(R.id.img2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, retrieveG.class);
                startActivity(intent);
                refdata.child(String.valueOf(maxid + 1)).setValue(member);

            }
        });

        ImageView img3 = (ImageView) findViewById(R.id.img3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, retrieveF.class);
                startActivity(intent);
                refdata.child(String.valueOf(maxid + 1)).setValue(member);

            }
        });


        ImageView img4 = (ImageView) findViewById(R.id.img4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, retrieveK.class);
                startActivity(intent);
                refdata.child(String.valueOf(maxid + 1)).setValue(member);

            }
        });

        ImageView img5 = (ImageView) findViewById(R.id.img5);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, retrieveL.class);
                startActivity(intent);
                refdata.child(String.valueOf(maxid + 1)).setValue(member);


            }

    });

        }}



