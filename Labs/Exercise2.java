import java.io.*;
import java.util.*;
public class Exercise2
{
    public static void main( String[] args )
    {
try
{
        int[][]m1 = new int[2][3];
        int[][]m2 = new int[2][3];
        int[][]m3 = new int[2][3];
		for (int r=0; r<m1.length ; ++r)
		{
			for (int c=0 ; c<m1[r].length ; ++c )
				m1[r][c] = (c+1) * (r+1);
		}
		for (int r=0; r<m2.length ; ++r)
		{
			for (int c=0 ; c<m2[r].length ; ++c )
				m2[r][c] = (r+2) * (c+2);
		}
		printMatrix("MATRIX1",m1);
		printMatrix("MATRIX2",m2);
		addMatrices(m3, m1,m2 ); 
		printMatrix("MATRIX1 + MATRIX2",m3);
}
catch( Exception e )
{
	System.out.println("EXCEPTION CAUGHT: " + e );
	System.exit(0);
}
    } 
    private static void addMatrices( int[][] sum, int[][]m1, int[][]m2 )
    {
      if(m1.length!=m2.length){
          System.out.println("Matrix cannot be added");
          return;
      }
      for(int i = 0 ; i<m1.length;++i){
      
          if(m1[i].length!=m2[i].length){
              System.out.println("Matrix cannot be added");
              return;
          }
          for(int j = 0 ; j <m1[i].length;++j){
              sum[i][j] = m1[i][j] + m2[i][j];
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
