package com.mtx;

import com.mtx.entity.User;
import com.mtx.mapper.SysMenuMapper;
import com.mtx.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    //测试selectPermsByUserId是否可以查到数据  （以后多写一写）
    @Test
    public void testSelectPermsByUserId(){
        List<String> list = sysMenuMapper.selectPermsByUserId(1L);
        System.out.println(list);
    }


    //测试加密及解密
    @Test
    public void TestBCryptPasswordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //测试加密
        String encode = passwordEncoder.encode("1234");
        String encode1 = passwordEncoder.encode("1234");
        System.out.println(encode);
        System.out.println(encode1);

        //测试解密
        System.out.println(passwordEncoder.matches("1234", "$2a$10$G0Aw8JP0uxLPjQQ.Wg1mBuVN25SnZfQvnJ2gCBULb6kzUm5nrlWAy"));
    }

    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
