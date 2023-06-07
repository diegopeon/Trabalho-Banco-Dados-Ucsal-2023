package trabalhoBanco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	// Função para selecionar dados da tabela livro
		public static void selecionarLivro(Connection conn) throws SQLException {
		    
			// Selecionar todos os dados da tabela livro
		    String selecionarLivro = "SELECT * FROM livro";
		    Statement statementLivro = conn.createStatement();
		    ResultSet result = statementLivro.executeQuery(selecionarLivro);
		    
		    // Resultado da query e exibe os dados selecionados
		    while (result.next()) {
		    	int cod_livro = result.getInt("cod_livro");
		        String autor = result.getString("autor");
		        String titulo = result.getString("titulo");

		        System.out.println("Dados Selecionados");
		        System.out.println("----------------------------------------------------------------------");
		        System.out.println("Codigo do Livro: " + cod_livro + " Autor: " + 
		        autor + " obra: " + titulo);
		        System.out.println("----------------------------------------------------------------------");
		    }
		}

		// Função para selecionar dados da tabela usuario
		public static void selecionaUsuario(Connection conn) throws SQLException {
		   
			// Selecionar todos os dados da tabela usuario
		    String selecionaUsuario = "SELECT * FROM usuario";
		    Statement statementUsuario = conn.createStatement();
		    ResultSet result = statementUsuario.executeQuery(selecionaUsuario);

		    //  Resultado da query e exibe os dados selecionados
		    while (result.next()) {
		    	int id = result.getInt("id");
		        String nome = result.getString("nome");
		        String email = result.getString("email");
		        int cod_livro = result.getInt("cod_livro");

		        System.out.println("Dados Selecionados");
		        System.out.println("---------------------------------------------------------------------------");
		        System.out.println("id: " + id + " Nome: " + nome + " email: " + email 
		        		+ " Codigo do Livro: " + cod_livro);
		        System.out.println("---------------------------------------------------------------------------");
		    }
		}

		// Função para realizar um JOIN entre as tabelas livro e usuario
		public static void joinDados(Connection conn) throws SQLException {
		    // Realizar o JOIN entre as tabelas livro e usuario
		    String join = "SELECT id, nome, email, usuario.cod_livro, titulo, autor, livro.cod_livro " + "FROM usuario INNER JOIN livro "
		            + "ON usuario.cod_livro = livro.cod_livro";

		    Statement statementSelect = conn.createStatement();
		    ResultSet result = statementSelect.executeQuery(join);

		    // Resultado da query e exibe os dados selecionados
		    while (result.next()) {
		    	int idSelecao = result.getInt("id");
		        String nomeSelecao = result.getString("nome");
		        String emailSelecao = result.getString("email");
		        int CodLivroUsuario = result.getInt("cod_livro");
		        String tituloSelecao = result.getString("titulo");
		        String autorSelecao = result.getString("autor");
		        int CodLivroLivro = result.getInt("cod_livro");

		        System.out.println("Dados Selecionados Pelo Join");
		        System.out.println("---------------------------------------------------------------------------------");
		        System.out.println("Tabela Usuario:");
		        System.out.println("id: " + idSelecao + " Nome: " + nomeSelecao + " Username: " + " email: " + emailSelecao
		        		+ " Codigo do Livro: " + CodLivroUsuario);
		        System.out.println("---------------------------------------------------------------------------------");
		        System.out.println("Tabela Livro");
		        System.out.println("Codigo do Livro: " + CodLivroLivro + " Titulo: " 
		        + tituloSelecao + " autor: " + autorSelecao);
		        System.out.println("---------------------------------------------------------------------------------");
		    }
		}

}
