package com.example.serverresponse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

public class displayAllData extends AppCompatActivity {


    // static WHy??


//    static method er static component use kora hocche

    static  ListView listView;
    static ProgressBar simpleProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_data);

        listView =findViewById(R.id.listView);

        simpleProgressBar = (ProgressBar) findViewById(R.id.simpleProgressBar);


        String url = "https://reqres.in/api/users?page=2";


        // visible the progress bar
        simpleProgressBar.setVisibility(View.VISIBLE);






        new Response(url, displayAllData.this);





//simpleProgressBar.setVisibility(View.GONE);

    }

// static class er object call kora jay na eta direct call kora hoy
    public static void fun(Context context, List<Model> model){

                      ModelAdapter modelAdapter=new ModelAdapter(context,model);

                      // list view te model adapter ta set kora holo
                      listView.setAdapter(modelAdapter);
simpleProgressBar.setVisibility(View.GONE);


    }
}

