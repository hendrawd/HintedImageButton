package hendrawd.hintedimagebutton

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import hendrawd.library.customview.hintedImageButton
import kotlinx.android.synthetic.main.layout_custom_toast.view.*
import org.jetbrains.anko.*

class FancyHintActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {
            layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
            gravity = Gravity.CENTER
            orientation = LinearLayout.VERTICAL

            hintedImageButton {
                contentDescription = getString(R.string.custom_hint)
                imageResource = R.mipmap.ic_launcher
                val customLayout = layoutInflater.inflate(
                        R.layout.layout_custom_toast,
                        null
                )
                setCustomLayout(customLayout, customLayout.textView)
            }.lparams(wrapContent, wrapContent)

            textView(R.string.long_click_button_above).lparams(wrapContent, wrapContent) {
                topMargin = dip(8)
            }
        }
    }
}