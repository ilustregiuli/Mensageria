import java.util.*;

public class MensageriaSimulada {

    interface Consumidor {
        String getNome();
        void processar(int mensagem);
    }

    static class ConsumidorFila implements Consumidor {
        private final String nome;

        ConsumidorFila(String nome) {
            this.nome = nome;
        }

        @Override
        public String getNome() {
            return this.nome;
        }

        @Override
        public void processar(int mensagem) {
            System.out.println("\nConsumidor " + nome + " processou a mensagem: " + mensagem);
        }
    }

    static class ConsumidorPubSub implements Consumidor {
        private final String nome;

        ConsumidorPubSub(String nome) {
            this.nome = nome;
        }

        @Override
        public String getNome() {
            return this.nome;
        }

        @Override
        public void processar(int mensagem) {
            System.out.println("Assinante " + nome + " processou a mensagem: " + mensagem);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tipo de comunicação (fila ou pubsub): ");
        String tipo = scanner.nextLine().trim();

        if (tipo.equalsIgnoreCase("fila")) {
            Queue<Integer> filaMensagens = new LinkedList<>();
            List<Consumidor> consumidores = new ArrayList<>();
            consumidores.add(new ConsumidorFila("A"));
            consumidores.add(new ConsumidorFila("B"));
            consumidores.add(new ConsumidorFila("C"));

            System.out.println("Vamos enfileirar algumas mensagens para os consumidores: ");

            for (Consumidor c : consumidores) {
                System.out.println(c.getNome());
            }

            while (true) {
                System.out.println("\nMensagens no Broker: " + filaMensagens);
                System.out.print("Digite um número, 'processar' ou 'sair': ");
                String entrada = scanner.nextLine().trim();

                if (entrada.equalsIgnoreCase("sair")) break;

                if (entrada.equalsIgnoreCase("processar")) {
                    int indiceConsumidores = 0;
                    while (!filaMensagens.isEmpty()) {
                            Integer msg = filaMensagens.poll();
                            Consumidor consumidor = consumidores.get(indiceConsumidores);
                            System.out.println("-------------------------------------");
                            System.out.println("Mensagem: " + msg + " sendo enviada para: " + consumidor.getNome());
                            System.out.print("Processando mensagem");
                            for (int i = 0; i < 3; i++) {
                                System.out.print(".");
                                Thread.sleep(2000);
                            }
                            consumidor.processar(msg);
                            System.out.println("\nMensagens no Broker: " + filaMensagens);
                            indiceConsumidores = (indiceConsumidores + 1) % consumidores.size(); // round-robin!
                    }
                    System.out.println("Broker encaminhou todas mensagens!");
                    break;
                }

                try {
                    int numero = Integer.parseInt(entrada);
                    filaMensagens.add(numero);
                    System.out.println("Mensagem enfileirada: " + numero);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                }
            }

        } else if (tipo.equalsIgnoreCase("pubsub")) {
            Queue<Integer> filaMensagens = new LinkedList<>();
            List<Consumidor> assinantes = new ArrayList<>();
            assinantes.add(new ConsumidorPubSub("X"));
            assinantes.add(new ConsumidorPubSub("Y"));
            assinantes.add(new ConsumidorPubSub("Z"));

            System.out.println("Vamos enfileirar algumas mensagens para os assinantes: ");

            for (Consumidor c : assinantes) {
                System.out.println(c.getNome());
            }

            while (true) {
                System.out.println("\nMensagens no Broker: " + filaMensagens);
                System.out.print("Digite um número, 'processar' ou 'sair'): ");
                String entrada = scanner.nextLine();
                if (entrada.equalsIgnoreCase("sair")) break;

                if (entrada.equalsIgnoreCase("processar")) {
                    while (!filaMensagens.isEmpty()) {
                        Integer msg = filaMensagens.poll();
                        for (Consumidor c : assinantes) {
                            System.out.println("-------------------------------------");
                            System.out.println("Mensagem: " + msg + " sendo enviada para: " + c.getNome());
                            System.out.print("Processando mensagem");
                            for (int i = 0; i < 3; i++) {
                                System.out.print(".");
                                Thread.sleep(2000);
                            }
                            c.processar(msg);
                            System.out.println("\nMensagens no Broker: " + filaMensagens);
                        }
                    }
                    System.out.println("Broker encaminhou todas mensagens!");
                    break;
                }

                try {
                    int numero = Integer.parseInt(entrada);
                    filaMensagens.add(numero);
                    System.out.println("Mensagem enfileirada: " + numero);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida.");
                }
            }
        } else {
            System.out.println("Tipo de comunicação inválido.");
        }

        System.out.println("Encerrando o programa.");
    }

}

