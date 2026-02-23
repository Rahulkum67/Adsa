class Solution {
    class Pair{
        String s;
        int dist;
        Pair(String s,int dist){
            this.s=s;
            this.dist=dist;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        HashSet<String> st=new HashSet<>(wordList);
        if(!st.contains(endWord)){
            return 0;
        }
        q.add(new Pair(beginWord,1));
        st.remove(beginWord);
        
        while(!q.isEmpty()){
            Pair curr=q.poll();
            String currword=curr.s;
            int currdist=curr.dist;
            if (currword.equals(endWord)) {
                return currdist;
            }
            char wordarr[]=currword.toCharArray();
            for(int i=0;i<currword.length();i++){
                char original=wordarr[i];
                for(char j='a';j<='z';j++){
                    wordarr[i]=j;
                    String newword=new String(wordarr);
                    if(st.contains(newword)){
                        q.add(new Pair(newword,currdist+1));
                        st.remove(newword);
                    }
                }
                wordarr[i]=original;
            }
        }
        return 0;
    }
}