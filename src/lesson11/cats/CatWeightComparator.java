package lesson11.cats;

import java.util.Comparator;

class CatWeightComparatorDown implements Comparator<Cat>{

        public int compare(Cat a, Cat b){
            if(a.getWeight() > b.getWeight()){
                return 1;
            } else {
                return -1;
            }
        }
}
class CatWeightComparatorUp implements Comparator<Cat>{

    public int compare(Cat b, Cat a){
        if(a.getWeight() < b.getWeight()){
            return 1;
        } else {
            return -1;
        }
    }
}
