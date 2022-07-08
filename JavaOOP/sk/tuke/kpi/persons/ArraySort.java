package sk.tuke.kpi.persons;

public class ArraySort {
    public void sort(CompareObject[] objArr){
        CompareObject co;
        
        for(int i = 0; i < objArr.length; i++) {
            for(int j = 0; j < objArr.length - 1; j++){
                if(objArr[j].compareTo(objArr[j+1]) > 0){
                    co = objArr[j];
                    objArr[j] = objArr[j+1];
                    objArr[j+1] = co;
                }
            }
        }
    }
}
