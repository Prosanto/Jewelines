package com.Jewelines.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.Jewelines.app.R;

public class AbouttusFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_aboutus, container, false);
        viewWebView(view);
        return view;
    }

    private void viewWebView(View view) {

    }
}
