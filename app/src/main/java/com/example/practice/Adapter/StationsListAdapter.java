package com.example.practice.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice.Model.Stations;
import com.example.practice.R;

import java.util.List;

public class StationsListAdapter extends ArrayAdapter<Stations> {

    Context mContext;
    public StationsListAdapter(@NonNull Context context, int resource, List<Stations> items) {
        super(context, resource, items);
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Viewholder viewholder = null;
        Stations rowItem = getItem(position);
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.stations_row, null);
            viewholder = new Viewholder();
            viewholder.txt_id = (TextView) convertView.findViewById(R.id.txt_id);
            viewholder.txt_station = (TextView) convertView.findViewById(R.id.txt_station);
            viewholder.txt_station_english = (TextView) convertView.findViewById(R.id.txt_station_english);
            viewholder.relative = (RelativeLayout) convertView.findViewById(R.id.relative);
            convertView.setTag(viewholder);

        }
        else {
            viewholder = (Viewholder) convertView.getTag();
        }
        viewholder.txt_station.setText(rowItem.getTitle());
        viewholder.txt_station_english.setText(rowItem.getEnglishTitle());
        viewholder.txt_id.setText(rowItem.getId()+"");
        int line=rowItem.getLine();


        if(line==1)
        {
            viewholder.relative.setBackgroundColor(Color.parseColor("#FF1744"));
        }
        else if(line==2)
        {
            viewholder.relative.setBackgroundColor(Color.parseColor("#FF5722"));
        }
        return convertView;
    }



    private class Viewholder{
        TextView txt_station, txt_station_english,txt_id;
        RelativeLayout relative;
    }
}
