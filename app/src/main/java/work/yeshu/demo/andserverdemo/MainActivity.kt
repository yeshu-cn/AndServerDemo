/*
 *
 *  * Copyright (c) 2018 yeshu. All Rights Reserved.
 *
 */

package work.yeshu.demo.andserverdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yanzhenjie.andserver.AndServer
import com.yanzhenjie.andserver.Server
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private lateinit var server: Server

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        server = AndServer.webServer(this).port(8080).timeout(10, TimeUnit.SECONDS).build()
        server.startup()
    }

    override fun onDestroy() {
        super.onDestroy()
        server.shutdown()
    }
}
