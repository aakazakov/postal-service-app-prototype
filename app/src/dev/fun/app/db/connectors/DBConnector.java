package dev.fun.app.db.connectors;

import java.sql.Connection;

public interface DBConnector {
	
	Connection connect();
	
	void disconnect();
	
}
