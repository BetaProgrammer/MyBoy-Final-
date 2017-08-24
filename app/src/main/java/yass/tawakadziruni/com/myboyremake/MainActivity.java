package yass.tawakadziruni.com.myboyremake;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
        File ARra;
        ArrayList Imagess = new ArrayList();

        int reg = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

            if(false==true){
                    System.out.println("ksak");
            }
    }

    public Uri fileUri;


public File MakeANewFile() throws IOException {
        int d = 1;
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        d += 1;
        File NewImage = File.createTempFile("Image " + d, ".jpg", storageDir);
        // Save a file: path for use with ACTION_VIEW intents
        String CurrentPhotoPath = NewImage.getAbsolutePath();
        Imagess.add(NewImage);

        ArrayAdapter<File> adapter=new ArrayAdapter<File>(this,android.R.layout.simple_list_item_1,Imagess);
        ListView liz =(ListView) findViewById(R.id.Image_ListView);
        liz.setAdapter(adapter);

        return NewImage;
}

public void Take_A_Photo(View v) {
        Intent NewClothingCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        /////////////////////////////////////////////////////////////////

        if (NewClothingCapture.resolveActivity(getPackageManager()) != null) {
        // Create the File where the photo should go
        File photoFile = null;
        try {

        photoFile = MakeANewFile();
        } catch (IOException ex) {
        // Error occurred while creating the File
        Toast error = new Toast(this);
        error.setDuration(Toast.LENGTH_LONG);
        error.setText("Failed to take a new photo. Please report to the developer.");
        error.show();
        }


        //////////////////////////////////////////////////////////////////
        if (photoFile != null) {
        Uri photoURI = FileProvider.getUriForFile(this, "com.example.android.fileprovider", photoFile);
        Imagess.add(photoFile);
        NewClothingCapture.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
        NewClothingCapture.putExtra("return-data", true);
        startActivityForResult(NewClothingCapture, 1);
        fileUri = Uri.parse(photoURI.getPath());


//// TODO: 2017/08/20 Find a way of retrieving the photo.
        }


        }
        }
        }
