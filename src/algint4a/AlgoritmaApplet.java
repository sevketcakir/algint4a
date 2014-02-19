/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmaYorumlayici;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Þevket
 */

final class TextAreaOutputStream extends OutputStream {

	private final JTextArea textArea;
	private final StringBuilder sb = new StringBuilder();

	public TextAreaOutputStream(final JTextArea textArea) {
		this.textArea = textArea;
	}

    @Override
    public void flush(){ }

    @Override
    public void close(){ }

	@Override
	public void write(int b) throws IOException {

		if (b == '\r')
			return;

		if (b == '\n') {
			textArea.append(sb.toString());
			sb.setLength(0);
		}

		sb.append((char)b);
	}
}

class adptr implements ActionListener {
    AlgoritmaApplet algapp;
    public adptr(AlgoritmaApplet alg) {
        algapp=alg;
    }
    public void actionPerformed(ActionEvent e) {
        algapp.stream=new ByteArrayInputStream(algapp.text.getText().getBytes());
        Algoritma alg=new Algoritma(algapp.stream);
        alg.degiskenler=new HashMap();
        alg.satirlar=new HashMap();
        algapp.sonuc.setText("");
        alg.cikis = new PrintStream(new TextAreaOutputStream(algapp.sonuc));
        //algapp.sonuc.set
        try {
            alg.Giris();
        if(Algoritma.AlgoritmaDuzgun())
            alg.Isle();

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Girdide hata\n"+ex.getMessage());
        }
        catch(TokenMgrError ex)
        {
            JOptionPane.showMessageDialog(null, "Girdide hata\n"+ex.getMessage());
        }
    }

}

public class AlgoritmaApplet extends JApplet {
    Algoritma alg;
    JButton parse;
    public JTextArea text;
    JTextArea sonuc;
    JLabel copyright;
    ByteArrayInputStream stream;
    public void init() {
        Container c=getContentPane();
        c.setLayout(new FlowLayout());
        parse=new JButton("Yorumla");
        parse.addActionListener(new adptr(this));
        Font f=new Font("Verdana",Font.BOLD,12);
        text=new JTextArea(20,40);
        text.setFont(f);
        text.setText("1. Basla\n2. karetoplam=0\n3. giris:N\n4. eger N==0 ise git 9\n5. karetoplam=karetoplam+N*N\n6. yaz N*N\n7. N=N-1\n8. git 4\n9. yaz 'Karelerin toplami:'\n10. yaz karetoplam\n11. Dur\n");
        sonuc=new JTextArea(10,40);
        sonuc.setFont(f);
        sonuc.setForeground(new Color(0, 127, 0));
        sonuc.setFont(f);
        sonuc.setEditable(false);
        copyright=new JLabel("pcprogramlama.com © 2008 - 2012. Her Hakký Saklýdýr ®");
        JScrollPane pane=new JScrollPane(text);
        JScrollPane pane2=new JScrollPane(sonuc);
        c.add(pane);
        c.add(parse);
        c.add(pane2);
        c.add(copyright);
        c.setVisible(true);
        setSize(500, 550);
    }

}
