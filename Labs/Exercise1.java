import java.io.*;
import java.util.*;
public class Exercise1
{
    public static void main( String[] args )
    {
        int[][]m = new int[5][5];
        fillDiagonal_1( m ); 
        printMatrix( "DIAGONAL_1",m );
        zeroMatrix( m ); 
        printMatrix( "ZEROS",m ); 
        fillDiagonal_2( m );
        printMatrix( "DIAGONAL_2",m );
        zeroMatrix( m );  
        printMatrix( "ZEROS",m ); 
        fillBorder( m ); 
        printMatrix( "BORDER",m );
    }
    private static void fillDiagonal_1( int[][] matrix )
    {
        int i = matrix.length - 1;
        for(int j = 0; j<matrix.length; j++) {
            matrix[i--][j] = j;
        }
    }
    private static void fillDiagonal_2( int[][] matrix )
    {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][i] = i;
        }
    }
    private static void fillBorder( int[][] matrix )
    {
       for(int i = 0; i <matrix.length; i++ ) {
            matrix[0][i] = i;
        }

        int j = matrix.length - 1;
        for(int i = 0; i < matrix.length; i++) {
            matrix[matrix.length-1][j--] = i;
        }

        for(int i = 0; i < matrix.length; i++) {
            matrix[i][0] = i;
        }

        j = matrix.length - 1;
        for(int i = 0; i< matrix.length; i++) {
            matrix[j--][matrix.length - 1] = i;
        }
    }
    private static void zeroMatrix( int[][] matrix )
    {
        for(int i=0; i < matrix.length; i++) {
            for(int j =0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    private static void printMatrix( String label, int[][] matrix )
    {
        System.out.println(label);
        for (int row=0 ; row<matrix.length ;  ++row)  
            {
                for (int col=0 ; col < matrix[row].length ; ++col )
                    System.out.print( matrix[row][col] + " ");

                System.out.println(); 
            } 

        System.out.println(); 
    } 
} 
