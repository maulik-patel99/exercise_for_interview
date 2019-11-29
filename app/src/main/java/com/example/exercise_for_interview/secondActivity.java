package com.example.exercise_for_interview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {
TextView t;
EditText name;
 SharedPreferences sp;
   Button b;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        sp = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("name",name.getText().toString());
        editor.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    t=findViewById(R.id.display_first_activitydata);
    name=findViewById(R.id.ed_name_for_second);
    b=findViewById(R.id.forfirst);
       Intent i=getIntent();
    String s=i.getStringExtra("name");
    t.setText(s);
    b.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View view) {
                                 Intent i1=new Intent(getApplicationContext(),MainActivity.class);
                                 sp = getSharedPreferences("data", MODE_PRIVATE);
                                 SharedPreferences.Editor editor=sp.edit();
                                 editor.putString("name",name.getText().toString());
                                 editor.commit();
                                 startActivity(i1);
                             }
                         });

    }
}
