import java.util.*;

public class CostReduction {
    public static void main(String str[]){

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(costReduction(l));
    }

    private static int costReduction(List<Integer> l) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(l);
        int sum = priorityQueue.poll();
        int cost = 0;
        while (!priorityQueue.isEmpty()) {
            int currentElement = priorityQueue.poll();
            if (currentElement < sum) {
                priorityQueue.add(sum);
                sum = currentElement;
            } else {
                sum += currentElement;
                cost += sum;
                continue;
            }

            sum += priorityQueue.poll();
            cost += sum;
        }

        return  cost;
    }

}
