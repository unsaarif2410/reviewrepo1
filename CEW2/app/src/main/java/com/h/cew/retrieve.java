package com.h.cew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class retrieve extends AppCompatActivity {
    ListView listview;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String>list;
    ArrayAdapter<String> adapter;
    Member mem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);
        mem=new Member();
        listview=(ListView)findViewById(R.id.listview);
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Member");
        list= new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.user_info,R.id.userInfo,list);
        ref.addValueEventListener(new ValueEventListener() {
                                      @Override
                                      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                          for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                              mem = ds.getValue(Member.class);
                                              list.add(mem.getResturantComment().toString());

                                          }

                                          listview.setAdapter(adapter);


                                      }


                                      @Override
                                      public void onCancelled(@NonNull DatabaseError databaseError) {

                                      }});




            Button button =findViewById(R.id.btn);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){
            Intent intent = new Intent(retrieve.this, input.class);
            startActivity(intent);


        }





            });}}

