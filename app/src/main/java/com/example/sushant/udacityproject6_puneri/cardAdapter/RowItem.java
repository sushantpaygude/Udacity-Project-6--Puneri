package com.example.sushant.udacityproject6_puneri.cardAdapter;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sushant on 31/8/16.
 */
public class RowItem {
    private int cardImage;
    private String cardTitle;

    public RowItem(int cardImage, String cardTitle) {
        this.cardImage = cardImage;
        this.cardTitle = cardTitle;
    }

    public int getcardImage() {
        return cardImage;
    }

    public String getcardTitle() {
        return cardTitle;
    }

    public void setcardImage(int cardImage) {
        this.cardImage = cardImage;
    }

    public void setString(String cardTitle) {
        this.cardTitle = cardTitle;
    }
}
