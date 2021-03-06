/* Generated By:JavaCC: Do not edit this line. Algoritma.java */
package AlgoritmaYorumlayici;
import java.io.*;
import java.util.*;
public class Algoritma implements AlgoritmaConstants {
  public static HashMap degiskenler;
  public static HashMap satirlar;
  public static PrintStream cikis;
  public static void main(String args[]) throws ParseException {
    InputStream fs=System.in;
    cikis=System.out;
    if(args.length>0)
    {
        try {
            fs=new FileInputStream(args[0]);
        }
        catch(FileNotFoundException e){
            cikis.println("Dosya bulunamadi.");
            System.exit(-1);
        }
    }
    degiskenler=new HashMap();
    satirlar=new HashMap();
    Algoritma alg = new Algoritma(fs);
    alg.Giris();
    if(Algoritma.AlgoritmaDuzgun())
        Algoritma.Isle();
  }
public static void degerAta(String degiskenAdi,int deger)
{
    degiskenler.put(degiskenAdi, deger);
}
public static int degerAl(String degiskenAdi)
{
    Object a=degiskenler.get(degiskenAdi);
    if(a==null)
    {
        cikis.println("Tanimlanmamis degisken: "+degiskenAdi);
        System.exit(-1);
    }
    return Integer.valueOf(a.toString());
}
public static Satir getSatir(int satirNo) {
    return (Satir)satirlar.get(satirNo);
}

public static void setSatir(int satirNo,Satir str) {
    satirlar.put(satirNo, str);
}
public static int SatirNoAl(String s) {
return Integer.parseInt(s.substring(0,s.length()-1));
}
public static void Isle()
{
    Satir s=getSatir(1);
    int sonraki=s.Isle();
    while(sonraki!=-1)
    {
        s=getSatir(sonraki);
        sonraki=s.Isle();
    }
}

public static boolean AlgoritmaDuzgun(){
    boolean duzgun=true;
    for(int i=0;i<satirlar.size();i++)
    {
        Satir s=(Satir) satirlar.get(i+1);
        if(s==null){
            cikis.println((i+1)+". satir bulunamadi.");
            duzgun=false;
        }
    }
    return duzgun;
}

