package yass.tawakadziruni.com.myboyremake;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
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
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity{
        File ARra;
        ArrayList<Bitmap> Imagess = new ArrayList<Bitmap>();


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



    public Bitmap getBitmapFromUri() throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = getContentResolver().openFileDescriptor(fileUri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap imagse = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return imagse;
    }
        private File getTempFile(Context context) {
            //it will return /sdcard/image.tmp
            final File path = new File(Environment.getExternalStorageDirectory(), context.getPackageName());
            if (!path.exists()) {
                path.mkdir();
            }
            return new File(path, "image.tmp");

        }





public void Take_A_Photo(View v) {
    Intent NewClothingCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    if (NewClothingCapture.resolveActivity(getPackageManager()) != null) {
        // Create the File where the photo should go
        File photoFile = null;
        try {
            photoFile = MakeANewFile();
        }
        catch (IOException ex) {
            // Error occurred while creating the File
            Toast error = new Toast(this);
            error.setDuration(Toast.LENGTH_LONG);
            error.setText("Failed to take a new photo. Please report to the developer.");
            error.show();
        }


        if (photoFile != null) {
            Uri photoURI = FileProvider.getUriForFile(this, "com.example.android.fileprovider", photoFile);
            NewClothingCapture.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            NewClothingCapture.putExtra("return-data", true);
            startActivityForResult(NewClothingCapture, 1);
            fileUri = Uri.parse(photoURI.getPath());

            if(Imagess.size()>1){
                Toast esa = new Toast(this);
                esa.setDuration(Toast.LENGTH_LONG);
                esa.setText("Added the photo(s).");
                esa.show();
            }

            try {
                Bitmap captureBmp = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(photoFile));
                Imagess.add(captureBmp);
                Toast picAdded=new Toast(this);
                picAdded.setDuration(Toast.LENGTH_LONG);
                picAdded.setText("Pic Added.");

                // do whatever you want with the bitmap (Resize, Rename, Add To Gallery, etc)
            } catch (FileNotFoundException e) {
                Toast error = new Toast(this);
                error.setDuration(Toast.LENGTH_LONG);
                error.setText("Failed to take a new photo. Please report to the developer.");
                error.show();
                e.printStackTrace();

            } catch (IOException e) {
                Toast error = new Toast(this);
                error.setDuration(Toast.LENGTH_LONG);
                error.setText("Failed to take a new photo. Please report to the developer.");
                error.show();
            }
        }

        }

    }


}







//// TODO: 2017/08/20 Find a way of retrieving the photo.







