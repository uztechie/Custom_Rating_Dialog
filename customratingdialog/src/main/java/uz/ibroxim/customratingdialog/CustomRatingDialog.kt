package uz.ibroxim.customratingdialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView


class CustomRatingDialog(context:Context, private val callback:CustomRatingDialogCallback):Dialog(context, R.style.AlertDialogTheme) {


    private lateinit var parentLayout:LinearLayout
    private lateinit var ratingBar:RatingBar
    private lateinit var tvTitle:TextView
    private lateinit var tvMessage:TextView

    private lateinit var btnDismiss:ImageView
    private lateinit var btnLater:TextView
    private lateinit var btnRateNow:TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCancelable(false)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.dialog_rating)
        println("CustomRatingDialog onCreate ")

        parentLayout = findViewById(R.id.dialog_rate_parent_layout)
        ratingBar = findViewById(R.id.dialog_rate_rating_bar)
        tvTitle = findViewById(R.id.dialog_rate_title)
        tvMessage = findViewById(R.id.dialog_rate_message)
        btnDismiss = findViewById<ImageView>(R.id.dialog_rate_btn_close)
        btnLater = findViewById<TextView>(R.id.dialog_rate_tv_later)
        btnRateNow = findViewById<TextView>(R.id.dialog_rate_tv_rate)

        btnDismiss.setOnClickListener {
            dismiss()
            callback.onClickNeverShow()
        }

        btnLater.setOnClickListener {
            dismiss()
            callback.onClickLater()
        }

        btnRateNow.setOnClickListener {
            dismiss()
            callback.onClickRate()
        }

    }


    fun setTitle(title:String){
        tvTitle.text = title
    }
    fun setMessage(message:String){
        tvMessage.text = message
    }
    fun setRatingBarColor(color:Int, colorSecondary:Int){
        try {
            val stars = ratingBar.progressDrawable as LayerDrawable
            stars.getDrawable(2).setColorFilter(
                color,
                PorterDuff.Mode.SRC_ATOP
            )
            stars.getDrawable(1).setColorFilter(
                colorSecondary,
                PorterDuff.Mode.SRC_ATOP
            )
            stars.getDrawable(0).setColorFilter(
                colorSecondary,
                PorterDuff.Mode.SRC_ATOP
            )
        }catch (e:Exception){
            println("setRatingBarColor error $e")
        }




    }
    fun setPositiveButtonText(text:String){
        btnRateNow.text = text
    }
    fun setNegativeButtonText(text:String){
        btnLater.text = text
    }
    fun setTitleColor(color: Int){
        tvTitle.setTextColor(color)
    }
    fun setMessageColor(color: Int){
        tvMessage.setTextColor(color)
    }
    fun setPositiveButtonColor(color: Int){
        btnRateNow.setTextColor(color)
    }
    fun setNegativeButtonColor(color: Int){
        btnLater.setTextColor(color)
    }




    interface CustomRatingDialogCallback{
        fun onClickLater()
        fun onClickRate()
        fun onClickNeverShow()
    }

}