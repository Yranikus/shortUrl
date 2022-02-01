package com.task.shortUrl.DAO;


import com.task.shortUrl.models.StatisticsEntity;
import com.task.shortUrl.models.UrlModel;
import com.task.shortUrl.models.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatisticDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public void deleteStatisticUrl(int id){
        jdbcTemplate.update("DELETE FROM STATISTIC WHERE linkid=?", id);
    }

    public List<StatisticsEntity> findByUrlId(int id){
        return jdbcTemplate.query("SELECT * FROM STATISTIC WHERE linkid=?", new Object[]{id}, new BeanPropertyRowMapper<>(StatisticsEntity.class));
    }

    public void save(StatisticsEntity statisticsEntity){
        jdbcTemplate.update("INSERT INTO STATISTIC(username, date, linkid) VALUES(?,?,?)", statisticsEntity.getUsername(),
                statisticsEntity.getDate(),statisticsEntity.getLinkId());
    }
}
