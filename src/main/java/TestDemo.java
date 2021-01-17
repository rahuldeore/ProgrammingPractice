import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Rahul on 1/30/20
 */
class SuggestionBox{         private void onSelection(){
    //Do action when item has been selected.
    System.out.println("Item selected.");
}
    public void onRemoveSelection(){
        //Do action when item selection has been removed.
        System.out.println("Item removed.");
    }
}

public class TestDemo{
    public static void main(String[] args){
        SuggestionBox officeSuggestionBox = new SuggestionBox()
        {   public void onSelection(){
            //Do action when item has been selected.
            System.out.println("Office selected.");
        }
            public void onRemoveSelection(){
                //Do action when item selection has been removed.
                onSelection();
                System.out.println("Office removed.");
            }
        };
        officeSuggestionBox.onRemoveSelection();

        Integer number1 = new Integer(1);
        Integer number2 = number1;
        number1+=1;
        System.out.println(number1);
        System.out.println(number2);

        Solution.birthdayCakeCandles(new int[] {12,13,14,15});
        new Solution().birthdayCakeCandles(new int[] {12,13,14,15});

        Predicate<String> lengther = (s) -> s.length() < 2;
        Predicate<String> equalizer = Predicate.isEqual("car");
        Function<Boolean,String> booleaner = i -> Boolean.toString(i);
        Function<String,Boolean> stringer  = s -> Boolean.parseBoolean(s);

        System.out.println(booleaner.apply(true));
        System.out.println(booleaner.compose(stringer).apply("true").substring(0,3));
        System.out.println(stringer.compose(booleaner).apply(true));
        System.out.println(lengther.negate().or(equalizer).test("CAR"));
        //System.out.println(booleaner.andThen(stringer).apply("true"));
        Long l = new Long(1234);
        Long l1 = l;
        if(l==l1)
            System.out.println("Equal Objects");
        else
            System.out.println("Not Equal Objects");
        l++;
        if(l==l1)
            System.out.println("Equal Objects");
        else
            System.out.println("Not Equal Objects");
        String.join(":", "a","b");
    }
}
