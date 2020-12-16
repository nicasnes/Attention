package xyz.asnes.attention

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class OnboardingActivity : AppCompatActivity() {

    var phoneNum = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

    }

    fun submitPhoneNumber(view: View) {
        phoneNum = findViewById<EditText>(R.id.editTextPhone).toString()
        finish()
    }
}