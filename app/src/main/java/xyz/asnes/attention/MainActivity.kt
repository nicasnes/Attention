package xyz.asnes.attention
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

open class MainActivity : AppCompatActivity() {

    val pref = "appInfo"

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Explore preference settings to see if this is the first run.
        val settings = this.getSharedPreferences(pref, Context.MODE_PRIVATE)

        val isPhoneNumber = settings.getBoolean("isPhoneNumber", false)

        // If this is the first run, request a phone number from the user.
        if (!isPhoneNumber) {
            settings.edit().clear().putBoolean("isPhoneNumber",true).apply()
            startActivity(Intent(this, OnboardingActivity::class.java))
        }
    }

    /**
     * Called when the user presses the "emotional attention" button.
     * **/
    fun emotionalAttention(view: View) {
        val intent = Intent(this, EmotionalPromptsActivity::class.java)
        startActivity(intent)
    }

    /**
     * Called when the user presses the "physical attention" button.
     */
    fun physicalAttention(view: View) {
        val intent = Intent(this, PhysicalPromptsActivity::class.java)
        startActivity(intent)

    }

}