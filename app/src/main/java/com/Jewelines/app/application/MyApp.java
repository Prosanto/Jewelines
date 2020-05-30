package com.Jewelines.app.application;

import android.app.Application;

import com.stripe.android.PaymentConfiguration;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        PaymentConfiguration.init(
                getApplicationContext(),
                "pk_test_eHQJOyH9rVKKuDsvspX8Ob7e00kr6db5Rm");
    }
}