```java
public class SegmentTree {
    
    // Node structure
    private class Node{
        private int data;
        private int rangeStartIndex;
        private int rangeEndIndex;
        private Node leftNode;
        private Node rightNode;

        public Node(int start, int end){
            rangeStartIndex = start;
            rangeEndIndex = end;
        }
    }

    private Node root;

    // constructor to initialize the segment tree
    public SegmentTree(int[] arr){
        this.root = populateSegmentTree(arr, 0, arr.length-1);
    }

    private Node populateSegmentTree(int[] arr, int startIndex, int endIndex){
        // if there is only one element left in range
        if(startIndex == endIndex){
            Node node = new Node(startIndex, endIndex);
            node.data = arr[startIndex];
            return node;
        }

        // if there are multiple values in the range then divide the range and process left and right part individually.
        Node node = new Node(startIndex, endIndex);
        int midIndex = startIndex + (endIndex - startIndex)/2;
        node.leftNode = populateSegmentTree(arr, startIndex, midIndex);
        node.rightNode = populateSegmentTree(arr, midIndex + 1, endIndex);

        node.data = node.leftNode.data + node.rightNode.data;
        return node;
    }

    // method to query the segment tree
    public int query(int start, int end){
        if(end > root.rangeEndIndex || start < root.rangeStartIndex){
            throw new NullPointerException("Invalid query");
        }
        return queryHelper(root, start, end);
    }

    private int queryHelper(Node root, int start, int end){
        // case 1 - if current query range entirely lies in current nodes range
        if(root.rangeStartIndex >= start && root.rangeEndIndex <= end){
            return root.data;
        }

        // case 2 - if current query range entirely out of the current nodes range.
        else if(root.rangeStartIndex > end || root.rangeEndIndex < start){
            return 0;
        }
        // case 3 - break the node range i.e. check to left and right of the current node
        else {
            return queryHelper(root.leftNode, start, end) + queryHelper(root.rightNode, start, end);
        }
    }

    // method to update value in tree at specific index
    public void update(int index, int value){
        if(index > root.rangeEndIndex || index < root.rangeStartIndex){
            throw new NullPointerException("Invalid index");
        }
        root.data = updateHelper(root, index, value);
    }

    private int updateHelper(Node root, int index, int value) {
        // update need to be performed only for valid index
        if(root.rangeStartIndex <= index && root.rangeEndIndex >= index){
            // if this is the leaf node with valid index update the data in the node
            if(root.rangeStartIndex == index && root.rangeEndIndex == index){
                root.data = value;
                return root.data;
            }
            // else recursively go till the valid leaf
            else {
                int leftData = updateHelper(root.leftNode, index, value);
                int rightData = updateHelper(root.rightNode, index, value);

                root.data = leftData + rightData;
                return root.data;
            }
        }

        // if index is invalid we just keep the data as it is.
        return root.data;
    }

}
```