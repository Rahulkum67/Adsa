class Solution {
    public long countPairs(String[] words) {
        Map<String ,Long> map=new HashMap<>();
        for(String word : words){
            String pattern =getPattern(word);
            map.put(pattern ,map.getOrDefault(pattern ,0L)+1);
        }
        long result=0;
        for(long fre:map.values()){
            result +=fre * (fre-1)/2;
        }
        return result;
    }
    private String getPattern(String s){
        StringBuilder sb=new StringBuilder();
        int base =s.charAt(0) - 'a';
        for(char c: s.toCharArray()){
            int diff=(c -'a' -base +26)%26;
            sb.append(diff).append('#');
        }
        return sb.toString();
    }
}