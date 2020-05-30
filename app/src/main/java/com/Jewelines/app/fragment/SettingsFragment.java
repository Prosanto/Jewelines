package com.Jewelines.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.Jewelines.app.R;
import com.Jewelines.app.utils.PersistentUser;
import com.Jewelines.app.utils.ToastHelper;

public class SettingsFragment extends Fragment {
    private View view;
    private LinearLayout layoutSave;
    private EditText edit_QuoteRate;
    private EditText edit_QuoteRate_Outside;
    private EditText edit_CompairQuoteRate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings, container, false);
        viewWebView(view);
        return view;
    }

    private void viewWebView(View view) {
        layoutSave = (LinearLayout) view.findViewById(R.id.layoutSave);
        edit_QuoteRate = (EditText) view.findViewById(R.id.edit_QuoteRate);
        edit_QuoteRate_Outside = (EditText) view.findViewById(R.id.edit_QuoteRate_Outside);
        edit_CompairQuoteRate = (EditText) view.findViewById(R.id.edit_CompairQuoteRate);
        edit_QuoteRate.setText(PersistentUser.getQuoteRate(getActivity()));
        edit_QuoteRate_Outside.setText(PersistentUser.getWihtiutZipQuoteRate(getActivity()));
        edit_CompairQuoteRate.setText(PersistentUser.getCompairQuoteRate(getActivity()));
        layoutSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validationQuote();
            }
        });

    }

    public void validationQuote() {
        String QuoteRate = edit_QuoteRate.getText().toString().trim();
        String OutSieQuoteRate = edit_QuoteRate_Outside.getText().toString().trim();
        String CompairQuoteRate = edit_CompairQuoteRate.getText().toString().trim();
        if (QuoteRate.equalsIgnoreCase("")) {
            edit_QuoteRate.setError("Enter Quote Rate Into ZipCode");
            return;
        } else if (OutSieQuoteRate.equalsIgnoreCase("")) {
            edit_QuoteRate_Outside.setError("Enter Quote Rate Outside ZipCode");
            return;
        } else if (CompairQuoteRate.equalsIgnoreCase("")) {
            edit_CompairQuoteRate.setError("Enter Compair Quote Rate");
            return;
        } else {
            PersistentUser.setQuoteRate(getActivity(),QuoteRate);
            PersistentUser.setWihtiutZipQuoteRate(getActivity(),OutSieQuoteRate);
            PersistentUser.setCompairQuoteRate(getActivity(),CompairQuoteRate);
            ToastHelper.showToast(getActivity(),"Quote Rate Update Successfully");

        }

    }
}
