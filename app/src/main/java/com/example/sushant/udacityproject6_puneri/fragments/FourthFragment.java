package com.example.sushant.udacityproject6_puneri.fragments;

import android.os.Bundle;
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
 * Created by sushant on 1/9/16.
 */
public class FourthFragment extends Fragment implements AdapterView.OnItemClickListener {
    private CustomCardAdapter cardAdapter;
    ListView listView;
    static Integer[] images = {R.drawable.image_penthouse,R.drawable.image_stonewater,R.drawable.image_miamiclub,R.drawable.image_fbeach,R.drawable.image_atmosphere,R.drawable.image_area51,R.drawable.image_hardrock,R.drawable.image_flambos};
    static Integer[] titles={R.string.penthouse,R.string.stone,R.string.miami,R.string.fbeach,R.string.atmosphere,R.string.area,R.string.hardrock,R.string.flambos};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.card_list_view, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) getView().findViewById(R.id.card_listView);
        cardAdapter = new CustomCardAdapter(getActivity().getApplicationContext(), R.layout.list_item_card);
        listView.setAdapter(cardAdapter);
        for (int i = 0; i < titles.length; i++) {
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