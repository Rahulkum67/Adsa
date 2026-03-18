class SegmentTree{
    int[] tree;
    SegmentTree(int n){
        tree=new int[4*n];
    }
    void build(int i,int st,int end,int[] arr){
        if(st==end){
            tree[i]=arr[st];
            return;
        }
        int mid =st+(end-st)/2;
        build(2*i+1,st,mid,arr);
        build(2*i+2,mid+1,end,arr);
        tree[i]=tree[2*i+1] + tree[2*i+2];
    }
    void update(int i,int st,int end,int pos,int val){
        if(st==end){
            tree[i]=val;
            return;
        }
        int mid =st+(end-st)/2;
        if(pos <= mid){
            update(2*i+1,st,mid,pos,val);
        }else{
            update(2*i+2,mid+1,end,pos,val);
        }
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }
    int query(int idx, int l, int r, int ql, int qr) {
        if (r < ql || l > qr)
            return 0;

        if (ql <= l && r <= qr)
            return tree[idx];

        int mid = (l + r) / 2;
        int left= query(2 * idx + 1, l, mid, ql, qr);
        int right= query(2 * idx + 2, mid + 1, r, ql, qr);
        return left+right;
    }
}
class NumArray {
    SegmentTree sg;
    int n;
    public NumArray(int[] nums) {
        n=nums.length;
        sg=new SegmentTree(nums.length);
        sg.build(0,0,nums.length-1,nums);
    }
    
    public void update(int index, int val) {
        sg.update(0,0,n-1,index,val);
    }
    
    public int sumRange(int left, int right) {
        return sg.query(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */