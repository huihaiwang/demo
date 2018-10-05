/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: WebApplication
 * Author:   94hai
 * Date:     2018/10/5 11:08
 * Description: 启动器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 〈一句话功能简述〉<br> 
 * 〈启动器〉
 *
 * @author 94hai
 * @create 2018/10/5
 * @since 1.0.0
 */
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}