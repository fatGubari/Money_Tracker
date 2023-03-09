package com.example.money_tracker;

import static android.app.appsearch.AppSearchResult.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class CameraFragment extends Fragment {
    Button camera,save;
    ImageView imageView;
    ActivityResultLauncher<Intent> activityResultLauncher;
    EditText imgName;
    Bitmap photo;
    DB db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_camera, container, false);

        camera = view.findViewById(R.id.camera);
        save = view.findViewById(R.id.save);
        imgName = view.findViewById(R.id.imgName);
        imageView = view.findViewById(R.id.camera_image);
        db = new DB(getActivity());

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getData() != null){
                    Bundle bundle = result.getData().getExtras();
                    photo = (Bitmap) bundle.get("data");
                    imageView.setImageBitmap(photo);

                }
            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (open_camera.resolveActivity(getContext().getPackageManager()) != null){
                    activityResultLauncher.launch(open_camera);
                }
                else {
                    Toast.makeText(getActivity(), "App Not Support", Toast.LENGTH_SHORT).show();
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String image = BitMapToString(photo);
                SavedImage savedImage = new SavedImage(imgName.getText().toString(), image);
                db.addImage(savedImage);
                Toast.makeText(getActivity(), "Image Saved", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp=Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }
}