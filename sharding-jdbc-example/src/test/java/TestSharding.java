import cn.hubaoquan.mysqltest.RunBoot;
import cn.hubaoquan.mysqltest.entity.User;
import cn.hubaoquan.mysqltest.entity.UserDetail;
import cn.hubaoquan.mysqltest.repository.UserDetailRepository;
import cn.hubaoquan.mysqltest.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunBoot.class)
public class TestSharding {

    @Resource
    private UserRepository userRepository;
    @Resource
    private UserDetailRepository userDetailRepository;

    @Test
    //@Transactional(dontRollbackOn = RuntimeException.class)
    public void testAdd() {
        for (int i = 1; i < 100; i++) {
            User user = new User();
            //user.setId(i);  //如果配置了主键策略这里设置的值自动失效
            user.setName("胡宝全" + i);
            user.setAge(26);
            user.setCity("西安");
            userRepository.save(user);

            UserDetail userDetail = new UserDetail();
            userDetail.setUserid(user.getId());
            userDetail.setCompany("公司"+i);
            userDetail.setSalary(1000.0 + i);
            userDetailRepository.save(userDetail);

        }
    }
    @Test
    public void testGet() {
        Object o= userRepository.getUserById(144820270752226L);
        Object[]  objects= (Object[]) o;
        for (Object o1:objects)
            System.out.println(o1);
    }
}
