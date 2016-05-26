import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by look on 16/7/17.
 */
public class NQueens {

    private int number = 0;

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        int i = 0;
        int[][] solution = new int[n][n];
        tryResolve(solution, i, result);

                return result;
    }

    private void tryResolve(int[][] solution, int i, List<List<String>> result ) {
        if (i < solution.length) {
            int[] possible = getPossible(solution, i);
            for (int index : possible) {
                if (index > -1) {
                    solution[i][index] = 1;
                    tryResolve(solution, i + 1, result);
                    solution[i][index] = 0;
                }
            }

        }else{
            StringBuilder sb = null;
            List<String> list = new LinkedList<>();
            for (int[] col : solution){
                sb = new StringBuilder();
                for (int cell: col){
                    if (cell > 0){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            System.out.println("found resolution "+ (++number)+":\n"+ Arrays.deepToString(solution));
        }
    }

    private int[] getPossible(int[][] solution, int i){
        int[] possibleValues = new int[solution.length];
        for (int index = 1; index< solution.length; index++){
            possibleValues[index] = index;
        }
        for (int j=0; j< i; j++){
            for (int k=0; k<solution.length; k++){
                if (solution[j][k] != 0){
                    possibleValues[k] = -1;
                    int a = k+ i-j;
                    if (a < solution.length){
                        possibleValues[a] = -1;
                    }
                    int b = k - (i -j);
                    if (b >= 0){
                        possibleValues[b] = -1;
                    }
                }

            }
        }

        return possibleValues;

    }


    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> result =  nQueens.solveNQueens(8);
        System.out.println(result);
    }
}
