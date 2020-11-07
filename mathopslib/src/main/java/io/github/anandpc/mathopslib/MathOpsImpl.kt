package io.github.anandpc.mathopslib

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.widget.Toast


class MathOpsImpl : MathOps {

    override fun launchTestApp2(activity: Activity, bundle: Bundle) {

        val fmIntent: Intent? =
            activity.packageManager.getLaunchIntentForPackage("io.github.anandpc.testapp2")
        fmIntent?.flags = 0
        fmIntent?.putExtras(bundle)
        try {
            activity.startActivityForResult(fmIntent, 100)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(activity, "Activity not found", Toast.LENGTH_SHORT).show()
        }
    }
}