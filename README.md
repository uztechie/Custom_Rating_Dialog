# Custom_Rating_Dialog

>Step 1. Add the JitPack repository to your build file

>Gradle
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
}
```
>Step 2. Add the dependency
```
dependencies {
	        implementation 'com.github.uztechie:Custom_Rating_Dialog:1.0.0'
	}
```


>How to use!

```
 val customRating = CustomRating(this)

        customRating.init()
            .setShowingInterval(2)                  // Each launching of application, default is 5

        customRating.begin()
            .setTitle("Title")
            .setMessage("Message")
            .setPositiveButtonText("Ok")
            .setNegativeButtonText("Cancel")
            .setTitleColor(Color.BLACK)                 // Optional default color is BLACK
            .setMessageColor(Color.BLACK)               // Optional default color is BLACK
            .setPositiveButtonColor(Color.RED)          // Optional default color is RED
            .setNegativeButtonColor(Color.RED)          // Optional default color is RED
            .setRatingBarColor(Color.MAGENTA, Color.GRAY) // Optional
            .setAppUrl("your app url in google play store")

```
  
  >Result


![image](https://user-images.githubusercontent.com/47640521/208348878-0dff8238-b16e-4a63-8be2-a0ba69216eae.png)
