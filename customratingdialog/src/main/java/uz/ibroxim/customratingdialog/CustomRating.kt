package uz.ibroxim.customratingdialog

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import com.chibatching.kotpref.Kotpref

class CustomRating  constructor(val context: Context) {
    private var interval = 5
    private var appUrl = ""


    private var customRatingDialog: CustomRatingDialog = CustomRatingDialog(context, object :
        CustomRatingDialog.CustomRatingDialogCallback {
        override fun onClickLater() {
            SharedPref.launchCount = 0
        }

        override fun onClickRate() {
            SharedPref.launchCount = 0
            openAppFromPlayStore()
        }

        override fun onClickNeverShow() {
            SharedPref.showDialog = false
        }

    })
    init {
        Kotpref.init(context)
        customRatingDialog.create()
    }



    fun begin():CustomRating{
        try {
            if (SharedPref.showDialog && SharedPref.launchCount%interval == 0){
                customRatingDialog.show()
            }
            initDefaultColors()
        }catch (e:Exception){
            println("begin error "+e)
        }


        return this
    }


    fun setTitle(title:String):CustomRating{
       customRatingDialog.setTitle(title)
        return this
    }
    fun setMessage(message:String):CustomRating{
        customRatingDialog.setMessage(message)
        return this
    }
    fun setRatingBarColor(color:Int,  colorSecondary:Int):CustomRating{
        try {
            customRatingDialog.setRatingBarColor(color, colorSecondary)
        }catch (e:Exception){
            println("setRatingBarColor error "+e)
        }
        return this
    }
    fun setPositiveButtonText(text:String):CustomRating{
        customRatingDialog.setPositiveButtonText(text)
        return this
    }
    fun setNegativeButtonText(text:String):CustomRating{
        customRatingDialog.setNegativeButtonText(text)
        return this
    }
    fun setTitleColor(color: Int):CustomRating{
        customRatingDialog.setTitleColor(color)
        return this
    }
    fun setMessageColor(color: Int):CustomRating{
        customRatingDialog.setMessageColor(color)
        return this
    }
    fun setPositiveButtonColor(color: Int):CustomRating{
       customRatingDialog.setPositiveButtonColor(color)
        return this
    }
    fun setNegativeButtonColor(color: Int):CustomRating{
        customRatingDialog.setPositiveButtonColor(color)
        return this
    }
    fun setShowingInterval(showingInterval:Int):CustomRating{
        interval = showingInterval
        return this
    }
    fun setAppUrl(url:String):CustomRating{
        try {
            appUrl = url
        }catch (e:Exception){
            println("setAppUrl "+e)
        }

        return this
    }



    private fun countLaunchApp(){
        try {
            val counter = SharedPref.launchCount+1
            println("countLaunchApp counter $counter")
            SharedPref.launchCount = counter
        }catch (e:Exception){
            println("countLaunchApp error "+e)
        }
    }
    private fun openAppFromPlayStore(){
        try {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.data = Uri.parse(appUrl)
            context.startActivity(intent)
        }catch (e:Exception){
            println("openAppFromPlayStore error "+e)
        }
    }

    private fun initDefaultColors(){
        val color = ContextCompat.getColor(context, R.color.purple_500)
        val colorSecondary = ContextCompat.getColor(context, R.color.purple_200)

        setRatingBarColor(color, colorSecondary)

    }

    fun init():CustomRating{
        println("init of lib ")
        countLaunchApp()
        return this
    }







}