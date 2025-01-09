package br.com.pilha.testes;
import br.com.pilha.modelo.Conexao;

public class TesteConexao {

	public static void main(String[] args) {
		
		
		try (Conexao conexao = new Conexao() ) {
			conexao.leDados();
		} catch(IllegalStateException ex) {
			System.out.println("Deu erro na conexao");
		}
		
		
		//-----------------------------
		
//		Conexao con = null;
//		try {
//			con = new Conexao();
//			con.leDados();
//		} catch(IllegalStateException ex) {
//			System.out.println("Deu erro na conexao");
//		} finally {
//			System.out.println("finally");
//			if(con != null) {
//				con.close();
//			}
//		}
		

	}

}
