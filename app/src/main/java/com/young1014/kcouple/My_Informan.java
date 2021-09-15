package com.young1014.kcouple;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class My_Informan extends AppCompatActivity {

    ImageView iv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_informan);

        iv = findViewById(R.id.iv);
        tv = findViewById(R.id.tv);

    }

    public void clickBtn(View view) {

        Intent intent= new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setType("image/*");

        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 100:
                if (resultCode != RESULT_CANCELED){
                    Uri uri= data.getData();

                    iv.setImageURI(uri);


                }
                break;


        }

    }
}