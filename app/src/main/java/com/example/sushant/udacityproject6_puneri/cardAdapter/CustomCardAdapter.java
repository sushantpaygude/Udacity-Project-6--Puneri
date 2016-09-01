package com.example.sushant.udacityproject6_puneri.cardAdapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sushant.udacityproject6_puneri.R;
import com.example.sushant.udacityproject6_puneri.fragments.InfoFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by sushant on 31/8/16.
 */
public class CustomCardAdapter extends ArrayAdapter<RowItem> {
    private List<RowItem> cardList=new ArrayList<RowItem>();
    private FragmentActivity myContext;




    static class CardViewHolder {
        ImageView cardImage;
        TextView cardTitle;
        CardView cardView;


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
            viewHolder.cardView=(CardView)row.findViewById(R.id.card_view);
            row.setTag(viewHolder);
        }
            else {
            viewHolder = (CardViewHolder) row.getTag();
        }
            RowItem rowItem=getItem(position);
           // viewHolder.cardImage.setImageResource(rowItem.getcardImage());
            viewHolder.cardTitle.setText(rowItem.getcardTitle());
            String selected=rowItem.getcardTitle();

        Picasso.with(getContext()).load(rowItem.getcardImage()).into(viewHolder.cardImage);
          //  Log.e("ID","IS:"+selected);
            return row;


//        return super.getView(position, convertView, parent);
    }


}
