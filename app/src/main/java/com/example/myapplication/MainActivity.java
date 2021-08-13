package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] titles ={"Title1","Title2","Title3","Title4","Title5","Title6"};
    String[] description={"Descripton1","Descripton2","Descripton3","Descripton4","Descripton5","Descripton6"};
    int[] images={R.drawable.adwords, R.drawable.apple,R.drawable.closed,R.drawable.cube,R.drawable.logo,R.drawable.messenger};
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.Listview);
        MyAdapter adpter=new MyAdapter(titles,description,images);
        lv.setAdapter(adpter);
    }


}
class  MyAdapter extends ArrayAdapter{
    int[] imageArray;
    String[] titleArray;
    String[] descArray;
    public MyAdapter(Context context,String[] titles1,String[]descriptions1,int[]img1){
        super(context,R.layout.sanmple_activity,R.id.Title,titles1);
        this.imageArray=img1;
        this.descArray=descriptions1;
        this.titleArray=titles1;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.sanmple_activity,parent,false);
        //Get the reference to the view objects
        ImageView myImage=row.findViewById(R.id.pic);
        TextView myTitle=row.findViewById(R.id.Title);
        TextView myDescription=row.findViewById(R.id.description);

        //providing the elemenet of array by specifying its position
        myImage.setImageResource(imageArray[position]);
        myTitle.setText(titleArray[position]);
        myDescription.setText(descArray[position]);

        return row;
    }
}