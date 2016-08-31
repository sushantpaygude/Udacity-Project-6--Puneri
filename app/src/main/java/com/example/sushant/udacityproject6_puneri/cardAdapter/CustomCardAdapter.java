package com.example.sushant.udacityproject6_puneri.cardAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sushant.udacityproject6_puneri.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by sushant on 31/8/16.
 */
public class CustomCardAdapter extends ArrayAdapter<RowItem> {
    private List<RowItem> cardList=new ArrayList<RowItem>();

    static class CardViewHolder{
        ImageView cardImage;
        TextView cardTitle;


    }
    public CustomCardAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(RowItem object) {
        cardList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.cardList.size();
    }

    @Override
    public RowItem getItem(int position) {
        return this.cardList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        CardViewHolder viewHolder;
        if(row==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row= layoutInflater.inflate(R.layout.first_fragment,parent,false);
            viewHolder =new CardViewHolder();
            viewHolder.cardImage=(ImageView)row.findViewById(R.id.card_image);
            viewHolder.cardTitle=(TextView)row.findViewById(R.id.card_title);
            row.setTag(viewHolder);
        }
            else {
            viewHolder = (CardViewHolder) row.getTag();
        }
            RowItem rowItem=getItem(position);
            viewHolder.cardImage.setImageResource(rowItem.getcardImage());
            viewHolder.cardTitle.setText(rowItem.getcardTitle());
            return row;

//        return super.getView(position, convertView, parent);
    }
}
