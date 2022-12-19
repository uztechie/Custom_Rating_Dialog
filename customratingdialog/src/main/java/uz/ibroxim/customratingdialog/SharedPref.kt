package uz.ibroxim.customratingdialog

import com.chibatching.kotpref.KotprefModel

object SharedPref:KotprefModel() {

    var showDialog by booleanPref(true)
    var launchCount by intPref(0)

}