class Solution {
    private boolean bfs(int numCourses,ArrayList<ArrayList<Integer>>adj,int[] indegree){
        Queue<Integer>queue=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int count=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            ++count ;
            for(int neighbour:adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
        }
        return count==numCourses;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int[] p:prerequisites){
            adj.get(p[1]).add(p[0]);
            ++indegree[p[0]];
            
        }
        return bfs(numCourses,adj,indegree);
        
    }
}
