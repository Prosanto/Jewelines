package com.Jewelines.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.Jewelines.app.HomeActivity;
import com.Jewelines.app.QuoteValueActivity;
import com.Jewelines.app.R;
import com.Jewelines.app.SplashActivity;
import com.Jewelines.app.utils.ToastHelper;

public class QuoteFragment extends Fragment {
    private View view;
    private LinearLayout layoutShowmyQuote;
    private EditText edittextZipcode;
    private EditText edittextValue;
    private Spinner spinnerSelectType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_quote, container, false);
        viewWebView(view);
        return view;
    }

    private void viewWebView(View view) {
        layoutShowmyQuote = (LinearLayout) view.findViewById(R.id.layoutShowmyQuote);
        edittextZipcode = (EditText) view.findViewById(R.id.edittextZipcode);
        edittextValue = (EditText) view.findViewById(R.id.edittextValue);
        spinnerSelectType = (Spinner) view.findViewById(R.id.spinnerSelectType);
        layoutShowmyQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Validation();
            }
        });
    }

    public void Validation() {
        String zipcode = edittextZipcode.getText().toString().trim();
        String value = edittextValue.getText().toString().trim();
        int selected = spinnerSelectType.getSelectedItemPosition();
        if (zipcode.equalsIgnoreCase("")) {
            ToastHelper.showToast(getActivity(), "Enter Zipcode");
            return;
        } else if (value.equalsIgnoreCase("")) {
            ToastHelper.showToast(getActivity(), "Enter Value");
            return;
        } else if (selected == 0) {
            ToastHelper.showToast(getActivity(), "Select Jewelry Type");
            return;
        } else {

            String[] arraly = getResources().getStringArray(R.array.array_name);
            String jewelryType = arraly[selected];
            Intent mm = new Intent(getActivity(), QuoteValueActivity.class);
            mm.putExtra("zipcode",zipcode);
            mm.putExtra("value",value);
            mm.putExtra("jewelryType",jewelryType);
            startActivity(mm);
        }

    }
}
