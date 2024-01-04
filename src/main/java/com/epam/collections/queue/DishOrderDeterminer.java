package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Integer> dishes = makeArray(numberOfDishes);

        int counter = everyDishNumberToEat -1;
        List<Integer> numbers = new ArrayList<>();

        while(result.size() < numberOfDishes){

            for(; counter < dishes.size(); counter += everyDishNumberToEat){
                numbers.add(dishes.get(counter));
            }

            counter -= dishes.size();
            result.addAll(numbers);
            removeNumbersFromList(dishes, numbers);
            numbers.clear();
        }

        return  result;
    }

    private void removeNumbersFromList(LinkedList<Integer> list, List<Integer> numbers) {
        for(Integer number : numbers){
            list.remove(number);
        }
    }

    private  LinkedList<Integer> makeArray(int arrayLength) {
        LinkedList<Integer> result = new LinkedList<>();

        for(int i = 1; i<= arrayLength; i++){
            result.add(i);
        }
        return  result;
    }
}
