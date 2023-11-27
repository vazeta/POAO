import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe mais importante do jogo, contém praticamente todas as funçoes do jogo e é responsável por gerir todos os personagens.
 */
abstract public class Personagem {
    private String nome;
    private int experiencia;
    private double forca;
    private double agilidade;
    private double inteligencia;
    protected static int[][] tabela = {
            {10, 5, 3},
            {2, 4, 9},
            {4, 10, 4}
    };

    /**
     * Construtor da classe, recebe dados par inicialização dos atributos
     * @param nome Nome da personagem
     * @param forca Nivel de força
     * @param agilidade Nivel de agilidade
     * @param inteligencia nível de inteligência
     */
    public Personagem(String nome, double forca, double agilidade, double inteligencia) {
        this.nome = nome;
        this.experiencia = (int) (Math.random() * 25);//Math.random devolve um valor entre 0 e 1
        this.forca = forca;
        this.agilidade = agilidade;

        this.inteligencia = inteligencia;
    }
    /**
     * Método de acesso ao Nome
     * @return Nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método de alterar nome
     * @param nome nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * Método de acesso à tabela com os valores inciais
     * @return tabela
     */

    public static int[][] getTabela() {
        return tabela;
    }

    /**
     * Método de alterar tabela
     * @param tabela tabela
     */

    public static void setTabela(int[][] tabela) {
        Personagem.tabela = tabela;
    }

    /**
     * Método de acesso a experiência
     * @return experiência
     */

    public int getExperiencia() {
        return experiencia;
    }

    /**
     * Método de alterar experiência
     * @param experiencia experiência
     */

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    /**
     * Método de acesso à força
     * @return força
     */
    public double getforca() {
        return forca;
    }
    /**
     * Método de alterar força
     * @param forca força
     */

    public void setforca(double forca) {
        this.forca = forca;
    }

    /**
     * Método de acesso a agilidade
     * @return agilidade
     */

    public double getAgilidade() {
        return agilidade;
    }

    /**
     * Métode de alterar agilidade
     * @param agilidade agilidade
     */

    public void setAgilidade(double agilidade) {
        this.agilidade = agilidade;
    }

    /**
     * Método de acesso a inteligência
     * @return inteligência
     */
    public double getInteligencia() {
        return inteligencia;
    }

    /**
     * Método de alterar inteligência
     * @param inteligencia inteligência
     */

    public void setInteligencia(double inteligencia) {
        this.inteligencia = inteligencia;
    }

    /**
     * Método toString() responsável por mostrar o nome e os níveis da personagem
     * @return Nome e níveis da Personagem
     */
    @Override
    public String toString() {
        return "Nome: " + nome + " --> Nivel de experiencia=" + experiencia +
                ", Força=" + forca +
                ", Agilidade=" + agilidade +
                ", Inteligência=" + inteligencia;
    }

    /**
     * Método responsável pela inicialização e criação de todas as personagens e inserção numa lista
     * @return Lista que contém todas as personagens
     */
    protected static ArrayList<Personagem> introduz() {
        ArrayList<Personagem> personagens;
        personagens = new ArrayList<>();
        Personagem mago1 = new Mago("Nike", "Abóbora", "Alecrim");
        Personagem mago2 = new Mago("Supreme", "Girassol", "Oliveira");
        Personagem mago3 = new Mago("Trapstar", "Abóbora", "Alecrim");
        Personagem mago4 = new Mago("Corteiz", "Sésamo", "Limoeiro");
        Personagem mago5 = new Mago("North", "Abóbora", "Alecrim");
        Personagem guerreiro1 = new Guerreiro("Lon3r", false, "Faca");
        Personagem guerreiro2 = new Guerreiro("Tyler", true, "Machado");
        Personagem guerreiro3 = new Guerreiro("Frank", false, "Faca");
        Personagem guerreiro4 = new Guerreiro("Yeat", true, "Espada");
        Personagem guerreiro5 = new Guerreiro("Carti", true, "Espada");
        Personagem mercenario1 = new Mercenario("Rain", "Pistola", 30);
        Personagem mercenario2 = new Mercenario("Cold", "Arco", 24);
        Personagem mercenario3 = new Mercenario("Niko", "Pistola", 7);
        Personagem mercenario4 = new Mercenario("Olof", "Pedra", 15);
        Personagem mercenario5 = new Mercenario("Fallen", "Arco", 9);
        personagens.add(mago1);
        personagens.add(mago2);
        personagens.add(mago3);
        personagens.add(mago4);
        personagens.add(mago5);
        personagens.add(guerreiro1);
        personagens.add(guerreiro2);
        personagens.add(guerreiro3);
        personagens.add(guerreiro4);
        personagens.add(guerreiro5);
        personagens.add(mercenario1);
        personagens.add(mercenario2);
        personagens.add(mercenario3);
        personagens.add(mercenario4);
        personagens.add(mercenario5);
        return personagens;
    }

