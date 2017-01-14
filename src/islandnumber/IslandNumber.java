package islandnumber;

/**
 *
 * @author Sarath
 */
public class IslandNumber {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                                 {0, 1, 0, 0, 1},
                                 {1, 0, 0, 1, 1},
                                 {0, 0, 0, 0, 0},
                                 {1, 0, 1, 0, 1}
                                };
        
        IslandNumber islands = new IslandNumber();
        int ct = islands.getCount(M);
        System.out.println(ct);
    }

    private int getCount(int[][] M) {
        int count =0;
        int row = M.length;
        int col = M[0].length;
        boolean[][] visited = new boolean[row][col];
        
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(M[i][j]==1 && !visited[i][j]){
                    dfs(M,i,j,visited);
                    count++;
                }
            }
        return count;
    }

    private void dfs(int[][] M, int i, int j, boolean[][] visited) {
        int[] rowNbr = {-1,-1,-1,0,0,1,1,1};
        int[] colNbr = {-1,0,1,-1,1,-1,0,1};
        
        visited[i][j] = true;
        for(int k=0;k<8;k++){
            if(isSafe(M,i+rowNbr[k],j+colNbr[k],visited)){
                dfs(M, i+rowNbr[k], j+colNbr[k], visited);
            }
        }
    }

    private boolean isSafe(int[][] M, int i, int j, boolean[][] visited) {
        boolean bool = (i>=0)&& j>=0 && i<M.length && j<M[0].length && !visited[i][j] && M[i][j]==1 ;
        return bool;
        
    }
    
    
    
    
}
