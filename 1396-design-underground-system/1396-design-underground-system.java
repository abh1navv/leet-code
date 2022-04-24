class UndergroundSystem {

    Map<String, Double> avgs;
    Map<String, Integer> dataCount;
    Map<Integer, Trip> startMap; 
    
    public UndergroundSystem() {
        avgs = new HashMap<>();
        dataCount = new HashMap<>();
        startMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        startMap.put(id, new Trip(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Trip trip = startMap.get(id);
        
        String startStation = trip.startStation;
        int startTime = trip.time;
        String key = startStation+"_"+stationName;

        double avg = avgs.getOrDefault(key, 0.0);
        int count = dataCount.getOrDefault(key, 0);
        
        double newAvg = (avg*count+(t-startTime))/(count+1);
        
        dataCount.put(key, count+1);
        avgs.put(key, newAvg);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation+"_"+endStation;
        return avgs.get(key);
    }
    
    public class Trip {
        String startStation;
        int time;
        
        public Trip(String stationName, int time) {
            this.startStation = stationName;
            this.time = time;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */