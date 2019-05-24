package hendrawd.hintedimagebutton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HintActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // optional set hint duration HintedImageButton.DURATION_SHORT or DURATION_LONG
        // hintedImageButton.hintDuration = HintedImageButton.DURATION_LONG
    }
}
