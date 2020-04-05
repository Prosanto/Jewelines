package com.Jewelines.app.formfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.Jewelines.app.R;
import com.Jewelines.app.utils.AppConstant;
import com.Jewelines.app.utils.CreatePdf;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

public class GeneralInformationFragment extends Fragment implements Step, BlockingStep, CompoundButton.OnCheckedChangeListener {
    private View view;
    private String checkStrin1, checkStrin2, checkStrin3, checkStrin4, checkStrin5, checkStrin6, checkStrin7, checkStrin8, checkStrin9, checkStrin10, checkStrin11;
    private CheckBox chk_yes_1, chk_yes_2, chk_yes_3, chk_yes_4, chk_yes_5, chk_yes_6, chk_yes_7,
            chk_yes_8, chk_yes_9, chk_yes_10, chk_yes_11;

    private CheckBox chk_no_1, chk_no_2, chk_no_3, chk_no_4, chk_no_5, chk_no_6, chk_no_7,
            chk_no_8, chk_no_9, chk_no_10, chk_no_11;

    private EditText edt_current_jewel, edt_camount_cover,
            edt_exp_date, edt_current_homeowner, edt_remark;


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
        edt_remark = view.findViewById(R.id.edt_remark);

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

//        checkBoxOnclick();

    }

    private void viewWebView(View view) {

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        callback.goToNextStep();
        saveData();
        CreatePdf.createDocument();
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        saveData();
        CreatePdf.createDocument();
        Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();
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


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.chk_yes_1:
                if (chk_yes_1.isChecked()) {
                    chk_no_1.setChecked(false);
                    checkStrin1 = "Yes";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_no_1:
                if (chk_no_1.isChecked()) {
                    chk_yes_1.setChecked(false);
                    checkStrin1 = "NO";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_yes_2:
                if (chk_yes_2.isChecked()) {
                    chk_no_2.setChecked(false);
                    checkStrin2 = "Yes";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_no_2:
                if (chk_no_2.isChecked()) {
                    chk_yes_2.setChecked(false);
                    checkStrin2 = "NO";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_yes_3:
                if (chk_yes_3.isChecked()) {
                    chk_no_3.setChecked(false);
                    checkStrin3 = "Yes";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_no_3:
                if (chk_no_3.isChecked()) {
                    chk_yes_3.setChecked(false);
                    checkStrin3 = "NO";
                    Log.i("Test", checkStrin1);
                }
                break;


            case R.id.chk_yes_4:
                if (chk_yes_4.isChecked()) {
                    chk_no_4.setChecked(false);
                    checkStrin4 = "Yes";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_no_4:
                if (chk_no_4.isChecked()) {
                    chk_yes_4.setChecked(false);
                    checkStrin4 = "NO";
                    Log.i("Test", checkStrin1);
                }
                break;

            case R.id.chk_yes_5:
                if (chk_yes_5.isChecked()) {
                    chk_no_5.setChecked(false);
                    checkStrin5 = "Yes";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_no_5:
                if (chk_no_5.isChecked()) {
                    chk_yes_5.setChecked(false);
                    checkStrin5 = "NO";
                    Log.i("Test", checkStrin1);
                }
                break;

            case R.id.chk_yes_6:
                if (chk_yes_6.isChecked()) {
                    chk_no_6.setChecked(false);
                    checkStrin6 = "Yes";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_no_6:
                if (chk_no_6.isChecked()) {
                    chk_yes_6.setChecked(false);
                    checkStrin6 = "NO";
                    Log.i("Test", checkStrin1);
                }
                break;

            case R.id.chk_yes_7:
                if (chk_yes_7.isChecked()) {
                    chk_no_7.setChecked(false);
                    checkStrin7 = "Yes";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_no_7:
                if (chk_no_7.isChecked()) {
                    chk_yes_7.setChecked(false);
                    checkStrin7 = "NO";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_yes_8:
                if (chk_yes_8.isChecked()) {
                    chk_no_8.setChecked(false);
                    checkStrin8 = "Yes";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_no_8:
                if (chk_no_8.isChecked()) {
                    chk_yes_8.setChecked(false);
                    checkStrin8 = "NO";
                    Log.i("Test", checkStrin1);
                }
                break;

            case R.id.chk_yes_9:
                if (chk_yes_9.isChecked()) {
                    chk_no_9.setChecked(false);
                    checkStrin9 = "Yes";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_no_9:
                if (chk_no_9.isChecked()) {
                    chk_yes_9.setChecked(false);
                    checkStrin9 = "NO";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_yes_10:
                if (chk_yes_10.isChecked()) {
                    chk_no_10.setChecked(false);
                    checkStrin10 = "Yes";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_no_10:
                if (chk_no_10.isChecked()) {
                    chk_yes_10.setChecked(false);
                    checkStrin10 = "NO";
                    Log.i("Test", checkStrin1);
                }
                break;

            case R.id.chk_yes_11:
                if (chk_yes_11.isChecked()) {
                    chk_no_11.setChecked(false);
                    checkStrin11 = "Yes";
                    Log.i("Test", checkStrin1);
                }
                break;
            case R.id.chk_no_11:
                if (chk_no_11.isChecked()) {
                    chk_yes_11.setChecked(false);
                    checkStrin11 = "NO";
                    Log.i("Test", checkStrin1);
                }
                break;
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
        AppConstant.general_inifo.add("Remarks" + ";" +
                edt_remark.getText().toString()+" ");
    }
}