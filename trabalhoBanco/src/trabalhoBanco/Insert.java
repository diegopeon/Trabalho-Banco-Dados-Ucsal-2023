package trabalhoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
	
	// Função para inserir dados na tabela livro
		public static void insertLivro(Connection conn) throws SQLException {
			//importação do scanner na função para fazer a aplicação ser mais personalizado e dinamico. 
			Scanner scan = new Scanner(System.in);
			
			// Dados do livro a serem inseridos
		  	System.out.println("Qual o titulo do livro?");
		    String titulo = scan.nextLine();
		    
		    System.out.println("Qual o autor do livro?");
		    String autor = scan.nextLine();
		    
		    System.out.println("Qual o valor do codigo do livro?");
		    int cod_livro = scan.nextInt();
		    

		    // Inserção de dados na tabela livro
		    String insertLivro = "INSERT INTO livro (cod_livro, titulo, autor) VALUES (?, ?, ?)";
		    PreparedStatement statementLivro = conn.prepareStatement(insertLivro);
		    statementLivro.setInt(1, cod_livro);
		    statementLivro.setString(2, titulo);
		    statementLivro.setString(3, autor);
		  

		    // Executa a query de inserção e verifica se os dados foram inseridos com sucesso
		    int dadosLivroInseridos = statementLivro.executeUpdate();

		    if (dadosLivroInseridos > 0) {
		        System.out.println("Dados da tabela Livros inseridos com sucesso!");
		       
		    } else {
		        System.out.println("Erro ao inserir os dados");
		       
		    }
		}

		// Função para inserir dados na tabela usuario
		public static void insertUsuario(Connection conn) throws SQLException {
			//importação do scanner na função para fazer a aplicação mais personalizado e dinamico. 
			  Scanner scan = new Scanner(System.in);
			
		  // Dados de usuário a serem inseridos
		    System.out.println("Qual o nome da pessoa que alugou o livro?");
		    String nome = scan.nextLine();
		    
		    System.out.println("Qual o email da pessoa?");
		    String email = scan.nextLine();
		    
		    System.out.println("Qual o valor do id?");
		    int id = scan.nextInt();
		    
		    System.out.println("Qual o valor do codigo do livro?");
		    int cod_livro = scan.nextInt();

		    // Inserção de dados na tabela usuario
		    String insertUsuario = "INSERT INTO usuario (id, nome, email, cod_livro) VALUES (?, ?, ?, ?)";
		    PreparedStatement statementUsuario = conn.prepareStatement(insertUsuario);
		    statementUsuario.setInt(1, id);
		    statementUsuario.setString(2, nome);
		    statementUsuario.setString(3, email);
		    statementUsuario.setInt(4, cod_livro);

		    // Executa inserção e verifica se os dados foram inseridos com sucesso
		    int dadosInseridos = statementUsuario.executeUpdate();

		    if (dadosInseridos > 0) {
		        System.out.println("Dados da tabela Usuario inseridos com sucesso!");
		       
		    } else {
		        System.out.println("Erro ao inserir os dados");
		      
		    }
		}
	
}


