//package top.xiamuyao.fastspringdevelop.task;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * ================================================
// * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
// * 版    本：1.0
// * 创建日期： 2018/12/19
// * 描    述：定时任务
// * 修订历史：https://blog.csdn.net/zhaoyanjun6/article/details/80657415
// * ================================================
// */
//@Component
//public class ScheduledTasks {
//
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//
//    @Scheduled(cron = "*/5 * * * * *")
//    public void reportCurrentTime() {
//        System.out.println("现在时间：" + dateFormat.format(new Date()));
//    }
//
//}