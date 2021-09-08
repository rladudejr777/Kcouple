package com.young1014.kcouple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.util.Utility;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class MainActivity extends AppCompatActivity {

    CircleImageView civ;
    TextView tvNickname;
    TextView tvEmail;
    TextView tvgender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String keyHash= Utility.INSTANCE.getKeyHash(this);
        Log.i("KeyHash", keyHash);

        civ= findViewById(R.id.civ);
        tvNickname= findViewById(R.id.tv_nickname);
        tvEmail = findViewById(R.id.tv_email);
        tvgender = findViewById(R.id.tv_gender);

    }

    public void clickLogin(View view) {

        UserApiClient.getInstance().loginWithKakaoAccount(this, new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {

                if (oAuthToken != null ){
                    Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();

                    UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                        @Override
                        public Unit invoke(User user, Throwable throwable) {

                            if (user != null) {

                                long id = user.getId();

                                G.nickname= user.getKakaoAccount().getProfile().getNickname();
                                G.profileUrl= user.getKakaoAccount().getProfile().getProfileImageUrl();

                                G.email= user.getKakaoAccount().getEmail();
                                G.gender= user.getKakaoAccount().getGender().toString();

                                tvNickname.setText(G.nickname);
                                tvEmail.setText(G.email);
                                tvgender.setText(G.gender);
                                Glide.with(MainActivity.this).load(G.profileUrl).into(civ);

                            }

                            return null;
                        }
                    });

                }else{
                    Toast.makeText(MainActivity.this, "사용자 정보 요청 실패", Toast.LENGTH_SHORT).show();
                }

                return null;
            }
        });

    }

    public void clickNext(View view) {

        startActivity( new Intent(this, D_DayActivity.class) );

    }
}




















































