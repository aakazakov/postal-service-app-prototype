package dev.fun.app.common.dbconnectors;

public class SQLiteConnetorFactory implements DBConnectorFactory {

	@Override
	public DBConnector create() {
		return new SQLiteConnector();
	}

}
