package com.route.myapplication.utils

import android.view.View
import kotlin.math.cos
import kotlin.math.sin

object ImageRotation {
     fun startOrbitAnimation(centerView: View, orbitView: View, angleDegrees: Float) {
//        val animator = ValueAnimator.ofFloat(0f, 360f)
//        animator.duration = 4000L
//        animator.repeatCount = ValueAnimator.INFINITE
//        animator.interpolator = LinearInterpolator()
//         val radius = (centerView.width / 2f) + (orbitView.width / 2f)
//         animator.addUpdateListener { animation ->
//            val angle = animation.animatedValue as Float
//            val radians = Math.toRadians(angle.toDouble())
//
//            val centerX = centerView.x + centerView.width / 2f - orbitView.width / 2f
//            val centerY = centerView.y + centerView.height / 2f - orbitView.height / 2f
//
//            val x = (centerX + radius * cos(radians)).toFloat()
//            val y = (centerY + radius * sin(radians)).toFloat()
//
//            orbitView.x = x
//            orbitView.y = y
//        }
         val radius = (centerView.width / 2f) + (orbitView.width / 2f)

         val radians = Math.toRadians(angleDegrees.toDouble())

         // Center position of centerView
         val centerX = centerView.x + centerView.width / 2f - orbitView.width / 2f
         val centerY = centerView.y + centerView.height / 2f - orbitView.height / 2f

         // New X, Y using angle and radius
         val newX = (centerX + radius * cos(radians)).toFloat()
         val newY = (centerY + radius * sin(radians)).toFloat()

         orbitView.x = newX
         orbitView.y = newY
//        animator.start()
    }
}