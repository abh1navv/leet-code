class Solution { 
    public int carFleet(int target, int[] position, int[] speed) {
        TreeSet<Car> sortedCars = new TreeSet<>((a,b) -> a.pos - b.pos);
        
        for(int i=0; i<position.length; i++) {
            sortedCars.add(new Car(position[i], speed[i], (double)(target-position[i])/speed[i]));
        }
        
        Iterator<Car> carIterator = sortedCars.iterator();
        
        Car[] stack=new Car[position.length];
        int top=0;
        stack[top] = carIterator.next();
        
      // System.out.println(sortedCars);

        int count=0;
        while(carIterator.hasNext()) {
            Car curr = carIterator.next();
            if(curr.eta < stack[top].eta) {
                stack[++top] = curr;
            } else {
                while(top>=0 && curr.eta >= stack[top].eta)
                    stack[top--] = curr;
                top++;
                
            }
            
           //System.out.println(Arrays.toString(stack));
           //System.out.println(top);

        }
              
       //System.out.println(Arrays.toString(stack));
        
        return top+1;
    }
    
    record Car(int pos, int speed, double eta) {
    }
}