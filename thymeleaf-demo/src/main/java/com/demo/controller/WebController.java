/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: WebController
 * Author:   94hai
 * Date:     2018/10/5 11:09
 * Description: web入口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈web入口〉
 *
 * @author 94hai
 * @create 2018/10/5
 * @since 1.0.0
 */
@Controller
public class WebController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("hello", "测试");
        return "hello";
    }
}