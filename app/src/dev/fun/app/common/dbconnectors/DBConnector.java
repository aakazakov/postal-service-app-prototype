package dev.fun.app.common.dbconnectors;

import java.sql.Connection;

public interface DBConnector {
	
	Connection connect();
	
	void disconnect();
	
}
