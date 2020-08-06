package cn.wf.dubboprovider.service;

import cn.wf.dubboapi.api.IUserService;
import cn.wf.dubboprovider.entity.User;
import cn.wf.dubboprovider.mapper.UserMapper;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service(version = "1.2",retries = 1)
public class UserService  implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<String> selectUsername() {
        IPage<User> userPage = userMapper.selectPage(new Page<User>(1, 5), null);
        List<User> userList = userPage.getRecords();
        userList.forEach(System.out::println);

        return userList.stream().map(o->o.getName()).collect(Collectors.toList());
    }
}
