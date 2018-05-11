package com.vaishnavi.database.dao;

import java.util.List;

import com.vaishnavi.database.model.Template;

public interface DatabaseDAO {
	
	public void addDataToDatabase(List<Template> lst);
	
	public List<Template> getAll();
	
	public void removeSelectedRows(String[] rows);
	
}
