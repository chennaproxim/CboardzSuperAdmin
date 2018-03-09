package com.cboadz.app.cboardzsuperadmin.Employees.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cboadz.app.cboardzsuperadmin.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */

public class LeaveBalance extends Fragment {

    private PieChart pieChart;
    private TextView leave_count,leave_heading;

    public LeaveBalance() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_leave_balance, container, false);

        pieChart = (PieChart) view.findViewById(R.id.piechart);
        leave_count = (TextView) view.findViewById(R.id.leave_count);
        leave_heading = (TextView) view.findViewById(R.id.leave_heading);
        pieChart.setDrawSliceText(false);
        pieChart.setDescription("");
//        pieChart.setDrawHoleEnabled(false);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(12, 0));
        entries.add(new Entry(5, 1));
        entries.add(new Entry(7, 2));
        entries.add(new Entry(10, 3));

        final PieDataSet dataset = new PieDataSet(entries, "");
        dataset.setSliceSpace(3f);
        dataset.setSelectionShift(5f);

        final ArrayList labels = new ArrayList<>();

        labels.add("Casual");
        labels.add("Bereavement");
        labels.add("Sick");
        labels.add("Work from home");

        final PieData data = new PieData(labels, dataset);
//                dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        dataset.setValueTextSize(8f);
        //set Text color on the graph
        data.setValueTextColor(Color.WHITE);

        final int[] MY_COLORS = {Color.rgb(35, 172, 240), Color.rgb(155, 70, 235), Color.rgb(218, 181, 60), Color.rgb(255, 69, 0)};
        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : MY_COLORS) colors.add(c);

        dataset.setColors(colors);

        pieChart.setData(data);
        pieChart.animateXY(0, 0);

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {

                if (e.getXIndex() == 0){
                    leave_count.setText("12");
                    leave_heading.setText("Casual");
                }else if (e.getXIndex() == 1){
                    leave_count.setText("5");
                    leave_heading.setText("Bereavement");
                }else if (e.getXIndex() == 2){
                    leave_count.setText("7");
                    leave_heading.setText("Sick");
                }else if (e.getXIndex() == 3){
                    leave_count.setText("10");
                    leave_heading.setText("Work from home");
                }

            }

            @Override
            public void onNothingSelected() {

            }
        });

        return  view;
    }

}
