package com.clicks.yogi.timepicker;

import androidx.appcompat.app.AppCompatActivity;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity{

    Button btnTimePicker;
    EditText time;
    TimePickerDialog timePickerDialog;
    int XHour, XMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTimePicker=(Button)findViewById(R.id.btn1);
        time=(EditText)findViewById(R.id.edt1);

        btnTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get Current Time
                final Calendar c = Calendar.getInstance();
                XHour = c.get(Calendar.HOUR_OF_DAY);
                XMinute = c.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view,int hourOfDay,int minute){
                                time.setText("Time : "+hourOfDay + ":" + minute);
                            }
                        }, XHour, XMinute, false);
                timePickerDialog.show();
            }
        });
    }
}