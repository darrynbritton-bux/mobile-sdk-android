package com.example.example_info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.CrowdinBaseContextWrappingDelegate

class InfoActivity : AppCompatActivity() {

    /**
     * We should wrap the base context of our activities, which is better to put it
     * on BaseActivity, so that we don't have to repeat it for all activities one-by-one.
     *
     * @see CrowdinBaseContextWrappingDelegate.attachBaseContext2
     */
    override fun getDelegate() = CrowdinBaseContextWrappingDelegate(super.getDelegate())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
    }
}
