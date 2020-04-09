package com.Jewelines.app;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.Jewelines.app.mailsend.GMailSender;

import java.util.HashMap;

public class QuoteValueActivity extends AppCompatActivity {
    private static final String TAG = QuoteValueActivity.class.getSimpleName();
    private Context mContext;
    private LinearLayout layoutBack;
    private HashMap<String, String> allZipcodeArray = new HashMap<>();
    private String zipcode = "";
    private String value = "";
    private String jewelryType = "";
    private TextView textQuotevalue;
    private TextView textCompareQuotevalue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotevalue);
        zipcode = getIntent().getStringExtra("zipcode");
        value = getIntent().getStringExtra("value");
        jewelryType = getIntent().getStringExtra("jewelryType");
        mContext = this;
        initUi();
    }

    private void initUi() {
        allZipcodeArray.clear();
        allZipcodeArray.put("11223", "11223");
        allZipcodeArray.put("11224", "11224");
        allZipcodeArray.put("11229", "11229");
        allZipcodeArray.put("11235", "11235");
        allZipcodeArray.put("11201", "11201");
        allZipcodeArray.put("11205", "11205");
        allZipcodeArray.put("11215", "11215");
        allZipcodeArray.put("11217", "11217");
        allZipcodeArray.put("11231", "11231");

        layoutBack = (LinearLayout) this.findViewById(R.id.layoutBack);
        layoutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textQuotevalue = (TextView) this.findViewById(R.id.textQuotevalue);
        textCompareQuotevalue = (TextView) this.findViewById(R.id.textCompareQuotevalue);

        findViewById(R.id.layoutSendQuote).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogSendQuote();
            }
        });
        validation();

    }

    public void showDialogSendQuote() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View mView = inflater.inflate(R.layout.dialog_sendemail, null);
        builder.setView(mView);
        builder.setCancelable(true);
        final AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        alertDialog.show();
        final EditText editFname = (EditText) mView.findViewById(R.id.editFname);
        final EditText editLname = (EditText) mView.findViewById(R.id.editLname);
        final EditText editemailaddress = (EditText) mView.findViewById(R.id.editemailaddress);
        final TextView btn_Cancel = (TextView) mView.findViewById(R.id.btn_Cancel);
        final TextView btn_done = (TextView) mView.findViewById(R.id.btn_done);
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        });
        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                try {
                    showDialogSendQuote();

                    GMailSender sender = new GMailSender("prosanto.mbstue@gmail.com", "zxcvbnm12345678");
                    sender.sendMail("This is Subject",
                            "This is Body",
                            editemailaddress.getText().toString().trim(),
                            "");
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }

            }
        });
    }

    public void validation() {
        float quoteValue = 0;
        if (allZipcodeArray.containsKey(zipcode)) {
            quoteValue = (float) ((Double.parseDouble(value) * 1.3));
            quoteValue=quoteValue/100;
        } else {
            quoteValue = (float) ((Double.parseDouble(value) * 1.4));
            quoteValue=quoteValue/100;

        }
        float quoteCompaireValue = (float) ((Double.parseDouble(value) * 2));
        quoteCompaireValue=quoteCompaireValue/100;

        int quoteValueInterger = (int) quoteValue;
        int quoteCompaireValueInterger = (int) quoteCompaireValue;

        textQuotevalue.setText("$" + quoteValueInterger);
        textCompareQuotevalue.setText("$" + quoteCompaireValueInterger);
    }


}
