package com.Jewelines.app.formfragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.Jewelines.app.R;
import com.Jewelines.app.adapter.LosshistoryAdapter;
import com.Jewelines.app.utils.AppConstant;
import com.Jewelines.app.utils.StringUtility;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LossHistoryFragment extends Fragment implements Step, BlockingStep {
    private View view;
    List<String> lossList = new ArrayList<String>();
    private Button btn_addnew;
    private LosshistoryAdapter adapter;
    private ListView loss_listview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_form_loss_history, container, false);
        viewWebView(view);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        btn_addnew = view.findViewById(R.id.btn_addnew);
        loss_listview=view.findViewById(R.id.loss_listview);

        btn_addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
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


    private void showCustomDialog() {
        // String downloadFileSize= FileUtils.getFileSize(downloadUrl);
        ViewGroup viewGroup = view.findViewById(android.R.id.content);
        final View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.add_loshistory, viewGroup, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.create();
        Button btn_cancel = (Button) dialogView.findViewById(R.id.btn_cancel);
        Button btn_apply = (Button) dialogView.findViewById(R.id.btn_apply);
        final EditText edt_datofloss = (EditText) dialogView.findViewById(R.id.edt_datofloss);
        final EditText edt_type = (EditText) dialogView.findViewById(R.id.edt_type);
        final EditText edt_description = (EditText) dialogView.findViewById(R.id.edt_description);
        final EditText edt_amount = (EditText) dialogView.findViewById(R.id.edt_amount);


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialog.dismiss();
            }
        });
        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lossList.add(edt_datofloss.getText().toString()+";"+edt_type.getText().toString()
                +";"+edt_description.getText().toString()+";"+edt_amount.getText().toString()+" ");
                alertDialog.dismiss();

                adapter = new LosshistoryAdapter(getActivity(), R.layout.row_losshistory, lossList);
                loss_listview.setAdapter(adapter);


            }
        });
        alertDialog.show();
    }

    private void saveData() {
        AppConstant.loss_historydate.clear();

        for (int i = 0; i < lossList.size(); i++) {

            Log.i("Test", Arrays.toString(lossList.toArray()));
            Log.i("Test", "" + StringUtility.getFirst(lossList.get(i),","));
            AppConstant.loss_historydate.add(StringUtility.getFirst(lossList.get(i),","));

        }


    }
}
