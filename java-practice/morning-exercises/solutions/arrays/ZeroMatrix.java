public class ZeroMatrix{
    public static int[][] zeroRowsAndColumns(int[][] input){
        Set<Integer> rowZero = new HashSet<>();
        Set<Integer> columnZero = new HashSet<>();
        for(int i = 0; i<input.length; i++){
            int[] curArr = input[i];
            for(int j = 0; j<curArr.length; j++) {
                if (input[i][j] == 0) {
                    rowZero.add(i);
                    columnZero.add(j);
                }
            }
        }
        for(int row: rowZero){
            for(int y = 0; y < input[row].length; y++ ){
                input[row][y] = 0;
            }
        }
        for(int col: columnZero){
            for(int x = 0; x < input.length; x++){
                input[x][col] = 0;
            }
        }
        return input;
    }
}