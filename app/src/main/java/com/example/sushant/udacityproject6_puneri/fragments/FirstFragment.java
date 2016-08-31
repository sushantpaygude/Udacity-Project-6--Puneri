package com.example.sushant.udacityproject6_puneri.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.sushant.udacityproject6_puneri.R;
import com.example.sushant.udacityproject6_puneri.cardAdapter.CustomCardAdapter;
import com.example.sushant.udacityproject6_puneri.cardAdapter.RowItem;


/**
 * Created by sushant on 30/8/16.
 */
public class FirstFragment extends Fragment {
private CustomCardAdapter cardAdapter;
    ListView listView;
static Integer[] images={R.drawable.image_sinhgadfort};
    String[] titles={"Sinhgad"};
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
    //   super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.card_list_view,container,false);

    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView)getView().findViewById(R.id.card_listView);
       // listView.addHeaderView(new View(this));

        cardAdapter=new CustomCardAdapter(getActivity().getApplicationContext(),R.layout.list_item_card);
        listView.setAdapter(cardAdapter);
        RowItem item=new RowItem(images[0],titles[0]);
        cardAdapter.add(item);



    }
}
