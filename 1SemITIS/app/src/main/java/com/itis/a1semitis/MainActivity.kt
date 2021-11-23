package com.itis.a1semitis

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat.CLOCK_24H
import java.util.*

private const val ALARM_REQUEST_CODE = 1000


class MainActivity : AppCompatActivity() {

    private var calendar: Calendar? = null
    private lateinit var datePicker: MaterialTimePicker


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val setAlarm = findViewById<Button>(R.id.btn_start)
        val offAlarm = findViewById<Button>(R.id.btn_stop)


        var alarmManager: AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent= PendingIntent.getBroadcast(this, ALARM_REQUEST_CODE,intent, PendingIntent.FLAG_UPDATE_CURRENT)

        setAlarm.setOnClickListener {
            datePicker = MaterialTimePicker.Builder()
                .setTimeFormat(CLOCK_24H)
                .setHour(12)
                .setMinute(0)
                .build()
            with(datePicker) {
                show(supportFragmentManager, "ALARM")
                addOnPositiveButtonClickListener {
                    calendar = Calendar.getInstance().also {
                        it[Calendar.HOUR_OF_DAY] = datePicker.hour
                        it[Calendar.MINUTE] = datePicker.minute
                        it[Calendar.SECOND] = 0
                        it[Calendar.MILLISECOND] = 0
                    }
                }
            }

            if (calendar != null) {
                alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
                val result: Long = calendar!!.timeInMillis
                alarmManager.set(AlarmManager.RTC_WAKEUP, result, pendingIntent)
            }

        }
        offAlarm.setOnClickListener{
            alarmManager.cancel(pendingIntent);
        }
    }
}