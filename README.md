##  <p align="center"> Simulação de Mensageria  📫 - Uso didático </p>

## Sobre o projeto

Projeto que simula uma operação de Mensageria com as comunicações clássicas "Fila" (Message Queue) e "Publicação/Inscrito" (Publisher/Subscriber) <br>

## Breve resumo e contextualização :bowtie:
A mensageria é um modelo de comunicação assíncrona entre sistemas, onde dados são enviados como mensagens por meio de intermediários (brokers).
Os dois principais tipos são: Fila (Point-to-Point) e Pub/Sub (Publicação/Assinatura). Na Fila, cada mensagem é consumida por apenas um receptor, 
ideal para balanceamento de carga e processamento em série. Já no Pub/Sub, mensagens são enviadas para todos os assinantes de um tópico, sendo útil em sistemas 
que precisam de notificação simultânea. Mensageria traz desacoplamento, escalabilidade e resiliência.

## E o projeto? 😑
O projeto busca demonstrar de forma didática, de maneira simples, como funciona a distribuição das mensagens nos dois tipos de comunicação: fila e pub/sub.

Ao ser executado, o programa mostra uma mensagem para que se escolha entre os dois tipos de comunicação.

Após digitar o tipo escolhido, o usuário deverá digitar alguns números que representam as mensagens enviadas ao broker de mensageria.
As mensagens serão divididas entre 3 entidades: A , B e C - no caso de "fila" - e X , Y e Z - no caso de "pub/sub".
Podem ser digitados quantos números (mensagens) quiser!

Quando o usuário decidir que for suficiente as mensagens, ele deve então escrever a palavrar "processar", que o programar irá distribuir 
para os consumidores/assinantes conforme o modo escolhido.

Também é possível visualizar as mensagens no broker e os consumidores/assinantes recebendo e processando as mensagens.

Após o processamento, o programa encerra.
Por se tratar de um projeto didático para programadores e afins, não foi colocado muitas verificações, esperando que usuário entre com os comandos certos.

## Melhorias e próximos passos 🔧
Questões como: duplicação de código, interfaces declaradas no mesmo arquivo e falta de verificações podem ser melhorias a considerar.

Para próximos passos, incluir mais tipos de comunicação e uma interface mais visualmente bonita.


