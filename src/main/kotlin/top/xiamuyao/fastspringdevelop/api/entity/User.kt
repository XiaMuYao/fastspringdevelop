package top.xiamuyao.fastspringdevelop.api.entity

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
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ToString
class User : Serializable, Model<User>() {
    private val id: String? = null
    /**
     * 用户昵称
     */
    var name: String? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}