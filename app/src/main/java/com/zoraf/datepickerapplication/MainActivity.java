package com.zoraf.datepickerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvShowDate;
    private Button  btnPickDate;
    private DatePicker mDatePicker;
    private Calendar mCalender;
    private int year,month, date;
    private DatePickerDialog.OnDateSetListener mDateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tvShowDate = findViewById(R.id.tvShowDate);
        btnPickDate = findViewById(R.id.btnPickDate);
        btnPickDate.setOnClickListener(this);
        mCalender = Calendar.getInstance();
        year = mCalender.get(Calendar.YEAR);
        month = mCalender.get(Calendar.MONTH);
        date = mCalender.get(Calendar.DATE);
        mDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                tvShowDate.setText("year: " + year + " month: " + month + " day: "+ date );
            }
        };
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999){
            return new DatePickerDialog(this, mDateListener, year, month, date);
        }
        return super.onCreateDialog(id);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPickDate:
                showDialog(999);
                break;
        }

    }
}