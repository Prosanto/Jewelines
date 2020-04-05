package com.Jewelines.app.formfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

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

public class LocationInformationFragment extends Fragment  implements Step, BlockingStep {
    private View view;
    private EditText edt_phome_add;
    private EditText edt_phome_city;
    private EditText edt_phome_state;
    private EditText edt_phome_zip;
    private EditText edt_sec_address;
    private EditText edt_sec_city;
    private EditText edt_sec_state;
    private EditText edt_sec_zip;
    private EditText edt_nofy_primary;
    private EditText edt_nofy_prior_primary;
    private EditText edt_const_type1;
    private EditText edt_const_type2;
    private EditText edt_yourbuilt_type1;
    private EditText edt_yourbuilt_type2;
    private EditText edt_sqrft_type1;
    private EditText edt_sqrft_type2;
    private EditText edt_usage_type1;
    private EditText edt_usage_type2;
    private EditText edt_nofstories_type1;
    private EditText edt_nofstories_type2;
    private EditText edt_noffamilies_type1;
    private EditText edt_noffamilies_type2;
    private EditText edt_regproc_type1;
    private EditText edt_regproc_type2;
    private EditText edt_fireproc_type1;
    private EditText edt_fireproc_type2;
    private EditText edt_otherproc_type1;
    private EditText edt_otherproc_type2;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_form_location_information, container, false);
        viewWebView(view);
        initUI(view);
        return view;
    }
    private void initUI(View view){
        edt_phome_add=view.findViewById(R.id.edt_phome_add);
        edt_phome_city=view.findViewById(R.id.edt_phome_city);
        edt_phome_state=view.findViewById(R.id.edt_phome_state);
        edt_phome_zip=view.findViewById(R.id.edt_phome_zip);
        edt_sec_address=view.findViewById(R.id.edt_sec_address);
        edt_sec_city=view.findViewById(R.id.edt_sec_city);
        edt_sec_state=view.findViewById(R.id.edt_sec_state);
        edt_sec_zip=view.findViewById(R.id.edt_sec_zip);
        edt_nofy_primary=view.findViewById(R.id.edt_nofy_primary);
        edt_nofy_prior_primary=view.findViewById(R.id.edt_nofy_prior_primary);
        edt_const_type1=view.findViewById(R.id.edt_const_type1);
        edt_const_type2=view.findViewById(R.id.edt_const_type2);
        edt_yourbuilt_type1=view.findViewById(R.id.edt_yourbuilt_type1);
        edt_yourbuilt_type2=view.findViewById(R.id.edt_yourbuilt_type2);
        edt_sqrft_type1=view.findViewById(R.id.edt_sqrft_type1);
        edt_sqrft_type2=view.findViewById(R.id.edt_sqrft_type2);
        edt_usage_type1=view.findViewById(R.id.edt_usage_type1);
        edt_usage_type2=view.findViewById(R.id.edt_usage_type2);
        edt_nofstories_type1=view.findViewById(R.id.edt_nofstories_type1);
        edt_nofstories_type2=view.findViewById(R.id.edt_nofstories_type2);
        edt_noffamilies_type1=view.findViewById(R.id.edt_noffamilies_type1);
        edt_noffamilies_type2=view.findViewById(R.id.edt_noffamilies_type2);
        edt_regproc_type1=view.findViewById(R.id.edt_regproc_type1);
        edt_regproc_type2=view.findViewById(R.id.edt_regproc_type2);
        edt_fireproc_type1=view.findViewById(R.id.edt_fireproc_type1);
        edt_fireproc_type2=view.findViewById(R.id.edt_fireproc_type2);
        edt_otherproc_type1=view.findViewById(R.id.edt_otherproc_type1);
        edt_otherproc_type2=view.findViewById(R.id.edt_otherproc_type2);





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

    private void saveData(){
        AppConstant.locationInfo_1.clear();
        AppConstant.locationInfo_2.clear();
        AppConstant.locationInfo_1.add("Primary Home Address – if different from above"+";"+
                edt_phome_add.getText().toString()+" , "+edt_phome_city.getText().toString()+" , "+
                edt_phome_state.getText().toString()+" , "+edt_phome_zip.getText().toString()+" ");
        AppConstant.locationInfo_1.add("Secondary Address (if applicable)"+";"+
                edt_sec_address.getText().toString()+" , "+edt_sec_city.getText().toString()+" , "+
                edt_sec_state.getText().toString()+" , "+edt_sec_zip.getText().toString()+" ");
        AppConstant.locationInfo_1.add("Number of years at present primary residence"+";"+
                edt_nofy_primary.getText().toString()+" ");
        AppConstant.locationInfo_1.add("Number of years at prior primary residence"+";"+
                edt_nofy_prior_primary.getText().toString()+" ");
        AppConstant.locationInfo_2.add("Construction Type (Frame, Masonry,Non-Conbustible, Modified Fire Resistive)"+";"+
                edt_const_type1.getText().toString()+";"+edt_const_type2.getText().toString()+" ");
        AppConstant.locationInfo_2.add("Year Built – if home is older than 20yrs.Provide updates to electrical, plumbing HVAC & roof - sq. ft"+";"+
                edt_yourbuilt_type1.getText().toString()+";"+edt_yourbuilt_type2.getText().toString()+" ");
        AppConstant.locationInfo_2.add("Square ft"+";"+
                edt_sqrft_type1.getText().toString()+";"+edt_sqrft_type2.getText().toString()+" ");
        AppConstant.locationInfo_2.add("Usage (primary, secondary, etc.)"+";"+
                edt_usage_type1.getText().toString()+";"+edt_usage_type2.getText().toString()+" ");
        AppConstant.locationInfo_2.add("Number of stories"+";"+
                edt_nofstories_type1.getText().toString()+";"+edt_nofstories_type2.getText().toString()+" ");
        AppConstant.locationInfo_2.add("Number of families"+";"+
                edt_noffamilies_type1.getText().toString()+";"+edt_noffamilies_type2.getText().toString()+" ");
        AppConstant.locationInfo_2.add("Burglar protective devices (monitored, local)"+";"+
                edt_regproc_type1.getText().toString()+";"+edt_regproc_type2.getText().toString()+" ");
        AppConstant.locationInfo_2.add("Fire protective devices(monitored, local)"+";"+
                edt_fireproc_type1.getText().toString()+";"+edt_fireproc_type2.getText().toString()+" ");
        AppConstant.locationInfo_2.add("Other protective devices"+";"+
                edt_otherproc_type1.getText().toString()+";"+edt_otherproc_type2.getText().toString()+" ");
    }

}
