package com.task.shortUrl.DAO;

import com.task.shortUrl.models.UrlModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UrlDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void deleteUrl(int id){
        jdbcTemplate.update("DELETE FROM URL WHERE id=?", id);
    }

    public UrlModel findById(int id){
        return jdbcTemplate.query("SELECT * FROM URL WHERE id=?", new Object[]{id}, new UrlRowMapper()).stream().findAny().orElse(null);
    }

    public List<UrlModel> findAll() {
        return jdbcTemplate.query("SELECT * FROM URL", new UrlRowMapper());
    }

    public void save(UrlModel urlModel){
        jdbcTemplate.update("INSERT INTO URL(counter, longurl, shorturl) VALUES( ?, ?, ?)",urlModel.getCounter(),urlModel.getLonUrl(),urlModel.getShorUrl());
    }

    public void updateCounter(UrlModel urlModel){
        jdbcTemplate.update("UPDATE URL SET counter=? WHERE id=?", urlModel.getCounter(), urlModel.getId());
    }

    public UrlModel findByShortUrl(String url){
       return jdbcTemplate.query("SELECT * FROM URL WHERE shorturl=?", new Object[]{url}, new UrlRowMapper()).stream().findAny().orElse(null);
    }

    public UrlModel findByLongtUrl(String url){
        return jdbcTemplate.query("SELECT * FROM URL WHERE longurl=?", new Object[]{url}, new UrlRowMapper()).stream().findAny().orElse(null);
    }




}
