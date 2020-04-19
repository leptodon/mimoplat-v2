package ru.mimobaka.mimoplat_v3.utills

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.graphics.drawable.VectorDrawable
import androidx.core.content.ContextCompat
import ru.mimobaka.mimoplat_v3.App

object AndroidUtils {
    fun getString(resString: Int): String = App.context.getString(resString)
    fun getInteger(resString: Int): String = App.context.getString(resString)
    fun getColor(resColor: Int): Int = ContextCompat.getColor(App.context, resColor)
    fun getDrawable(resDrawable: Int): Drawable? = ContextCompat.getDrawable(App.context, resDrawable)

    fun getBitmap(vectorDrawable: VectorDrawable): Bitmap {
        var bitmap : Bitmap = Bitmap.createBitmap(vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        var canvas: Canvas = Canvas(bitmap)
        vectorDrawable.setBounds(0, 0, canvas.width, canvas.height)
        vectorDrawable.draw(canvas)
        return bitmap
    }

}