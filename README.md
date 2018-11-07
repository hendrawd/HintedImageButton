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
```
or directly within anko layout
```kotlin
frameLayout { 
    hintedImageButton { 
       // set properties
    }
}
```
