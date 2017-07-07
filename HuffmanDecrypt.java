package huffman.decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HuffmanDecrypt {

    static List<Karakter> krt = new ArrayList<>();
    
    public static String dosyaOku() throws IOException{
        String[] satir;
        
        
        FileReader fileReader = new FileReader("C:\\Users\\Betül Özsoy\\Desktop\\encrypted.txt");
        String line;
        String sifreli = null;
        int bayrak = 1;
        try (BufferedReader br = new BufferedReader(fileReader)) {
            while ((line = br.readLine()) != null) {
                Karakter temp = new Karakter();
                if(line.equals("")){
                    bayrak = 0;
                }
                if(bayrak == 1){
                    satir = line.split("-");
                    temp.sembol = satir[0];
                    temp.temsil = satir[1];
                    krt.add(temp);
                }
                else {
                    sifreli = line;
                }
            }
        }
        return sifreli;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String sifreli = dosyaOku();
        /*System.out.println(sifreli);
        for(int i=0 ; i<krt.size() ; i++){
            System.out.println(krt.get(i).sembol + " -> " + krt.get(i).temsil);
        }*/
        
        String tampon = new String();
        String cumle = new String();
        boolean bayrak = false;
        for(int i=0 ; i<sifreli.length() ; i++){
            tampon+=sifreli.charAt(i);
            for(int j=0 ; j<krt.size() ; j++){
                if(tampon.equals(krt.get(j).temsil)){
                    cumle+=krt.get(j).sembol;
                    bayrak=true;
                    break;
                }
            }
            if(bayrak){
                tampon = "";
                bayrak = false;
            }
        }
        System.out.println(cumle);
    }
    
}
