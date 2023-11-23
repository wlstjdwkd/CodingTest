import java.util.*;
class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        List<Integer>[] childList = new ArrayList[info.length];
        for(int i = 0; i< info.length; i++){
            childList[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            childList[edge[0]].add(edge[1]);
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        return dfs(info, childList, list, new int[2], 0);
    }
    private int dfs(int[] info, List<Integer>[] childList, List<Integer> list, int[] count, int index){
        count[info[index]]++;
        int result = count[0];
        
        if(count[1] < count[0]){
            List<Integer> newList = new ArrayList<>();
            newList.addAll(list);
            newList.addAll(childList[index]);
            newList.remove(Integer.valueOf(index));
            for(Integer tmp : newList){
                result = Math.max(result, dfs(info, childList, newList, count, tmp));
            }
        }
        count[info[index]]--;
        return result;
    }
}