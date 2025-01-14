package view;

import model.Sudoku;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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
   
   private Color txtBackground4;
   private Color txtForeground4;
   
   private Sudoku sudoku;
   private ArrayList<JTextField> txtListAux;
   private ArrayList<JTextField> txtGeneratedList;
   
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
       
       txtBackground4 = Color.red;
       txtForeground4 = Color.white;
       
       sudoku = new Sudoku();
       txtListAux = new ArrayList<>();
       txtGeneratedList = new ArrayList<>();
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
       int i;
       int j;
       for (i = 0; i < txtList.length; i++) {
           for (j = 0; j < txtList[0].length; j++) {
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
               txtList[i][j] = txt;
               generateEvents(txt);
           }
           x = txtMargin;
           y += txtHeight;
           
           if ((i + 1) % 3 == 0) {
               y += txtMargin;
           }
       }
   }
   
   public void generateEvents(JTextField txt){
       MouseListener event = new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {
               
           }

           @Override
           public void mousePressed(MouseEvent e) {
               pressed(txt);
           }

           @Override
           public void mouseReleased(MouseEvent e) {
               
           }

           @Override
           public void mouseEntered(MouseEvent e) {
               
           }

           @Override
           public void mouseExited(MouseEvent e) {
              
           }
       };
      
       KeyListener keyEvent = new KeyListener() {
           @Override
           public void keyTyped(KeyEvent e) {
               
           }

           @Override
           public void keyPressed(KeyEvent e) {
               if (e.getKeyChar() >= 49 && e.getKeyChar() <= 57) {
                   txt.setText(String.valueOf(e.getKeyChar()));
               }
           }

           @Override
           public void keyReleased(KeyEvent e) {
              
           }
           
       };
       txt.addMouseListener(event);
       txt.addKeyListener(keyEvent);
   }
   
   public void pressed(JTextField txt) {
       int i;
       int j;
       
       int posI;
       int posJ;
       
       for (JTextField jtxt : txtListAux) {
           jtxt.setBackground(txtBackground1);
           jtxt.setForeground(txtForeground1);
           jtxt.setBorder(BorderFactory.createLineBorder(panelBackground, 1));
       }
       txtListAux.clear();
       
       for (JTextField jtxt : txtGeneratedList) {
           jtxt.setBackground(txtBackground4);
           jtxt.setForeground(txtForeground4);
       }
       
       for (i = 0; i < txtList.length; i++) {
           for (j = 0; j < txtList[0].length; j++) {
               if (txtList[i][j] == txt) {
                   
                   for (int k = 0; k < txtList.length; k++) {
                       txtList[k][j].setBackground(txtBackground2);
                       txtList[k][j].setForeground(txtForeground2);
                       txtListAux.add(txtList[k][j]);
                   }
                   for (int k = 0; k < txtList[0].length; k++) {
                       txtList[i][k].setBackground(txtBackground2);
                       txtList[i][k].setForeground(txtForeground2);
                       txtListAux.add(txtList[i][k]);
                   }
                   posI = sudoku.currentSubquadrant(i);
                   posJ = sudoku.currentSubquadrant(j);
                   for (int k = posI - 3; k < posI; k++) {
                       for (int l = posJ - 3; l < posJ; l++) {
                           txtList[k][l].setBackground(txtBackground2);
                           txtList[k][l].setForeground(txtForeground2);
                           txtListAux.add(txtList[k][l]);
                       }
                   }
                   
                   txtList[i][j].setBackground(txtBackground3);
                   txtList[i][j].setForeground(txtForeground3);
                   txtList[i][j].setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                   return;
               }
           }
       }
   }
   
   public void generateSudoku(int level) {
       txtClean();
       sudoku.generateSudoku(level);
       int[][] generatedSudoku = sudoku.getSudoku();
       for (int i = 0; i < txtList.length; i++) {
           for (int j = 0; j < txtList[0].length; j++) {
               if (generatedSudoku[i][j] != 0) {
                   txtList[i][j].setText(String.valueOf(generatedSudoku[i][j]));
                   txtList[i][j].setBackground(txtBackground4);
                   txtList[i][j].setForeground(txtForeground4);
                   txtGeneratedList.add(txtList[i][j]);
               }
           }
        }
   }
   
   public void txtClean(){
       for (int i = 0; i < txtList.length; i++) {
           for (int j = 0; j < txtList[0].length; j++) {
               txtList[i][j].setText("");
               txtList[i][j].setBackground(txtBackground1);
               txtList[i][j].setForeground(txtForeground1);
           }
       }
   }

    public void setTxtBackground4(Color txtBackground4) {
        this.txtBackground4 = txtBackground4;
    }

    public void setTxtForeground4(Color txtForeground4) {
        this.txtForeground4 = txtForeground4;
    }

    public Color getTxtBackground4() {
        return txtBackground4;
    }

    public Color getTxtForeground4() {
        return txtForeground4;
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
