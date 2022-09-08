package com.crowdin.platform.example

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.CrowdinBaseContextWrappingDelegate
import com.crowdin.crowdin_controls.OverlayActivityContract
import com.crowdin.crowdin_controls.destroyCrowdinControl
import com.crowdin.crowdin_controls.initCrowdinControl

abstract class BaseActivity : AppCompatActivity() {

    var overlayPermissionActivityLauncher = registerForActivityResult(OverlayActivityContract()) { }

    /**
     * We should wrap the base context of our activities, which is better to put it
     * on BaseActivity, so that we don't have to repeat it for all activities one-by-one.
     *
     * @see CrowdinBaseContextWrappingDelegate.attachBaseContext2
     */
    override fun getDelegate() = CrowdinBaseContextWrappingDelegate(super.getDelegate())

    override fun onResume() {
        super.onResume()
        // Init Crowdin SDK overlay controls
        initCrowdinControl(this, overlayPermissionActivityLauncher)
    }

    override fun onPause() {
        super.onPause()
        // Destroy crowdin overlay view.
        destroyCrowdinControl(this)
    }
}

