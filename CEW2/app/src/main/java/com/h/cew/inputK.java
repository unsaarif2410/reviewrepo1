package com.h.cew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class inputK extends AppCompatActivity {
    DatabaseReference refdata;
    MemberK member;
    long maxid=0;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_k);
        member = new MemberK();
        refdata = FirebaseDatabase.getInstance().getReference().child("MemberK");
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
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inputK.this, retrieveK.class);
                startActivity(intent);
                EditText edit = findViewById(R.id.edittxt);
                int star1 = 1;
                String rest="restt";
                member.setResturant(rest.trim());
                member.setResturantComment(edit.getText().toString().trim());
                member.setRestStar(star1);
                refdata.child(String.valueOf(maxid + 1)).setValue(member);
                refdata.child("member").setValue(member);
            }
        });
    }}





