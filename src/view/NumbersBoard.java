package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author alexandermunoznava
 */
public class NumbersBoard extends JPanel {
    private int txtWidth;
    private int txtHeight;
    private int txtMargin;
    private int txtFontsize;
    private Color panelBackground;
    private Color txtBackground1;
    private Color txtForeground1;
    private Color txtBackground2;
    private Color txtForeground2;
    private SudokuBoard sudokuBoard;
    
    public NumbersBoard(){
        initComp();
        sudokuBoard = FormSudoku.sudokuBoard;
    }
    
    public void initComp(){
        txtWidth = 30;
        txtHeight = 30;
        txtFontsize = 27;
        panelBackground = Color.black;
        txtBackground1 = Color.white;
        txtForeground1 = Color.black;
        txtBackground2 = Color.white;
        txtForeground2 = Color.black;
    }
    
    public void createBoard(){
        this.setLayout(null);
        this.setSize(txtWidth + (2 * txtMargin), 
                txtHeight * 9 + (4 * txtMargin));
        this.setBackground(panelBackground);
        createTextFields();
    }
    
    public void createTextFields(){
        int x = txtMargin;
        int y = txtMargin;
        
        int i;
        int j;
        for (i = 0; i < 9; i++) {
            JTextField txt = new JTextField();
            this.add(txt);
            txt.setBounds(x, y, txtWidth, txtHeight);
            txt.setBackground(txtBackground1);
            txt.setForeground(txtForeground1);
            txt.setCursor(new Cursor(Cursor.HAND_CURSOR));
            txt.setEditable(false);
            txt.setBorder(BorderFactory.createLineBorder(panelBackground, 1));
            txt.setFont(new Font("Montserrat", Font.BOLD, txtFontsize));
            txt.setText(String.valueOf(i + 1));
            
            y += txtHeight;
            if ((i + 1) % 3 == 0) {
                y += txtMargin;
            }
            generateEvents(txt);
        }
    }
    
    public void generateEvents(JTextField txt){
        MouseListener event = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
               
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (sudokuBoard.txtGenerated(sudokuBoard.txtSelected)) {
                    return;
                }
                sudokuBoard.txtSelected.setText(txt.getText());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                txt.setBackground(txtBackground2);
                txt.setForeground(txtForeground2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                txt.setBackground(txtBackground1);
                txt.setForeground(txtForeground1);
            }
            
        };
        txt.addMouseListener(event);
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
    
    
}
