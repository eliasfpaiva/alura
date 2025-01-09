
public class ControleBonificacao {

	private double soma = 0;

	public double getSoma()               { return soma; }	
	public void   registra(Funcionario f) { 
		this.soma += f.getBonificacao();
		System.out.println(soma);
		}	
}
