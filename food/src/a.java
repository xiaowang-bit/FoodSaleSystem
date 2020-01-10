import com.hubu.mapper.UserMapper;
import com.hubu.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class a {
    @Autowired
    private  UserMapper qo;

    public List<User> queryUser(){
        return qo.queryOrder();
    }
    public static void main(String[] args) {
    }
}
