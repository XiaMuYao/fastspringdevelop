package top.xiamuyao.fastspringdevelop.util;


import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

import javax.validation.Payload;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期：2018/10/10
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class JpushUtil {
    /**
     * 推送Android 通过RegistrationId
     *
     * @param registrationList
     */
    public static void jpushAndroidWithRegistration(List<String> registrationList) {

        String appKey = "7d3b02dcee98d8c4838bf4ac";
        String masterSecret = "68a97711a9abee12699c66a8";

        JPushClient mJPushClient = new JPushClient(masterSecret, appKey);

        PushPayload mPushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.registrationId(registrationList))
                .setNotification(Notification.android("收到新异常提醒！", "异常提醒！", null))
                .build();

        try {
            mJPushClient.sendPush(mPushPayload);
        } catch (APIConnectionException | APIRequestException mE) {
            mE.printStackTrace();
        }

    }

    public static void main(String[] args) {
        jpushAndroidWithRegistration(Arrays.asList("160a3797c82cf9b2772", "1a0018970a8ed267e3a", "170976fa8aa539fa299"));
    }

}
