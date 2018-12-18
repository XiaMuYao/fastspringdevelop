package top.xiamuyao.fastspringdevelop.api.service.impl;

import top.xiamuyao.fastspringdevelop.api.entity.User;
import top.xiamuyao.fastspringdevelop.api.mapper.UserMapper;
import top.xiamuyao.fastspringdevelop.api.service.IUserService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 夏沐尧
 * @since 2018-12-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectOneByRegisterCode(String registerCode) {
        return userMapper.selectOneByRegisterCode(registerCode);
    }
}
