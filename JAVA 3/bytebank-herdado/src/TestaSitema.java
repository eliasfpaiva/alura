
public class TestaSitema {

	public static void main(String[] args) {
		
		Autenticavel referencia = new Gerente();
		referencia.setSenha(123);
		System.out.println(referencia.autentica(123));
		System.out.println(referencia.autentica(13));

		Autenticavel referencia2 = new Cliente();
		referencia2.setSenha(123);
		System.out.println(referencia2.autentica(123));
		System.out.println(referencia2.autentica(13));

		Autenticavel referencia3 = new Administrador();
		referencia3.setSenha(123);
		System.out.println(referencia3.autentica(123));
		System.out.println(referencia3.autentica(13));
	}

}
