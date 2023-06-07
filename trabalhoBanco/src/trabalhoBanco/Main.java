package trabalhoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Cria um objeto Scanner para ler a entrada do usuário
	    Scanner scan = new Scanner(System.in);

	    // Configuração de conexão com o banco de dados
	    String url = "jdbc:postgresql://localhost:5432/TrabalhoBanco";
	    String user = "postgres";
	    String password = "postgres";
	    
	    // testa se esta tendo a conexão
	    try (Connection conn = DriverManager.getConnection(url, user, password)) {
	        if (conn != null) {
	            System.out.println("Banco funcionando 100%!");
	        }

	        // Loop infinito feito por do while, onde colocamos o while(true), porque sempre estara em repetição.
	        do {
	        	//O Menu Onde mostrara as opções 
	            System.out.println("Escolha uma das opções abaixo:");
	            System.out.println("[il] Inserir dados na tabela Livro");
	            System.out.println("[iu] Inserir dados na tabela Usuario");
	            System.out.println("[sl] Selecionar dados da Tabela Livro");
	            System.out.println("[su] Selecionar dados da Tabela Usuario");
	            System.out.println("[j] Realizar um Join nos dados");
	            System.out.println("[u] Dar um update das informações");
	            System.out.println("[du] Deletar os dados da tabela usuario");
	            System.out.println("[dl] Deletar os dados da tabela livro");
	            System.out.println("[x] Sair do sistema");
	            
	            String opcao = scan.nextLine();

	            switch (opcao) {
	                // Chamada da função para inserir dados na tabela livro
	                case "il":
	                	Insert.insertLivro(conn);
	                    break;

	                // Chamada da função para inserir dados na tabela usuario
	                case "iu":
	                	Insert.insertUsuario(conn);
	                    break;

	                // Chamada da função para selecionar dados da tabela livro
	                case "sl":
	                	Select.selecionarLivro(conn);
	                    break;

	                // Chamada da função para selecionar dados da tabela usuario
	                case "su":
	                	Select.selecionaUsuario(conn);
	                    break;

	                // Chamada da função para realizar um JOIN entre as tabelas livro e usuario
	                case "j":
	                	Select.joinDados(conn);
	                    break;

	                // Chamada da função para atualizar informações na tabela usuario
	                case "u":
	                	Update.updateInformacoes(conn);
	                    break;

	                // Chamada da função para excluir dados da tabela usuario
	                case "du":
	                	Delete.deleteUsuario(conn);
	                    break;

	                // Chamada da função para excluir dados da tabela livro
	                case "dl":
	                	Delete.deleteLivro(conn);
	                    break;

	                // Encerra o programa
	                case "x":
	                    System.out.println("Saindo...");
	                    //fechando o scanner
	                    scan.close();
	                    //desconectar o banco
	                    conn.close();
	                    //fechando o sistema
	                    System.exit(0);
	                    break;

	                // Fazeruma mensagem para opções inválidas
	                default:
	                    System.out.println("Opção Inválida");
	            }
	        } while (true);
	    } catch (SQLException excecao) {
	        excecao.printStackTrace();
	    }
	}
	
	
}