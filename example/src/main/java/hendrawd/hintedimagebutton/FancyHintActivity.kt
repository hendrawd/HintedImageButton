package hendrawd.hintedimagebutton

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import hendrawd.hintedimagebutton.databinding.ActivityFancyHintBinding
import hendrawd.hintedimagebutton.databinding.LayoutCustomToastBinding

class FancyHintActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFancyHintBinding
    private lateinit var layoutCustomToastBinding: LayoutCustomToastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFancyHintBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutCustomToastBinding = LayoutCustomToastBinding.inflate(layoutInflater)

        binding.hintedImageButton.setCustomLayout(
            layoutCustomToastBinding.root,
            layoutCustomToastBinding.textView
        )
    }
}