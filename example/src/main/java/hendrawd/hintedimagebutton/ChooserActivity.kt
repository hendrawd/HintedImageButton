package hendrawd.hintedimagebutton

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.*

/**
 * @author hendrawd on 24 May 2019
 */
class ChooserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {
            layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
            gravity = Gravity.CENTER
            orientation = LinearLayout.VERTICAL

            button {
                text = MainActivity::class.java.simpleName
                allCaps = false
                setOnClickListener {
                    startActivity<MainActivity>()
                }
            }.lparams(wrapContent, wrapContent)

            button {
                text = MainAnkoActivity::class.java.simpleName
                allCaps = false
                setOnClickListener {
                    startActivity<MainAnkoActivity>()
                }
            }.lparams(wrapContent, wrapContent) {
                topMargin = dip(8)
            }
        }
    }
}