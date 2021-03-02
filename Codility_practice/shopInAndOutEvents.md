# shopInAndOutEvents
You have installed a new tracking system in your local shop. The system tracks every time a customer enters or exits the shop. Now you'd like to test if the system works correctly.

At the beginning and at the end of the day there are no customers in the shop. The system logs all the in and out movements of customers in a two-dimensional array of strings events, where events[i][0] is the unique id of the customer entering or exiting the shop, and events[i][1] is either "in" or "out", depending on the direction of movement of that customer.

Your task is to write a function shopInAndOutEvents(events), which returns true if the system may have worked correctly, and false otherwise.

Example

For

events = [
  ["John_0", "in"],
  ["Mary_0", "in"],
  ["John_0", "out"],
  ["Mary_0", "out"]
]
the output should be shopInAndOutEvents(events) = true.

For

events = [
  ["John_0", "in"],
  ["John_0", "in"],
  ["John_0", "out"],
  ["John_0", "out"]
]
the output should be shopInAndOutEvents(events) = false.

The same person cannot enter the shop twice without exiting.

For

events = [
  ["John_0", "in"],
  ["John_1", "in"],
  ["John_1", "out"]
]
the output should be shopInAndOutEvents(events) = false.

The customer with the id John_0 cannot be in the shop at the end of the day.

```
boolean shopInAndOutEvents(String[][] events) {
    if(events.length % 2 != 0){
        return false;
    }
    HashMap<String,Integer> map = new HashMap<>();
    for(String[] event :events){
        if(event[1].equals("in")){
            if(map.containsKey(event[0]) && map.get(event[0]) !=0 )
                return false;
            map.put(event[0],map.getOrDefault(event[0], 0)+1);
        }
        else{
            if(!map.containsKey(event[0])){
                return false;
            }
            map.put(event[0],map.getOrDefault(event[0], 0)-1);
            
        }
        //System.out.println(map);
    }
    // System.out.println("----");
    // System.out.println(map);
    for(String key:map.keySet()){
        if(map.get(key) != 0)
            return false;
    }
    
    
    return true;
}
```
