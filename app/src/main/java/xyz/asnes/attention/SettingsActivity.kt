package xyz.asnes.attention

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SettingsActivity : AppCompatActivity() {

    val pref = "appInfo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

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
        val newPhone : EditText = findViewById<EditText>(R.id.editTextPhone2)
        val settings = this.getSharedPreferences(pref, Context.MODE_PRIVATE)
        // NOTE: This is temporary functionality for testing. The user is required to enter
        // "000" before exiting settings. A text listener will be added in the future.
        if (newPhone.text.toString() != "000") {
            settings.edit().putString("phoneNumber", newPhone.text.toString()).apply()
        }
        finish()
    }
}