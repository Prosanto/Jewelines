package com.Jewelines.app.formfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.Jewelines.app.R;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

public class GeneralInformationFragment extends Fragment  implements Step, BlockingStep, CompoundButton.OnCheckedChangeListener {
    private View view;
    private String checkStrin1="";
    private CheckBox chk_yes_1;
    private CheckBox chk_yes_2;
    private CheckBox chk_yes_3;
    private CheckBox chk_yes_4;
    private CheckBox chk_yes_5;
    private CheckBox chk_yes_6;
    private CheckBox chk_yes_7;
    private CheckBox chk_yes_8;
    private CheckBox chk_yes_9;
    private CheckBox chk_yes_10;

    private CheckBox chk_no_1;
    private CheckBox chk_no_2;
    private CheckBox chk_no_3;
    private CheckBox chk_no_4;
    private CheckBox chk_no_5;
    private CheckBox chk_no_6;
    private CheckBox chk_no_7;
    private CheckBox chk_no_8;
    private CheckBox chk_no_9;
    private CheckBox chk_no_10;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_form_general_information, container, false);
        viewWebView(view);
        initUI(view);
        return view;
    }
    private void initUI(View view){
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
//        checkBoxOnclick();

    }
    private void viewWebView(View view) {

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        callback.goToNextStep();
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


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.chk_yes_1:
                if(chk_yes_1.isChecked()){
                    chk_no_1.setChecked(false);
                    checkStrin1="Yes";
                    Log.i("Test",checkStrin1);
                }
                break;
            case R.id.chk_no_1:
                if(chk_no_1.isChecked()){
                    chk_yes_1.setChecked(false);
                    checkStrin1="NO";
                    Log.i("Test",checkStrin1);
                }
                break;
            case R.id.chk_yes_2:
                if(chk_yes_2.isChecked()){
                    chk_no_2.setChecked(false);
                    checkStrin1="Yes";
                    Log.i("Test",checkStrin1);
                }
                break;
            case R.id.chk_no_2:
                if(chk_no_2.isChecked()){
                    chk_yes_2.setChecked(false);
                    checkStrin1="NO";
                    Log.i("Test",checkStrin1);
                }
                break;
            case R.id.chk_yes_3:
                if(chk_yes_3.isChecked()){
                    chk_no_3.setChecked(false);
                    checkStrin1="Yes";
                    Log.i("Test",checkStrin1);
                }
                break;
            case R.id.chk_no_3:
                if(chk_no_3.isChecked()){
                    chk_yes_3.setChecked(false);
                    checkStrin1="NO";
                    Log.i("Test",checkStrin1);
                }
                break;


            case R.id.chk_yes_4:
                if(chk_yes_4.isChecked()){
                    chk_no_4.setChecked(false);
                    checkStrin1="Yes";
                    Log.i("Test",checkStrin1);
                }
                break;
            case R.id.chk_no_4:
                if(chk_no_4.isChecked()){
                    chk_yes_4.setChecked(false);
                    checkStrin1="NO";
                    Log.i("Test",checkStrin1);
                }
                break;

            case R.id.chk_yes_5:
                if(chk_yes_5.isChecked()){
                    chk_no_5.setChecked(false);
                    checkStrin1="Yes";
                    Log.i("Test",checkStrin1);
                }
                break;
            case R.id.chk_no_5:
                if(chk_no_5.isChecked()){
                    chk_yes_5.setChecked(false);
                    checkStrin1="NO";
                    Log.i("Test",checkStrin1);
                }
                break;
        }
    }
}
