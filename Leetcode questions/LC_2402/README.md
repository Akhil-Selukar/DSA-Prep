### 2402 - Meeting Rooms III

**Question link** - [Link](https://leetcode.com/problems/meeting-rooms-iii/description/)

**Topics** - Arrays, Sorting, priorityQueue

**Interview tips** -
In question on leetcode the constraints are given, but before starting this question one can ask below questions to the interviewer
to determine edge cases.
1.

**Intuition** -<br>
Here important points to note are<br> 
1. Intervals are **Half intervals** i.e. end time is not included in duration.<br>
2. In case of multiple available rooms we need to pick the one with lowest room no (i.e. lowest index).
3. If no room is available we need to delay the meeting instead of cancelling or shifting to next meeting. (which indirectly tells us that the meetings need to be conducted in order of their start time)

From above observations we can conclude few things and decide on some data structures.
1. As meetings need to be conducted in order of start time and if no room is available we need to delay the meeting, we can conclude that we need meetings in sorted order based on start time. (**So sort the meetings based on start time**).
2. We need to keep track of empty rooms and in case of multiple empty rooms we need the room with lowest room no (index). <br>Here it is obvious that one room can held multiple meetings so it will get occupied and freed frequently, so we need some data structure which will keep the available rooms in sorted order based on the index. (consider initially we have room no 3,4,6 available and we got a new freed room 1 so if we just add it in free rooms it will be added at last but we want it before 3). This is typical behaviour of priority queue.<br>So we need a priority queue for storing the free rooms (the priority queue will be sorted based on room index).
3. We also need to keep track or occupied rooms because in case of no room available we have to wait till the earliest meeting ending. So it might happen that there is a room 0 having meeting which is ending at time 10 while another room 1 which is occupied by meeting which will be ending at time 6. So even though room 1 (index) is greater than room 0, (means room 0 has to be occupied first - given in question that we have to choose room with lowest index first) room 1 will be freed first. This means again we need a data structure which will hold all occupied rooms in sorted order based on end time so that we can free up the rooms in proper order of end time. (Again priority queue)
4. We need to keep track of which room held how many meetings, so there has to be a counter against each room. This we can do by using either a Map of room index and count, but it is given in question that we have rooms from 0 to n-1 (i.e. in order and not some random values for room no). So better choice for counter here will be and array where we can consider room no as index. This will save the hashing operation in map while adding values.

Now the algorithm is simple we just have to do what is said in the problem and what we observed above.

1. Sort the meetings array based on start time.
2. Define all data structure decided.
3. Add all rooms in available priorityQueue. (as we are adding the index of rooms so it will automatically be sorted so no need to do explicit sorting).
4. Iterate over meetings
   1. There might be some rooms getting freed up at or before current time so check that and if there are such rooms the add them if available rooms priority queue.
   2. If there are available rooms then get the available room from availableRooms priority queue.
   3. Increment meeting counts for that room.
   4. Calculate the end time when the meeting will end (because we will need to make sure that we are freeing the room as soon as the meeting in that room ended).
   5. Add the room with end time in occupied priority queue.
   6. In case of no room available then first freeup the room which is occupied by meeting which will be ending the earliest, and then place the new meeting in that room.