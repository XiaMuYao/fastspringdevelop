package com.confluence.fast.api.entity

import com.baomidou.mybatisplus.extension.activerecord.Model
import lombok.Data
import lombok.EqualsAndHashCode
import lombok.ToString
import lombok.experimental.Accessors
import java.io.Serializable

/**
 *
 *
 * 用户表
 *
 *
 * @author XiaMuYao
 * @since 2020-02-06
 */
@EqualsAndHashCode(callSuper = false)
class User : Serializable , Model<User>(){
    var id: String? = null

    /**
     * 用户昵称
     */
    var name: String? = null

    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                "}"
    }
}