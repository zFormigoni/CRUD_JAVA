package br.com.java_project.connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {  
	//nome do usuario
	public static final String username="postgres";
	
	//senha do banco de dados
	public static final String password="9411";	
	
	// caminho pro banco de dados
	public static final String DB_URL ="jdbc:postgresql://localhost:5433/projeto_java";
    
	//Conexão com o banco de dados
	public static Connection createConnectionToPostgresql() throws Exception {
		//Faz com q a classe seja carregada pelo JVM
		Class.forName("org.postgresql.Driver");
		//Cria conexão com o banco de dados
		Connection connection = DriverManager.getConnection(DB_URL, username,password);
		 
		 return connection;  
	}		 
	 
		 
    public static void main(String[] args) throws Exception {
    	
    	//Recuperar uma conexão com o banco de dados
    	Connection con = createConnectionToPostgresql();
    	
    	if (con != null) {
            System.out.println("Connection OK");
            con.close();
        }
	}
}
