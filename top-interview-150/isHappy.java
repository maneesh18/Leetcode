class Solution {
    Set<Integer> set;
    public boolean isHappy(int n) {
        set = new HashSet();
        return check(n);
    }
    private boolean check(int n){
        if(n == 1)
            return true;
        if(set.contains(n))
            return false;
        int res = 0;
        set.add(n);
        while(n > 0){
            int rem = n % 10;
            res += rem*rem;
            n /= 10;
        }
        // System.out.println(res);
        return check(res);
    }
}
