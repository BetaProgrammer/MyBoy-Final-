package yass.tawakadziruni.com.myboyremake;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by T on 2017/08/19.
 */

public class List extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
    }
    ImageView mImageView=(ImageView) findViewById(R.id.Image);
}
