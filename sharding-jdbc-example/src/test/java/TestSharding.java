import cn.hubaoquan.mysqltest.RunBoot;
import cn.hubaoquan.mysqltest.entity.User;
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

    @Test
    //@Transactional(dontRollbackOn = RuntimeException.class)
    public void testAdd() {
        for (int i = 1; i < 100; i++) {
            User user = new User();
            user.setId(i);
            user.setName("胡宝全" + i);
            user.setAge(26);
            user.setCity("西安");
            userRepository.save(user);
        }
    }
}
