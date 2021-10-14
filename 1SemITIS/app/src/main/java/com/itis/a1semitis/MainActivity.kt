package com.itis.a1semitis

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.CallLog.*
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.itis.a1semitis.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val CALL_REQUEST_CODE = 101
    private val REQUEST_TAKE  = 1
    lateinit var binding: ActivityMainBinding


    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        with(binding) {
            btnText.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        SecondActivity::class.java
                    ).apply {
                        putExtra("KEY", etNumber.text.toString())
                    }
                )
            }
        }

        setupPermissions()

        val et_number=findViewById<TextView>(R.id.et_number)

        val btn_call=findViewById<Button>(R.id.btn_call)
        // Calling using intent
        btn_call.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + et_number.getText())
            startActivity(intent)
        })

        val btn_call_log=findViewById<Button>(R.id.btn_call_log)
        // Call log
        btn_call_log.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.type = Calls.CONTENT_TYPE
            startActivity(intent)
        })

        val btn_contact=findViewById<Button>(R.id.btn_contact)
        //Contact
        btn_contact.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = ContactsContract.Contacts.CONTENT_TYPE
            startActivity(intent)
        })

        val btn_browser=findViewById<Button>(R.id.btn_browser)
        // browser
        btn_browser.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://tutorial.eyehunts.com/")
            startActivity(intent)
        })

        val btn_gallery=findViewById<Button>(R.id.btn_gallery)
        // Gallery
        btn_gallery.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("content://media/external/images/media/")
            startActivity(intent)
        })

        val btn_camera=findViewById<Button>(R.id.btn_camera)
        // camera
        btn_camera.setOnClickListener(View.OnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        })

        val btn_alarm=findViewById<Button>(R.id.btn_alarm)
        // alarm
        btn_alarm.setOnClickListener(View.OnClickListener {
            val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS)
            startActivity(intent)
        })

    }

    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.CALL_PHONE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i("none", "Permission to Call has denied")
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.CALL_PHONE),
            CALL_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_TAKE && resultCode == Activity.RESULT_OK) {
            Snackbar.make(
                binding.root,
                "Sended",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
    }
