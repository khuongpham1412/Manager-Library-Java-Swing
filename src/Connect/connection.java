package Connect;

	import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

	public class connection {
			public static Connection openConnection() throws Exception {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String connectionURL ="jdbc:sqlserver://localhost\\SQLEXPRESS:1433;database=DoanQLTV;";
				String username="sa";
				String password="123456";
				Connection conn =DriverManager.getConnection(connectionURL, username, password);
				return conn;
				
			}

		}
 