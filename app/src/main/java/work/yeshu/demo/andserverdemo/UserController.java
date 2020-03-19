/*
 *
 *  * Copyright (c) 2018 yeshu. All Rights Reserved.
 *
 */

package work.yeshu.demo.andserverdemo;

import com.yanzhenjie.andserver.annotation.GetMapping;
import com.yanzhenjie.andserver.annotation.PostMapping;
import com.yanzhenjie.andserver.annotation.RequestMapping;
import com.yanzhenjie.andserver.annotation.RequestParam;
import com.yanzhenjie.andserver.annotation.RestController;

@RestController
@RequestMapping(path = "/data")
public class UserController {
    private String cache = "";

    @PostMapping("/upload")
    String login(@RequestParam("data") String data) {
        cache = data;
        return "success";
    }

    @GetMapping("/get")
    String login() {
        return cache;
    }
}
