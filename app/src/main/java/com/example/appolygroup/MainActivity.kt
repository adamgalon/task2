package com.example.appolygroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

import android.content.Intent
import android.util.Log
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btIntent = findViewById<Button>(R.id.btIntent)

        /*
        * Task 1
        * */
        lifecycleScope.launch {
            Log.d("onCreate", "Hello from onCreate in coroutineScope")
        }

        /*
        * task2
        * */
        val textMessage = "google.com"
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage)
        sendIntent.type = "text/plain"

        /*
        * There may be zero activities to handle the Intent.
        * Even for something as common as a Web browser, the specific user
        * might not have access to a browser app (secondary user profiles, etc.).
        * If you try starting an activity, and there is no match, you get
        * an ActivityNotFoundException, so this check is trying to avoid such an exception.
        */
        if (sendIntent.resolveActivity(packageManager) != null) {
            startActivity(sendIntent)
        }

        btIntent.setOnClickListener {
            startActivity(sendIntent)
        }

    }
}