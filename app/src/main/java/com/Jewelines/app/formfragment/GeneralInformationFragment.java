package com.Jewelines.app.formfragment;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class GeneralInformationFragment extends Fragment implements Step, BlockingStep,View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private View view;
    private String checkStrin1, checkStrin2, checkStrin3, checkStrin4, checkStrin5, checkStrin6, checkStrin7, checkStrin8, checkStrin9, checkStrin10, checkStrin11;
    private CheckBox chk_yes_1, chk_yes_2, chk_yes_3, chk_yes_4, chk_yes_5, chk_yes_6, chk_yes_7,
            chk_yes_8, chk_yes_9, chk_yes_10, chk_yes_11;

    private CheckBox chk_no_1, chk_no_2, chk_no_3, chk_no_4, chk_no_5, chk_no_6, chk_no_7,
            chk_no_8, chk_no_9, chk_no_10, chk_no_11;

    private EditText edt_current_jewel, edt_camount_cover,
            edt_exp_date, edt_current_homeowner;
    final private int REQUEST_CODE_ASK_PERMISSIONS_STORGE = 100;
    private List<String> permissions = new ArrayList<String>();
    final Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog date;
    private int year, month, day;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_form_general_information, container, false);
        viewWebView(view);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        edt_current_jewel = view.findViewById(R.id.edt_current_jewel);
        edt_camount_cover = view.findViewById(R.id.edt_camount_cover);
        edt_exp_date = view.findViewById(R.id.edt_exp_date);
        edt_current_homeowner = view.findViewById(R.id.edt_current_homeowner);

        chk_yes_1 = view.findViewById(R.id.chk_yes_1);
        chk_yes_2 = view.findViewById(R.id.chk_yes_2);
        chk_yes_3 = view.findViewById(R.id.chk_yes_3);
        chk_yes_4 = view.findViewById(R.id.chk_yes_4);
        chk_yes_5 = view.findViewById(R.id.chk_yes_5);
        chk_yes_6 = view.findViewById(R.id.chk_yes_6);
        chk_yes_7 = view.findViewById(R.id.chk_yes_7);
        chk_yes_8 = view.findViewById(R.id.chk_yes_8);
        chk_yes_9 = view.findViewById(R.id.chk_yes_9);
        chk_yes_10 = view.findViewById(R.id.chk_yes_10);
        chk_yes_11 = view.findViewById(R.id.chk_yes_11);

        chk_no_1 = view.findViewById(R.id.chk_no_1);
        chk_no_2 = view.findViewById(R.id.chk_no_2);
        chk_no_3 = view.findViewById(R.id.chk_no_3);
        chk_no_4 = view.findViewById(R.id.chk_no_4);
        chk_no_5 = view.findViewById(R.id.chk_no_5);
        chk_no_6 = view.findViewById(R.id.chk_no_6);
        chk_no_7 = view.findViewById(R.id.chk_no_7);
        chk_no_8 = view.findViewById(R.id.chk_no_8);
        chk_no_9 = view.findViewById(R.id.chk_no_9);
        chk_no_10 = view.findViewById(R.id.chk_no_10);
        chk_no_11 = view.findViewById(R.id.chk_no_11);
        chk_yes_1.setOnCheckedChangeListener(this);
        chk_no_1.setOnCheckedChangeListener(this);
        chk_yes_2.setOnCheckedChangeListener(this);
        chk_no_2.setOnCheckedChangeListener(this);
        chk_yes_3.setOnCheckedChangeListener(this);
        chk_no_3.setOnCheckedChangeListener(this);
        chk_yes_4.setOnCheckedChangeListener(this);
        chk_no_4.setOnCheckedChangeListener(this);
        chk_yes_5.setOnCheckedChangeListener(this);
        chk_no_5.setOnCheckedChangeListener(this);
        chk_yes_6.setOnCheckedChangeListener(this);
        chk_no_6.setOnCheckedChangeListener(this);
        chk_yes_7.setOnCheckedChangeListener(this);
        chk_no_7.setOnCheckedChangeListener(this);
        chk_yes_8.setOnCheckedChangeListener(this);
        chk_no_8.setOnCheckedChangeListener(this);
        chk_yes_9.setOnCheckedChangeListener(this);
        chk_no_9.setOnCheckedChangeListener(this);
        chk_yes_10.setOnCheckedChangeListener(this);
        chk_no_10.setOnCheckedChangeListener(this);
        chk_yes_11.setOnCheckedChangeListener(this);
        chk_no_11.setOnCheckedChangeListener(this);
        edt_exp_date.setOnClickListener(this);




