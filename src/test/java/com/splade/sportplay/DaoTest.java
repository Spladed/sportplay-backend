package com.splade.sportplay;


import com.splade.sportplay.bean.MainMenu;
import com.splade.sportplay.bean.SubMenu;
import com.splade.sportplay.dao.MenuDao;
import com.splade.sportplay.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTest {

    @Autowired
    MenuDao menuDao;
    @Autowired
    UserDao userDao;

    @Test
    public void MenuDaoTest(){
        List<MainMenu> menuList=menuDao.getMainMenus();
        System.out.println(menuList.size());
        for (MainMenu mainMenu : menuList) {
            System.out.println(mainMenu.getTitle());
            List<SubMenu> list=mainMenu.getSlist();
            list.forEach(System.out::println);
        }
    }

}
