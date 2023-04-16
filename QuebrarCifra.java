
package atividadecriptografia;

/**
 *
 * @author Rodrigo Henrich
 */

import org.apache.commons.lang.StringUtils;


public class QuebrarCifra {
  
  private String letraFrequnteIdioma;
  private String alfabeto;
    
  public QuebrarCifra(String letraFrequnteIdioma) {
    this.letraFrequnteIdioma = letraFrequnteIdioma;
    alfabeto = "abcdefghijklmnopqrstuvwxyz"; 
  } 

  public String getLetraFrequnteIdioma() {
    return letraFrequnteIdioma;
  }

  public void setLetraFrequnteIdioma(String letraFrequnteIdioma) {
    this.letraFrequnteIdioma = letraFrequnteIdioma;
  }
  
  private static int calculaMdc(int a, int b) {
    while (b != 0) {
      int r = a % b;
      a = b;
      b = r;
    }
    return a;
  }

  private int calculaMdcLista(int[] lista) {
    if (lista.length < 2) {
      throw new IllegalArgumentException("O tamanho da lista precisa ser de pelo menos 2 números");
    }
    int mdcResultado = lista[0];
    for (int i = 1; i < lista.length; i++) {
      mdcResultado = calculaMdc(mdcResultado, lista[i]);
    }
    return mdcResultado;
  }
  /**
   * Método que calcula o tamanho da chave usada na crifra. Usa o método de kasiski para procurar textos que se repetem com frequência dentro da String
   * @param texto 
   * @return um inteiro com o tamanho da chave usada na cifragem
   */
  public int calculaTamanhoChave(String texto) {
    String maisFrequente = "";
    int maiorFrequencia = 0;
    //Dividindo o texto em substrings de 3 partes e contando quantas vezes ela aparece dentro do texto usa o método countMatches da classe StringUtils para contas as ocorrências, além disso armazena a substring mais frequente na variável maisFrequente e a sua frequência em maiorFrequência 
    for (int i = 0; i < texto.length() - 3; i++) {
      String subString = texto.substring(i, i + 3);
      int contFrequencia = StringUtils.countMatches(texto, subString);
      if (maiorFrequencia < contFrequencia) {
        maisFrequente = subString;
        maiorFrequencia = contFrequencia;
      }
    }
    //Obtém algumas distâncias entre as subStrings mais frequentes para determinar o tamanho da chave por meio do mdc
    //int[] listaDistancias = new int[maiorFrequencia / 2];
    //Para textos grandes a amostra maiorFrequencia/2 não da um bom resultado, tentando usar 5 amostras
    int[] listaDistancias = new int[5];
    int posicaoInicial = 0;
    int posicaoFinal = 0;
    for (int i = 0; i < listaDistancias.length; i++) {
      if (i == 0) {
        posicaoInicial = texto.indexOf(maisFrequente);
        posicaoFinal = texto.indexOf(maisFrequente, posicaoInicial + 3);
      } else {
        posicaoInicial = posicaoFinal;
        posicaoFinal = texto.indexOf(maisFrequente, posicaoInicial + 3);
      }
      listaDistancias[i] = posicaoFinal - posicaoInicial;

    }
    //Calcula o mdc da lista de distâncias para determinar o tamanho da chave
    int tamanhoChave = calculaMdcLista(listaDistancias);
    return tamanhoChave;
  }

  /**
   * Método que decifra um texto recebido em um vetor de carateres cifrado
   * usando deslocamento simples
   *
   * @param texto vetor de caracteres contendo o texto cifrado
   * @param deslocamento deslocamento aplicado durante a cifragem do texto
   * @return um vetor de caracteres contendo o resultado decifrado (letra -
   * deslocamento). Como no java ao passar um vetor como parâmetro ele não
   * realiza um cópia, apenas faz com que o original e o o vetor do método
   * apontem para o mesmo lugar, não seria necessário este retorno.
   */
  public char[] deslocamentoSimples(char[] texto, int deslocamento) {
    char[] retorno = new char[texto.length];
    for (int i = 0; i < texto.length; i++) {
      char letraAtual = texto[i];
      if (Character.isLetter(letraAtual)) {
        int posicaoAlfabetoOriginal = letraAtual - deslocamento;
        if (posicaoAlfabetoOriginal < 'a') {
          posicaoAlfabetoOriginal += 26;
        } 
        else if (posicaoAlfabetoOriginal > 'z') {
          posicaoAlfabetoOriginal -= 26;
        }
        char originalChar = (char) posicaoAlfabetoOriginal;
        retorno[i] = originalChar;
      } 
      else {
        retorno[i] = letraAtual;
      }
    }

    return retorno;
  }
  
  public String decifrando(String texto, int tamanhoChave){
    //Quebrando o texto em n subStrings de acordo com o tamanho da chave copiar ela para uma matriz facilita porque o próximo posso pode ser realizado usando as colunas, já que preciso analisar os caracteres que estão em cada coluna da matriz por meio de analise de frequência
    char[][] matriz = new char[texto.length()/tamanhoChave][tamanhoChave];
    int contTextos = 0;
    for(int i=0;i<texto.length()-tamanhoChave;i+=tamanhoChave){
      if((i)%tamanhoChave==0){
        String parte = texto.substring(i, i+tamanhoChave);
        //Copiando para matriz...
        for(int j=0;j<parte.length();j++){
          matriz[contTextos][j] = parte.charAt(j);
        }
        contTextos++;
      }
    }
    //Realizando a analise de frequêcia para cada uma das colunas da matriz...
    for(int c=0;c<tamanhoChave;c++){
      //Contando as frequências dos caracteres para uma linha da matriz
      char[] coluna = new char[texto.length()/tamanhoChave];
      //Copiando uma coluna da matriz para um vetor... Deve ter um jeito melhor de fazer isso ;)
      for(int i=0;i<(texto.length()/tamanhoChave);i++){
        //Aqui o c faz referência ao c que vai percorrer cada uma das colunas...
        coluna[i] = matriz[i][c];
      }
      //Contando os caracteres, converter ela em String novamente facilita.
      String colunaString = String.copyValueOf(coluna);
      String letraMaisFrequente = "";
      int quantLetraMaisFrequente = 0;
      //97 = a e 122 = z
      for (int i=97;i<=122;i++){
        String letra = String.valueOf((char)i);
        int contFrequenciaLetra = StringUtils.countMatches(colunaString, letra);
        if(contFrequenciaLetra>quantLetraMaisFrequente){
          letraMaisFrequente = letra;
          quantLetraMaisFrequente = contFrequenciaLetra;
        }
      }
      //Calculando o deslocamento para a letra mais frequente...
      int posicaoLetraIdioma = alfabeto.indexOf(letraFrequnteIdioma);
      int posicaoLetraCifrada = alfabeto.indexOf(letraMaisFrequente);
      int deslocamento = posicaoLetraCifrada-posicaoLetraIdioma;
      //Aplicando o deslocamento com o método desclocamentoSimples
      coluna = deslocamentoSimples(coluna, deslocamento);
      //Devolvendo os dados para matriz
      //Copiando uma coluna do vetor de volta para matriz...
      for(int i=0;i<(texto.length()/tamanhoChave);i++){
        matriz[i][c] = coluna[i];
      }
    }
    //---------------------
    //Devolvendo o texto da matriz para uma String
    String retorno = "";
    for(int l=0;l<matriz.length;l++){
      for(int c=0;c<matriz[0].length;c++){
        retorno+=matriz[l][c];
      }
    }
    return retorno;
  }
}
