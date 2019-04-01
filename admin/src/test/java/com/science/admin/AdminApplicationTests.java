package com.science.admin;

import com.science.admin.mapper.ProjectMapper;
import com.science.admin.model.Person;
import com.science.admin.model.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminApplicationTests {

    @Autowired
    private ProjectMapper projectMapper;

    @Test
    public void contextLoads() {




    }

}
