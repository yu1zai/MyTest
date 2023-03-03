package org.test.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.test.bean.Section;
import org.test.dao.SectionDao;
import org.test.util.BaseDao;
import org.test.util.BaseDaoInterface;

import java.sql.SQLException;
import java.util.List;

public class SectionDaoImpl extends BaseDao implements SectionDao {
    @Override
    public List<Section> findAll() throws SQLException {
        return queryRunner.query("select * from bbssection", new BeanListHandler<>(Section.class));
    }
    @Override
    public Section findById(Integer id) throws SQLException {
        return queryRunner.query("select * from bbssection where SID = ?", new BeanHandler<>(Section.class), id);
    }
    @Override
    public void save(Section section) throws SQLException {
        queryRunner.update("insert into bbssection values (?, ?, ?, ?, ?, ?)",
                section.getSID(), section.getSName(), section.getSMasterID(), section.getSStatement(), section.getSClickCount(), section.getSTopicCount());
    }
    @Override
    public void updateById(Section section) throws SQLException {
        queryRunner.update("update bbssection set SStatement = ?, SClickCount = ? where SID = ?", section.getSStatement(), section.getSClickCount(), section.getSID());
    }
    @Override
    public void deleteById(Integer id) throws SQLException {
        queryRunner.update("delete from bbssection where SID = ?", id);
    }
    @Override
    public List<Section> page(Integer pageNumber) throws SQLException {
        return queryRunner.query("select * from bbssection limit ?, ?", new BeanListHandler<>(Section.class), (pageNumber - 1) * pageSize, pageSize);
    }
    @Override
    public Integer pageRcord() throws SQLException {
        return queryRunner.query("select count(*) from bbssection", new ScalarHandler<Long>()).intValue();
    }
}
