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

        lifecycleScope.launch {
            Log.d("onCreate", "Hello from onCreate in coroutineScope")
        }


        val textMessage = "wykop.pl"
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage)
        sendIntent.type = "text/plain"

        if (sendIntent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }



        btIntent.setOnClickListener {
            startActivity(sendIntent)
        }

    }
}