/**
 * Classe responsável pelo mercenário
 */
public class Mercenario extends Personagem{
    private String arma;
    private int municoes;

    /**
     * Construtor da classe, recebe dados para inicialização dos atributos
     * @param nome Nome da mercenário
     * @param arma Arma que utiliza
     * @param municoes Número de munições
     */
    public Mercenario(String nome, String arma,int municoes) {
        super(nome,tabela[2][0],tabela[2][1],tabela[2][2]);
        this.arma=arma;
        this.municoes=municoes;
    }

    /**
     * Método de acesso a munições
     * @return munições
     */
    public int getMunicoes() {
        return municoes;
    }

    /**
     * Método para alterar munições
     * @param municoes munições
     */

    public void setMunicoes(int municoes) {
        this.municoes = municoes;
    }

    /**
     * Método de acesso a arma
     * @return arma
     */

    public String getArma() {
        return arma;
    }

    /**
     * método para alterar arma
     * @param arma arma
     */

    public void setArma(String arma) {
        this.arma = arma;
    }

    /**
     * Método toString() responsável por imprimir o tipo de pesonagem, o nome e o nível de experiência
     * @return Tipo de pesonagem, o nome e o nível de experiência
     */
    @Override
    public String toString() {
        return "Mercenário --> Nome: " + getNome() + ". Nível de Experiência: " + getExperiencia();
    }

    /**
     * Método responsável por imprimir o tipo de personagem, o nome e as estatísticas
     * @return Tipo de personagem, o nome e estatísticas
     */
    protected String imprimeTudo(){
        return "Mercenário --> " + super.toString();
    }

    /**
     * Método para subir niveis do mercenário
     */
    protected void subirNivelExp(){
        setExperiencia((getExperiencia()) + 1);
        setforca(((getforca()) + (0.08 * getforca())));
        setAgilidade(getAgilidade() + (0.20 * getAgilidade()));
        setInteligencia(getInteligencia() + (0.08 * getInteligencia()));
    }
    /**
     * Método que verifica se o mercenário tem arco
     */
    protected void arcoAboborasArmadura(){
        if (getArma().equalsIgnoreCase("Arco")) {
            System.out.println(imprimeTudo()+"-> Tem arco");
        }
    }
    /**
     * Método que imprime as stats de cada personagem
     */
    protected void imprimeStats(){
        System.out.println(imprimeTudo());
    }
}