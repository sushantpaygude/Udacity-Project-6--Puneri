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
public class FifthFragment extends Fragment implements AdapterView.OnItemClickListener {
    private CustomCardAdapter cardAdapter;
    ListView listView;
    static Integer[] images = {R.drawable.image_westin,R.drawable.image_ohotel,R.drawable.image_novotel,R.drawable.image_jwmarriot,R.drawable.image_lemeridien,R.drawable.image_hyatt,R.drawable.image_corinthians,R.drawable.image_sunandsand};
    String[] titles = {"The Westin", "O Hotel", "Novotel", "JW Marriot", "Le Meridien", "Hyatt Regency", "Corinthians Resort & Spa", "Sun & Sand"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //   super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.card_list_view, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView) getView().findViewById(R.id.card_listView);
        // listView.addHeaderView(new View(this));

        cardAdapter = new CustomCardAdapter(getActivity().getApplicationContext(), R.layout.list_item_card);
        listView.setAdapter(cardAdapter);
        for (int i = 0; i < images.length; i++) {
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