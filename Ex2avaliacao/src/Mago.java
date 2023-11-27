/**
 * Classe responsável pelo mago
 */
public class Mago extends Personagem {
    private String sementes;
    private String folhas;

    /**
     * Construtor da classe, recebe dados para inicialização dos atributos
     * @param nome Nome do mago
     * @param sementes Sementes que utiliza
     * @param folhas Folhas que utiliza
     */
    public Mago(String nome, String sementes,String folhas) {
        super(nome, tabela[1][0],tabela[1][1],tabela[1][2]);
        this.sementes = sementes;
        this.folhas=folhas;
    }

    /**
     * Método de acesso a folhas
     * @return folhas
     */
    public String getFolhas() {
        return folhas;
    }

    /**
     * Método para alterar as folhas
     * @param folhas folhas
     */
    public void setFolhas(String folhas) {
        this.folhas = folhas;
    }

    /**
     * Método de acesso a sementes
     * @return sementes
     */
    public String getSementes() {
        return sementes;
    }

    /**
     * Método para alterar sementes
     * @param sementes sementes
     */

    public void setSementes(String sementes) {
        this.sementes = sementes;
    }

    /**
     * Metódo toString() responsável por imprimir o tipo de personagem, o nome e o nível de experiência
     * @return Tipo de personagem, o nome e o nível de experiência
     */
    @Override
    public String toString() {
        return "Mago --> Nome: " + getNome() + ". Nível de Experiência: " + getExperiencia();
    }

    /**
     * Método responsável por imprimir o tipo de personagem, o nome e as estatísticas
     * @return Tipo de personagem, o nome e estatísticas
     */
    protected String imprimeTudo(){
        return "Mago --> " + super.toString();
    }

    /**
     * Método para subir niveis do mago
     */
    protected void subirNivelExp(){
        setExperiencia((getExperiencia()) + 1);
        setforca(((getforca()) + (0.05 * getforca())));
        setAgilidade(getAgilidade() + (0.10 * getAgilidade()));
        setInteligencia(getInteligencia() + (0.20 * getInteligencia()));

    }

    /**
     * Método que verifica se o mago tem sementes de abóbora
     */
    protected void arcoAboborasArmadura(){
        if (getSementes().equalsIgnoreCase("Abóbora")) {
            System.out.println(imprimeTudo() + "-> Tem sementes de abóbora");
        }
    }

    /**
     * Método que imprime as stats de cada personagem
     */
    protected void imprimeStats(){
        System.out.println(imprimeTudo());
    }
}