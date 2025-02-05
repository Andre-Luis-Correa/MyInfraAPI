package unioeste.apoio.bd;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    public Connection getConexaoBD() throws Exception {
        InitialContext context = new InitialContext();
        DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/irrf");
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new Exception(e.getMessage());
        }
    }

//    public Connection getConexaoBD() throws Exception {
//        String url = System.getenv("DB_URL");
//        String usuario = System.getenv("DB_USER");
//        String senha = System.getenv("DB_PASSWORD");
//        String driver = System.getenv("DB_DRIVER");
//
//        if (url == null || usuario == null || senha == null || driver == null) {
//            throw new Exception("Variáveis de ambiente do banco de dados não estão configuradas corretamente.");
//        }
//
//        try {
//            Class.forName(driver);
//            return DriverManager.getConnection(url, usuario, senha);
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new Exception("Erro ao conectar ao banco de dados: " + e.getMessage());
//        }
//    }
}
