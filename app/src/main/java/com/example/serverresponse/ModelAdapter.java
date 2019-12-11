package com.example.serverresponse;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ModelAdapter extends ArrayAdapter {

    List list= new ArrayList();
    public ModelAdapter(Context context, List<Model> modellist) {


        //extend kora hoyeche ArrayAdapter  er constructor call korar jonno model Adapter er ekta
        // constructor banano holo. sekhane super key word diye data ArrayAdapter e pathano hocche.


        super(context,0, modellist);
        list= modellist;
    }



    public void add(Model object) {
        super.add(object);

        // jei array list banano holo set ate object add kora hochhe
        list.add(object);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return  list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         View row;
         row= convertView;
         ContactHolder contactHolder;
         if(row==null){

             LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             row = layoutInflater.inflate(R.layout.row_list,parent,false);
             contactHolder = new ContactHolder();

             contactHolder.tx_id = (TextView) row.findViewById(R.id.id);
             contactHolder.tx_email = (TextView) row.findViewById(R.id.email);
             contactHolder.tx_first_name = (TextView) row.findViewById(R.id.firsst_name);
             contactHolder.tx_last_name = (TextView) row.findViewById(R.id.last_name);
             contactHolder.tx_avatar = (ImageView) row.findViewById(R.id.profileImage);

             row.setTag(contactHolder);
         }else {

             contactHolder = (ContactHolder) row.getTag();
         }


         Model model = (Model) this.getItem(position);


         contactHolder.tx_id.setText(model.getId());
         contactHolder.tx_email.setText(model.getEmail());
         contactHolder.tx_first_name.setText(model.getFirst_name());
         contactHolder.tx_last_name.setText(model.getLast_name());



//         contactHolder.tx_avatar.setImageURI(model.getAvatar());
//        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imageView);



//        ei dui ta line dekhe sycconize kora hoye che
        Picasso.get().load(model.getAvatar()).into(contactHolder.tx_avatar);



        return row;
    }


    static class ContactHolder{

        TextView tx_id,tx_email,tx_first_name,tx_last_name;
                ImageView tx_avatar;

    }
}
