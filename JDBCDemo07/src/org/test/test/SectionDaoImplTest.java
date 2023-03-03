package org.test.test;

import org.junit.Test;
import org.test.bean.Section;
import org.test.dao.SectionDao;
import org.test.dao.impl.SectionDaoImpl;

import java.sql.SQLException;


public class SectionDaoImplTest {

    public SectionDao sectionDao = new SectionDaoImpl();
    @Test
    public void findAll() throws SQLException {
        sectionDao.findAll().forEach(System.out::println);
    }

    @Test
    public void findById() throws SQLException{
        System.out.println(sectionDao.findById(1));
    }

    @Test
    public void save() throws SQLException{
        Section section = new Section(2, "java", 2, "1111",
                99, 10);
        sectionDao.save(section);
    }

    @Test
    public void updateById() throws SQLException{
        Section section = new Section(2, "java", 2, "21",
                1000000, 1000000);
        sectionDao.updateById(section);
    }

    @Test
    public void deleteById() throws SQLException{
        sectionDao.deleteById(2);
    }

    @Test
    public void page() throws SQLException{
        sectionDao.page(1).forEach(System.out::println);
    }

    @Test
    public void pageRcord() throws SQLException{
        System.out.println(sectionDao.pageRcord());
    }
}