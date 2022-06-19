import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> visit = new HashSet<>();
        HashSet<Integer> cycle = new HashSet<>();
        HashMap<Integer, List<Integer>> preCourseMap = new HashMap<>();
        for (int idx = 0; idx < numCourses; idx++) {
            preCourseMap.put(idx, new ArrayList<>());
        }
        for (int[] dependency: prerequisites) {
            preCourseMap.get(dependency[0]).add(dependency[1]);
        }
        for (int idx = 0; idx < numCourses; idx++) {
            if (!dfs(idx, visit, cycle, preCourseMap, result)) {
                return new int[]{};
            }
        }
       return transform(result);
    }
    public int[] transform(List<Integer> result) {
        Integer[] temp = result.toArray(new Integer[0]);
        int[] intResult = new int[temp.length];
        int idx = 0;
        for (Integer i : temp) {
            intResult[idx] = i;
            idx++;
        }
        return intResult;
    }
    public boolean dfs(int course, HashSet<Integer> visit, HashSet<Integer> cycle,
                       HashMap<Integer, List<Integer>> preCourseMap, List<Integer> result) {
        if (cycle.contains(course)) {
            return false;
        }
        if (visit.contains(course)) {
            return true;
        }
        cycle.add(course);
        List<Integer> preCourses  = preCourseMap.get(course);
        for (Integer preCourse : preCourses) {
            if (!dfs(preCourse, visit, cycle, preCourseMap, result)) {
                return false;
            }
        }
        cycle.remove(course);
        visit.add(course);
        result.add(course);
        return true;
    }
}
