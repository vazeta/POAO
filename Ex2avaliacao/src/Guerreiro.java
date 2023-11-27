/**
 * Classe responsável pelo guerreiro
 */
public class Guerreiro extends Personagem {
    private boolean armadura;
    private String arma;

    /**
     * Construtor da classe, recebe dados para inicialização dos atributos
     * @param nome Nome do Guerreiro
     * @param armadura Boolean que indica se tem armadura
     * @param arma Arma que utiliza
     */
    public Guerreiro(String nome, boolean armadura,String arma) {
        super(nome,tabela[0][0],tabela[0][1],tabela[0][2]);
        this.armadura=armadura;
        this.arma=arma;
    }

    /**
     * Método de acesso a arma
     * @return arma
     */
    public String getArma() {
        return arma;
    }

    /**
     * Método para alterar arma
     * @param arma arma
     */
    public void setArma(String arma) {
        this.arma = arma;
    }

    /**
     * Método de acesso a armadura
     * @return armadura
     */

    public boolean isArmadura() {
        return armadura;
    }

    /**
     * Método para alterar armadura
     * @param armadura armadura
     */
    public void setArmadura(boolean armadura) {
        this.armadura = armadura;
    }

    /**
     * Método toString() responsável por imprimir o tipo de personagem, o nome e o nível de experiência
     * @return Tipo de personagem, nome e nível de experiência
     */
    @Override
    public String toString() {
        return "Guerreiro --> Nome: " + getNome() + ". Nível de Experiência: " + getExperiencia();
    }

    /**
     * Método responsável por imprimir o tipo de personagem, o nome e as estatísticas
     * @return Tipo de personagem, nome e estatísticas
     */
    protected String imprimeTudo(){
        return "Guerreiro --> " + super.toString();
    }

    /**
     * Método para subir niveis do guerreiro
     */
    protected void subirNivelExp(){
        setExperiencia((getExperiencia()) + 1);
        setforca(((getforca()) + (0.20 * getforca())));
        setAgilidade(getAgilidade() + (0.10 * getAgilidade()));
        setInteligencia(getInteligencia() + (0.05 * getInteligencia()));

    }
    /**
     * Método que verifica se o guerreiro tem armadura
     */
    protected void arcoAboborasArmadura(){
        if (isArmadura()) {
            System.out.println(imprimeTudo() + "-> Tem armadura");
        }
    }
    /**
     * Método que imprime as stats de cada personagem
     */
    protected void imprimeStats(){
        System.out.println(imprimeTudo());
    }

}