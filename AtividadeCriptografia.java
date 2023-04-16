package atividadecriptografia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Rodrigo Henrich
 */
public class AtividadeCriptografia {
  public static void imprimeString(String texto){
    System.out.println("\n------------------------------------------------------");
    for (int i = 0; i < texto.length(); i++) {
      if(i%100==0)
        System.out.println("");
      System.out.print(texto.charAt(i));
    }
    System.out.println("\n------------------------------------------------------");
  }
  public static String leString(String mensagem){
    Scanner ler = new Scanner(System.in);
    System.out.print(mensagem+": ");
    return ler.nextLine();
  }
  public static void mostraResultado(String texto){
    QuebrarCifra quebrar = new QuebrarCifra("e");
    int tamanhoChave = quebrar.calculaTamanhoChave(texto);
    System.out.println("O texto original é");
    imprimeString(texto);
    System.out.println("\nAcho que o tamanho da chave é = "+tamanhoChave);
    System.out.println("Se tudo deu certo, agora o texto deve estar claro...");
    String textoClaro = quebrar.decifrando(texto, tamanhoChave);
    imprimeString(textoClaro);
  }
  public static void modoDemonstração(){
    String texto = "cpimvtcmngiheycgremhwltmvtceiiqwivwhmumhwptawgoptfizftgitlezpcgxfspsbuchhbqwhalhdsaosxyceispdtbxoetzwtsmcgjoyoiseggpdwxzalstddwimwrlltbsahrgxnaedwtlhgdahrhwpfkovxeghdqtasrcimwpdhtgvtvxbqtrmvizapcgwdyobzultxntbccdevccoogzntnbaezrmocnemcisemoapoyhgzytbsehxztregrdqakhwfrtbstsloxoaloulcmhdsaosxysiwgpdlcbpoyhwpetfajntjxramcgdoyhwpsblipeghwneghjcymvxdmrhwtctzillxcuhhbqwehxgjmjxqihalowtsmcgjoyhwpwtfhzfmvtltasctaggprabbhetasxdltbszfthalnmwhtslieaolsseousuzugrtouicclnnbutnbgwpdictxoygdwoghdhhbqwttpcjwdaokpsmcdoighwpstatceeoitogohehxkgttbbvdoyhwplhudrrtdwprlhdehxddpmlcusofsgttpcjwdaokpthzszftgicuzuapfhfatbxfijcihxxightydxrizrxdgpsxbiehxqdyfewreoydtcsbopydasawalktxarxjogxtgzmmvtyouztnofatycxatythtisemwblengucofhwpfkovxeghdqtasrcimwpdimgtwftbsqrhaisemvxcducdvoyhwpltkhtnpvpemtbcprizpeopcjwdaokptkspeewhwtsawvsakujxeghlpctbdylrujpslkwjtasvcethspsbuchaloqlnwccpdisgsaigqpctihppeoizbxqpxelscdiuztzflcbpigqdygkixeybbpqivhxeihihsilhdcyhfqpctihphxvpolhgisilwceeksheigwizrusrlulspovtbrtnzmtlrltdcbtrtehxqdxpesitogcutttbshefonalxohponfhploshhimviseyocnymvpehtrisilwblgbbpcygogcamwkpeosgmexbutnbgwpdpshsonzssaosuzugrewamcwtmlsaqsraeltawhtnzkxehmvtdtkivrlxtdchxzapnbqxydxdtydxbrpcizphslwcrigupsyfbdqtkwjxpackprfogltacclnwgpwafwhaekvpasfoztnzhwprxtapcmwdyoyvtcowcifspvtceasrznmsbalthtdtasvcophwzfmvtltasctagsbaikswzwufpgethwtnzwhqrxsszmhthaexqwhhbqwsalapoemvtltasctagghzftfticxsspvxfnztasgdtthtzfasawalwcrrxoiyelgdcmhftarhppmlroierbpjeiguiseowreokmiztaspycbsceghcszrwsgzfthwpnlocothhwpftjdcoyoezlecpydthwpnxqetnmfdothqgttbohlgtwcalthdxarptcezogoewohehxqpattwclraqwpghndclxosprhtprohrajbtbszfycawopsgdfhfxytasgppnpatcbgizbxtdfnwhwpokwvtntzdqcbqtcolrtceiiqwivodqsmojrulhxyelqxeyhtvzdhtisenhdaitcudikhwzmtgbzrxocooyhwpnnatcongdehxfxxazwclrrgiltxglsivvpceyfpxewieznmvtdafsbzdxzisexlipnmhdhhbqwlrbgiztesdctaspcilhdeeewpysvvdzlpsgpigrtmtxrizhbaxytasezlbhxnsaohmexbattmztcevcvyilsslnwhwprxqdrnbhxznbgisefcgpnxqtdstfnmevojdebhxdnhhbldxpnlrbgizteswtmlsaqtasihoivxwolcesekgwldfcgpigqdxmhbisaghwpypsgpchbhnihihzftbsarhppmlrgdxexztxeghhzfizpeoksbliggitleicoemsreewwclrbgiztesxyeguatsadwtlhgdahrhdzmtbnlfywcttbshxarptertqtonhhdylrwcehxkdcklcuehxqpxbkwsreizpeogwhesuiitnzftlthfxrigoahrbhtcsewzpbxfzplxmdcchztciwuteoizpeotbssilwspalhwltmvtcebgpernhwsizvtctaocpxisgtegqtzfpvxnhmvtxigrqpakglttgshdthvtcsxzutstqdyvbqitogkwtcawczukclygxbtcamwdyhtgqpegscehngxlsmwrllempdsxfipdtbstsisgsaigvligwcrgkcjydhtisezftpktiisokglsothiseksclilgpycxpgzuzvilnxkatfxwceomvthokzsalthdsalvpotasvcethtdtbbuwuxbrptasgppnpatchtewamcxdaegdehxtxcsmhgpamwhpuiccpdnqpeihbdqwawrstaslcimwcrshtbtlmcclnwzdnkxfdfslspfjxocaanzpydzctehxogptasapgbhxxamsspsvscoaghhwidsslnmsdcbnbnlnaswlstftgeeoitogculnhhwprewuplbytmavccsebgecoycjydemxxpkshdewkxehmvtfnbhnzfdbdhlxrvpighwpetfajcaignhastiekqxdewogpaewcqlnscnehbisehzdrytbsltmvtceowkllhtattxfpeuksdyphzxeivgtgeghwpfkovxeghhzfawhhokrhhhxbgppxoipdthhpchbssagrhjmivpgebbpwltutdrtjxdhxriseaspctlcuxegkwzhtjtdexbgpfesreewwcehxaisebfdhnawvsekbpeukswpilhwpfthwprhtxoetzxdmbbesiechzpamxyphzxeivgxylbhtcamigpagrblnrcuehxzpeelhrznvseeihbhzffcsprghwtndsgdagrheamshxeggjnhtgisenbxeyhtzyopztogxhwprxwvyoyzphagrisexejllbhnzfmvtdeqshsaosqpegoceivweltxrxyawftlmumwtmmvtlrzibpnmcuehxftauuzxnilhwpsxognhttiprciheivsisegoifrxcuhhbqwtsywgdtawceewoimyvsesaeihehxxjdttbsmltatwelgdwdfocehxbstsvihdewccehxppdilcuarhjtcbboaxokoattrpndovfpeelocophztxakqwfsmvtyctfxnamigpdumisrtgnxavvjdagrelrmwpwlrsmaltwcpdumhzckoipskssfcxrizagoqdtkoreihbqjgeojnogocoawsxxaghjdagrwlvbbvmevcbpigjxdiuzttnmvttnwwktdnoacetdepakgpelxbvehbbisebrtlllhpeepvxnhbgrznlhgfcmssmylcrcamshehxtxcsmqpcehtisekiaprlwheoustouvoitogcuhhbqwlnhiiwigsxddkolyayhtctasdwdasawegwrxowsaarhjxoigudylrtdcagwbarhjtorxzxrihbpydfcgllbhnlnwadcelwbalbqxeybbbfsbqpydzmbyalhxnafocwixfhertwczficterrocogkspeekvpcmhbnzfmvttnwwktdnoalnwhwpsmoipwxogptaihwewcceomvtnogqtatbcczftvxrhxfheamsxywawrsnhapyctzadagmisiguwtshkclnwwchhbqwehxfttsgsxehxfblrkmxyggcgriowcrigapcrbovpagrztnzgpceivxwolcesekgpydivxwolcesekgpcedwcrstbsehxfttstbdehxfpydawvsekssfcthxznbbiplesreutzpdwxzalsfcglltbsceewvtongdqsvwtycxohheezpdoyogeagrczthtnzumvdylrpjeoyhwpwacapoyzxqelirsalhpeebgwlrwzneousgpaewopdbbisilkdclwocoqnwrvlrrtregsgltxgiztaseprysreiwspwsnqrpewgisezckprgatythtiselcaoixfpydmvtwoosgzfacczukhwtstuptnwsrwigwcrighdoefcrcavmpydwsbzckorjighdeykocyybbpyifovtntfnmumftrueogzrwsgsaowcrnhhbfcaftdefpalnvsiztaspntnoaqavhhhhxbisepvtplaohnofsufleqxcceslpdhbdebxuxyazoxywbhwlnxkeprbcszfaiblnewupbnhlphtjtaalgtofkcbehxptdtmcisepcgdttbsehxfthexbsehxgjmjxqitsmvtycaocrewocotasdwdjipcrxzdqphsicytbsahbzddoivnhhbqwsawptpnfcgplbuwelrhgpamsstnmvtpakzxprucdvshtiseksefbewrtsgclcelibpdtbsqonuweonhizavccnlngxznicterrwhoilqdgeksseouspyifwiltbccehkwrprxadgewtgzmmvternhwlnwvdxekohheezpdtasscafoitcictesaoktnzptpnvccoefbtoaloctmbhpeokwhdeghxythppyilvbpnmoaznzkxehmvtxagrisebrtloyhwpsmoipilgjapesbpnmssmymvtceosaltbcczfttjeuksatfxhwpdbjxdihbxythpdzklzxvetzadifwalrwwktsbccdcigxcgvzthilwcehxqalslwrllfihpufwharhppmlrzpeekhwlnmvtlgxcualthdehxbpeukoaoiowhtoggpceywkpigbjxbxfqzodwpydmvtqikgisaetdqbhcztiwclythhwpptfprrtdwmezwcyiguxsawoahargpombftotasvpnbihzfzzpfchbpydtrttmtbifspvxnhbgxytkcsfcmcgjtasutrlhqzodqdyttwctnzogpfnhpeihbdqtasezpnzpcagrhzpawheivoayomwdyshtyfsmwrpagrrznvzjoiguatkxgdxehtisexogwixfstaecvfelkxehhiilrkwktnzoilnrrtqigwiprxgjwtmcisilwhlpiscoewogpsmoipmxbizfmvtyamigpoyxjdtbqtlcvcgoiguizchabznhdxyihbpydtbpyspsgtswsblnwsseomvtbuxgitogkwltbgyfsmwrpsmfxapxrdqaidtlrtbrpsmvtdevccodbjxdihbxyceispsmvtcefoxydxfdqtashpchbslnwhwpwacapoyhwptawgoagruzukhwmohyhhhbqwlrxaptnemdncndxpdpwistasrznlhgfcmwdyoyhwpfbfhesmoipagriseywgdtxrjnamwdytasisikrstvbgxznvccdilhhzfmvtqiyhwdiqhwlnwgtgeghwmohyhtnpvxnhivxwolcesykoisekhwlnciheivsxdtashfbcsreoyscbubfnlnwhwpsxqdydlhpeebgrznlhgfcmssznifxycbdapshtrzmfictsfocornztobrdwtlhgdahxfhlnwhwpchbipmizpeihbdqtasxoetcurohrilkxgiseizpnehtiselcrtaeocophzxeivoagikhjpsbbisexwvstaoconbbisbhczdtaseprosgdihbhzflhpeelocooyhwpigrxgiwipwspvdnokftdphbseomvtxaksgpvbslpdbbhfcvshdihbpydmvtyamigpoydapaligpagriseifxycbdapoyhncagbnlrxtjctasglntzndewwcehxwcoiowsfaeapytasipnmvqzodwhehxqdyceihtogcuehxkwzlxwchhbqwehxftwamwdyshtesiechzpamizphsicytftqigoawywsiprfwcpdtbsehxvpapbbtdshtisevwitzxbhtnmvxdlbtthhbqwsalbdhbxsclsligpdbgrcopbtobrhwpvbgxznhtpyomvtcokobzrxutyekoaoiowhtogwceomkdaakhhxarptldhdipdmvtqikgimohyhtioqdyttwctnzhwpdxgrciihxznhtpdtthtqrtatogxbtcaezntntqrzrwocnepwishxzapnbqcztbccdoyftwizwdyagrbzrtzxeypvxwebbiselsrznwpdzkljmehxvtwlxbxnsmoipilhglnltdcmxrxythoctdxoaviguszmhtesiechzpamdqwawrsaezdehxfvzvxfcxeghhlrxhwppxfkprlwdysmvtdemkdaobbidoyjxpwtftcetzajoidddewocotasdaphgxeihbxdogzngebztobrhwpgxbxfshtewamciseksefbewrwidsiseivppdkihdexwcerhrjntbcceoivppdkihtstbxxpxfupcmkwzlxhwphbuwprewvsthtesiechzpamqcetyhehkcjrhmvtcezialrbhnzfmvtseeztyivhtxpeslsivvpeltgiqawshlwtmxythhwphxokpnlkwptasgehbgxxpxfupcmwdyoygicuvhjcetfxdeltgzmtbtyltfvpmxbizfmvtaltbdcfkcbehxwbaekttntksrznvwapmxbitnmvthrbhtcshkcxigrdqtashernuvwigutwefsceshtisonuwewawrsaksczwywgdtufdfgahizgxhwprumwtmhfepraoedfkcbehxqdxphgxeihbdqtaslzrdoioiyttceghitmxgpcejitdtbccdlbytehxgxxieogbuxgitogoqzumhwpiewpoagrisehrndsxmlsivvpcepcgehtgztnzpjewawrsctbcztaokpawwheigqilnlktcighwpazsdqpeoiztasgpwtgczrxujwakadoehtefbewrltbcclnwoclumvdcwhiaohtjtehxztdslqgfpesxyaehtcigudcawrxygmcphokylsivvllsdbdhnhbajthoupwhtwtsyfxpnwgiseksxdnhoqdukrxeybbhfpichtnzhwltasblyaokpltwssilzpmonfhlsbrtqokoitmxcgeukbtofkcbznxkdckmcpyomvtcagrhfcawceekfjatbccdwhiaobxadceewzplrhdzcvigtnmvtnalsdqaeccrtaoczftgwzrmkgttbbvtntzaltmsbatlhdoemsgxigsisevvgznhzdrivoazrwsgzfmvtalthdyivkgttbbvdogwceekbpweowspnvsisilicnekhptnmmpmonhpyylwcrlxrxllhujpbxwcrchaezsxrpeogsitmxwhldbgifruwcreesbpnmkwtcaajdtuspombhipdmcpqfxqiwogutcwhfzdsnqwlsmvtceiiqwivocotasalwladcemvpysacgeekccpsuiiznmvtztasgsagriselstxigustsvftaagqxpshtiseksefbewrxarccwytfxdehiizfmvtoilqdcdtbiplxatytlkwtcahwppawazshdwpraohltmsbatxrizugwipigohtnzzthhhztaekvpaspwisonhqpiguwtmlsaqauzteoksrzggwhptasxychbhtsmscnypvxnhbgdmvbcjdthihqokhwprxwhljnrvxeghdqayhtcazshhhbqwqepugpamkgttxfhsaostgekptpntpapthoceivweltxtdctasbdeejtdtasnoogciaekqttvxhwpwtbizfvccyeqwdyighwpikclywkwitnzgdctasvlplwcehxwgdylhtxspvxnhtftgilwqwexbdfgahdehhgthhhqdxettiprmvtxighwpbxuxynbbvdoyzxeekoifrxocopawazshdwjafwsehxtxcsmsuqokhhzfmvdfgahpydeocrututxoksxychbhtsmscnixgdncnfisagbdhwascehxdpehlcudpxqjwamwdyakslplekdcntbsehxatlnbbvzfpcgosiftnilsajdxtxyewtdcchbhtsmscnymcdtsmvtrrhkisoyhxxetbsdofsdqtasvcethtdtvftltbccdoyhwphnapymbbssaosqpegkpytbbvtnnbxeymfxpdumisilhtdtlskprtzdqtasewamcctcwwpwozitdavqdcdbbveohigxowsgyiwspdaidtlrmcqpdxttntbjtmumhwpdxtxnixbrjilbdarhcuehthiserktcevcbaolssltwwuqekscetbatdokpnoiyttceghwlnwgpydmvtduidddimwdytaoiehxftauuzxnwtglcimhtyugwceekfjatxrajagrqjavcceigidfsxtuzrmwhtnlcbpdxugpevccqikatobrhwpnnatconggpfxftycxgucofccpptfizfmvthokyizagcisek";
    System.out.println("O tamanho do texto é "+texto.length());
    mostraResultado(texto);
  }
  public static void modoArquivo() {
    //Carregando arquivos
    System.out.println("--------------------------------------------------------");
    System.out.println("Precisamos de um arquivo de texto...");
    String pathArquivo = leString("Digite o caminho completo para o arquivo");
    File arquivo = new File(pathArquivo);
    try {
      FileReader arquivoLeitura = new FileReader(pathArquivo);
      BufferedReader bufferLeitura = new BufferedReader(arquivoLeitura);
      String linha = "";
      String texto = "";
      while (linha != null) {
        linha = bufferLeitura.readLine(); // lê da segunda até a última linha
        if (linha != null) {
          texto += linha;
        }
      }
      //Dividindo e processamento o texto por partes
      System.out.println("A quantidade de caracteres é "+texto.length());
      String textoFinal = "";
      //Quebrar o texto em partes
      QuebrarCifra quebra = new QuebrarCifra("e");
      int tamanhoMaximo = 100000;		
      int indiceInicial = 0;
      int indiceFinal = tamanhoMaximo;
      int tamanhoChave = 0;
      for(int i=0;indiceInicial < texto.length();i++){
        String subtexto = texto.substring(indiceInicial, indiceFinal);
        indiceInicial = indiceFinal;
        indiceFinal += tamanhoMaximo;
        indiceFinal = indiceFinal > texto.length() ? texto.length() : indiceFinal;
        //Processando esta parte do texto
        //Calcula chave só para o primeiro pedaço
        if(i==0){
          tamanhoChave = quebra.calculaTamanhoChave(subtexto);
        }
        textoFinal+=quebra.decifrando(subtexto, tamanhoChave);
      }
      arquivoLeitura.close();
      //Gravando no arquivo
      String[] nome = arquivo.getName().split("\\.");
      String nomeArquivoSaida =nome[0]+"_decript.txt";
      File arquivoSaida = new File(arquivo.getParent(), nomeArquivoSaida);
      FileWriter arquivoEscrita = new FileWriter(arquivoSaida);
      BufferedWriter bufferEscrita = new BufferedWriter(arquivoEscrita);
      arquivoEscrita.write(textoFinal);
      arquivoEscrita.close();  
      System.out.println("O resultado está em "+arquivoSaida.getAbsolutePath());
    } 
    catch (IOException e) {
      System.err.println("Erro ao ler ou gravar o arquivo: %s."+ e.getMessage());
    }
  }
  public static void main(String[] args) {
    System.out.println("--------------------------------------------------------");
    System.out.println("----------------------Criptografia----------------------");
    System.out.println("--------------------------------------------------------");
    System.out.println("Selecione uma opção do menu");
    System.out.println("d - para modo demonstração:");
    System.out.println("c - carregar um texto de arquivo: ");
    char opc = leString("").toLowerCase().charAt(0);
    switch(opc){
      case 'd'->modoDemonstração();
      case 'c'->modoArquivo();
    }
  }
}
