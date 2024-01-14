import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.Point;

public class Main {
    static class Team implements Comparable<Team> {
        int id;
        int[] scoreList;
        int submitNum;
        int lastSubmit;
        int totalScore;

        @Override
        public int compareTo(Team o){
            if(this.totalScore== o.totalScore){
                if(this.submitNum == o.submitNum){
                    return this.lastSubmit - o.lastSubmit;
                }
                return this.submitNum - o.submitNum;
            }
            return o.totalScore - this.totalScore;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T=Integer.parseInt(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());
            int t=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());

            Team[] list = new Team[n];
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int teamID=Integer.parseInt(st.nextToken());
                int problemNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if(list[teamID-1] == null){
                    list[teamID-1] = new Team();
                    list[teamID-1].id = teamID;
                    list[teamID-1].scoreList = new int[k+1];
                }
                list[teamID-1].scoreList[problemNum] = Math.max(score, list[teamID-1].scoreList[problemNum]);
                list[teamID-1].submitNum++;
                list[teamID-1].lastSubmit = i;
            }
            for(int i=0; i<n; i++){
                int sum = 0;
                for(int j=1; j<=k; j++){
                    sum += list[i].scoreList[j];
                }
                list[i].totalScore = sum;
            }

            Arrays.sort(list);

            for(int i=0; i<n; i++){
                if(list[i].id == t){
                    sb.append(i+1).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}