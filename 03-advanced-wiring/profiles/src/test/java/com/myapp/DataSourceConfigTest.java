package com.myapp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by yohahn on 2/21/16.
 */
public class DataSourceConfigTest {

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = DataSourceConfig.class)
    @ActiveProfiles("dev")
    public static class DevDataSourceTest {
        @Autowired
        private DataSource dataSource;

        @Test
        public void shouldBeEmbeddedDataSource() {
            Assert.assertNotNull(dataSource);
            JdbcTemplate jdbc = new JdbcTemplate(dataSource);
            List<String> results = jdbc.query("select id, name from Things", new RowMapper<String>() {
                public String mapRow(ResultSet rs, int i) throws SQLException {
                    return rs.getLong("id") + ":" + rs.getString("name");
                }
            });

            Assert.assertEquals(1, results.size());
            Assert.assertEquals("1:A", results.get(0));
        }
    }

    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = DataSourceConfig.class)
    @ActiveProfiles("prod")
    public static class ProdDataSourceTest {
        @Autowired
        private DataSource dataSource;

        @Test
        public void shouldBeJndiDatasource() {
            // should be null, because there isn't a datasource configured in JNDI
            Assert.assertNull(dataSource);
        }
    }
}
