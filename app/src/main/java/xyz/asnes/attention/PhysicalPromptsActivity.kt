package xyz.asnes.attention

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PhysicalPromptsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physical_prompts)
    }
}