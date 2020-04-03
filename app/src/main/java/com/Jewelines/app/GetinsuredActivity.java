package com.Jewelines.app;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.Jewelines.app.formfragment.ApplicantInformationFragment;
import com.Jewelines.app.formfragment.CoastalLocationsFragment;
import com.Jewelines.app.formfragment.GeneralInformationFragment;
import com.Jewelines.app.formfragment.LocationInformationFragment;
import com.Jewelines.app.formfragment.LossHistoryFragment;
import com.Jewelines.app.mailsend.GMailSender;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

import java.util.HashMap;

public class GetinsuredActivity extends AppCompatActivity {
    private static final String TAG = GetinsuredActivity.class.getSimpleName();
    private Context mContext;
    private LinearLayout layoutBack;
    private StepperLayout mStepperLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getinsured);
        mContext = this;
        initUi();
    }

    private void initUi() {
        mStepperLayout = (StepperLayout) this.findViewById(R.id.stepperLayout);
        mStepperLayout.setAdapter(new FormAdapter(getSupportFragmentManager(), this));

    }

    //==For  Musica machin
    public class FormAdapter extends AbstractFragmentStepAdapter {
        private static final String CURRENT_STEP_POSITION_KEY = "position";

        public FormAdapter(FragmentManager fm, Context context) {
            super(fm, context);
        }

        @Override
        public Step createStep(int position) {
            Bundle b = new Bundle();
            b.putInt(CURRENT_STEP_POSITION_KEY, position);

            switch (position) {
                case 0:
                    ApplicantInformationFragment stepperOne = new ApplicantInformationFragment();
                    return stepperOne;

                case 1:
                    LocationInformationFragment stepperTwo = new LocationInformationFragment();
                    return stepperTwo;

                case 2:
                    CoastalLocationsFragment steppeThree = new CoastalLocationsFragment();
                    return steppeThree;

                case 3:
                    LossHistoryFragment stepperFour = new LossHistoryFragment();
                    return stepperFour;

                case 4:
                    GeneralInformationFragment stepperfive = new GeneralInformationFragment();
                    return stepperfive;


            }

            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Nullable
        @Override
        public StepViewModel getViewModel(@IntRange(from = 0) int position) {

            StepViewModel.Builder builder = new StepViewModel.Builder(context);
            switch (position) {

                case 0:
                    builder.setTitle("Step 1"); //can be a CharSequence instead break;
                    builder.setSubtitle("Applicant Information");
                    break;
                case 1:
                    builder.setTitle("Step 2");
                    builder.setSubtitle("Location Information");
                    break;

                case 2:
                    builder.setTitle("Step 3");
                    builder.setSubtitle("Coastal Locations");
                    break;

                case 3:
                    builder.setTitle("Step 4");
                    builder.setSubtitle("Loss History");
                    break;

                case 4:
                    builder.setTitle("Step 5");
                    builder.setSubtitle("General Information");
                    break;


                default:
                    throw new IllegalArgumentException("Unsupported position: " + position);
            }
            return builder.create();

        }
    }


}
