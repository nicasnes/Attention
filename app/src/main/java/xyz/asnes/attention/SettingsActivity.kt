package xyz.asnes.attention

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SettingsActivity : AppCompatActivity() {

    val pref = "appInfo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        supportActionBar?.hide()

        // Load the SharedPermissions manager object.
        val settings = this.getSharedPreferences(pref, Context.MODE_PRIVATE)

        // Find the value of the textView which holds the current phone number.
        val textView : TextView = findViewById<TextView>(R.id.curPhone)

        //if (SPManager.isPhoneNumber()) {
        if (settings.getBoolean("isPhoneNumber", true)) {
            textView.text = settings.getString("phoneNumber", "phone number not found.")
        } else {
            textView.text = "phone number not found."
        }
    }

    /**
     * Called when the user clicks "submit" in the settings menu.
     */
    fun onSubmit(view: View) {
        val newPhone = findViewById<EditText>(R.id.editTextPhone2).text.toString()
        val settings = this.getSharedPreferences(pref, Context.MODE_PRIVATE)
        var submitMessage = "Settings successfully submitted."
        // If no text is entered in the text box, do not change the phone number in the settings.
        if (newPhone == "") {
            submitMessage = "No phone number entered - no changes were made."
        } else if (!PhoneNumberUtils.isGlobalPhoneNumber(newPhone)) {
            submitMessage = "Invalid phone number - no changes were made."
        } else {
            settings.edit().putString("phoneNumber", newPhone).apply()
        }
        Toast.makeText(applicationContext, submitMessage, Toast.LENGTH_LONG).show();
        finish()
    }
}