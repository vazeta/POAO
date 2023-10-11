public class Ex1avaliacao {
    public static void main(String[] args) {
        String[] URLs = {
                "https://www.dei.uc.pt/poao/exames",
                "http://www.scs.org/index.html",
                "https://www.nato.int/events",
                "https://www.btu.de/",
                "https://www.dei.uc.pt/poao/exames",
                "http://www.eth.ch/index.html",
                "http://www.osu.edu/"
        };

        String[][] paises = {
                {"pt", "Portugal"},
                {"org", "EUA"},
                {"fr", "França"},
                {"uk", "Reino Unido"},
                {"de", "Alemanha"},
                {"edu", "EUA"}
        };

        int[] contagemPaises = new int[paises.length];//Inicialização do array que irá conter a contagem por ordem;
        int contagemOutros = compararPaises(URLs, paises, contagemPaises);
        if (verificarUrls(URLs)) {//Caso a função retorne false, o programa acaba;
            verificaPrefixos(paises, contagemPaises);
            imprimirResultado(paises, contagemPaises, contagemOutros);
        }
    }

    private static boolean verificarUrls(String[] URLs) {
        //Função reponsável por verificar se todos os URLs começam com "https://" ou "htpp://";
        int cont = 0;
        boolean verifica = true;
        for (int i = 0; i < URLs.length; i++) {
            if (URLs[i].startsWith("http://") || URLs[i].startsWith("https://")) {
                cont++;
            }
        }
        if (cont == URLs.length) {
            System.out.println("-------------------------------------");
            System.out.println("Todos os links inseridos são válidos!");
            System.out.println("-------------------------------------");
        } else {
            System.out.println("--------------------------------------------------------");
            System.out.println("Verifique! Um ou mais dos links inseridos são inválidos!");
            verifica = false;
        }
        return verifica; //Retorna a variavel booleana "verifica";
    }

    private static int compararPaises(String[] URLs, String[][] paises, int[] contagemPaises) {
        //Função reponsável por separar os URLs por barras e posteriormente por pontos e fazer toda a contagem tanto dos países como dos outros;
        int contagemOutros = 0;
        for (String url : URLs) {
            String[] partes = url.split("/");//Separação por barras dos URLs usando a função split();
            if (partes.length >= 3) {
                String terceiraParte = partes[2];//Acesso à terceira parte (índice 2) para acessar a parte dos URLs que começa em "www";
                String[] partesPorPontos = terceiraParte.split("\\.");//Separação por pontos da terceira parte usando também a função split();
                boolean encontrado = false;
                for (int i = 0; i < paises.length; i++) {
                    if (partesPorPontos[(partesPorPontos.length) - 1].equals(paises[i][0])) {//Comparação com os prefixos e com o último elemento do array separado por pontos;
                        contagemPaises[i]++;
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    contagemOutros++;
                }
            }
        }
        return contagemOutros;//Retorna a contagem dos outros;
    }

    private static void verificaPrefixos(String[][] paises, int[] contagemPaises) {
        //Função responsável por verificar se existe mais do que um prefixo associado ao mesmo país;
        for (int i = 0; i < paises.length; i++) {
            for (int k = i + 1; k < paises.length; k++) {
                if (paises[i][1].equals(paises[k][1])) {
                    contagemPaises[i] += contagemPaises[k]; //Soma dos dois contadores caso o país seja o mesmo;
                    contagemPaises[k] = 0; //Atualização do outro contador para 0 (não será impresso porque não é maior que 0);
                }
            }
        }
    }

    private static void imprimirResultado(String[][] paises, int[] contagemPaises, int contagemOutros) {
        //Função responsável por imprimir o resultado final (imprime caso a contagem seja superior a 0);
        for (int i = 0; i < paises.length; i++) {
            if (contagemPaises[i] > 0) {
                System.out.println(paises[i][1] + ": " + contagemPaises[i]);
            }
        }
        if (contagemOutros > 0) {
            System.out.println("Outros: " + contagemOutros);
        }
    }
}