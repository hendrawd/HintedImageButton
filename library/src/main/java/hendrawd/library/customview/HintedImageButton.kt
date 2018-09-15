package hendrawd.library.customview

import android.content.Context
import android.support.v7.widget.AppCompatImageButton
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.Toast

/**
 * Extended image view to show the content description in a Toast view when
 * the user long presses.
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
            mOnLongClickListener?.apply {
                if (!onLongClick(longClickedView)) {
                    handleLongClick()
                    return true
                }
            }
        } else {
            handleLongClick()
            return true
        }
        return false
    }

    private fun handleLongClick() {
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