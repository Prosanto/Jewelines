package com.Jewelines.app.formfragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ApplicantInformationFragment extends Fragment implements Step, BlockingStep, View.OnClickListener , AdapterView.OnItemSelectedListener {
    private View view;
    final Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;
    private String married_status="";
    List<String> spnList = new ArrayList<String>();
    private EditText edt_app_firstname;
    private EditText edt_app_lastname;
    private EditText edt_coapp_firstname;
    private EditText edt_coapp_lastname;
    private EditText edt_dob;
    private EditText edt_address;
    private EditText edt_city;
    private EditText edt_state;
    private EditText edt_zip;
    private EditText edt_email;
    private EditText edt_app_occupation;
    private EditText edt_employuer_street;
    private EditText edt_employuer_city;
    private EditText edt_employuer_state;
    private EditText edt_employuer_zip;
    private EditText edt_years_with_current;
    private EditText edt_years_with_prior;
    private Spinner spinner_married;
    private EditText edt_dob_final;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_form_application_information, container, false);
        viewWebView(view);
        initUI(view);
        return view;
    }


    private void initUI(View view){

        edt_app_firstname=view.findViewById(R.id.edt_app_firstname);
        edt_app_lastname=view.findViewById(R.id.edt_app_lastname);
        edt_coapp_firstname=view.findViewById(R.id.edt_coapp_firstname);
        edt_coapp_lastname=view.findViewById(R.id.edt_coapp_lastname);
        edt_dob=view.findViewById(R.id.edt_dob);
        edt_address=view.findViewById(R.id.edt_address);
        edt_city=view.findViewById(R.id.edt_city);
        edt_state=view.findViewById(R.id.edt_state);
        edt_zip=view.findViewById(R.id.edt_zip);
        edt_email=view.findViewById(R.id.edt_email);
        edt_app_occupation=view.findViewById(R.id.edt_app_occupation);
        edt_employuer_street=view.findViewById(R.id.edt_employuer_street);
        edt_employuer_city=view.findViewById(R.id.edt_employuer_city);
        edt_employuer_state=view.findViewById(R.id.edt_employuer_state);
        edt_employuer_zip=view.findViewById(R.id.edt_employuer_zip);
        edt_years_with_current=view.findViewById(R.id.edt_years_with_current);
        edt_years_with_prior=view.findViewById(R.id.edt_years_with_prior);
        spinner_married=view.findViewById(R.id.spinner_married);
        edt_dob_final=view.findViewById(R.id.edt_dob_final);
        spnList.add("MARRIED");
        spnList.add("UNMARRIED");
        edt_dob.setOnClickListener(this);
        edt_dob_final.setOnClickListener(this);

        ArrayAdapter dataAdapter = new ArrayAdapter(getActivity(), R.layout.spinner_item, spnList);
        dataAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner_married.setAdapter(dataAdapter);
        spinner_married.setOnItemSelectedListener(this);

    }
    private void viewWebView(View view) {

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        callback.goToNextStep();
        saveData();

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


    private void datePick(final EditText ed) {
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                ed.setText(updateLabel());
            }

        };



    }

    public void onClick(View v) {

        switch(v.getId()){

            case R.id.edt_dob:

                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                datePick(edt_dob);
                break;

            case R.id.edt_dob_final:

                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                datePick(edt_dob_final);
                break;
        }
    }
    private String updateLabel() {
        String myFormat = "d MMM yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        return ""+sdf.format(myCalendar.getTime());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        switch (parent.getId()) {
            case R.id.spinner_married:
                spinner_married.clearFocus();
                married_status = spinner_married.getSelectedItem().toString();
                break;


        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void saveData(){
        AppConstant.appInfo.clear();
        AppConstant.appInfo.add("Applicant’s First Name"+";"+edt_app_firstname.getText().toString());
        AppConstant.appInfo.add("Applicant’s Last Name"+";"+edt_app_lastname.getText().toString());
        AppConstant.appInfo.add("Co-Applicant First Name"+";"+edt_coapp_firstname.getText().toString());
        AppConstant.appInfo.add("Co-Applicant Last Name"+";"+edt_coapp_lastname.getText().toString());
        AppConstant.appInfo.add("Date of birth"+";"+edt_dob.getText().toString());
        AppConstant.appInfo.add("Mailing Address"+";"+edt_address.getText().toString()+" , "+
                edt_city.getText().toString()+" , "+
                edt_state.getText().toString()+" , "+
                edt_zip.getText().toString());

        AppConstant.appInfo.add("Email Address"+";"+edt_email.getText().toString());
        AppConstant.appInfo.add("Applicant(s) occupation – state nature of business if self-employed or retired"+";"+edt_app_occupation.getText().toString());
        AppConstant.appInfo.add("Applicant(s) employer address"+";"+edt_employuer_street.getText().toString()+" , "+
                edt_employuer_city.getText().toString()+" , "+
                edt_employuer_state.getText().toString()+" , "+
                edt_employuer_zip.getText().toString());

        AppConstant.appInfo.add("Years with current employer"+";"+edt_years_with_current.getText().toString());
        AppConstant.appInfo.add("Years with prior employer"+";"+edt_years_with_prior.getText().toString());
        AppConstant.appInfo.add("Marital status"+";"+married_status);
        AppConstant.appInfo.add("Date of birth"+";"+edt_dob_final.getText().toString());
    }


}
