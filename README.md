# HintedImageButton

ImageButton that shows hint using toast when long clicked

# How to use?
- Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
- Add the dependency
```gradle
dependencies {
    implementation 'com.github.hendrawd:HintedImageButton:x.x.x'
}
```
Where **x.x.x** is the latest release version. Please check the latest release version [here](https://github.com/hendrawd/HintedImageButton/releases)
- Use it
```XML
<hendrawd.library.customview.HintedImageButton
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"
	android:src="@drawable/ic_xxx"
	android:contentDescription="Put your hint here!"
	android:background="@drawable/optional_selector"
	/>
```
This library ❤️ anko DSL. You can use it directly from your kotlin code.
```kotlin
frameLayout { 
    hintedImageButton { 
	// ...
    }
}
```
