
public class TesteTributaveis {

	public static void main(String[] args){
        ContaCorrente cc = new ContaCorrente(222, 333);
        cc.deposita(100.0);

        SeguroDeVida seguro = new SeguroDeVida();

        CalculadorDeImposto calc = new CalculadorDeImposto();
        System.out.println(calc.getTotalImposto());

        calc.registra(seguro);
        System.out.println(calc.getTotalImposto());
        calc.registra(cc);
        System.out.println(calc.getTotalImposto());
    }
}
