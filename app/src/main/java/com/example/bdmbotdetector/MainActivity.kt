package com.example.bdmbotdetector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.pm.PackageManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isAppInstalled("com.pearlabyss.blackdesertm.gl")) {
            this.detect_bot_button.text = "Detect bot"
        } else {
            this.detect_bot_button.text = "BDM not installed"
            detect_bot_button.isEnabled = false
        }
    }

    fun onDetectBot(view: View) {
        if (isAppInstalled("com.pearlabyss.blackdesertmpropen")) {
            this.detect_result_text.text = "Bot detected"
        } else {
            this.detect_result_text.text = "Bot not detected"
        }
    }

    private fun isAppInstalled(packageName: String): Boolean {
        return try {
            packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }
}