//        checkBoxOnclick();

    }

    private void viewWebView(View view) {

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        callback.goToNextStep();
        getPermission();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {


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
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.edt_exp_date:
                datePick(edt_exp_date);
                break;


        }
    }
    private void datePick(final EditText ed) {
        final Calendar cq = Calendar.getInstance();
        year = cq.get(Calendar.YEAR);
        month = cq.get(Calendar.MONTH);
        day = cq.get(Calendar.DAY_OF_MONTH);
        date = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        ed.setText(updateLabel());
                    }
                }, year, month, day);
        date.show();

    }
    private String updateLabel() {
        String myFormat = "d MMM yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        return "" + sdf.format(myCalendar.getTime());
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.chk_yes_1:
                if (chk_yes_1.isChecked()) {
                    chk_no_1.setChecked(false);
                    checkStrin1 = "Yes";
                }
                break;
            case R.id.chk_no_1:
                if (chk_no_1.isChecked()) {
                    chk_yes_1.setChecked(false);
                    checkStrin1 = "NO";
                }
                break;
            case R.id.chk_yes_2:
                if (chk_yes_2.isChecked()) {
                    chk_no_2.setChecked(false);
                    checkStrin2 = "Yes";
                }
                break;
            case R.id.chk_no_2:
                if (chk_no_2.isChecked()) {
                    chk_yes_2.setChecked(false);
                    checkStrin2 = "NO";
                }
                break;
            case R.id.chk_yes_3:
                if (chk_yes_3.isChecked()) {
                    chk_no_3.setChecked(false);
                    checkStrin3 = "Yes";
                }
                break;
            case R.id.chk_no_3:
                if (chk_no_3.isChecked()) {
                    chk_yes_3.setChecked(false);
                    checkStrin3 = "NO";
                }
                break;


            case R.id.chk_yes_4:
                if (chk_yes_4.isChecked()) {
                    chk_no_4.setChecked(false);
                    checkStrin4 = "Yes";
                }
                break;
            case R.id.chk_no_4:
                if (chk_no_4.isChecked()) {
                    chk_yes_4.setChecked(false);
                    checkStrin4 = "NO";
                }
                break;

            case R.id.chk_yes_5:
                if (chk_yes_5.isChecked()) {
                    chk_no_5.setChecked(false);
                    checkStrin5 = "Yes";
                }
                break;
            case R.id.chk_no_5:
                if (chk_no_5.isChecked()) {
                    chk_yes_5.setChecked(false);
                    checkStrin5 = "NO";
                }
                break;

            case R.id.chk_yes_6:
                if (chk_yes_6.isChecked()) {
                    chk_no_6.setChecked(false);
                    checkStrin6 = "Yes";
                }
                break;
            case R.id.chk_no_6:
                if (chk_no_6.isChecked()) {
                    chk_yes_6.setChecked(false);
                    checkStrin6 = "NO";
                }
                break;

            case R.id.chk_yes_7:
                if (chk_yes_7.isChecked()) {
                    chk_no_7.setChecked(false);
                    checkStrin7 = "Yes";
                }
                break;
            case R.id.chk_no_7:
                if (chk_no_7.isChecked()) {
                    chk_yes_7.setChecked(false);
                    checkStrin7 = "NO";
                }
                break;
            case R.id.chk_yes_8:
                if (chk_yes_8.isChecked()) {
                    chk_no_8.setChecked(false);
                    checkStrin8 = "Yes";
                }
                break;
            case R.id.chk_no_8:
                if (chk_no_8.isChecked()) {
                    chk_yes_8.setChecked(false);
                    checkStrin8 = "NO";
                }
                break;

            case R.id.chk_yes_9:
                if (chk_yes_9.isChecked()) {
                    chk_no_9.setChecked(false);
                    checkStrin9 = "Yes";
                }
                break;
            case R.id.chk_no_9:
                if (chk_no_9.isChecked()) {
                    chk_yes_9.setChecked(false);
                    checkStrin9 = "NO";
                }
                break;
            case R.id.chk_yes_10:
                if (chk_yes_10.isChecked()) {
                    chk_no_10.setChecked(false);
                    checkStrin10 = "Yes";
                }
                break;
            case R.id.chk_no_10:
                if (chk_no_10.isChecked()) {
                    chk_yes_10.setChecked(false);
                    checkStrin10 = "NO";
                }
                break;

            case R.id.chk_yes_11:
                if (chk_yes_11.isChecked()) {
                    chk_no_11.setChecked(false);
                    checkStrin11 = "Yes";
                }
                break;
            case R.id.chk_no_11:
                if (chk_no_11.isChecked()) {
                    chk_yes_11.setChecked(false);
                    checkStrin11 = "NO";
                }
                break;
        }
    }

    private void getPermission(){
        if (Build.VERSION.SDK_INT > 22) {
            String storagePermission = Manifest.permission.WRITE_EXTERNAL_STORAGE;
            int hasstoragePermission = getActivity().checkSelfPermission(storagePermission);
            if (hasstoragePermission != PackageManager.PERMISSION_GRANTED) {
                permissions.add(storagePermission);
            }
            if (!permissions.isEmpty()) {
                String[] params = permissions.toArray(new String[permissions.size()]);
                requestPermissions(params, REQUEST_CODE_ASK_PERMISSIONS_STORGE);
            } else {
                saveData();
                copyAssets();
                //getActivity().finish();

            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS_STORGE:
                if (grantResults.length > 0) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        saveData();
                        copyAssets();

                       // getActivity().finish();
                    } else {
                        //finish();
                    }
                }
                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    private void saveData() {
        AppConstant.general_inifo.clear();

        AppConstant.general_inifo.add("Is the property retroftted for earthquake?" + ";" +
                checkStrin1+" ");
        AppConstant.general_inifo.add("Will any property be exhibited?" + ";" +
                checkStrin2+" ");
        AppConstant.general_inifo.add("Is any property used commercially?" + ";" +
                checkStrin3+" ");
        AppConstant.general_inifo.add("Is any business conducted on the premises?" + ";" +
                checkStrin4+" ");
        AppConstant.general_inifo.add("Has any applicant been convicted of a crime in the last 10 years?" + ";" +
                checkStrin5+" ");
        AppConstant.general_inifo.add("Any coverage declined, cancelled or non-renewed in the last 3 years?(N/A in CA & MO)" + ";" +
                checkStrin6+" ");
        AppConstant.general_inifo.add("Any foreclosure, repossession or bankruptcy in the past 5 years?" + ";" +
                checkStrin7+" ");
        AppConstant.general_inifo.add("Is there a manager on premises?" + ";" +
                checkStrin8+" ");
        AppConstant.general_inifo.add("Is there a security attendant?" + ";" +
                checkStrin9+" ");
        AppConstant.general_inifo.add("Is the building entrance locked?" + ";" +
                checkStrin10+" ");
        AppConstant.general_inifo.add("Appraisals Attached:" + ";" +
                checkStrin11+" ");


        AppConstant.general_inifo.add("Current jewel carrier" + ";" +
                edt_current_jewel.getText().toString()+" ");
        AppConstant.general_inifo.add("Amount of coverage" + ";" +
                edt_camount_cover.getText().toString()+" ");
        AppConstant.general_inifo.add("Exp. Date" + ";" +
                edt_exp_date.getText().toString()+" ");
        AppConstant.general_inifo.add("Current homeowners carrier" + ";" +
                edt_current_homeowner.getText().toString()+" ");




    }

    private void copyAssets() {
        AssetManager assetManager = getActivity().getAssets();
        String[] files = null;
        try {
            files = assetManager.list("");
        } catch (IOException e) {
            Log.e("tag", "Failed to get asset file list.", e);
        }
        if (files != null) for (String filename : files) {
            InputStream in = null;
            OutputStream out = null;
            try {
                in = assetManager.open(filename);
//                File outFile = new File(getActivity().getExternalFilesDir(null), filename);
                String root = Environment.getExternalStorageDirectory().toString();
                File myDir = new File(root + "/Jewelines_pdf");
                myDir.mkdirs();
                String fname = "logo" + ".png";
                File filePDD = new File(myDir, fname);
                out = new FileOutputStream(filePDD);
                copyFile(in, out);
            } catch(IOException e) {
                Log.e("tag", "Failed to copy asset file: " + filename, e);
            }
            finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        // NOOP
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        // NOOP
                    }
                }
            }
        }
    }
    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }
}
