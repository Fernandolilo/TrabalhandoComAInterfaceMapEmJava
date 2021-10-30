package application;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        /*
         * No Map para iserir dados usa-se o put, caso haja a inserção de duas chaves com
         * o mesmo valor uma será desconsiderada, veja a impressão a baixo:
         * {Kwid=15.6, Gol=14.4, Uno=15.6, Hb20=14.4, Mobi=16.1}
         * tambem não imprime na ordem inserida, ele randomiza a impressão.
         */
        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumo:  ");
        Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("Gol", 16.1);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("Hb20", 14.4);
            put("Kwid", 14.4);
        }};
        System.out.println(carrosPopulares.toString());

        /*
         * como no caso do map, não vamos varrer então neste caso será sobreecrevido na chave Gol
         * um outro valor de consumo.
         */
        System.out.println("Subistitua o consumo do gol por 15.2 km/l: ");
        carrosPopulares.put("Gol", 15.2);
        System.out.println(carrosPopulares.toString());

        /*
         * Para verificar se um objeto exite, usaremos o  containsKey,
         * passando o objeto dentro do containsKey(" xpto"0), o containsKey é um boolean então ele verifica
         * sendo verdadeiro retorna true, sendo falso retorna false.
         * veja as impressoes a baixo:
         * Confira se o carro Tucson está adicionado: false
         * Confira se o carro Gol está adicionado: true
         */
        System.out.println("Confira se o carro Tucson está adicionado: " + carrosPopulares.containsKey("Tucson"));
        System.out.println("Confira se o carro Gol está adicionado: " + carrosPopulares.containsKey("Gol"));
        //para verificarmos o consumo atribuido ao veículo no caso, precisamos fazer uso do get veja o ex: a baixo
        System.out.println("Exiba o consumo do Gol: " + carrosPopulares.get("Gol") + " Km/l");


        /*
         * neste caso o Set retorna um Set,
         */
        System.out.println("Exiba os modelos: ");
        Set<String> modelo = carrosPopulares.keySet();
        System.out.println(modelo);

        /*
         * Para isto temos o matodo Value, ele pega apenas os valores é e uma collections
         */
        System.out.println("Exiba o consumo dos carros: ");
        Collection<Double> consumo = carrosPopulares.values();
        System.out.println(consumo);

        /*
         * para sabermos a cerca do veiculo que tem o melhor desempenho por litro podemos fazer so do max,
         * veja o exemplo a baixo:
         */


        System.out.println("Exiba o veículo que tem melhor performace por litro de combustível");
        /*
         * Agora como poderemos fazer uso de chave e valor, pois no metodo acima obtivemos apenas o valor
         * não sabemos a quem pertence tal valor, para isto vamos fazer uso do entrySet, veja a baixo.
         */
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";
        for(Map.Entry<String, Double> entry: entries) {
            if(entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entry.getKey();
                System.out.println("O modelo mais eficiente? " + modeloMaisEficiente + " - " + consumoMaisEficiente + ": Km/l");
            }
        }

        System.out.println("Exiba o modelo menos eficiênte");
        Double menorEficiencia = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente ="";
        for (Map.Entry<String, Double> entry:carrosPopulares.entrySet()) {
            if(entry.getValue().equals(menorEficiencia)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("O modelo menos eficiênte é: " + modeloMenosEficiente + " - " + menorEficiencia + ": Km/l");
            }
        }

        System.out.println("Exiba a soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0.0;

        while (iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("A soma é dos consumos é: " + soma);

        System.out.println("Exiba a média de consumo dos veiculos: " + soma / 5);

        System.out.println("Remova veiculos que tem o consumo igual a 15.6 km ");

        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        System.out.println(carrosPopulares);
        while (iterator1.hasNext()){
            if (iterator1.next() == 15.6){
                iterator1.remove();
            }
        }
        System.out.println(carrosPopulares);

        System.out.println("Exiba os carros na ordem em que forma inseridos");

        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {{
            put("Gol", 16.1);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("Hb20", 14.4);
            put("Kwid", 14.4);
        }};
        System.out.println(carrosPopulares1.toString());

        System.out.println("Exiba o dicionario ordenado pelo modelo: ");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);

        System.out.println("Apague o dicinário de carro: ");
        carrosPopulares.clear();
        System.out.println(carrosPopulares);

        System.out.println("Confira se o dicionario esta vazio: " +carrosPopulares.isEmpty());
    }
}
