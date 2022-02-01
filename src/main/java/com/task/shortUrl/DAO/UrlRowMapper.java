package com.task.shortUrl.DAO;

import com.task.shortUrl.models.UrlModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UrlRowMapper implements RowMapper<UrlModel> {


    @Override
    public UrlModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        UrlModel url = new UrlModel();
        url.setId(rs.getInt("id"));
        url.setLonUrl(rs.getString("longurl"));
        url.setShorUrl(rs.getString("shorturl"));
        url.setCounter(rs.getInt("counter"));
        return url;
    }
}
