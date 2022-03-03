class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        if(rowIndex == 0) return prev;
        int counter = 2;
        
        while(counter <= rowIndex+1) {
            int[] current = new int[counter];
            current[0] = 1;
            current[counter-1] = 1;
            
            for(int i=1;i<counter-1;i++) {
                current[i] = prev.get(i-1)+prev.get(i);
            }
            
            prev = IntStream.of(current).boxed().collect(Collectors.toList());
            counter++;
        }
        
        return prev;
    }
}