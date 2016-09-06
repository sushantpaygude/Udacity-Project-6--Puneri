package com.example.sushant.udacityproject6_puneri.cardAdapter;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sushant on 31/8/16.
 */
public class RowItem {
    private int cardImage;
    private int cardTitle;

    public RowItem(int cardImage, int cardTitle) {
        this.cardImage = cardImage;
        this.cardTitle = cardTitle;
    }

    public int getcardImage() {
        return cardImage;
    }

    public int getcardTitle() {
        return cardTitle;
    }

    public void setString(int cardTitle) {
        this.cardTitle = cardTitle;
    }
}
