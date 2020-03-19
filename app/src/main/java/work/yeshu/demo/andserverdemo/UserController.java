/*
 *
 *  * Copyright (c) 2018 yeshu. All Rights Reserved.
 *
 */

package work.yeshu.demo.andserverdemo;

import com.yanzhenjie.andserver.annotation.PostMapping;
import com.yanzhenjie.andserver.annotation.RequestMapping;
import com.yanzhenjie.andserver.annotation.RequestParam;
import com.yanzhenjie.andserver.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @PostMapping("/login")
    public String login(@RequestParam("account") String account,
                        @RequestParam("password") String password) {


        return "Successful.";
    }
//
//    @GetMapping(path = "/{userId}")
//    public User info(@PathVariable("userId") String userId,
//                     @QueryParam("fields") String fields) {
//
//        return new User("guan", 66);
//    }

}
