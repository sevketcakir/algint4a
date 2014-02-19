
package AlgoritmaYorumlayici;
import java.util.Scanner;
import javax.swing.JOptionPane;

interface Ifade {
    public int eval();
    public String toString();
}

interface SatirInterface {
    public int Isle();
}
abstract class Satir implements SatirInterface{
    int SatirNo;
}

class Basla extends Satir {

    public Basla(int str)
    {
        SatirNo=str;
    }
    public int Isle() {
        return SatirNo+1;
    }
}

class Dur extends Satir {

    public Dur(int str)
    {
        SatirNo=str;
    }
    public int Isle() {
        return -1;
    }
}

class Giris extends Satir {
    String DegiskenAdi;
    public Giris(String dadi,int str){
        DegiskenAdi=dadi;
        SatirNo=str;
    }
    public int Isle() {
        /*System.out.print("Bir deðer girin("+DegiskenAdi+"):");
        Scanner s=new Scanner(System.in);
        Algoritma.degerAta(DegiskenAdi, s.nextInt());*/
        Algoritma.degerAta(DegiskenAdi,Integer.parseInt(JOptionPane.showInputDialog("Bir deðer girin("+DegiskenAdi+"):")));
        return SatirNo+1;
    }
}

class Yazdir extends Satir{
    Ifade ifade;
    public Yazdir(Ifade ifd,int str) {
        ifade=ifd;
        SatirNo=str;
    }
    public int Isle() {
        Algoritma.cikis.println(ifade);
        return  SatirNo+1;
    }

}

class Atama extends Satir {
    Ifade ifade;
    String DegiskenAdi;
    public Atama( Ifade ifd,int str,String dadi)
    {
        ifade=ifd;
        SatirNo=str;
        DegiskenAdi=dadi;
    }
    public int Isle() {
        Algoritma.degerAta(DegiskenAdi, ifade.eval());
        return SatirNo+1;
    }
}

class Git extends Satir {
    int GidilecekSatir;
    public Git(int str,int gitstr)
    {
        SatirNo=str;
        GidilecekSatir=gitstr;
    }
    public int Isle() {
        return GidilecekSatir;
    }

}

class Karsilastir extends Satir {
    Ifade sol;
    Ifade sag;
    Satir islem;
    String operator;
    public Karsilastir(int str,Ifade so,Ifade sa,String op,Satir is)
    {
        sol=so;
        sag=sa;
        operator=op;
        islem=is;
        SatirNo=str;
    }
    public int Isle(){
        if( operator.equals(">") && sol.eval() > sag.eval())
            return islem.Isle();
        else if(operator.equals("<") && sol.eval() < sag.eval())
            return islem.Isle();
        else if(operator.equals(">=") && sol.eval() >= sag.eval())
            return islem.Isle();
        else if(operator.equals("<=") && sol.eval() <= sag.eval())
            return islem.Isle();
        else if(operator.equals("==") && sol.eval() == sag.eval())
            return islem.Isle();
        else if(operator.equals("<>") && sol.eval() != sag.eval())
            return islem.Isle();

        return SatirNo+1;
    }
}

class Metin implements Ifade {
    String s;
    public Metin(String str) {
        s=str;
    }
    public int eval() {
        return Integer.MAX_VALUE;
    }
    public String toString(){
        return s;
    }

}

class Var implements Ifade {
    public String adi;
    public Var(String a){
        adi=a;
    }
    public int eval() {
        return Algoritma.degerAl(adi);
    }

    public String toString() {
        return String.valueOf(Algoritma.degerAl(adi));
    }
}

class Num implements Ifade {
    public int deger;
    public Num(int d){
        deger=d;
    }
    public int eval() {
        return deger;
    }
    public String toString() {
        return String.valueOf(deger);
    }
}

class Toplam implements Ifade {
    Ifade sol,sag;
    public Toplam(Ifade so,Ifade sa){
        sol=so;
        sag=sa;
    }
    public int eval() {
        return sol.eval()+sag.eval();
    }
    public String toString() {
        return String.valueOf(eval());
    }

}

class Fark implements Ifade {
    Ifade sol,sag;
    public Fark(Ifade so,Ifade sa){
        sol=so;
        sag=sa;
    }
    public int eval() {
        return sol.eval()-sag.eval();
    }
    public String toString() {
        return String.valueOf(eval());
    }

}

class Bolme implements Ifade {
    Ifade sol,sag;
    public Bolme(Ifade so,Ifade sa){
        sol=so;
        sag=sa;
    }
    public int eval() {
        return sol.eval()/sag.eval();
    }
    public String toString() {
        return String.valueOf(eval());
    }

}
class Carpma implements Ifade {
    Ifade sol,sag;
    public Carpma(Ifade so,Ifade sa){
        sol=so;
        sag=sa;
    }
    public int eval() {
        return sol.eval()*sag.eval();
    }
    public String toString() {
        return String.valueOf(eval());
    }

}

class Mod implements Ifade {
    Ifade sol,sag;
    public Mod(Ifade so,Ifade sa){
        sol=so;
        sag=sa;
    }
    public int eval() {
        return sol.eval()%sag.eval();
    }
    public String toString() {
        return String.valueOf(eval());
    }

}
