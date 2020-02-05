package top.xiamuyao.fastspringdevelop.api.service.impl;

import top.xiamuyao.fastspringdevelop.api.entity.User;
import top.xiamuyao.fastspringdevelop.api.mapper.UserMapper;
import top.xiamuyao.fastspringdevelop.api.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author XiaMuYao
 * @since 2020-02-06
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
