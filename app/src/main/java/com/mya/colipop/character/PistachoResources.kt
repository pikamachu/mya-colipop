package com.mya.colipop.character

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory

import com.mya.colipop.R
import com.mya.colipop.ResourceUtils

object PistachoResources {

    private val TAG = "ColiPop"

    // Pistacho baseline sizes
    private val DEFAULT_SURFACE_WIDTH = 800
    private val DEFAULT_WIDTH = 150
    private val DEFAULT_HEIGHT = 125
    private val DEFAULT_PIXEL_MOVE = 0

    // Pistacho sizes
    var WIDTH = DEFAULT_WIDTH
    var HEIGHT = DEFAULT_HEIGHT
    var PIXEL_MOVE = DEFAULT_PIXEL_MOVE

    // Pistacho graphics
    lateinit var CARA_GRAPHICS_BITMAP: Array<Bitmap>
    // OJO! la logintud de esta array determina la longitud de todas las secuencias de animation
    var CARA_ANIMATION_SEQUENCE = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

    lateinit var OJOS_GRAPHICS_BITMAP: Array<Bitmap>
    var OJOS_ANIMATION_SEQUENCE = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 1, 1, 1, 1, 0, 0, 0, 0)

    lateinit var BOCA_GRAPHICS_BITMAP: Array<Bitmap>
    var BOCA_ANIMATION_SEQUENCE = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0)

    lateinit var BIGOTES_GRAPHICS_BITMAP: Array<Bitmap>
    var BIGOTES_ANIMATION_SEQUENCE = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0)

    fun initializeGraphics(resources: Resources) {
        CARA_GRAPHICS_BITMAP = arrayOf(BitmapFactory.decodeResource(resources, R.drawable.pistacho_cara))

        OJOS_GRAPHICS_BITMAP = arrayOf(BitmapFactory.decodeResource(resources, R.drawable.pistacho_ojos))

        BOCA_GRAPHICS_BITMAP = arrayOf(BitmapFactory.decodeResource(resources, R.drawable.pistacho_boca))

        BIGOTES_GRAPHICS_BITMAP = arrayOf(BitmapFactory.decodeResource(resources, R.drawable.pistacho_bigotes))

    }

    fun resizeGraphics(surfaceWidth: Int, surfaceHeight: Int) {
        //Log.d(TAG, "Surface resize: width = " + surfaceWidth + ", height = " + surfaceHeight);

        // Calculatemos el refactor index ( siempre en funcion del width ?? )
        var refactorIndex = surfaceWidth.toFloat()
        refactorIndex /= DEFAULT_SURFACE_WIDTH.toFloat()
        // Prevencin de cosas raras
        if (refactorIndex == 0f) {
            refactorIndex = 1f
        }

        // Cogemos el valor por debajo
        val width = java.lang.Float.valueOf(DEFAULT_WIDTH * refactorIndex).toInt()
        val height = java.lang.Float.valueOf(DEFAULT_HEIGHT * refactorIndex).toInt()
        val pixel_move = java.lang.Float.valueOf(DEFAULT_PIXEL_MOVE * refactorIndex).toInt()

        WIDTH = width
        HEIGHT = height
        PIXEL_MOVE = pixel_move

        var i = 0
        for (bitmap in CARA_GRAPHICS_BITMAP) {
            CARA_GRAPHICS_BITMAP[i] = Bitmap.createScaledBitmap(bitmap, width, height, true)
            i++
        }

        i = 0
        for (bitmap in OJOS_GRAPHICS_BITMAP) {
            OJOS_GRAPHICS_BITMAP[i] = Bitmap.createScaledBitmap(bitmap, width, height, true)
            i++
        }

        i = 0
        for (bitmap in BOCA_GRAPHICS_BITMAP) {
            BOCA_GRAPHICS_BITMAP[i] = Bitmap.createScaledBitmap(bitmap, width, height, true)
            i++
        }

        i = 0
        for (bitmap in BIGOTES_GRAPHICS_BITMAP) {
            BIGOTES_GRAPHICS_BITMAP[i] = Bitmap.createScaledBitmap(bitmap, width, height, true)
            i++
        }
    }

    fun destroy() {
        ResourceUtils.recycleBitmaps(CARA_GRAPHICS_BITMAP)
        ResourceUtils.recycleBitmaps(OJOS_GRAPHICS_BITMAP)
        ResourceUtils.recycleBitmaps(BOCA_GRAPHICS_BITMAP)
        ResourceUtils.recycleBitmaps(BIGOTES_GRAPHICS_BITMAP)
    }
}
