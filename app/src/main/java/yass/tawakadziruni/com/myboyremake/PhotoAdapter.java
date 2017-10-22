package yass.tawakadziruni.com.myboyremake;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;


class PhotoAdapter extends ArrayAdapter<Photo> {

    PhotoAdapter(Activity context, ArrayList<Photo> Pics) {
        super(context, 0, Pics);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }

        Photo currentPhoto = getItem(position);
        ImageView photo = (ImageView) listItemView.findViewById(R.id.Image);
        assert currentPhoto != null;
        photo.setImageDrawable(currentPhoto.getThePhoto());


        return listItemView;

    }


}





