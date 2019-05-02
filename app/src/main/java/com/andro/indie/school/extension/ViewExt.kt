package com.andro.indie.school.extension

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.view.View
import android.view.ViewTreeObserver
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.app.ActivityCompat

/**
 * @author herisulistiyanto
 * @suppress
 */
const val CLIP_LABEL = "CLIP_LABEL"

/**
 * [showKeyboard] Ext Func to show soft keyboard from current view token
 * @author herisulistiyanto
 */
fun View.showKeyboard() {
    val imm: InputMethodManager by lazy { this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager }
    this.requestFocus()
    imm.showSoftInput(this, 0)
}

/**
 * [hideKeyboard] Ext Func to hide soft keyboard from current view token
 * @author herisulistiyanto
 */
fun View.hideKeyboard() {
    val imm: InputMethodManager by lazy { this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager }
    imm.hideSoftInputFromWindow(windowToken, 0)
}

/**
 * [goneIf] Ext Func to set visibility of View based on conditional [condition]
 * if [condition] true, then current view will be [View.GONE] else [View.VISIBLE]
 * @author herisulistiyanto
 * @param condition boolean value to toggle visibility state between VISIBLE or GONE
 */
fun View.goneIf(condition: Boolean) {
    if (condition) this.visibility = View.GONE else this.visibility = View.VISIBLE
}

/**
 * [invisibleIf] Ext Func to set visibility of View based on conditional [condition]
 * if [condition] true, then current view will be [View.INVISIBLE] else [View.VISIBLE]
 * @author herisulistiyanto
 * @param condition boolean value to toggle visibility state between VISIBLE or INVISIBLE
 */
fun View.invisibleIf(condition: Boolean) {
    if (condition) {
        this.visibility = View.INVISIBLE
        this.isEnabled = false
    } else {
        this.visibility = View.VISIBLE
        this.isEnabled = true
    }
}

/**
 * [blockTouchScreen] Ext Func to block touch interaction based on current Window token
 * @author herisulistiyanto
 */
fun Window.blockTouchScreen() {
    this.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
}

/**
 * [unblockTouchScreen] Ext Func to unblock touch interaction based on current Window token
 * @author herisulistiyanto
 */
fun Window.unblockTouchScreen() {
    this.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
}

/**
 * [scheduleStartPostponedTransition] use this to start postponed enter transition
 * @param activity take param current activity
 */
fun View.scheduleStartPostponedTransition(activity: Activity) {
    this.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    this@scheduleStartPostponedTransition.viewTreeObserver.removeOnPreDrawListener(this)
                    ActivityCompat.startPostponedEnterTransition(activity)
                    return true
                }
            })
}

/**
 * [copyText] Ext Func to handle copy text to clipboard
 * @author herisulistiyanto
 * @param context take current context
 */
fun TextView.copyText(context: Context) {
    val clipManager = context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?
    val clipData = ClipData.newPlainText(CLIP_LABEL, this.text)
    clipManager?.let {
        it.primaryClip = clipData
    }
}

/**
 * [copyTextNumberOnly] Ext Func to handle copy text to clipboard BUT only the numeric format
 * @author herisulistiyanto
 * @param context take current context
 */
fun TextView.copyTextNumberOnly(context: Context) {
    val clipManager = context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?
    val clipData = ClipData.newPlainText(CLIP_LABEL, this.text.replace("\\D".toRegex(), ""))
    clipManager?.let {
        it.primaryClip = clipData
    }
}