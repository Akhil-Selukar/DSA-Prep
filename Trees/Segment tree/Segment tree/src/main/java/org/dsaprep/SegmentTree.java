package org.dsaprep;

public class SegmentTree {
    private class Node{
        private int data;
        private int intervalStartIndex;
        private int intervalEndIndex;
        private Node leftNode;
        private Node rightNode;

        public Node(int intervalStartIndex, int intervalEndIndex){
            this.intervalStartIndex = intervalStartIndex;
            this.intervalEndIndex = intervalEndIndex;
        }
    }

    private Node root;

    public SegmentTree(int[] arr){
        this.root = constructSegmentTree(arr, 0, arr.length-1);
    }

    private Node constructSegmentTree(int[] arr, int startIndex, int endIndex){
        // base condition (i.e. leaf node)
        if(startIndex == endIndex){
            Node leafNode = new Node(startIndex, endIndex);
            leafNode.data = arr[startIndex];
            return leafNode;
        }

        // Create a new node for received index
        Node node = new Node(startIndex, endIndex);

        // Find middle of received index
        int midIndex = startIndex + (endIndex - startIndex)/2;

        // Create left and right nodes using midIndex
        node.leftNode = constructSegmentTree(arr, startIndex, midIndex);
        node.rightNode = constructSegmentTree(arr, midIndex+1, endIndex);

        // after both the nodes are created their values will also be set so we can calculate value for current node
        // by adding left and right values.
        node.data = node.leftNode.data + node.rightNode.data;

        return node;
    }

    // query (finding the actual addition between index range)
    public int query(int queryStartIndex, int queryEndIndex){
        return queryHelper(this.root, queryStartIndex, queryEndIndex);
    }

    private int queryHelper(Node node, int queryStartIndex, int queryEndIndex){
        // case 1 (refer README.md)
        if(node.intervalStartIndex >= queryStartIndex && node.intervalEndIndex <= queryEndIndex){
            return node.data;
        }
        // case 2 (refer README.md)
        else if(node.intervalStartIndex > queryEndIndex || node.intervalEndIndex < queryStartIndex){
            return 0; // default value (1 in case of multiplication)
        }
        // case 3 (refer README.md) i.e. recursive call
        else {
            return queryHelper(node.leftNode, queryStartIndex, queryEndIndex) + queryHelper(node.rightNode, queryStartIndex, queryEndIndex);
        }
    }

    // update element at specific index
    public void update(int index, int value){
        this.root.data = updateHelper(this.root, index, value);
    }

    private int updateHelper(Node node, int index, int value){
        if (index >= node.intervalStartIndex && index <= node.intervalEndIndex){
            // base condition
            if(index == node.intervalStartIndex && index == node.intervalEndIndex) {
                node.data = value;
                return node.data;
            }
            // recursive calls
            else {
                int leftAnswer = updateHelper(node.leftNode, index, value);
                int rightAnswer = updateHelper(node.rightNode, index, value);

                node.data = leftAnswer + rightAnswer;
                return node.data;
            }
        }
        return node.data;
    }


    // Not the part of actual segment tree, just created to see the segment tree.
    public void display(){
        displayHelper(this.root);
    }

    private void displayHelper(Node node){
        String str = "";

        // leftNode details
        if(node.leftNode != null){
            str = str + " Interval ["+node.leftNode.intervalStartIndex+" - "+node.leftNode.intervalEndIndex+"] and value : "+node.leftNode.data+" => ";
        } else {
            str = str + " No left node present! => ";
        }

        // currentNode details
        str = str + " Interval ["+node.intervalStartIndex+" - "+node.intervalEndIndex+"] and value : "+node.data;

        // rightNode details
        if(node.rightNode != null){
            str = str + " <= Interval ["+node.rightNode.intervalStartIndex+" - "+node.rightNode.intervalEndIndex+"] and value : "+node.rightNode.data;
        } else {
            str = str + " <= No right node present! ";
        }

        // print the details
        System.out.println(str);

        // recursive call
        if(node.leftNode != null){
            displayHelper(node.leftNode);
        }

        if(node.rightNode != null){
            displayHelper(node.rightNode);
        }
    }
}
