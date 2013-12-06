public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0) return list;
        list.add(1);
        if (rowIndex == 0) return list;
        
        list.add(1);
        for (int i = 2; i <= rowIndex; i++) {
            list.add(1, list.get(0) + list.get(1));
            for (int j = 2; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        
        return list;
    }
}
