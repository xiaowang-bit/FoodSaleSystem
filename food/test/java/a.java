import com.hubu.controller.UserController;
import com.hubu.mapper.UserMapper;
import com.hubu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:springmvc.xml")
public class a {
    @Autowired
    private UserMapper um;

    @Autowired
    private UserService service;

    @Autowired
    private UserController userController;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void b(){
        System.out.println(applicationContext.containsBean("userMapper"));
        System.out.println(um.queryOrder());
        System.out.println(service.queryUser());
        System.out.println(userController.userquery());
    }
}
