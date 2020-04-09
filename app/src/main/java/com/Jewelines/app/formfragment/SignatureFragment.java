package com.Jewelines.app.formfragment;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.Jewelines.app.R;
import com.Jewelines.app.utils.AppConstant;
import com.Jewelines.app.utils.CreatePdf;
import com.github.gcacace.signaturepad.views.SignaturePad;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class SignatureFragment extends Fragment implements Step, BlockingStep {
    private View view;


    private SignaturePad signature_applicant;
    private Button btnclear_sig1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_form_signature, container, false);
        viewWebView(view);
        initUI(view);
        return view;
    }

    private void initUI(View view) {

        signature_applicant = view.findViewById(R.id.signature_applicant);
        btnclear_sig1 = view.findViewById(R.id.btnclear_sig1);
        signature_applicant.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {
                Toast.makeText(getActivity(), "OnStartSigning", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSigned() {
            }

            @Override
            public void onClear() {
                btnclear_sig1.setEnabled(false);
            }
        });



        btnclear_sig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signature_applicant.clear();
            }
        });

    }

    private void viewWebView(View view) {

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
//        CreatePdf.createDocument(getActivity());
//        Toast.makeText(getActivity(), "Pdf Saved on Jewelines_pdf", Toast.LENGTH_SHORT).show();

        saveData();
        CreatePdf.createDocument(getActivity());

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        callback.goToPrevStep();
    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    private void saveData() {
        Bitmap signatureBitmap = signature_applicant.getSignatureBitmap();
        if (addJpgSignatureToGallery(signatureBitmap)) {
            Toast.makeText(getActivity(), "Signature saved into the Gallery", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Unable to store the signature", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean addJpgSignatureToGallery(Bitmap signature) {
        boolean result = false;
        try {
            File photo = new File(getAlbumStorageDir(), "Signature_1.jpg");
            saveBitmapToJPG(signature, photo);
//            scanMediaFile(photo);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public File getAlbumStorageDir() {
        // Get the directory for the user's public pictures directory.
        String root = Environment.getExternalStorageDirectory().toString();
        File file = new File(root, "/Jewelines_pdf");
        if (!file.mkdirs()) {
            Log.e("SignaturePad", "Directory not created");
        }
        return file;
    }
    public void saveBitmapToJPG(Bitmap bitmap, File photo) throws IOException {
        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBitmap);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(bitmap, 0, 0, null);
        OutputStream stream = new FileOutputStream(photo);
        newBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
        stream.close();
    }
    private void scanMediaFile(File photo) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri contentUri = Uri.fromFile(photo);
        mediaScanIntent.setData(contentUri);
        getActivity().sendBroadcast(mediaScanIntent);
    }

}
