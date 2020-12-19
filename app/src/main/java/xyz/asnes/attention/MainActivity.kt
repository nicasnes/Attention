package xyz.asnes.attention
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Explore preference settings to see if this is the first run.
        val settings = this.getSharedPreferences("appInfo", Context.MODE_PRIVATE)

        // If this is the first run, request a phone number from the user.
        if (!settings.getBoolean("isPhoneNumber", false)) {
            settings.edit().putBoolean("isPhoneNumber", true).apply()
            startActivity(Intent(this, OnboardingActivity::class.java))
        }
    }

    /**
     * Called when the user presses the "emotional attention" button.
     * **/
    fun openEmotionalAttentionMenu(view: View) {
        val intent = Intent(this, EmotionalPromptsActivity::class.java)
        startActivity(intent)
    }

    /**
     * Called when the user presses the "physical attention" button.
     */
    fun openPhysicalAttentionMenu(view: View) {
        val intent = Intent(this, PhysicalPromptsActivity::class.java)
        startActivity(intent)

    }

    /**
     * Called when the user presses the "settings" button.
     */
    fun openSettingsMenu(view: View) {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

}