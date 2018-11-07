# HintedImageButton

ImageButton that shows hint using toast when long clicked

<a href="https://user-images.githubusercontent.com/9481791/48111768-a0235d00-e285-11e8-8279-f3d1c01361a3.jpg"><img src="https://user-images.githubusercontent.com/9481791/48111768-a0235d00-e285-11e8-8279-f3d1c01361a3.jpg" width="300px"/></a>
<a href="https://user-images.githubusercontent.com/9481791/48111769-a0235d00-e285-11e8-9ffe-0029d801c74f.jpg"><img src="https://user-images.githubusercontent.com/9481791/48111769-a0235d00-e285-11e8-9ffe-0029d801c74f.jpg" width="300px"/></a>

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
