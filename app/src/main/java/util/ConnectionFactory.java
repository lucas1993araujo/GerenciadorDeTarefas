
package util;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author Lucas
 */
public class ConnectionFactory {
    
    public static final String DRIVE = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/gerenciadordetarefas";
    public static final String USER = "root";
    public static final String PASS = "";
    
    public static Connection getConnection(){
        try{
            Class.forName(DRIVE);
            return DriverManager.getConnection(URL, USER, PASS);
        }catch(Exception ex) {
            throw new RuntimeException("Erro na conexão com o banco de dados", ex);
        }
    }
    
    public static void closeConnection(Connection connection){
        try{
            if(connection != null){
               connection.close();
            }
                    
        }catch(Exception ex){
            throw new RuntimeException("Erro na conexão com o banco de dados", ex);
        }
    }
}
