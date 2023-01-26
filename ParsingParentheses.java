import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String Parsing(String parentheses) {
        List<Integer> indexesList = new ArrayList<>();

        for (int i = 0; i < parentheses.length() - 1; i++)
            if (parentheses.charAt(i) == '(') {
                for (int j = i + 1; j < parentheses.length(); j++) {
                    if (parentheses.charAt(j) == ')' && !indexesList.contains(j)) {
                        indexesList.add(i);
                        indexesList.add(j);
                        break;
                    }
                }
            }

        var result = new StringBuilder();
        for (int i = 0; i < parentheses.length(); i++) {
            if (indexesList.contains(i)) {
                result.append(parentheses.charAt(i));
            }
        }
        
        if (indexesList.isEmpty()) {
            return "0";
        }
        
        return indexesList.size() + " - " + result;
    }

    public static void main(String[] args) {
        String ex1 = "(()";
        String ex2 = ")()())";
        String ex3 = ")(()())";
        String ex4 = ")(";
        String ex5 = "())(()())(()";
        System.out.println(Parsing(ex1));
        System.out.println(Parsing(ex2));
        System.out.println(Parsing(ex3));
        System.out.println(Parsing(ex4));
        System.out.println(Parsing(ex5));
    }
}
