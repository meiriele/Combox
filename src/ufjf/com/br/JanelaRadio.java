
package ufjf.com.br;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class JanelaRadio extends JFrame{
    private  final JTextField mensagem = new JTextField("Universidade Federal de Juiz de Fora");
    private  final JRadioButton rbPlano;
    private  final JRadioButton rbNegrito;
    private  final JRadioButton rbItalico;
    private  final JRadioButton rbNegritoItalico;
    
    public JanelaRadio() throws HeadlessException {
        
    super("RadioButton Test");
        setLayout(new FlowLayout());
        add(mensagem);
        rbPlano = new JRadioButton("Plano", true);
        add(rbPlano);
        rbNegrito = new JRadioButton("Negrito", false);
        add(rbNegrito);
        rbItalico = new JRadioButton("Itálico", false);
        add(rbItalico);
        rbNegritoItalico = new JRadioButton("Negrito-Itálico", false);
        add(rbNegritoItalico);
        
        ButtonGroup bgEstilo = new ButtonGroup();
        bgEstilo.add(rbPlano);
        bgEstilo.add(rbNegrito);
        bgEstilo.add(rbItalico);
        bgEstilo.add(rbNegritoItalico);
        
        Font fPlana = new Font(Font.SERIF,Font.PLAIN, 14);
        Font fNegrito = new Font(Font.SERIF,Font.BOLD, 14);
        Font fItalico = new Font(Font.SERIF,Font.ITALIC, 14);
        Font fNegritoItalico = new Font(Font.SERIF,Font.BOLD + Font.ITALIC, 14);
        
        rbPlano.addItemListener(new EstiloRadio(fPlana));
        rbNegrito.addItemListener(new EstiloRadio(fNegrito));
        rbItalico.addItemListener(new EstiloRadio(fItalico));
        rbNegritoItalico.addItemListener(new EstiloRadio(fNegritoItalico));
        
    }

    private  class EstiloRadio implements ItemListener {
        private Font fonte;
        public EstiloRadio(Font fonte) {
            this.fonte = fonte;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            mensagem.setFont(fonte);
        }
    }
    
}
