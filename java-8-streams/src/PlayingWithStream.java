import java.util.List;

public class PlayingWithStream {


    public static void main(String[] args) {

        List<Integer> numbers = List.of(10,6,2,8,3,4);

        // Find all the odd numbers
        // Square them
        // Add them

       int sum = numbers.stream().filter(n -> n%2 != 0)
                .map(n -> n*n)
                .reduce((x,y)->x+y)
                .orElse(0);

       System.out.println(sum);


    }





}
