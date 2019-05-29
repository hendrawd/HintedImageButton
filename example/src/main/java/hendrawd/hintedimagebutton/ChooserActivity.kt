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
                text = AppCompatHintActivity::class.java.simpleName
                allCaps = false
                setOnClickListener {
                    startActivity<AppCompatHintActivity>()
                }
            }.lparams(matchParent, wrapContent)

            button {
                text = HintActivity::class.java.simpleName
                allCaps = false
                setOnClickListener {
                    startActivity<HintActivity>()
                }
            }.lparams(matchParent, wrapContent)

            button {
                text = HintWithAnkoLayoutActivity::class.java.simpleName
                allCaps = false
                setOnClickListener {
                    startActivity<HintWithAnkoLayoutActivity>()
                }
            }.lparams(matchParent, wrapContent) {
                topMargin = dip(8)
            }

            button {
                text = FancyHintActivity::class.java.simpleName
                allCaps = false
                setOnClickListener {
                    startActivity<FancyHintActivity>()
                }
            }.lparams(matchParent, wrapContent) {
                topMargin = dip(8)
            }
        }
    }
}