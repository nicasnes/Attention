package xyz.asnes.attention

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PhysicalPromptsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physical_prompts)
    }

    /**
     * A series of functions called when the user presses the associated button.
     * Sends an SMS to the phone number specified in settings regarding a desire
     * for additional physical attention through the specified means.
     */

    fun sendHugs(view: View) {
        sendSMS("Hugs")
    }

    fun sendKiss(view: View) {
        sendSMS("Kisses")
    }

    fun sendSex(view: View) {
        sendSMS("Sex")
    }

    fun sendMassage(view: View) {
        sendSMS("Massage")
    }

    fun sendCuddles(view: View) {
        sendSMS("Cuddles")
    }

    /**
     * Takes a message as a String which will be sent to the phone number stored in the
     * settings (through SharedPreferences)
     * If the phone number is invalid or the SMS fails, the user is notified.
     */

    private fun sendSMS(message : String) {
        // Load the phone number
        val settings = this.getSharedPreferences("appInfo", Context.MODE_PRIVATE)
        val phoneNum = settings.getString("phoneNumber", "none")
        if (phoneNum == "none") {
            Toast.makeText(applicationContext, "Phone number is invalid or does not exist.", Toast.LENGTH_SHORT).show()
            return
        }

        try {
            startActivity(
                Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", phoneNum, null))
                    .putExtra("sms_body", message)
            )
            finish()
        } catch (ex : android.content.ActivityNotFoundException) {
            Toast.makeText(applicationContext, "SMS failed, please try again later", Toast.LENGTH_SHORT).show()
        }

    }
}