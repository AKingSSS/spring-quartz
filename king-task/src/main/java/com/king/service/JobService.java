package com.king.service;

import com.king.domin.User;
import com.king.persistence.UsersDao;
import com.king.utils.WordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 通过注解的形式执行定时任务
 */
@Component
public class JobService {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(JobService.class);

    public JobService() {
        logger.info("JobService创建成功");
    }

    @Autowired
    private UsersDao usersDao;

//    Cron表达式的格式：秒 分 时 日 月 周 年(可选)。
//    “?”字符：表示不确定的值
//
//    “,”字符：指定数个值
//
//    “-”字符：指定一个值的范围
//
//    “/”字符：指定一个值的增加幅度。n/m表示从n开始，每次增加m
//
//    “L”字符：用在日表示一个月中的最后一天，用在周表示该月最后一个星期X
//
//    “W”字符：指定离给定日期最近的工作日(周一到周五)
//
//    “#”字符：表示该月第几个周X。6#3表示该月第3个周五
//
//    每隔5秒执行一次：*/5 * * * * ?
//
//    每隔1分钟执行一次：0 */1 * * * ?
//
//    每天23点执行一次：0 0 23 * * ?
//
//    每天凌晨1点执行一次：0 0 1 * * ?
//
//    每月1号凌晨1点执行一次：0 0 1 1 * ?
//
//    每月最后一天23点执行一次：0 0 23 L * ?
//
//    每周星期天凌晨1点实行一次：0 0 1 ? * L
//
//    在26分、29分、33分执行一次：0 26,29,33 * * * ?
//
//    每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?
    // 每隔1秒执行一次
    @Scheduled(cron = "0/5 * *  * * ?")
    // 定时器的任务方法不能有返回值
    public void run() {
        System.out.println("每隔5s插入一条数据");
        User user = new User();
        user.setAge((int) (1 + Math.random() * (100 - 1 + 1)));
        user.setName(WordUtil.getRandomChar());
        System.out.println("age=" + user.getAge() + ";name=" + user.getName());
        try {
            usersDao.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
