class RecentCounter {

    private Deque<Integer> q;
    
    public RecentCounter() {
        this.q = new LinkedList<>();
    }
    
    public int ping(int t) {
        this.q.addLast(t);
        
        while (this.q.peekFirst()< t-3000) {
            this.q.removeFirst();
        }
        
        return q.size();
    }
}
