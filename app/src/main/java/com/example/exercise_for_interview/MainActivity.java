package com.example.exercise_for_interview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
EditText name;
Button b;
TextView t;
SharedPreferences sp;
RecyclerView recyclerView;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycleview);
    Retrofit retro=new Retrofit.Builder().
            baseUrl("https://jsonplaceholder.typicode.com").
            addConverterFactory(GsonConverterFactory.create()).build();
    RetrofitInterface retrofitInterface=retro.create(RetrofitInterface.class);
    Call<List<Hero>> listCall=retrofitInterface.getGsonData();
    listCall.enqueue(new Callback<List<Hero>>() {
        @Override
        public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response)
        {
            List<Hero> heroes=response.body();

            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            ArrayList<Hero> arrayList=new ArrayList<>();
            for(int i=0;i<heroes.size();i++)
            {
                String userid=heroes.get(i).getUserId();
                String id=heroes.get(i).getId();
                String title=heroes.get(i).getTitle();
                String body=heroes.get(i).getBody();
            arrayList.add(new Hero(userid,id,title,body));
            }



            DataAdapter dataAdapter=new DataAdapter(arrayList);
recyclerView.setAdapter(dataAdapter);
  //          Toast.makeText(getApplicationContext(),response.body().toString(),Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onFailure(Call<List<Hero>> call, Throwable t) {

        }
    });
}

    private void linearlayout1() {
        name=findViewById(R.id.ed_name);
        b=findViewById(R.id.b1);
        t=findViewById(R.id.display_data);
        sp=getSharedPreferences("data",MODE_PRIVATE);
        String name1=sp.getString("name","");
        t.setText(name1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),secondActivity.class);
                i.putExtra("name",name.getText().toString());
                startActivity(i);
            }
        });

    }
}
