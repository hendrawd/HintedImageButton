package hendrawd.hintedimagebutton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hendrawd.hintedimagebutton.databinding.ActivityChooserBinding
import splitties.activities.start

/**
 * @author hendrawd on 24 May 2019
 */
class ChooserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            bAppCompatHintActivity.setOnClickListener {
                start<AppCompatHintActivity>()
            }
            bHintActivity.setOnClickListener {
                start<HintActivity>()
            }
            bFancyHintActivity.setOnClickListener {
                start<FancyHintActivity>()
            }
        }
    }
}