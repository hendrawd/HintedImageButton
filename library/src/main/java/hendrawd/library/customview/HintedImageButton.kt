package hendrawd.library.customview

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton

/**
 * Show the content description in a Toast when the user long presses it.
 *
 * Note: `android:contentDescription` must be set in order for the toast to
 * work
 *
 * @author Callum Taylor, hendrawd
 * @see [http://callumtaylor.net](http://callumtaylor.net)
 */
class HintedImageButton @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = androidx.appcompat.R.attr.imageButtonStyle
) : AppCompatImageButton(context, attrs, defStyleAttr), OnLongClickListener {

    private var mOnLongClickListener: OnLongClickListener? = null
    private var customLayout: View? = null
    private var textView: TextView? = null
    var hintDuration = DURATION_SHORT

    companion object {
        const val DURATION_SHORT = 0
        const val DURATION_LONG = 1
    }

    init {
        super.setOnLongClickListener(this)
        val attributes = context.obtainStyledAttributes(
                attrs,
                R.styleable.HintedImageButton,
                defStyleAttr,
                0
        )
        try {
            hintDuration = attributes.getInteger(
                    R.styleable.HintedImageButton_hintDuration,
                    DURATION_SHORT
            )
        } finally {
            attributes.recycle()
        }
    }

    override fun setOnLongClickListener(onLongClickListener: OnLongClickListener?) {
        mOnLongClickListener = onLongClickListener
    }

    override fun onLongClick(longClickedView: View): Boolean {
        if (mOnLongClickListener != null) {
            mOnLongClickListener?.run {
                if (!onLongClick(longClickedView)) {
                    showContentDescriptionAsHint()
                    return true
                }
            }
        } else {
            showContentDescriptionAsHint()
            return true
        }
        return false
    }

    override fun onHoverChanged(hovered: Boolean) {
        if (hovered) {
            showContentDescriptionAsHint()
        }
        super.onHoverChanged(hovered)
    }

    private fun showContentDescriptionAsHint() {
        contentDescription?.toString()?.let { contentDescription ->
            if (contentDescription.isNotEmpty()) {
                val positions = IntArray(2)
                getLocationOnScreen(positions)

                val xOffset = positions[0] - contentDescription.length / 6
                val yOffset = positions[1] - height * 3 / 4

                Toast.makeText(
                        context.applicationContext,
                        contentDescription,
                        if (hintDuration == DURATION_SHORT) {
                            Toast.LENGTH_SHORT
                        } else {
                            Toast.LENGTH_LONG
                        }
                ).apply {
                    if (customLayout != null && textView != null) {
                        customLayout?.let { view = customLayout }
                        textView?.text = contentDescription
                    }
                    setGravity(Gravity.TOP or Gravity.LEFT, xOffset, yOffset)
                    show()
                }
            }
        }
    }

    fun setCustomLayout(layout: View, textView: TextView) {
        customLayout = layout
        this.textView = textView
    }
}