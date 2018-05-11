package com.vaishnavi.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.vaishnavi.database.model.Template;

public class DatabaseDAOImpl implements DatabaseDAO {

	DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addDataToDatabase(final List<Template> lst) {
		// change query
		String sql = "insert into user values (?, ?, ?, ?, ?, ?, ?)";

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Template template = lst.get(i);
				// change elements
				ps.setString(1, template.getFirstname());
				ps.setString(2, template.getLastname());
				ps.setString(3, template.getEmail());
				ps.setString(4, template.getPassword());
				ps.setString(5, template.getState());
				ps.setString(6, template.getCountry());
				ps.setInt(7, template.getAge());
			}

			@Override
			public int getBatchSize() {
				return lst.size();
			}
		});
	}

	@Override
	public List<Template> getAll() {
		// change query
		// String query = "SELECT FIRSTNAME, LASTNAME, EMAIL, PASSWORD, STATE, COUNTRY,
		// AGE FROM USER";
		String query = "select * from user";
		return jdbcTemplate.query(query, new RowMapper<Template>() {

			@Override
			public Template mapRow(ResultSet rs, int arg1) throws SQLException {
				return new Template(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}
		});
	}

	@Override
	public void removeSelectedRows(String[] rows) {
		String query = "delete from user where email=?";
		for (String row : rows) {
			jdbcTemplate.update(query, row);
		}
	}

}
