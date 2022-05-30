package hendrawd.hintedimagebutton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.TooltipCompat
import hendrawd.hintedimagebutton.databinding.ActivityAppCompatHintBinding

class AppCompatHintActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppCompatHintBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppCompatHintBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageButton.apply {
            TooltipCompat.setTooltipText(this, contentDescription)
        }
    }
}