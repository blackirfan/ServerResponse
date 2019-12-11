package com.example.serverresponse;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class Response {

    public String id,email,first_name,last_name,avatar;

    // model type list  neoya holo
    List<Model> modellist = new ArrayList <>();




    public Response(String url, Context context){








        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("Fail","there fall some fail");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull okhttp3.Response response) throws IOException {

                String data = response.body().string();

//                Log.e("data",data);


                try {
                    JSONObject jsonObject = new JSONObject(data);

//                    Log.e("data2",jsonObject.toString());

//                    JSONObject jsonObject1 = jsonObject.getJSONObject("data");

                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    for(int count = 0;count <jsonArray.length();count++){

                        JSONObject JO= jsonArray.getJSONObject(count);
                        id = JO.getString("id");
                        email = JO.getString("email");
                        first_name = JO.getString("first_name");
                        last_name = JO.getString("last_name");
                        avatar = JO.getString("avatar");

                        Model model = new Model(id,email,first_name,last_name,avatar);


//                        generic type list e model add kora holo

                       modellist.add(model);


                    }


//                    Log.e("data3",jsonArray.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }




                ((Activity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        // why send context here?  er sathe modellist send kora holo

                        //
//
                        displayAllData.fun(context,modellist);


                    }

                });



            }
        });




    }
}
