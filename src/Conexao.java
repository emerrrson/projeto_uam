import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Classe simples que centraliza a conexão com o banco.
 * Mantenha o URL / usuário / senha conforme seu XAMPP.
 * Se o root não tem senha, deixe PASSWORD = "".
 */
public class Conexao {

    // URL do banco (ajuste timezone/useSSL conforme sua versão do MySQL/MariaDB)
    private static final String URL = "jdbc:mysql://localhost:3306/projeto_java?useSSL=false&serverTimezone=UTC";

    // usuário e senha do MySQL (padrão XAMPP: root sem senha)
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    // Método que retorna uma Connection — use try-with-resources na chamada
    public static Connection getConnection() throws SQLException {
        // DriverManager vai procurar o driver se o .jar estiver no classpath na hora de executar
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}