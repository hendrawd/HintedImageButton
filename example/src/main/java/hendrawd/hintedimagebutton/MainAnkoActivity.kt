package hendrawd.hintedimagebutton

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import hendrawd.library.customview.hintedImageButton
import org.jetbrains.anko.*

class MainAnkoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {
            layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
            gravity = Gravity.CENTER
            orientation = LinearLayout.VERTICAL

            hintedImageButton {
                contentDescription = getString(R.string.hint)
                imageResource = R.mipmap.ic_launcher
                // optional set hint duration HintedImageButton.DURATION_SHORT or DURATION_LONG
                // hintDuration = HintedImageButton.DURATION_LONG
            }.lparams(wrapContent, wrapContent)

            textView(R.string.long_click_button_above).lparams(wrapContent, wrapContent) {
                topMargin = dip(8)
            }
        }
    }
}