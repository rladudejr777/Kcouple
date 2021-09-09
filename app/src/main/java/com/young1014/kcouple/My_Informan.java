package com.young1014.kcouple;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class My_Informan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_informan);
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


                }
                break;
        }

    }
}