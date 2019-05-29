package hendrawd.hintedimagebutton

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.TooltipCompat
import org.jetbrains.anko.*

class AppCompatHintActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {
            layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
            gravity = Gravity.CENTER
            orientation = LinearLayout.VERTICAL

            imageButton {
                contentDescription = getString(R.string.app_compat_hint)
                imageResource = R.mipmap.ic_launcher

                // use this to show hint with android appcompat library
                TooltipCompat.setTooltipText(this, contentDescription)
            }.lparams(wrapContent, wrapContent)

            textView(R.string.long_click_button_above).lparams(wrapContent, wrapContent) {
                topMargin = dip(8)
            }
        }
    }
}