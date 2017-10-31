package com.example.ashutosh.assignment_73;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URI;

//Class Declaration which is extending AppCompactActivity and implementing onClickListener interface.
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static int RESULT_LOAD_IMAGE=100;
    //static int to pass for request code while starting another activity.

    ImageView boxImage;     //Declaring object of ImageView class.
    Button upload;          //Button which will switch from one activity to another.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upload=(Button)findViewById(R.id.upload);      //Defining Button which will change the activity.
        upload.setOnClickListener(this);          //Setting onClick event.
    }

    @Override
    public void onClick(View v) {

        Intent uploadImage=new Intent();       //Creating object of Intent.

        uploadImage.setAction(Intent.ACTION_PICK);      //Setting the Action of Intent.

        uploadImage.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
           //Setting data to Intent.

        startActivityForResult(uploadImage,RESULT_LOAD_IMAGE);
                   //Starting Activity.
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //When image is picked.
        if(requestCode==RESULT_LOAD_IMAGE && resultCode==RESULT_OK && null!=data)
        {
            boxImage=(ImageView)findViewById(R.id.imageView);
                  //Setting the boxImage as an ImageView.

            Uri pickedImage=data.getData();
            //Image picked.

            boxImage.setImageURI(pickedImage);
                  //Image uploaded.
        }
    }
}    //End of class.
