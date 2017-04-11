/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.exchange;

import java.sql.*;


/**
 *
 * @author navneet
 */
public class sqlConnection {
       /*public static void main(String[] args) {
      Connection conn = null;
        try {
 
            String dbURL = "jdbc:sqlserver://localhost\\sqlexpress";
            String user = "root";
            String pass = "dbpass";
            conn = DriverManager.getConnection(dbURL, user, pass);
            if (conn != null) {
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
       }}
   */
public static void main(String[] args) throws SQLException, ClassNotFoundException {
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
	Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=stock1;user=root;password=dbpass");
	System.out.println("test");
	Statement sta = conn.createStatement();
	String Sql = "select * from login";
	ResultSet rs = sta.executeQuery(Sql);
	while (rs.next()) {
        	System.out.println(rs.getString("userN"));
		}
	}
}
        
        

/*
while (rs.next()) {
        	System.out.println(rs.getString("userN"));
		}
*/