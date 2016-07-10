import java.util.Arrays;

/**
 * Created by look on 16/7/3.
 */
public class Sokudo {

    public char[][][] solveSudokuStep1(char[][] board) {
        char[][][] temp3d = new char[board.length][][];
        boolean needReCal = false;
        for (int i = 0 ; i< board.length; i++){
            char[] line = board[i];
            temp3d[i] = new char[line.length][];
            for (int j=0; j< line.length; j++){
                char cell = line[j];
                if (cell != '.'){
                    temp3d[i][j] = new char[]{cell};
                }else{
                    char[] values = determinePossilbeValues(i,j,board);
                    if (values.length == 0){
                        return null;
                    }else if (values.length == 1){
                        needReCal = true;
                    }
                    temp3d[i][j] = values;
                }
            }
        }
        if (needReCal){
            int i=0;
            for(char[][] line: temp3d){
                int j =0;
                for (char[] cell: line){
                    if (cell.length == 1){
                        board[i][j]=cell[0];
                    }
                    j++;
                }
                i++;
            }
            System.out.println("temp:"+Arrays.deepToString(board));

            return solveSudokuStep1(board);
        }
        return temp3d;
    }

    public boolean validate(char[][] board){
        char[] cs = new char[]{'1','2','3','4','5','6','7', '8', '9'};

        for(char[] line : board){
            for(char c : cs){
                boolean found = false;
                for (char cell : line){
                    if (cell == c){
                        found = true;
                        break;
                    }
                }
                if (!found){
                    return false;
                }
            }
        }

        for (int i =0; i<9;i++){
            for(char c : cs){
                boolean found = false;
                for (char[] line : board){
                    if (line[i] == c){
                        found = true;
                        break;
                    }
                }
                if (!found){
                    return false;
                }
            }
        }

        for (int x=0; x<9; x=x+3){
            for (int y=0; y<9; y=y+3){
                for(char c : cs){
                    boolean found = false;
                    outer: for (int n1=0; n1<3; n1++){
                        for (int n2=0; n2<3; n2++){
                            char ccell = board[x+n1][y+n2];
                            if (ccell == c){
                                found = true;
                                break outer;
                            }
                        }
                    }
                    if (!found){
                        return false;
                    }
                }
            }

        }


        return true;
    }


    public boolean trySolve(char[][] board, char[][][] temp3dboard){
        boolean solved = true;
        for(char[][] line: temp3dboard){
            for (char[] cell: line){
                if (cell.length > 1){
                    solved = false;
                }
            }
        }
        if (solved){
            System.out.println("result:"+Arrays.deepToString(board));
            boolean valid = validate(board);
            System.out.println(valid);
            return valid;
        }else{


            System.out.println("before:"+Arrays.deepToString(board));
            printFistPossilbes(temp3dboard);
            int i = 0;
            char[][] backup = new char[board.length][];
            for(char[] line: board){
                backup[i] = new char[line.length];
                int j = 0;
                for(char cell: line){
                    backup[i][j] = cell;
                    j++;
                }
                i++;
            }
            System.out.println("backup:"+Arrays.deepToString(backup));

            i=0;
            for(char[][] line: temp3dboard){
                int j = 0;
                for(char[] cell: line){
                    if (cell.length > 1){

                        for (char value: cell){
                            restore(backup, board);

                            board[i][j]=value;
                            printFistPossilbes(temp3dboard);
                            System.out.println(i+":"+j+":"+value);
                            System.out.println("rec:"+Arrays.deepToString(board));

                            char[][][] result = solveSudokuStep1(board);
                            if (result == null){

                                System.out.println("Cant' resolve");
                                continue;
                            }else{

                                boolean isSolved = trySolve(board, result);
                                if (isSolved){
                                    return true;
                                }else{

                                    System.out.println("rec:"+Arrays.deepToString(board));

                                    continue;
                                }
                            }
                        }
                        return false;
                    }
                    j++;
                }
                i++;
            }
        }
        return false;
    }

    private void restore(char[][] backup, char[][] board) {
        int i = 0;
        for (char[] line : backup){
            int j =0;
            for (char cell: line){
                board[i][j] = cell;
                j++;
            }
            i++;
        }
    }

    private void  printFistPossilbes(char[][][] temp3dboard){
        int i = 0;
        outer: for(char[][] line: temp3dboard){
            int j = 0;
            for(char[] cell: line){
                if (cell.length > 1){
                    System.out.println("Fist Possible:"+(i++)+":"+(j++)+":"+Arrays.toString(cell));
                    break outer;
                }
                j++;
            }
            i++;
        }
    }



    private char[] determinePossilbeValues(int i, int j, char[][] board) {
        char[] noexists = new char[]{'1','2','3','4','5','6','7', '8', '9'};
        for (char hcell: board[i]){
            if (hcell != '.'){
                for (int n =0; n< noexists.length; n++){
                    if (hcell == noexists[n]){
                        noexists[n] = 0;
                    }
                }
            }
        }
        for (char[] line : board){
            char vcell = line[j];
            if (vcell != '.'){
                for (int n =0; n< noexists.length; n++){
                    if (vcell == noexists[n]){
                        noexists[n] = 0;
                    }
                }
            }
        }
        int x = (i/3)*3;
        int y = (j/3)*3;
        for (int n1=0; n1<3; n1++){
            for (int n2=0; n2<3; n2++){
                char ccell = board[x+n1][y+n2];
                if (ccell != '.'){
                    for (int n =0; n< noexists.length; n++){
                        if (ccell == noexists[n]){
                            noexists[n] = 0;
                        }
                    }
                }
            }
        }

        int candinateNum = 0;
        for (char c : noexists){
            if (c != 0){
                candinateNum ++;
            }
        }
        char[] candinates = new char[candinateNum];
        int ci = 0;
        for (char c : noexists){
            if (c != 0){
                candinates[ci++]=c;
            }
        }
        return candinates;
    }

    public void solveSudoku(char[][] board) {
        char[][][] possilbeValues = solveSudokuStep1(board);
        trySolve(board, possilbeValues);
        System.out.println("Final:"+Arrays.deepToString(board));
    }


    public static void main(String[] args) {
        //String[] strBoard = new String[]{"53..7....","6..195...",".98....6.",
          //      "8...6...3","4..8.3..1","7...2...6",
            //    ".6....28.","...419..5","....8..79"};

        String[] strBoard = new String[]{"1...7..3.","83.6.....","..29..6.8","6....49.7",".9.....5.","3.75....4","2.3..91..",".....2.43",".4..8...9"};

        char[][] board = new char[strBoard.length][];
        int i = 0;
        for (String line : strBoard){
            board[i++]=line.toCharArray();
        }

        Sokudo sokudo = new Sokudo();
        sokudo.solveSudoku(board);
    }
}
