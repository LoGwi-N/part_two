package lesson11.cats;

import java.util.Comparator;

class CatWeightComparatorDown implements Comparator<Cat>{

    public int compare(Cat a, Cat b){
        return (int) (a.getWeight() - b.getWeight());
    }
}
class CatWeightComparatorUp implements Comparator<Cat>{

    public int compare(Cat a, Cat b){
        return (int) (b.getWeight() - a.getWeight());
    }
}
