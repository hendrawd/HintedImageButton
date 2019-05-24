# HintedImageButton

ImageButton that shows hint using toast when long clicked

<img src="https://user-images.githubusercontent.com/9481791/48111769-a0235d00-e285-11e8-9ffe-0029d801c74f.jpg" width="300px"/>

# How to use?
- Add jitpack url in your root build.gradle
```gradle
allprojects {
   repositories {
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
Where **x.x.x** is the latest release version. Check the latest release version [here](https://github.com/hendrawd/HintedImageButton/releases)
- Use
```XML
<hendrawd.library.customview.HintedImageButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:src="@drawable/ic_xxx"
    android:contentDescription="Put your hint here!"
    android:background="@drawable/optional_selector"
    />
<!-- use android:background="@null" if you want to remove the background-->
<!--optional app:hintDuration="durationShort" or "durationLong", default="durationShort"-->
```
set duration property from code (optional)
```kotlin
hintedImageButton.hintDuration = HintedImageButton.DURATION_LONG // or HintedImageButton.DURATION_SHORT
```
or directly within anko layout
```kotlin
frameLayout { 
    hintedImageButton { 
       // set properties
    }
}
```

# New Attribute in Android Oreo

Starting from Android Oreo you can also use `android:tooltipText` attribute in order to display a simple Toast-like tooltip when user long-presses on a `View`
```xml
<View
    android:id="@+id/yourView"
    android:tooltipText="@string/view_tooltip"/>
```
Although it has limitation with minimum API 26, you can still use it through the Support Library's `TooltipCompat` helper class
```kotlin
TooltipCompat.setTooltipText(yourView, getString(R.string.view_tooltip))
```
Have fun! ;)
