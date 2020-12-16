package xyz.asnes.attention

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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