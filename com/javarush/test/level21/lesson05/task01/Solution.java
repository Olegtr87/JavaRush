package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n==null) return false;
        if (n.getClass()!=this.getClass()) return false;
        Solution solution=(Solution) n;
        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
        if (last != null ? !last.equals(solution.last) : solution.last != null) return false;

        return true;
    }

    public int hashCode() {
        int result=first!=null?first.hashCode():0;
        int result1=last!=null?last.hashCode():0;
        return 31 * result + result1;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution(null, "Duck"));

        System.out.println(s.contains(new Solution(null, "Duck")));

    }
}
