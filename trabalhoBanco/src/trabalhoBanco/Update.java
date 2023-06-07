package trabalhoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
	// Função para atualizar informações na tabela usuario
		public static void updateInformacoes(Connection conn) throws SQLException {
			 Scanner scan = new Scanner(System.in);
			 
			 //campos de preencimento onde vai ser auterado os dados.
			 	System.out.println("Digite o novo nome do usario: ");
			    String nome = scan.nextLine();
			    
			    System.out.println("Digite o novo email do usuario: ");
			    String email = scan.nextLine();
			 
			 System.out.println("Id do usuario que vai ter as informações atualizadas: ");
			    int id = scan.nextInt();
			    
		    // Atualizar informações na tabela usuario a partir do ID
		    String update = "UPDATE usuario SET  nome = ?, email = ? WHERE id = ?";
		    PreparedStatement statementUpdate = conn.prepareStatement(update);
		    
		    statementUpdate.setString(1, nome);
		    statementUpdate.setString(2, email);
		    statementUpdate.setInt(3, id);

		    // Executa a query de atualização e verifica se os dados foram atualizados com sucesso
		    int dadosUpdate = statementUpdate.executeUpdate();
		    if (dadosUpdate > 0) {
		        System.out.println("Informações atualizadas com sucesso!");
		    } else {
		        System.out.println("Erro ao atualizar os dados");
		    }
		}
}
