package hendrawd.library.customview

import android.content.Context
import android.view.ViewManager
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko.custom.ankoView

/**
 * @author hendrawd on 06 Nov 2018
 */
inline fun ViewManager.hintedImageButton() = hintedImageButton {}

inline fun ViewManager.hintedImageButton(init: (@AnkoViewDslMarker HintedImageButton).() -> Unit) =
        ankoView({ ctx: Context -> HintedImageButton(ctx) }, 0) { init() }