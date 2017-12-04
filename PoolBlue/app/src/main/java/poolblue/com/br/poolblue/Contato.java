package poolblue.com.br.poolblue;

/**
 * Created by rafaelcarvalho on 04/12/2017.
 */

public class Contato {

    private String nome;
    private String endereco;
    private String empresa;
    private String sexo;
    private String cargo;

    public Contato(String nome, String endereco, String empresa, String sexo, String cargo) {
        this.nome = nome;
        this.endereco = endereco;
        this.empresa = empresa;
        this.sexo = sexo;
        this.cargo = cargo;
    }

    //getter
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCargo() {
        return cargo;
    }
    //setter

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
