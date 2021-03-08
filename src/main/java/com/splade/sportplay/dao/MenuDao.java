package com.splade.sportplay.dao;

import com.splade.sportplay.bean.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {

    public List<MainMenu> getMainMenus();

}
