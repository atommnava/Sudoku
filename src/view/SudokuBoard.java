package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author alexandermunoznava
 */
public class SudokuBoard extends JPanel {
    private JTextField[][] txtList;
    private int txtWidth;
    private int txtHeight;
    private int txtMargin;
    private int txtFontsize;
    private Color panelBackground;
    
   private Color txtBackground1;
   private Color txtForeground1;
   private Color txtBackground2;
   private Color txtForeground2;
   private Color txtBackground3;
   private Color txtForeground3;
   
   public SudokuBoard(){
       iniciarComponentes();
   }
   
   public void iniciarComponentes(){
       txtList = new JTextField[9][9];
       txtWidth = 35;
       txtHeight = 36;
       txtMargin = 4;
       txtFontsize = 27;
       panelBackground = Color.black;
       txtBackground1 = Color.white;
       txtForeground1 = Color.black;
       txtBackground2 = Color.white;
       txtForeground2 = Color.black;
       txtBackground3 = Color.white;
       txtForeground3 = Color.black;
   }
   
   public void createSudoku(){
       this.setLayout(null);
       this.setSize(txtWidth * 9 + (txtMargin * 4), 
               txtHeight * 9 + (txtMargin * 4));
       this.setBackground(panelBackground);
       createtxtFields();
   }
   
   public void createtxtFields(){
       int x = txtMargin;
       int y = txtMargin;
       for (int i = 0; i < txtList.length; i++) {
           for (int j = 0; j < txtList[0].length; j++) {
               JTextField txt = new JTextField();
               this.add(txt);
               txt.setBounds(x, y, txtWidth, txtHeight);
               txt.setBackground(txtBackground1);
               txt.setForeground(txtForeground1);
               txt.setFont(new Font("Montserrat", Font.BOLD, txtFontsize));
               txt.setEditable(false);
               txt.setCursor(new Cursor(Cursor.HAND_CURSOR));
               txt.setBorder(BorderFactory.createLineBorder(panelBackground));
               txt.setVisible(true);
               x += txtWidth;
               
               if ((j + 1 ) % 3 == 0) {
                   x += txtMargin;
               }
               
           }
           x = txtMargin;
           y += txtHeight;
           
           if ((i + 1) % 3 == 0) {
               y += txtMargin;
           }
       }
   }

    public JTextField[][] getTxtList() {
        return txtList;
    }

    public int getTxtWidth() {
        return txtWidth;
    }

    public int getTxtHeight() {
        return txtHeight;
    }

    public int getTxtMargin() {
        return txtMargin;
    }

    public int getTxtFontsize() {
        return txtFontsize;
    }

    public Color getPanelBackground() {
        return panelBackground;
    }

    public Color getTxtBackground1() {
        return txtBackground1;
    }

    public Color getTxtForeground1() {
        return txtForeground1;
    }

    public Color getTxtBackground2() {
        return txtBackground2;
    }

    public Color getTxtForeground2() {
        return txtForeground2;
    }

    public Color getTxtBackground3() {
        return txtBackground3;
    }

    public Color getTxtForeground3() {
        return txtForeground3;
    }

    public void setTxtList(JTextField[][] txtList) {
        this.txtList = txtList;
    }

    public void setTxtWidth(int txtWidth) {
        this.txtWidth = txtWidth;
    }

    public void setTxtHeight(int txtHeight) {
        this.txtHeight = txtHeight;
    }

    public void setTxtMargin(int txtMargin) {
        this.txtMargin = txtMargin;
    }

    public void setTxtFontsize(int txtFontsize) {
        this.txtFontsize = txtFontsize;
    }

    public void setPanelBackground(Color panelBackground) {
        this.panelBackground = panelBackground;
    }

    public void setTxtBackground1(Color txtBackground1) {
        this.txtBackground1 = txtBackground1;
    }

    public void setTxtForeground1(Color txtForeground1) {
        this.txtForeground1 = txtForeground1;
    }

    public void setTxtBackground2(Color txtBackground2) {
        this.txtBackground2 = txtBackground2;
    }

    public void setTxtForeground2(Color txtForeground2) {
        this.txtForeground2 = txtForeground2;
    }

    public void setTxtBackground3(Color txtBackground3) {
        this.txtBackground3 = txtBackground3;
    }

    public void setTxtForeground3(Color txtForeground3) {
        this.txtForeground3 = txtForeground3;
    }
}
