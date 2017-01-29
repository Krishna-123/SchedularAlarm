package com.example.krishna.schedular;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    static final int Sun_ID = 0, Mon_ID = 1, Tue_ID = 2, Wed_ID = 3, Thu_ID = 4, Fri_ID = 5, Sat_ID = 6;
    Button b_su, b_mo, b_tu, b_we, b_th, b_fr, b_sa;
    int hour_su, hour_mo, hour_tu, hour_we, hour_th, hour_fr, hour_sa;
    int minute_mo, minute_su, minute_tu, minute_we, minute_th, minute_fr, minute_sa;
    int flag = 0;

    private PendingIntent panding;
    private AlarmManager alarmManager;

    Button startServiceButton, stopServiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startServiceButton = (Button)findViewById(R.id.buttonStart);
        stopServiceButton = (Button)findViewById(R.id.buttonStop);


        showTimeDialogPicker();


    }

    public void showTimeDialogPicker() {
        b_su = (Button) findViewById(R.id.button);
        b_mo = (Button) findViewById(R.id.button1);
        b_tu = (Button) findViewById(R.id.button2);
        b_we = (Button) findViewById(R.id.button3);
        b_th = (Button) findViewById(R.id.button4);
        b_fr = (Button) findViewById(R.id.button5);
        b_sa = (Button) findViewById(R.id.button6);

        b_su.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        showDialog(Sun_ID);
                    }
                }
        );
    }


    protected TimePickerDialog.OnTimeSetListener kTimePickerListener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            switch (flag) {
                case 0:
                    hour_su = hourOfDay;
                    minute_su = minute;
                    Toast.makeText(MainActivity.this, hour_su + "first:" + minute_su, Toast.LENGTH_SHORT).show();
                    setAlarm(flag,hour_su,minute_su);
                    break;
                case 1:
                    hour_mo = hourOfDay;
                    minute_mo = minute;
                    Toast.makeText(MainActivity.this, hour_mo + "first:" + minute_mo, Toast.LENGTH_SHORT).show();
                    setAlarm(flag,hour_mo,minute_mo);
                    break;
                case 2:
                    hour_tu = hourOfDay;
                    minute_tu = minute;
                    Toast.makeText(MainActivity.this, hour_tu + "first:" + minute_tu, Toast.LENGTH_SHORT).show();
                    setAlarm(flag,hour_tu,minute_tu);
                    break;
                case 3:
                    hour_we = hourOfDay;
                    minute_we = minute;
                    Toast.makeText(MainActivity.this, hour_we + "first:" + minute_we, Toast.LENGTH_SHORT).show();
                    setAlarm(flag,hour_we,minute_we);
                    break;
                case 4:
                    hour_th = hourOfDay;
                    minute_th = minute;
                    Toast.makeText(MainActivity.this, hour_th + ":" + minute_th, Toast.LENGTH_SHORT).show();
                    setAlarm(flag,hour_th,minute_th);
                    break;
                case 5:
                    hour_fr = hourOfDay;
                    minute_fr = minute;
                    Toast.makeText(MainActivity.this, hour_fr + ":" + minute_fr, Toast.LENGTH_SHORT).show();
                    setAlarm(flag,hour_fr,minute_fr);
                    break;
                case 6:
                    hour_sa = hourOfDay;
                    minute_sa = minute;
                    Toast.makeText(MainActivity.this, hour_sa + ":" + minute_sa, Toast.LENGTH_SHORT).show();
                    setAlarm(flag,hour_sa,minute_sa);
                    break;

            }
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case Sun_ID:
                flag = 0;
                return new TimePickerDialog(MainActivity.this, kTimePickerListener, hour_su, minute_su, false);

            case Mon_ID:
                flag = 1;
                return new TimePickerDialog(MainActivity.this, kTimePickerListener, hour_mo, minute_mo, false);

            case Tue_ID:
                flag = 2;
                return new TimePickerDialog(MainActivity.this, kTimePickerListener, hour_tu, minute_tu, false);

            case Wed_ID:
                flag = 3;
                return new TimePickerDialog(MainActivity.this, kTimePickerListener, hour_we, minute_we, false);

            case Thu_ID:
                flag = 4;
                return new TimePickerDialog(MainActivity.this, kTimePickerListener, hour_th, minute_th, false);

            case Fri_ID:
                flag = 5;
                return new TimePickerDialog(MainActivity.this, kTimePickerListener, hour_fr, minute_fr, false);

            case Sat_ID:
                flag = 6;
                return new TimePickerDialog(MainActivity.this, kTimePickerListener, hour_sa, minute_sa, false);

            default:
                return null;

        }
    }


    public void monDay(View view) {
        showDialog(Mon_ID);
    }

    public void tueDay(View view) {
        showDialog(Tue_ID);
    }

    public void wedDay(View view) {
        showDialog(Wed_ID);
    }

    public void thuDay(View view) {
        showDialog(Thu_ID);
    }

    public void friDay(View view) {
        showDialog(Fri_ID);
    }

    public void satDay(View view) {
        showDialog(Sat_ID);
    }


    public void setAlarm(int flag, int hour_x, int minute_x) {

        Calendar calendar = Calendar.getInstance();
        switch (flag){
            case 0:  calendar.set(calendar.DAY_OF_WEEK ,Calendar.SUNDAY);
                     break;

            case 1:  calendar.set(calendar.DAY_OF_WEEK ,Calendar.MONDAY);
                break;

            case 2:  calendar.set(calendar.DAY_OF_WEEK ,Calendar.TUESDAY);
                break;

            case 3:  calendar.set(calendar.DAY_OF_WEEK ,Calendar.WEDNESDAY);
                break;

            case 4:  calendar.set(calendar.DAY_OF_WEEK ,Calendar.THURSDAY);
                break;

            case 5:  calendar.set(calendar.DAY_OF_WEEK ,Calendar.FRIDAY);
                break;

            case 6:  calendar.set(calendar.DAY_OF_WEEK ,Calendar.SATURDAY);
                break;


        }


        calendar.set(calendar.HOUR_OF_DAY, hour_x);
        calendar.set(calendar.MINUTE, minute_x);
        calendar.set(calendar.SECOND, 0);
        calendar.set(calendar.MILLISECOND, 0);

        Intent alarmintent = new Intent(MainActivity.this, AlarmReceiver.class);
        final int _id = (int) System.currentTimeMillis();

        panding = PendingIntent.getBroadcast(this, _id, alarmintent, PendingIntent.FLAG_ONE_SHOT);

        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                panding);

        Toast.makeText(this, "" + hour_x + ":" + minute_x, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MyService.class);
        startService(intent);

    }

    public void stopOnClick(View view) {

    }


    public void startOnclick(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }
}