package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:queena
 * @Date:2020/5/172223
 * @Description:
 */
public class FindOrder_210 {
  int[] visit;
  Map<Integer, List<Integer>> edges=new HashMap<>();
  List<Integer> result=new ArrayList<>();
  boolean invalid=false;

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    visit=new int[numCourses];
    for (int[] pre:prerequisites){
      if (edges.containsKey(pre[1])) {
        edges.get(pre[1]).add(pre[0]);
      }
      else {
        List<Integer> list=new ArrayList<>();
        list.add(pre[0]);
        edges.put(pre[1],list);
      }
    }
    for (int i=0;i<numCourses;i++){
      if (!invalid&&visit[i]==0){
        dfs(i);
      }
    }
    if (invalid){
      return null;
    }
    int[] r=new int[numCourses];
    for (int i=0;i<result.size();i++){
      r[i]=result.get(numCourses-i-1);
    }
    return r;

  }
  public void dfs(int u){
    visit[u]=1;
    if (edges.get(u)!=null) {
      for (int v : edges.get(u)) {
        if (visit[v] == 0) {
          dfs(v);
          if (invalid) {
            return;
          }
        } else if (visit[v] == 1) {
          invalid = true;
          return;
        }
      }
    }
    visit[u]=2;
    result.add(u);
  }

  public static void main(String[] args) {
    FindOrder_210 findOrder_210=new FindOrder_210();
    System.out.println(findOrder_210.findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}}));
  }
}
