package xyz.asnes.attention

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)
    }

    fun submitPhoneNumber(view: View) {
        var phoneNum = findViewById<EditText>(R.id.editTextPhone).text.toString()
        val settings = this.getSharedPreferences("appInfo", Context.MODE_PRIVATE)
        settings.edit().putString("phoneNumber", phoneNum).apply()
        finish()
    }
}