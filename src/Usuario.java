/*
 * Classe que representa um usuário no sistema.
 * Campos bem simples, com getters e setters.
 */
public class Usuario {
    private int id;            // gerado pelo DB (AUTO_INCREMENT)
    private String nome;
    private String cpf;
    private String email;
    private String cargo;
    private String login;
    private String senha;     // OBS: em projeto real, não salve senha em texto puro
    private String perfil;    // "ADMIN", "GERENTE" ou "COLABORADOR"

    public Usuario() {}

    public Usuario(String nome, String cpf, String email, String cargo,
                   String login, String senha, String perfil) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    // getters e setters (apenas alguns mostrados para economizar espaço)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getPerfil() { return perfil; }
    public void setPerfil(String perfil) { this.perfil = perfil; }
}