package yass.tawakadziruni.com.myboyremake;

import android.app.Activity;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import yass.tawakadziruni.com.myboyremake.R;


class Adapter extends ArrayAdapter<Bitmap> {

    Adapter(Activity context, ArrayList<Bitmap> words){

        super(context,0,words);
    }


    @NonNull
    @Override
    public View getView (int position, View convertView, @NonNull ViewGroup parent){


        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }

        Bitmap currentPhoto= getItem(position);

        ImageView iconView= (ImageView) listItemView.findViewById(R.id.Image);
        return listItemView;


    }
}
