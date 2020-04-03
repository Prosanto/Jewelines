package com.Jewelines.app.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.Jewelines.app.R;

public class ContactusFragment extends Fragment {
    private View view;
    private LinearLayout layoutEmailContact;
    private LinearLayout layoutCallContact;
    private LinearLayout layoutWebsite;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contactus, container, false);
        viewWebView(view);
        return view;
    }

    private void viewWebView(View view) {
        layoutEmailContact = (LinearLayout) view.findViewById(R.id.layoutEmailContact);
        layoutCallContact = (LinearLayout) view.findViewById(R.id.layoutCallContact);
        layoutWebsite = (LinearLayout) view.findViewById(R.id.layoutWebsite);
        layoutEmailContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                    String aEmailList[] = {"jewel@marketscout.com"};
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Contact");
                    emailIntent.setType("plain/text");
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
                    startActivity(emailIntent);
                } catch (Exception ex) {

                }

            }
        });
        layoutCallContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String phone = "972-934-4217";
                    Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.fromParts(
                            "tel", phone, null));
                    startActivity(phoneIntent);
                } catch (Exception e) {
                }

            }
        });

        layoutWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jewelines.com"));
                startActivity(intent);
            }
        });

    }
}
