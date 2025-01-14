package model;

import java.util.Random;

/**
 *
 * @author alexandermunoznava
 */
public class Sudoku {
    private int sudoku[][];
    public Sudoku() {
        sudoku = new int[9][9];
        cleanSudoku();
    }
    
    public boolean resolveSudoku(){
        int i;
        int j;
        int value;
        for (i = 0; i < sudoku.length; i++) {
            for (j = 0; j < sudoku[0].length; j++) {
                if (sudoku[i][j] == 0) {
                    for (value = 1; value <= 9; value++) {
                        if (rowValidation(i, value) && columnValidation(j, value) && quadrantValidation(i, j, value)) {
                            sudoku[i][j] = value;
                            if (resolveSudoku()) return true;
                            sudoku[i][j] = 0;                        
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean rowValidation(int row, int value) {
        int j;
        for (j = 0; j < sudoku[row].length; j++) {
            if (sudoku[row][j] == value) {
                return false;
            }
        }
        return true;
    }
    
    public boolean columnValidation(int column, int value) {
        int i;
        for (i = 0; i < sudoku.length; i++) {
           if (sudoku[i][column] == value) {
               return false;
           }
        }
        return true;
    }
    
    public boolean quadrantValidation(int i, int j, int value) {
        int posI = currentSubquadrant(i);
        int posJ = currentSubquadrant(j);
        int k;
        int l;
        
        for (k = posI - 3; k < posI; k++) {
            for (l = posJ - 3; l < posJ; l++) {
                if (sudoku[k][l] == value) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int currentSubquadrant(int pos) {
        if (pos <= 2) return 3;
        else if (pos <= 5) return 6;
        else return 9;
    }
    
    public void printSudoku(){
        int i;
        int j;
        resolveSudoku();
        for (i = 0; i < sudoku.length; i++) {
            for (j = 0; j < sudoku[0].length; j++) {
                System.out.print(sudoku[i][j]);
                if (!(j == sudoku[0].length - 1)) System.out.print(" - ");
            }
            System.out.println();
        }
    }
    
    public void cleanSudoku() {
        int i;
        int j;
        for (i = 0; i < sudoku.length; i++) {
            for (j = 0; j < sudoku[0].length; j++) {
                sudoku[i][j] = 0;
            }
        }
    }
    
    public void generateSudoku(int level){
        cleanSudoku();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = random.nextInt(9) + 1;
                if (quadrantValidation(i, j, num)) {
                    sudoku[i][j] = num;
                } else {
                    j--;
                }
            }
        }
        
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                int num = random.nextInt(9) + 1;
                if (quadrantValidation(i, j, num)) {
                    sudoku[i][j] = num;
                } else {
                    j--;
                }
            }
        }
        
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                int num = random.nextInt(9) + 1;
                if (quadrantValidation(i, j, num)) {
                    sudoku[i][j] = num;
                } else {
                    j--;
                }
            }
        }
        resolveSudoku();
        
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                int aux = j;
                int rand = random.nextInt(level + 1);
                j += rand;
                
                for (int k = aux; k < j && k < sudoku.length; k++) {
                    sudoku[i][k] = 0;
                }
            }
        }
    }
    
    public boolean checkSudoku(){
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                int aux = sudoku[i][j];
                sudoku[i][j] = 0;
                if (!rowValidation(i, aux) || !columnValidation(j, aux) || !quadrantValidation(i, j, aux)) {
                    sudoku[i][j] = aux;
                    return false;
                }
                sudoku[i][j] = aux;
            }
        }
        return true;
    }

    public void setSudoku(int[][] sudoku) {
        this.sudoku = sudoku;
    }

    public int[][] getSudoku() {
        return sudoku;
    }
}
