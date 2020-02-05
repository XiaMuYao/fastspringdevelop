package com.confluence.fast.config

import com.alibaba.fastjson.serializer.SerializerFeature
import com.alibaba.fastjson.support.config.FastJsonConfig
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
import java.nio.charset.Charset
import java.util.*

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期：2018/9/16
 * 描    述：
 * 修订历史：
 * ================================================
 */
@Configuration
class FastJsonConfigByMe : WebMvcConfigurationSupport() {
    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>?>) {
        val converter = FastJsonHttpMessageConverter()
        val config = FastJsonConfig()
        config.setSerializerFeatures( //保留map空的字段
                SerializerFeature.WriteMapNullValue,  // 将String类型的NULL转化为""
                SerializerFeature.WriteNullStringAsEmpty,  // 将Number类型的NULL转化为0
                SerializerFeature.WriteNullNumberAsZero,  // 将List类型的NULL转成[]
                SerializerFeature.WriteNullListAsEmpty,  // 将Boolean类型的NULL转化为false
                SerializerFeature.WriteNullBooleanAsFalse,  // 避免循环引用
                SerializerFeature.DisableCircularReferenceDetect)
        converter.setFastJsonConfig(config)
        converter.setDefaultCharset(Charset.forName("UTF-8"))
        val mediaTypeList: MutableList<MediaType> = ArrayList()
        // 解决中文乱码问题，相当于在Controller上的@RequestMapping中加了个属性produces = "application/json"
        mediaTypeList.add(MediaType.APPLICATION_JSON)
        converter.setSupportedMediaTypes(mediaTypeList)
        converters.add(converter)
    }
}