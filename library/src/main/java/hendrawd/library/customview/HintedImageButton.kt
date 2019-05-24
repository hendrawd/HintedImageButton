package hendrawd.library.customview

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.View.OnLongClickListener
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
        defStyleAttr: Int = 0
) : AppCompatImageButton(context, attrs, defStyleAttr), OnLongClickListener {

    private var mOnLongClickListener: OnLongClickListener? = null
    var hintDuration = DURATION_SHORT

    companion object {
        val DURATION_SHORT = 0
        val DURATION_LONG = 1
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

    private fun showContentDescriptionAsHint() {
        contentDescription?.toString()?.let { contentDescription ->
            if (contentDescription.isNotEmpty()) {
                val positions = IntArray(2)
                getLocationOnScreen(positions)

                val xOffset = positions[0] - contentDescription.length / 6
                val yOffset = positions[1] - 128 // TODO change y position based on view height

                Toast.makeText(
                        context,
                        contentDescription,
                        if (hintDuration == DURATION_SHORT) {
                            Toast.LENGTH_SHORT
                        } else {
                            Toast.LENGTH_LONG
                        }
                ).apply {
                    setGravity(Gravity.TOP or Gravity.LEFT, xOffset, yOffset)
                    show()
                }
            }
        }
    }
}