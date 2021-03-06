package com.example.sushant.udacityproject6_puneri.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sushant.udacityproject6_puneri.R;
import com.example.sushant.udacityproject6_puneri.cardAdapter.CustomCardAdapter;
import com.example.sushant.udacityproject6_puneri.cardAdapter.RowItem;

/**
 * Created by sushant on 30/8/16.
 */
public class SecondFragment extends Fragment implements AdapterView.OnItemClickListener{
    private CustomCardAdapter cardAdapter;
    ListView listView;
    static Integer[] images={R.drawable.image_dagduseth,R.drawable.image_rajivpark,R.drawable.image_durvankur,R.drawable.image_agakhan,R.drawable.image_pataleshwar,R.drawable.image_osho,R.drawable.image_george,R.drawable.image_kelkar};
    static Integer[] titles={R.string.dagdushet,R.string.rajiv,R.string.durvankur,R.string.agakhan,R.string.pataleshwar,R.string.osho,R.string.george,R.string.raja};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.card_list_view,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView)getView().findViewById(R.id.card_listView);
        cardAdapter=new CustomCardAdapter(getActivity().getApplicationContext(),R.layout.list_item_card);
        listView.setAdapter(cardAdapter);

        for(int i=0;i<titles.length;i++) {
            RowItem item = new RowItem(images[i], titles[i]);
            cardAdapter.add(item);
        }

        listView.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedTitle=((TextView)view.findViewById(R.id.card_title)).getText().toString();
        Log.e("ID","IS:"+selectedTitle);
    }
}
