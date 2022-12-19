package uz.ibroxim.customratingdialog

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

//        try {
//
//        }catch (e:Exception){
//            println("Errorr "+e)
//        }





    }
}