package unioeste.apoio.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    public Connection getConexaoComBD() throws Exception {
        String url = System.getenv("DB_URL");
        String usuario = System.getenv("DB_USER");
        String senha = System.getenv("DB_PASSWORD");
        String driver = "org.postgresql.Driver";

        if (url == null || usuario == null || senha == null) {
            throw new Exception("Variáveis de ambiente para conexão com o banco de dados não estão definidas.");
        }

        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        ConexaoBD conexaoBD = new ConexaoBD();

        try (Connection conn = conexaoBD.getConexaoComBD()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Conexão com banco de dados estabelecida com sucesso!");
            } else {
                System.out.println("Não foi possível estabelecer a conexão com o banco de dados.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
