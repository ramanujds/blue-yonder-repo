import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<String> myList = new ArrayList<>(List.of("Harsh", "Suraj","Priya","Karan","Mohit", "Parveen"));

        Collections.sort(myList);

//        List<String> pList = new ArrayList<>();
//        for (String name:myList){
//            if(name.startsWith("P")){
//                pList.add(name);
//            }
//        }
//
//        List <String>upList = new ArrayList<>();
//
//        for (String name:pList){
//            upList.add(name.toUpperCase());
//        }
//
//     //   upList.forEach(System.out::println);
//
//        String output = "";
//
//        for (String name:upList){
//            output+=name+", ";
//        }
//
//        System.out.println(output);

        String output = myList.parallelStream()
                .filter(name -> name.startsWith("P"))
                .map(name -> name.toUpperCase())
                .collect(Collectors.joining(", "));

        System.out.println(output);



    }
}