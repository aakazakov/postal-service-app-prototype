package dev.fun.app.db.connectors;

public class SQLiteConnetorFactory implements DBConnectorFactory {

	@Override
	public DBConnector create() {
		return new SQLiteConnector();
	}

}
