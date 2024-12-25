package org.akhil;

public class Main {
    public static void main(String[] args) {
        int[][] adj = new int[3][3];
        addEdge(adj,1,2);

        System.out.println(findCircleNum(adj));
        Solution2 sol = new Solution2();
        System.out.println(sol.findCircleNum(adj));
    }

    private static void addEdge(int[][] adj, int i, int j) {
        adj[i][j] = 1;
        adj[j][i] = 1;
    }


    public static int findCircleNum(int[][] isConnected) {
        int province = 0;
        boolean[] visited = new boolean[isConnected.length];

        for(int i=0; i< isConnected.length; i++){
            if(!visited[i]){
                province++;
                visited[i] = true;
                dfs(isConnected, visited, i);
            }
        }
        return province;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int i) {
        for(int j=0; j<isConnected.length; j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }
}