  final public void Giris() throws ParseException {
    Satir s;
    Token sno;
    sno = jj_consume_token(SATIRNO);
    jj_consume_token(BASLA);
    jj_consume_token(EOL);
                                 Algoritma.setSatir(SatirNoAl(sno.image),new Basla(SatirNoAl(sno.image)));
    label_1:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_1;
      }
      s = Islem();
      jj_consume_token(EOL);
                      Algoritma.setSatir(s.SatirNo,s);
    }
    sno = jj_consume_token(SATIRNO);
    jj_consume_token(DUR);
    label_2:
    while (true) {
      if (jj_2_2(2)) {
        ;
      } else {
        break label_2;
      }
      jj_consume_token(EOL);
    }
                                  Algoritma.setSatir(SatirNoAl(sno.image),new Dur(SatirNoAl(sno.image)));
    jj_consume_token(0);
  }

  final public Satir Islem() throws ParseException {
    Token sno;
    Ifade ifd;
    Token t;
    Ifade i1;
    Ifade i2;
    Token t1;
    if (jj_2_6(2)) {
      sno = jj_consume_token(SATIRNO);
      jj_consume_token(YAZ);
      ifd = Ifade();
                                     {if (true) return new Yazdir(ifd,SatirNoAl(sno.image));}
    } else if (jj_2_7(2)) {
      sno = jj_consume_token(SATIRNO);
      jj_consume_token(GIT);
      t = jj_consume_token(SAYI);
                                  {if (true) return new Git(SatirNoAl(sno.image),Integer.parseInt(t.image));}
    } else if (jj_2_8(2)) {
      sno = jj_consume_token(SATIRNO);
      t = jj_consume_token(DEGISKEN);
      jj_consume_token(ESIT);
      ifd = Ifade();
                                                   Algoritma.degerAta(t.image,0); {if (true) return new Atama(ifd,SatirNoAl(sno.image),t.image);}
    } else if (jj_2_9(2)) {
      sno = jj_consume_token(SATIRNO);
      jj_consume_token(GIRIS);
      jj_consume_token(IKINOKTA);
      t = jj_consume_token(DEGISKEN);
                                                   {if (true) return new Giris(t.image,SatirNoAl(sno.image));}
    } else if (jj_2_10(2)) {
      sno = jj_consume_token(SATIRNO);
      jj_consume_token(EGER);
      i1 = Ifade();
      t = jj_consume_token(KARSILASTIR);
      i2 = Ifade();
      jj_consume_token(ISE);
      if (jj_2_3(2)) {
        jj_consume_token(YAZ);
        ifd = Ifade();
                           {if (true) return new Karsilastir(SatirNoAl(sno.image),i1,i2,t.image,new Yazdir(ifd,SatirNoAl(sno.image)));}
      } else if (jj_2_4(2)) {
        jj_consume_token(GIT);
        t1 = jj_consume_token(SAYI);
                         {if (true) return new Karsilastir(SatirNoAl(sno.image),i1,i2,t.image,new Git(SatirNoAl(sno.image),Integer.parseInt(t1.image)));}
      } else if (jj_2_5(2)) {
        t1 = jj_consume_token(DEGISKEN);
        jj_consume_token(ESIT);
        ifd = Ifade();
                                          Algoritma.degerAta(t.image,0);{if (true) return new Karsilastir(SatirNoAl(sno.image),i1,i2,t.image,new Atama(ifd,SatirNoAl(sno.image),t1.image));}
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public Ifade Ifade() throws ParseException {
    Ifade x;
    Ifade y;
    x = Term();
    label_3:
    while (true) {
      if (jj_2_11(2)) {
        ;
      } else {
        break label_3;
      }
      if (jj_2_12(2)) {
        jj_consume_token(TOPLA);
        y = Term();
                          x=new Toplam(x,y);
      } else if (jj_2_13(2)) {
        jj_consume_token(CIKAR);
        y = Term();
                          x=new Fark(x,y);
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
     {if (true) return x;}
    throw new Error("Missing return statement in function");
  }

  final public Ifade Term() throws ParseException {
    Ifade x;
    Ifade y;
    x = Primary();
    label_4:
    while (true) {
      if (jj_2_14(2)) {
        ;
      } else {
        break label_4;
      }
      if (jj_2_15(2)) {
        jj_consume_token(CARP);
        y = Primary();
                            x=new Carpma(x,y);
      } else if (jj_2_16(2)) {
        jj_consume_token(BOL);
        y = Primary();
                           x=new Bolme(x,y);
      } else if (jj_2_17(2)) {
        jj_consume_token(MOD);
        y = Primary();
                            x=new Mod(x,y);
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
     {if (true) return x;}
    throw new Error("Missing return statement in function");
  }

  final public Ifade Primary() throws ParseException {
    Token t;
    Ifade ifd;
    if (jj_2_18(2)) {
      t = jj_consume_token(SAYI);
              {if (true) return new Num(Integer.parseInt(t.image));}
    } else if (jj_2_19(2)) {
      t = jj_consume_token(DEGISKEN);
                  {if (true) return new Var(t.image);}
    } else if (jj_2_20(2)) {
      jj_consume_token(CIKAR);
      t = jj_consume_token(SAYI);
                      {if (true) return new Num(-1*Integer.parseInt(t.image));}
    } else if (jj_2_21(2)) {
      t = jj_consume_token(METIN);
               {if (true) return new Metin(t.image.substring(1,t.image.length()-1));}
    } else if (jj_2_22(2)) {
      jj_consume_token(PARAC);
      ifd = Ifade();
      jj_consume_token(PARKAPA);
                                   {if (true) return ifd;}
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  private boolean jj_2_8(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  private boolean jj_2_9(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  private boolean jj_2_10(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_10(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(9, xla); }
  }

  private boolean jj_2_11(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_11(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(10, xla); }
  }

  private boolean jj_2_12(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_12(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(11, xla); }
  }

  private boolean jj_2_13(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_13(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(12, xla); }
  }

  private boolean jj_2_14(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_14(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(13, xla); }
  }

  private boolean jj_2_15(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_15(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(14, xla); }
  }

  private boolean jj_2_16(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_16(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(15, xla); }
  }

  private boolean jj_2_17(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_17(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(16, xla); }
  }

  private boolean jj_2_18(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_18(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(17, xla); }
  }

  private boolean jj_2_19(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_19(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(18, xla); }
  }

  private boolean jj_2_20(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_20(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(19, xla); }
  }

  private boolean jj_2_21(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_21(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(20, xla); }
  }

  private boolean jj_2_22(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_22(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(21, xla); }
  }

  private boolean jj_3_17() {
    if (jj_scan_token(MOD)) return true;
    if (jj_3R_8()) return true;
    return false;
  }

  private boolean jj_3_16() {
    if (jj_scan_token(BOL)) return true;
    if (jj_3R_8()) return true;
    return false;
  }

  private boolean jj_3_14() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_15()) {
    jj_scanpos = xsp;
    if (jj_3_16()) {
    jj_scanpos = xsp;
    if (jj_3_17()) return true;
    }
    }
    return false;
  }

  private boolean jj_3_15() {
    if (jj_scan_token(CARP)) return true;
    if (jj_3R_8()) return true;
    return false;
  }

  private boolean jj_3R_7() {
    if (jj_3R_8()) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_3R_5()) return true;
    return false;
  }

  private boolean jj_3_13() {
    if (jj_scan_token(CIKAR)) return true;
    if (jj_3R_7()) return true;
    return false;
  }

  private boolean jj_3_11() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_12()) {
    jj_scanpos = xsp;
    if (jj_3_13()) return true;
    }
    return false;
  }

  private boolean jj_3_12() {
    if (jj_scan_token(TOPLA)) return true;
    if (jj_3R_7()) return true;
    return false;
  }

  private boolean jj_3R_6() {
    if (jj_3R_7()) return true;
    return false;
  }

  private boolean jj_3_5() {
    if (jj_scan_token(DEGISKEN)) return true;
    if (jj_scan_token(ESIT)) return true;
    return false;
  }

  private boolean jj_3_4() {
    if (jj_scan_token(GIT)) return true;
    if (jj_scan_token(SAYI)) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_scan_token(YAZ)) return true;
    if (jj_3R_6()) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_scan_token(EOL)) return true;
    return false;
  }

  private boolean jj_3_22() {
    if (jj_scan_token(PARAC)) return true;
    if (jj_3R_6()) return true;
    return false;
  }

  private boolean jj_3_21() {
    if (jj_scan_token(METIN)) return true;
    return false;
  }

  private boolean jj_3_10() {
    if (jj_scan_token(SATIRNO)) return true;
    if (jj_scan_token(EGER)) return true;
    return false;
  }

  private boolean jj_3_20() {
    if (jj_scan_token(CIKAR)) return true;
    if (jj_scan_token(SAYI)) return true;
    return false;
  }

  private boolean jj_3_9() {
    if (jj_scan_token(SATIRNO)) return true;
    if (jj_scan_token(GIRIS)) return true;
    return false;
  }

  private boolean jj_3_19() {
    if (jj_scan_token(DEGISKEN)) return true;
    return false;
  }

  private boolean jj_3_8() {
    if (jj_scan_token(SATIRNO)) return true;
    if (jj_scan_token(DEGISKEN)) return true;
    return false;
  }

  private boolean jj_3R_8() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_18()) {
    jj_scanpos = xsp;
    if (jj_3_19()) {
    jj_scanpos = xsp;
    if (jj_3_20()) {
    jj_scanpos = xsp;
    if (jj_3_21()) {
    jj_scanpos = xsp;
    if (jj_3_22()) return true;
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3_18() {
    if (jj_scan_token(SAYI)) return true;
    return false;
  }

  private boolean jj_3_7() {
    if (jj_scan_token(SATIRNO)) return true;
    if (jj_scan_token(GIT)) return true;
    return false;
  }

  private boolean jj_3R_5() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_6()) {
    jj_scanpos = xsp;
    if (jj_3_7()) {
    jj_scanpos = xsp;
    if (jj_3_8()) {
    jj_scanpos = xsp;
    if (jj_3_9()) {
    jj_scanpos = xsp;
    if (jj_3_10()) return true;
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3_6() {
    if (jj_scan_token(SATIRNO)) return true;
    if (jj_scan_token(YAZ)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public AlgoritmaTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[0];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[22];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Algoritma(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Algoritma(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AlgoritmaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Algoritma(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AlgoritmaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Algoritma(AlgoritmaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(AlgoritmaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 0; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[28];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 0; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 28; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 22; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
            case 9: jj_3_10(); break;
            case 10: jj_3_11(); break;
            case 11: jj_3_12(); break;
            case 12: jj_3_13(); break;
            case 13: jj_3_14(); break;
            case 14: jj_3_15(); break;
            case 15: jj_3_16(); break;
            case 16: jj_3_17(); break;
            case 17: jj_3_18(); break;
            case 18: jj_3_19(); break;
            case 19: jj_3_20(); break;
            case 20: jj_3_21(); break;
            case 21: jj_3_22(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
