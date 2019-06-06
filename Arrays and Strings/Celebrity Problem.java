/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        LinkedList<Integer> people = new LinkedList<>();
        for(int i=0;i<n;i++)
            people.add(i);
        for(int i=0;i<n-1;i++)
            if(knows(people.get(0),people.get(1)))
                people.remove(0);
            else
                people.remove(1);
        
        for(int i=0;i<n;i++)
        {
            if(i==people.get(0))
                continue;
            if(knows(people.get(0),i) || !knows(i,people.get(0)))
                return -1;
        }
        return people.get(0);
    }
}
