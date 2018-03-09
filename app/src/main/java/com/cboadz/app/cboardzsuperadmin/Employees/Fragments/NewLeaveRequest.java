package com.cboadz.app.cboardzsuperadmin.Employees.Fragments;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cboadz.app.cboardzsuperadmin.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewLeaveRequest extends Fragment {

    private Calendar mCurrentDate;
    private int day, month, year;
    private ImageView from_date, to_date;
    private TextView from_date_text, to_date_text, leave_name, no_of_leaves;
    private Spinner spinner;
    private EditText leave_reson,leave_approver;
    private String leavereson;
    private DatePickerDialog datepickerdialog;


    public NewLeaveRequest() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_new_leave_request, container, false);
        from_date_text = (TextView) view.findViewById(R.id.from_date_text1);
        to_date_text = (TextView) view.findViewById(R.id.to_date_text1);
        leave_reson = (EditText) view.findViewById(R.id.leave_reson1);
//
        Calendar mcurrentDate = Calendar.getInstance();
        year = mcurrentDate.get(Calendar.YEAR);
        month = mcurrentDate.get(Calendar.MONTH);
        day = mcurrentDate.get(Calendar.DAY_OF_MONTH);

        view.findViewById(R.id.leave_approval_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leavereson = leave_reson.getText().toString();
                if (leavereson.equals("")) {
                    leave_reson.setError("Enter Data");
                    leave_reson.requestFocus();
                } else {
                    Toast.makeText(getActivity(), "Leave request Sent", Toast.LENGTH_LONG).show();
                }
            }
        });

        from_date = (ImageView) view.findViewById(R.id.from_date1);
        to_date = (ImageView) view.findViewById(R.id.to_date1);

        view.findViewById(R.id.linear_from_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar mcurrentDate = Calendar.getInstance();
                year = mcurrentDate.get(Calendar.YEAR);
                month = mcurrentDate.get(Calendar.MONTH);
                day = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                datepickerdialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
//                        from_date_text.setText(new StringBuilder().append(year).append("-").append(month + 1).append("-").append(day));
                        int month_k = selectedmonth + 1;
                        ArrayList<String> fulldate = new ArrayList<String>();
                        String[] months = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "July"
                                , "Aug", "Sep", "Oct", "Nov", "Dec"};

                        fulldate.add(String.valueOf(selectedday));
                        fulldate.add(months[month_k]);
                        fulldate.add(String.valueOf(selectedyear));

                        from_date_text.setText(fulldate.get(0) + " " + fulldate.get(1) + " " + fulldate.get(2));

                    }
                }, year, month, day);
                // TODO Hide Past Date Here
                datepickerdialog.getDatePicker().setMinDate(System.currentTimeMillis());

                // TODO Hide Future Date Here
                //  mDatePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
                datepickerdialog.show();
            }
        });

        view.findViewById(R.id.linear_to_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar mcurrentDate = Calendar.getInstance();
                year = mcurrentDate.get(Calendar.YEAR);
                month = mcurrentDate.get(Calendar.MONTH);
                day = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                datepickerdialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
//                        from_date_text.setText(new StringBuilder().append(year).append("-").append(month + 1).append("-").append(day));
                        int month_k = selectedmonth + 1;
                        ArrayList<String> fulldate1 = new ArrayList<String>();
                        String[] months = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "July"
                                , "Aug", "Sep", "Oct", "Nov", "Dec"};

                        fulldate1.add(String.valueOf(selectedday));
                        fulldate1.add(months[month_k]);
                        fulldate1.add(String.valueOf(selectedyear));

                        to_date_text.setText(fulldate1.get(0) + " " + fulldate1.get(1) + " " + fulldate1.get(2));

                    }
                }, year, month, day);
                // TODO Hide Past Date Here
                datepickerdialog.getDatePicker().setMinDate(System.currentTimeMillis());

                // TODO Hide Future Date Here
                //  mDatePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
                datepickerdialog.show();
            }
        });


        return  view;
    }

}
