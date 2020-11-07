package io.github.anandpc.mathopslib

import android.app.Activity
import android.content.Intent
import android.os.Bundle


class MathOpsImpl : MathOps {

    override fun performOps(activity: Activity, bundle: Bundle) {
        val intent = Intent()
        intent.setClassName("com.example.B", "com.example.B.ActivityB")
        activity.startActivityFromChild(activity, intent, 100)
    }
}