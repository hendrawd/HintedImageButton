package hendrawd.library.customview

import android.content.Context
import androidx.appcompat.widget.AppCompatImageButton
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.Toast

/**
 * Show the content description in a Toast when the user long presses it.
 *
 * Note: `android:contentDescription` must be set in order for the toast to
 * work
 *
 * @author Callum Taylor, hendrawd
 * @see [http://callumtaylor.net](http://callumtaylor.net)
 */
class HintedImageButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null)
    : AppCompatImageButton(context, attrs), OnLongClickListener {
    private var mOnLongClickListener: OnLongClickListener? = null

    init {
        super.setOnLongClickListener(this)
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
                val yOffset = positions[1] - 128

                Toast.makeText(
                        context,
                        contentDescription,
                        Toast.LENGTH_SHORT
                ).apply {
                    setGravity(Gravity.TOP or Gravity.LEFT, xOffset, yOffset)
                    show()
                }
            }
        }
    }
}