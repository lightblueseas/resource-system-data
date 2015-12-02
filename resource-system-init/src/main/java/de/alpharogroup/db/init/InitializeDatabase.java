package de.alpharogroup.db.init;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import de.alpharogroup.resource.system.db.init.DatabaseInitialization;
import de.alpharogroup.resourcebundle.properties.PropertiesExtensions;

/**
 * The Class {@link InitializeDatabase} initialize the specific database.
 */
public class InitializeDatabase {

	/**
	 * @param args
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void main(final String[] args) throws ClassNotFoundException,
			SQLException, IOException {
		Properties dbProperties = PropertiesExtensions.loadProperties("jdbc.properties");
		new DatabaseInitialization(dbProperties).initializeDatabase();
	}

}