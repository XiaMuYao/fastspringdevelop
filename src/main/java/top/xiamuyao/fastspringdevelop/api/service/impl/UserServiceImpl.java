package top.xiamuyao.fastspringdevelop.api.service.impl;

import top.xiamuyao.fastspringdevelop.api.entity.User;
import top.xiamuyao.fastspringdevelop.api.mapper.UserMapper;
import top.xiamuyao.fastspringdevelop.api.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 夏沐尧
 * @since 2018-09-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
