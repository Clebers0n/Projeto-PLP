package classes;

public abstract class Empresa {
	
	private String cnpj;
	private String razaoSocial;
	protected boolean estaAberta = false;
	
	private String nomeClasse = this.getClass().getSimpleName();
	
	public Empresa(String cnpj, String razaoSocial) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}
	
	public void abrir() {
		if(this.estaAberta) {
			System.out.println("A " + this.nomeClasse.toLowerCase() + " já está aberta");
		} else {
			System.out.println(this.nomeClasse + " aberta com sucesso");
			this.estaAberta = true;
		}
	}
	
	public void fechar() {
		if(this.estaAberta) {
			System.out.println(this.nomeClasse + " fechada com sucesso");
			this.estaAberta = false;
		} else {
			System.out.println(this.nomeClasse + " já está fechada");
		}
	}
	
	public abstract void vender(Cliente cliente);

	public String getCnpj() {
		return cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

}
