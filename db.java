import java.sql.*;

public class db {
	public static void main(String... args){
		for(int iterator = 0; iterator < 3; iterator++){
			try {
				Thread.sleep(20000);
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://10.0.10.3:3306/my_database","kdrzazga","password");
				Statement statement = conn.createStatement();
				statement.executeQuery("CREATE TABLE users ("+
					"id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,"+
					"firstname VARCHAR(30) NOT NULL,"+
					"lastname VARCHAR(30) NOT NULL,"+
					")");
				statement.executeQuery("INSERT INTO users VALUES ('Jan', 'Kowalski'),"+
					"('Adam', 'Nowak'),('Krzysztof', 'Drzazga')");
				ResultSet result = statement.executeQuery("SELECT * FROM users");
				while(result.next()){
					int i = result.getInt("id");
					String fn = result.getString("firstname");
					String ln = result.getString("lastname");
					System.out.println(Integer.toString(i)+" "+fn+" "+ln);
				}
				conn.close();
			} catch (ClassNotFoundException e) {
				System.out.println("Brak jdbc");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Blad dzialania");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Blad dzialania");
				e.printStackTrace();
				
			}
		}
	}
}
