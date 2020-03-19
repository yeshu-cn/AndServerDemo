/*
 *
 *  * Copyright (c) 2018 yeshu. All Rights Reserved.
 *
 */

package work.yeshu.demo.andserverdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.yanzhenjie.andserver.AndServer
import com.yanzhenjie.andserver.Server
import com.yanzhenjie.andserver.Server.ServerListener
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var server: Server

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        server = AndServer.webServer(this)
            .port(8080)
            .timeout(10, TimeUnit.SECONDS)
            .listener(object : ServerListener {
                override fun onException(e: Exception?) {
                }

                override fun onStarted() {
                    tv_status.text = "${tv_status.text}\n server start"
                }

                override fun onStopped() {
                    tv_status.text = "${tv_status.text}\n server stop!!"
                }
            })
            .build()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (server.isRunning) {
            server.shutdown()
        }
    }

    fun onButtonClick(view: View) {
        if (server.isRunning) {
            server.shutdown()
            button.text = "start"
        } else {
            server.startup()
            button.text = "stop"
        }
    }
}
