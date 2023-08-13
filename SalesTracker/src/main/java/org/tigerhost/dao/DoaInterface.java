package org.tigerhost.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tigerhost.model.Menu;

import java.util.List;

public interface DoaInterface<T> {
	Logger log = LogManager.getLogger(Menu.class);
	List<T> listAll();
	void add(T t);
	void delete(int t);
}// end DoaInterface
