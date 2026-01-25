class RandomizedSet {
    int i;
    Map<Integer,Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        i = 0;
        map = new HashMap();
        list = new ArrayList();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        if(i == list.size())
            list.add(val);
        else
            list.set(i,val);
        map.put(val,i);
        i++;
        // System.out.println(list);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int temp = list.get(--i);
        list.set(map.get(val), temp);
        map.put(temp, map.get(val));
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int r =  (int)(Math.random() * i);
        // System.out.println(list);
        return list.get(r);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
