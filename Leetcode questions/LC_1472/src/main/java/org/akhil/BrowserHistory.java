package org.akhil;

public class BrowserHistory {

    private HistoryNode head;
    private HistoryNode tail;
    private HistoryNode current;
    private int size;

    public BrowserHistory(String homepage){
        HistoryNode node = new HistoryNode(homepage);
        this.head = node;
        this.tail = node;
        this.current = node;
        this.size = 1;
    }

    public void visit(String url) {
        HistoryNode node = new HistoryNode(url);
        node.previous = this.current;
        this.current.next = node;
        this.current = node;
        this.tail = node;
        this.tail.next = null;
    }

    public String back(int steps) {
        HistoryNode temp = this.current;
        for(int i=0; i<steps; i++){
            if(temp.previous == null){
                this.current = temp;
                return temp.siteName;
            }
            temp = temp.previous;
            this.current = temp;
        }
        return this.current.siteName;
    }

    public String forward(int steps) {
        HistoryNode temp = this.current;
        for(int i=0; i<steps; i++){
            if(temp.next == null){
                this.current = temp;
                return temp.siteName;
            }
            temp = temp.next;
            this.current = temp;
        }
        return this.current.siteName;
    }

    private class HistoryNode{
        private String siteName;
        private HistoryNode next;
        private HistoryNode previous;

        public HistoryNode(String siteName){
            this.siteName = siteName;
        }
    }
}
