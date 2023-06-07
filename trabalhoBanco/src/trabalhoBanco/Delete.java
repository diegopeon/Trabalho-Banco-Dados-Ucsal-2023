package trabalhoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {


	// Função para deletar dados da tabela usuario
	public static void deleteUsuario(Connection conn) throws SQLException {
		 Scanner scan = new Scanner(System.in);
		 
		 // um scanner para determinar um id para assim apagar os dados da tabela usuario
		 System.out.println("Insira o id do Usuario que vai ser apagado: ");
		 int id = scan.nextInt();
		 
	    // Deletar dados da tabela usuario
	    String delete = "DELETE FROM usuario WHERE id = ?";
	    PreparedStatement statementExcluirU = conn.prepareStatement(delete);
	    statementExcluirU.setInt(1, id);

	    // Executa a query de deleção e verifica se os dados foram deletados com sucesso
	    int dadosExcluidos = statementExcluirU.executeUpdate();

	    if (dadosExcluidos > 0) {
	        System.out.println("Informações apagadas com sucesso!");
	    } else {
	        System.out.println("Erro ao apagar os dados");
	    }
	}

	// Função para deletar dados da tabela livro
	public static void deleteLivro(Connection conn) throws SQLException {
		
		Scanner scan = new Scanner(System.in);
		 
		 System.out.println("Insira o codigo de livro do livro que vai ser apagado: ");
		 int cod_livro = scan.nextInt();
		 
	    // Deletar dados da tabela livro
	    String deleteLivro = "DELETE FROM livro WHERE cod_livro = ?";
	    PreparedStatement statementExcluirL = conn.prepareStatement(deleteLivro);
	    statementExcluirL.setInt(1, cod_livro);

	    // Executa a query de deleção e verifica se os dados foram deletados com sucesso
	    int dadosExcluidosLivro = statementExcluirL.executeUpdate();

	    if (dadosExcluidosLivro > 0) {
	        System.out.println("Informações apagadas com sucesso!");
	    } else {
	        System.out.println("Erro ao apagar os dados");
	    }
	}
}
