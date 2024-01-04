package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> result = new ArrayDeque<>();

        boolean queueHasValue = firstQueue.size() >= 2 && secondQueue.size() >= 2;

        giveTwoCards(result, firstQueue);
        giveTwoCards(result, secondQueue);

        while(queueHasValue && !firstQueue.isEmpty() && !secondQueue.isEmpty() ){
            takeOneAndAddLast(firstQueue, result);
            giveTwoCards(result, firstQueue);

            takeOneAndAddLast(secondQueue, result);
            queueHasValue = giveTwoCards(result, secondQueue);
        }

        return  result;
    }

    private void takeOneAndAddLast(Queue<Integer> to, ArrayDeque<Integer> from) {
        Integer card = from.getLast();
        from.removeLast();
        to.add(card);
    }

    private boolean giveTwoCards(ArrayDeque<Integer> to, Queue<Integer> from) {
        int cards = 2;
        while (cards > 0){
            Integer x = from.poll();

            if( x == null){
                return false;
            }

            to.add(x);
            cards -= 1;
        }

        return true;
    }

}