    /**
     * Método responsável por verificar e imprimir todas as prsonagens com nível de experiência acima de 10
     * @param personagens Lista que contém todas as personagens
     */
    protected static void maiorQue10(List<Personagem> personagens) {
        for (Personagem personagem : personagens) {
            if (personagem.getExperiencia() > 10) {
                System.out.println(personagem);
            }
        }
    }

    /**
     * Método responsável por verificar e imprimir todos os magos com sementes de abóbora, guerreiros com armadura e mercenários com arcos
     * @param personagens Lista que contém todas as pesonagens
     */
    protected static void arcoAboborasArmadura(List<Personagem> personagens) {
        for (Personagem personagem : personagens) {
            personagem.arcoAboborasArmadura();
        }
    }
    protected abstract void arcoAboborasArmadura();
    protected abstract String imprimeTudo();

    /**
     * Método responsável por imprimir os personagens todos contidos na lista
     * @param personagens Lista que contém todas as personagens
     */
    protected static void imprime(List<Personagem> personagens) {
        for (Personagem personagem : personagens) {
            System.out.println(personagem);
        }
    }

    /**
     * Método responsável por imprimir todas as estatísticas de um personagem
     * @param personagens Lista que contém todas as personagens
     */
    protected static void imprimeStats(List<Personagem> personagens) {
        for (Personagem personagem : personagens) {
           personagem.imprimeStats();
        }
    }
    protected abstract void imprimeStats();

    /**
     * Método responsável por subir o nível de todas as personagens
     * @param personagens Lista que contém todos os personagens
     */
    protected static void subirNivelExp(List<Personagem> personagens) {
        for(Personagem personagem : personagens){
            personagem.subirNivelExp();
        }
    }
    protected abstract void subirNivelExp();

    /**
     * Método responsável pela criação do menu do jogo, chama os respetivos métodos conforme o que o utilizador insira
     */
    protected static void menu() {
        ArrayList<Personagem> personagens = introduz();
        Scanner ler = new Scanner(System.in);
        int entrada;
        boolean flag=true;
        System.out.println("-------------------------------------------------------");
        System.out.println("Bem vindos ao Jogo POAO of Warcraft (PoW), um jogo RPG");
        System.out.println("--------------------------------------------------------");
        while (flag) {
            System.out.println("---------------------~~~~ MENU ~~~----------------------");
            System.out.println("--------------------------------------------------------");
            System.out.println("1 - Imprimir personagens ");
            System.out.println("2 - Imprimir personagens com experiência maior que 10 ");
            System.out.println("3 - Imprimir magos com sementes de abóbora, guerreiros com armaduras e mercenários com arcos ");
            System.out.println("4 - Subir nível de experiência dos personagens ");
            System.out.println("5 - Sair do jogo ");
            System.out.println("--------------------------------------------------------");
            System.out.println("Selecione uma das opções apresentadas acima (5 para sair): ");
            entrada = ler.nextInt();
            switch (entrada) {
                case 1:
                    System.out.println("Personagens: ");
                    imprime(personagens);
                    break;
                case 2:
                    System.out.println("Personagens com experiência maior que 10: ");
                    maiorQue10(personagens);
                    break;
                case 3:
                    System.out.println("Magos com sementes de abóbora, guerreiros com armaduras e mercenários com arcos: ");
                    arcoAboborasArmadura(personagens);
                    break;
                case 4:
                    System.out.println("Personagens antes da subida:");
                    imprimeStats(personagens);
                    subirNivelExp(personagens);
                    System.out.println("Personagens depois da subida:");
                    imprimeStats(personagens);
                    break;
                case 5:
                    System.out.println("A sair... ");
                    System.out.println(("Obrigado por jogar este maravilhoso jogo!!! <3"));
                    System.out.println("Reporte bugs ou sugira melhorias -> uc2022231087@student.uc.pt");
                    flag=false;
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        }
    }
}