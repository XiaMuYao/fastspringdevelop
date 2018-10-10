package top.xiamuyao.fastspringdevelop.api.service.impl;

import top.xiamuyao.fastspringdevelop.api.entity.Address;
import top.xiamuyao.fastspringdevelop.api.mapper.AddressMapper;
import top.xiamuyao.fastspringdevelop.api.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 夏沐尧
 * @since 2018-09-25
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

}
