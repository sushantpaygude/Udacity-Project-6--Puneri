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
import android.widget.Toast;

import com.example.sushant.udacityproject6_puneri.R;
import com.example.sushant.udacityproject6_puneri.cardAdapter.CustomCardAdapter;
import com.example.sushant.udacityproject6_puneri.cardAdapter.RowItem;


/**
 * Created by sushant on 30/8/16.
 */
public class FirstFragment extends Fragment implements AdapterView.OnItemClickListener{
private CustomCardAdapter cardAdapter;
    ListView listView;
static Integer[] images={R.drawable.image_sinhgadfort,R.drawable.image_goodluck,R.drawable.image_parvati1,R.drawable.image_wadeshwar,R.drawable.image_taljai,R.drawable.image_vaishali,R.drawable.image_vohuman,R.drawable.image_chai};
    String[] titles={"Sinhgad Fort","Cafe GoodLuck","Parvati Hill","Wadeshwar","Taljai Hill","Hotel Vaishali","Vohuman Cafe","Chai"};
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.card_list_view,container,false);
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView)getView().findViewById(R.id.card_listView);
        cardAdapter=new CustomCardAdapter(getActivity().getApplicationContext(),R.layout.list_item_card);
        listView.setAdapter(cardAdapter);
        for(int i=0;i<images.length;i++) {
            RowItem item = new RowItem(images[i], titles[i]);
            cardAdapter.add(item);
        }
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedTitle=((TextView)view.findViewById(R.id.card_title)).getText().toString();
    }
}
