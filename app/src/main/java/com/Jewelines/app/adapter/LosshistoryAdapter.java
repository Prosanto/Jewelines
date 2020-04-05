package com.Jewelines.app.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.Jewelines.app.R;
import com.Jewelines.app.utils.AppConstant;
import com.Jewelines.app.utils.StringUtility;

import java.util.List;

public class LosshistoryAdapter extends ArrayAdapter<String> {
    List<String> arrayList;
    Context context;

    public LosshistoryAdapter(Context context, int textViewResourceId, List<String> arrayList) {
        super(context, textViewResourceId, arrayList);
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    //        @Override
//        public String getItem(int position) {
//            return position;
//        }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String subjectData = arrayList.get(position);
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.row_losshistory, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });

            TextView date_of_loss = convertView.findViewById(R.id.date_of_loss);
            TextView txt_type = convertView.findViewById(R.id.txt_type);
            TextView txt_description = convertView.findViewById(R.id.txt_description);
            TextView txt_amount = convertView.findViewById(R.id.txt_amount);

            date_of_loss.setText("" + StringUtility.getFirst(subjectData,";"));
            txt_type.setText("" + StringUtility.getSecond(subjectData,";"));
            txt_description.setText("" + StringUtility.getThird(subjectData,";"));
            txt_amount.setText("" + StringUtility.getFourth(subjectData,";"));




        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }




}
