package com.young1014.kcouple;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class GlobalApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        KakaoSdk.init(this, "d7393bf5dd56a162cf512e2f36795407");

    }
}
