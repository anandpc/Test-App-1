package io.github.anandpc.mathopslib

import android.app.Activity
import android.content.Intent
import android.os.Bundle


class MathOpsImpl : MathOps {

    override fun performOps(activity: Activity, bundle: Bundle) {
        val intent = Intent()
        intent.setClassName("io.github.anandpc", "io.github.anandpc.testapp2")
        activity.startActivityFromChild(activity, intent, 100)
    }
}