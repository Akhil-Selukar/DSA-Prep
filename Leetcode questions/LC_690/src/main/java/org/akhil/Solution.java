package org.akhil;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    // Solution 1 - using BFS (O(N^2)/O(N))
//    public int getImportance(List<Employee> employees, int id) {
//        int importance = 0;
//        Employee root = getEmpById(employees, id);
//        Queue<Employee> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            for(int i=0; i<size; i++){
//                Employee polled = queue.poll();
//                importance = importance + polled.importance;
//
//                if(polled.subordinates != null){
//                    for(Integer sub:polled.subordinates){
//                        queue.offer(getEmpById(employees, sub));
//                    }
//                }
//            }
//        }
//        return importance;
//    }
//
//    private Employee getEmpById(List<Employee> employees, int id){
//        for(Employee emp:employees){
//            if(emp.id == id){
//                return emp;
//            }
//        }
//        return null;
//    }


    // Above time complexity is N^2 because for each employee we are calling getEmpById method which in worst case will loop over all employees.
    // we can change this to O(N) by using hashMap.
    // O(N)/O(N)
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        int importance = 0;
        for(Employee emp:employees){
            map.put(emp.id, emp);
        }

        Employee root = map.get(id);
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Employee polled = queue.poll();
                importance = importance + polled.importance;

                if(polled.subordinates != null){
                    for(Integer sub:polled.subordinates){
                        queue.offer(map.get(sub));
                    }
                }
            }
        }
        return importance;
    }
}
