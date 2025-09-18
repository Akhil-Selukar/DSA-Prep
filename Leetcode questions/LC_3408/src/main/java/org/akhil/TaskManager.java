package org.akhil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskManager {

    // Structure of each task
    private static class Task {
        int taskId;
        int priority;

        public Task(int taskId, int priority) {
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    // global variables to store data
    PriorityQueue<Task> queue = new PriorityQueue<>((a, b)->{
        if(a.priority == b.priority){
            return b.taskId - a.taskId;
        }
        return b.priority - a.priority;
    });

    Map<Integer, Integer> taskToPriority = new HashMap<>();
    Map<Integer, Integer> taskToUser = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {         // [[userId, taskId, priority]]
        for(List<Integer> task:tasks){
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);

            Task newTask = new Task(taskId, priority);
            queue.offer(newTask);
            taskToPriority.put(taskId, priority);
            taskToUser.put(taskId, userId);
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskToUser.put(taskId, userId);
        taskToPriority.put(taskId, priority);
        queue.offer(new Task(taskId, priority));
    }

    public void edit(int taskId, int newPriority) {
        queue.offer(new Task(taskId, newPriority));
        taskToPriority.put(taskId, newPriority);
    }

    public void rmv(int taskId) {
        taskToPriority.put(taskId, -1); // mark as invalid
    }

    public int execTop() {
        while (!queue.isEmpty()) {
            Task top = queue.poll();
            int currPriority = taskToPriority.getOrDefault(top.taskId, -1);

            if (top.priority == currPriority) {     // this will make sure that only the updated priority (if updated) will be considered.
                taskToPriority.put(top.taskId, -1); // mark executed    (as -1 is the lowest priority hence it will not be considered);
                return taskToUser.get(top.taskId);
            }
        }
        return -1; // no valid tasks
    }
}
