/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: SpringbootApplication
 * Author:   94hai
 * Date:     2018/10/5 12:13
 * Description: 启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 〈一句话功能简述〉<br> 
 * 〈启动类〉
 *
 * @author 94hai
 * @create 2018/10/5
 * @since 1.0.0
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}