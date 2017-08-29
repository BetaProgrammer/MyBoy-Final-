package yass.tawakadziruni.com.myboyremake;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.ArrayList;


public class Photo {
    private Uri mPhotoUri;
    private Bitmap mThePhoto;

    ArrayList<Uri> PhotoUris = new ArrayList<>();
    ArrayList<Bitmap> Imagess = new ArrayList<Bitmap>();

    public Photo(Uri PhotoUri,Bitmap ThePhoto){
        mPhotoUri=PhotoUri;
        mThePhoto=ThePhoto;

    }


}