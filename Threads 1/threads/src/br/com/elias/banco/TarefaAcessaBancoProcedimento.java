package br.com.elias.banco;

public class TarefaAcessaBancoProcedimento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		synchronized (pool) {
			System.out.println(Thread.currentThread().getId() + " Peguei a chave do Pool!");
			pool.getConnection();
			synchronized (tx) {
				System.out.println(Thread.currentThread().getId() + " Peguei a chave da TX!");
				tx.begin();
			}
		}
	}

}
