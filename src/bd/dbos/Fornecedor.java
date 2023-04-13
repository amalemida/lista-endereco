package bd.dbos;

public class Fornecedor implements Cloneable {

  private int codigo;
  private String cnpj;
  private String razaoSocial;
  private String cep;
  private int numero;
  private String complemento;

  public void setCodigo(int codigo) throws Exception {
    if (codigo <= 0)
      throw new Exception("Codigo invalido");

    this.codigo = codigo;
  }

  public void setCnpj(String cnpj) throws Exception {
    if (cnpj == null || cnpj.equals(""))
      throw new Exception("CNPJ nao fornecido");

    this.cnpj = cnpj;
  }

  public void setRazaoSocial(String razaoSocial) throws Exception {
    if (razaoSocial == null || razaoSocial.equals(""))
      throw new Exception("Razao Social invalida");

    this.razaoSocial = razaoSocial;
  }

  public void setCep(String cep) throws Exception {
    if (cep == null || cep.equals(""))
      throw new Exception("CEP invalido");

    this.cep = cep;
  }

  public void setNumero(int numero) throws Exception {
    if (numero <= 0)
      throw new Exception("Numero invalido");

    this.numero = numero;
  }

  public void setComplemento(String complemento) { // nao lanco excessao porque aceita nulo
    this.complemento = complemento;
  }

  public int getCodigo() {
    return this.codigo;
  }

  public String getCnpj() {
    return this.cnpj;
  }

  public String getRazaoSocial() {
    return this.razaoSocial;
  }

  public String getCep() {
    return cep;
  }

  public int getNumero() {
    return numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public Fornecedor(int codigo, String cnpj, String razaoSocial, String cep, int numero, String complemento)
      throws Exception {
    this.setCodigo(codigo);
    this.setCnpj(cnpj);
    this.setRazaoSocial(razaoSocial);
    this.setCep(cep);
    this.setNumero(numero);
    this.setComplemento(complemento);
  }
  
  public Fornecedor(String cnpj, String razaoSocial, String cep, int numero, String complemento) throws Exception {
	    this.setCnpj(cnpj);
	    this.setRazaoSocial(razaoSocial);
	    this.setCep(cep);
	    this.setNumero(numero);
	    this.setComplemento(complemento);
	  
  }

  public Fornecedor(int codigo, String cep, int numero, String complemento) throws Exception {
    this.setCodigo(codigo);
    this.setCep(cep);
    this.setNumero(numero);
    this.setComplemento(complemento);
  }

  public String toString() {
    String ret = "";

    ret += "Codigo: " + this.codigo + "\n";
    ret += "CNPJ..: " + this.cnpj + "\n";
    ret += "Razao Social.: " + this.razaoSocial + "\n";
    ret += "CEP.: " + this.cep + "\n";
    ret += "Numero.: " + this.numero + "\n";
    ret += "Complemento.: " + this.complemento;

    return ret;
  }

  public boolean equals(Object obj) {
    if (this == obj)
      return true;

    if (obj == null)
      return false;

    if (!(obj instanceof Fornecedor))
      return false;

    Fornecedor liv = (Fornecedor) obj;

    if (this.codigo != liv.codigo)
      return false;

    if (this.cnpj.equals(liv.cnpj))
      return false;

    if (this.razaoSocial.equals(liv.razaoSocial))
      return false;

    if (this.cep.equals(liv.cep))
      return false;

    if (this.numero != liv.numero)
      return false;

    if (this.complemento.equals(liv.complemento))
      return false;

    return true;
  }

  public int hashCode() {
    int ret = 666;

    ret = 7 * ret + this.codigo;
    ret = 7 * ret + this.cnpj.hashCode();
    ret = 7 * ret + this.razaoSocial.hashCode();
    ret = 7 * ret + this.cep.hashCode();
    ret = 7 * ret + this.numero;
    ret = 7 * ret + this.complemento.hashCode();

    return ret;
  }

  public Fornecedor(Fornecedor modelo) throws Exception {
    this.codigo = modelo.codigo; // nao clono, pq nao eh objeto
    this.cnpj = modelo.cnpj; // nao clono, pq nao eh clonavel
    this.razaoSocial = modelo.razaoSocial; // nao clono, pq nao eh objeto
    this.cep = modelo.cep; // nao clono, pq nao eh objeto
    this.numero = modelo.numero; // nao clono, pq nao eh objeto
    this.complemento = modelo.complemento; // nao clono, pq nao eh objeto
  }

  public Object clone() {
    Fornecedor ret = null;

    try {
      ret = new Fornecedor(this);
    } catch (Exception erro) {
    } // nao trato, pq this nunca � null e construtor de
      // copia da excecao qdo seu parametro for null

    return ret;
  }
}