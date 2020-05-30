package com.Jewelines.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.Jewelines.app.mailsend.GMailSender;
import com.Jewelines.app.utils.PersistentUser;
import com.Jewelines.app.utils.ToastHelper;
import com.stripe.android.ApiResultCallback;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.PaymentIntentResult;
import com.stripe.android.Stripe;
import com.stripe.android.model.Card;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.Token;
import com.stripe.android.view.CardInputWidget;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Objects;

public class PaymentActivity extends AppCompatActivity {
    private static final String TAG = PaymentActivity.class.getSimpleName();
    private Context mContext;
    private String Quotevalue = "";
    private CardInputWidget mCardInputWidget;
    private TextView tvPayment;
    private String paymentIntentClientSecret = "sk_test_BWNUSyllXFolHUst6p3LAnrw00tdUAhVL0";
    private Stripe stripe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotepayment);
        Quotevalue = getIntent().getStringExtra("Quotevalue");
        mContext = this;
        initUi();
    }

    private void initUi() {
        tvPayment = (TextView) this.findViewById(R.id.tvPayment);
        mCardInputWidget = (CardInputWidget) findViewById(R.id.card_input_widget);
        mCardInputWidget.setCvcNumberTextWatcher(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validationCardNumber();
            }
        });
        mCardInputWidget.setCardNumberTextWatcher(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validationCardNumber();
            }
        });
        mCardInputWidget.setExpiryDateTextWatcher(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validationCardNumber();
            }
        });
        findViewById(R.id.layoutQuotePayment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validatation();
            }
        });
        validationCardNumber();
    }

    public void validationCardNumber() {
        Card cardToSave = mCardInputWidget.getCard();
        if (cardToSave == null) {
            //tvPayment.setTextColor(Color.parseColor("#ffffff"));
            //tvPayment.setBackgroundColor(Color.parseColor("#AAAAAA"));
        } else {

            //tvPayment.setTextColor(Color.parseColor("#ffffff"));
            // tvPayment.setBackgroundColor(Color.parseColor("#F71226"));
        }

    }

    public void validatation() {
        Card cardToSave = mCardInputWidget.getCard();
        if (cardToSave == null) {
            ToastHelper.showToast(mContext, "Invalid Card Informaiton");
            return;

        } else {
            try {
                PaymentMethodCreateParams params = mCardInputWidget.getPaymentMethodCreateParams();
                if (params != null) {
                    Log.w("params", "" + params.toString());
                    ConfirmPaymentIntentParams confirmParams = ConfirmPaymentIntentParams.createWithPaymentMethodCreateParams(params, paymentIntentClientSecret);
                    stripe = new Stripe(mContext, PaymentConfiguration.getInstance(mContext).getPublishableKey());
                    stripe.confirmPayment(this, confirmParams);

                }
            } catch (Exception ex) {
                ToastHelper.showToast(mContext, ex.toString());
                Log.w("paraExceptionms", "" + ex.getMessage().toString());

            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        stripe.onPaymentResult(requestCode, data, new PaymentResultCallback(this));
    }

    private class PaymentResultCallback implements ApiResultCallback<PaymentIntentResult> {
        @NonNull
        private final WeakReference<PaymentActivity> activityRef;

        PaymentResultCallback(@NonNull PaymentActivity activity) {
            activityRef = new WeakReference<>(activity);
        }

        @Override
        public void onSuccess(@NonNull PaymentIntentResult result) {
            final PaymentActivity activity = activityRef.get();
            if (activity == null) {
                return;
            }
            PaymentIntent paymentIntent = result.getIntent();
            PaymentIntent.Status status = paymentIntent.getStatus();
            if (status == PaymentIntent.Status.Succeeded) {
                Log.e("successfully", "successfully");
                ToastHelper.showToast(mContext, "successfully");

                // Payment completed successfully
//                Gson gson = new GsonBuilder().setPrettyPrinting().create();
//                activity.displayAlert(
//                        "Payment completed",
//                        gson.toJson(paymentIntent),
//                        true
//                );
            } else if (status == PaymentIntent.Status.RequiresPaymentMethod) {
                Log.e("failed", "failed");
                ToastHelper.showToast(mContext, "failed");

//                activity.displayAlert(
//                        "Payment failed",
//                        Objects.requireNonNull(paymentIntent.getLastPaymentError()).getMessage(),
//                        false
//                );
            }
        }

        @Override
        public void onError(@NonNull Exception e) {
            final PaymentActivity activity = activityRef.get();
            if (activity == null) {
                return;
            }
            Log.e("Error", "" + e.toString());
            ToastHelper.showToast(mContext, "" + e.toString());

            // Payment request failed – allow retrying using the same payment method
            //activity.displayAlert("Error", e.toString(), false);
        }
    }


}
