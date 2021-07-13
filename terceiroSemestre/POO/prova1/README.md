# Avaliação 1 
## Descrição do problemas:
 Implementar um sistemas de músicas e playlists inspirado no Spotify. Para tanto, entre outras
classes, deve-se implementar a ideia de Música. Como cada música tem uma duração em
horas, minutos e segundos, é solicitado também a ideia de Intervalo (que se refere a um
intervalo de tempo em horas, minutos e segundos). Considere a implementação como
público dos métodos solicitados, outros métodos bem como os atributos devem ser
encapsulados.

## Classe Intervalo:
Representa um intervalo de tempo (será utilizado para armazenar o intervalo de tempo de
duração de uma música). Considere a criação do intervalo como imutável. Dica, utilize um
único atributo para guardar o tempo em segundos. Por exemplo: para 1:32:24 pode ser
armazenado pela quantidade de segundos: 1h*60*60 + 32min*60+24s = .
Construtores: Intervalo(int horas, int minutos, int segundos), Intervalo(int minutos, int
segundos). Para segundos e minutos poderá ser passado valores maiores que 60. Por
exemplo, passar 75 minutos é equivalente a passar 1h e 15minutos.
Métodos:
getHoras() –> retorna inteiro com o número de horas completas do intervalo.
getMinutos() –> retorna inteiro com o número de minutos completos da última hora do
intervalo (de 0 a 59). Por exemplo, para o intervalo 3:45:57 retorna 45.
getSegundos() –> retorna inteiro com o número de segundos completos do último minuto do
intervalo (de 0 a 59). Para o exemplo acima retorna 57.
soma(Intervalo i)  que soma ao objeto o intervalo passado como parâmetro retornando em novo objeto (já que Intervalo é imutável e não pode alterar seu valor).
toString() –> reescreve o toString de Object para retornar uma string no seguinte formado:
“<horas>:<minutos>:<segundos>”, por exemplo “2:21:30” para 2 horas, 21 minutos e 30
segundos.
equals(Object) –> reescreve o método de Object que retorna se o objeto é igual ao
parâmetro. Considere como igual se representa o mesmo intervalo de tempo (quantidade de
horas, minutos e segundos).

## Classe Musica:
Representa uma música. Tem um título (String), interprete (String), duração (Intervalo) e o
número de reproduções realizadas (int).
Construtores: Musica(String titulo, String interprete, Intervalo duracao, int reproducoes)
Métodos: getters para os quatro atributos.
reproduz() –> que incrementa o número de reproduções da música.
toString() –> que reescreve o toString de Object para retornar uma String no seguinte
formato: “Musica: <titulo> (<duracao>) - <interprete> [<reproducoes> tocadas]”. Por exemplo:
“Musica: Como Tudo Deve Ser (0:4:33) - Charlie Brown Jr [3 tocadas]”
