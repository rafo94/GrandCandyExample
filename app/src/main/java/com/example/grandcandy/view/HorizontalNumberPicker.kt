package com.example.grandcandy.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.grandcandy.R

class HorizontalNumberPicker(context: Context?, attrs: AttributeSet?) :
    LinearLayout(context, attrs) {

    private val numberTv: TextView?
    var min = 0
    var max = 0
    private var listener: OnValueChangeListener? =
        null

    /***
     * HANDLERS
     */
    private inner class AddHandler(val diff: Int) : OnClickListener {
        override fun onClick(v: View) {
            var newValue = value + diff
            if (newValue < min) {
                newValue = min
            } else if (newValue > max) {
                newValue = max
            }
            listener!!.changeValueData(newValue)
            numberTv!!.text = newValue.toString()
            if (newValue == 0) {
                numberTv.text = "5"
            }
        }

    }

    /***
     * GETTERS & SETTERS
     */
    var value: Int
        get() {
            if (numberTv != null) {
                try {
                    val value = numberTv.text.toString()
                    return value.toInt()
                } catch (ex: NumberFormatException) {
                    Log.e("HorizontalNumberPicker", ex.toString())
                }
            }
            return 0
        }
        set(value) {
            if (numberTv != null) {
                numberTv.text = value.toString()
            }
        }

    fun setListener(listener: OnValueChangeListener?) {
        this.listener = listener
    }

    interface OnValueChangeListener {
        fun changeValueData(value: Int)
    }

    init {
        View.inflate(context, R.layout.number_picker_custom_layout, this)
        numberTv = findViewById(R.id.display)
        val btnLess = findViewById<TextView>(R.id.decrement)
        btnLess.setOnClickListener(AddHandler(-1))
        val btnMore = findViewById<TextView>(R.id.increment)
        btnMore.setOnClickListener(AddHandler(1))
    }
}