package top.xiamuyao.fastspringdevelop.api.mapper;

import top.xiamuyao.fastspringdevelop.api.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 夏沐尧
 * @since 2018-12-16
 */
public interface UserMapper extends BaseMapper<User> {

    User selectOneByRegisterCode(String registerCode);

}
