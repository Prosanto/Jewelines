package com.Jewelines.app.formfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

import java.util.ArrayList;
import java.util.List;

public class CoastalLocationsFragment extends Fragment  implements Step, BlockingStep , AdapterView.OnItemSelectedListener{
    private View view;
    List<String> spnList1 = new ArrayList<String>();
    List<String> spnList2 = new ArrayList<String>();
    private  String spinnerValue1="";
    private  String spinnerValue2="";
    private Spinner spn_builtin_type1;
    private Spinner spn_builtin_type2;
    private EditText edn_domesticem_type1;
    private EditText edn_domesticem_type2;
    private EditText edn_renovation_type1;
    private EditText edn_renovation_type2;
    private EditText edn_coastelwater_type1;
    private EditText edn_coastelwater_type2;
    private EditText edn_shutter_type1;
    private EditText edn_shutter_type2;
    private EditText edn_proximity_type1;
    private EditText edn_proximity_type2;
    private EditText edn_elevation_type1;
    private EditText edn_elevation_type2;
    private EditText edn_brusharea_type1;
    private EditText edn_brusharea_type2;
    private EditText edn_brushclearence_type1;
    private EditText edn_brushclearence_type2;
    private EditText edn_travelyear_type1;
    private EditText edn_travelyear_type2;
    private EditText edn_longduration;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_form_coastal_location, container, false);
        viewWebView(view);
        initUI(view);
        return view;
    }
 private void initUI(View view){
     spn_builtin_type1=view.findViewById(R.id.spn_builtin_type1);
     spn_builtin_type2=view.findViewById(R.id.spn_builtin_type2);
     edn_domesticem_type1=view.findViewById(R.id.edn_domesticem_type1);
     edn_domesticem_type2=view.findViewById(R.id.edn_domesticem_type2);
     edn_renovation_type1=view.findViewById(R.id.edn_renovation_type1);
     edn_renovation_type2=view.findViewById(R.id.edn_renovation_type2);
     edn_coastelwater_type1=view.findViewById(R.id.edn_coastelwater_type1);
     edn_coastelwater_type2=view.findViewById(R.id.edn_coastelwater_type2);
     edn_shutter_type1=view.findViewById(R.id.edn_shutter_type1);
     edn_shutter_type2=view.findViewById(R.id.edn_shutter_type2);
     edn_proximity_type1=view.findViewById(R.id.edn_proximity_type1);
     edn_proximity_type2=view.findViewById(R.id.edn_proximity_type2);
     edn_elevation_type1=view.findViewById(R.id.edn_elevation_type1);
     edn_elevation_type2=view.findViewById(R.id.edn_elevation_type2);
     edn_brusharea_type1=view.findViewById(R.id.edn_brusharea_type1);
     edn_brusharea_type2=view.findViewById(R.id.edn_brusharea_type2);
     edn_brushclearence_type1=view.findViewById(R.id.edn_brushclearence_type1);
     edn_brushclearence_type2=view.findViewById(R.id.edn_brushclearence_type2);
     edn_travelyear_type1=view.findViewById(R.id.edn_travelyear_type1);
     edn_travelyear_type2=view.findViewById(R.id.edn_travelyear_type2);
     edn_longduration=view.findViewById(R.id.edn_longduration);


     spnList1.add("safe");
     spnList1.add("vault");

     spnList2.add("safe");
     spnList2.add("vault");

     ArrayAdapter dataAdapter = new ArrayAdapter(getActivity(), R.layout.spinner_item, spnList1);
     dataAdapter.setDropDownViewResource(R.layout.spinner_item);
     spn_builtin_type1.setAdapter(dataAdapter);
     spn_builtin_type1.setOnItemSelectedListener(this);

     ArrayAdapter dataAdapter1 = new ArrayAdapter(getActivity(), R.layout.spinner_item, spnList2);
     dataAdapter.setDropDownViewResource(R.layout.spinner_item);
     spn_builtin_type2.setAdapter(dataAdapter1);
     spn_builtin_type2.setOnItemSelectedListener(this);


 }
    private void viewWebView(View view) {

    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        callback.goToNextStep();
        saveData();
//        CreatePdf.createDocument();

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
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        switch (parent.getId()) {
            case R.id.spn_builtin_type1:
                spn_builtin_type1.clearFocus();
                spinnerValue1 = spn_builtin_type1.getSelectedItem().toString();
                break;
            case R.id.spn_builtin_type2:
                spn_builtin_type1.clearFocus();
                spinnerValue2 = spn_builtin_type2.getSelectedItem().toString();
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void saveData(){
        AppConstant.coastal_location.clear();

        AppConstant.coastal_location.add("Built-in safe/vault?"+";"+
                spinnerValue1+";"+spinnerValue1);
        AppConstant.coastal_location.add("Domestic employees?(duties, age, length of service)"+";"+
                edn_domesticem_type1.getText().toString()+";"+edn_domesticem_type2.getText().toString());
        AppConstant.coastal_location.add("Is building undergoing renvovations?"+";"+
                edn_renovation_type1.getText().toString()+";"+edn_renovation_type2.getText().toString());
        AppConstant.coastal_location.add("Is location within 2.5 miles of coastal waters? If yes, answer the following questions."+";"+
                edn_coastelwater_type1.getText().toString()+";"+edn_coastelwater_type2.getText().toString());
        AppConstant.coastal_location.add("Do all exterior openings have storm shutters?"+";"+
                edn_shutter_type1.getText().toString()+";"+edn_shutter_type2.getText().toString());
        AppConstant.coastal_location.add("Proximity to water"+";"+
                edn_proximity_type1.getText().toString()+";"+edn_proximity_type2.getText().toString());
        AppConstant.coastal_location.add("Property elevation"+";"+
                edn_elevation_type1.getText().toString()+";"+edn_elevation_type2.getText().toString());
        AppConstant.coastal_location.add("Is location within 250 ft. of a designated brush area? If yes, provide the following info"+";"+
                edn_brusharea_type1.getText().toString()+";"+edn_brusharea_type2.getText().toString());
        AppConstant.coastal_location.add("Brush clearance (all sides)"+";"+
                edn_brushclearence_type1.getText().toString()+";"+edn_brushclearence_type2.getText().toString());
        AppConstant.coastal_location.add("How many times do you travel per year?"+";"+
                edn_travelyear_type1.getText().toString()+";"+edn_travelyear_type2.getText().toString());
        AppConstant.coastal_location.add("Longest duration (# of days)"+";"+
                edn_longduration.getText().toString()+";"+"  ");
    }
}
