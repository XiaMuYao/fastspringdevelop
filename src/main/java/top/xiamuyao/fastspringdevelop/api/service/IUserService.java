package top.xiamuyao.fastspringdevelop.api.service;

import top.xiamuyao.fastspringdevelop.api.entity.User;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 夏沐尧
 * @since 2018-12-16
 */
public interface IUserService extends IService<User> {
    User selectOneByRegisterCode(String registerCode);
}
