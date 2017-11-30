// package edu.gcccd.csis

        import java.io.*;
        import java.util.Iterator;
        import java.util.Random;

/**
 * Use the starter code, including the NodeList class, our implementation of a BasicList.
 * <p>
 * We are going to use a very simple lists to store positive long numbers, one list element per digit.
 * The most significant digit is stored in the head element, the least significant digit is stored in the tail.
 * <p>
 * The starter code's main method creates very long numbers.
 * It is your task, to complete the class so that it can calculate the sum of positive very long numbers and
 * store the result in a file.
 * <p>
 * Of course, all methods need to have unit-tests to verify corner cases and happy-paths.
 * For that you may find the java.math.BigInteger class help-full when writing the unit-tests.
 * In the test code you are free to use java classes from all packages.
 * In the implementation of the Project2 class however, you are limited to
 * <p>
 * import java.io.*;
 * import java.util.Iterator;
 * import java.util.Random;
 * Moreover, you need to provide a detailed estimate for how often on average ANY iterator's next() method gets called
 * (depending on the value of L) when addition(Iterator&lt;NodeList&lt;Integer&gt;&gt; iterator) gets called.
 */
public class Project2 {

    static NodeList<Integer> generateNumber(final int maxLength) {
        final NodeList<Integer> nodeList = new NodeList<>();
        final int len = 1 + new Random().nextInt(maxLength);
        for (int i = 0; i < len; i++) {
            nodeList.append(new Random().nextInt(10));
        }
        System.out.print("Generated Number: ");
        print(nodeList);
        return nodeList;
    }

    /**
     * Prints a very long number to System.out
     *
     * @param nodeList NodeList<Integer>
     */
    static void print(final NodeList<Integer> nodeList) {
        for (final Integer i : nodeList) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static NodeList<Integer> reverse(Iterator<Integer> list)
    {
        NodeList<Integer> temp;
        if (list.hasNext()) {
            final int i = list.next();
            temp = reverse(list);
            temp.append(i);
            return temp;
        }
        else
        {
            temp = new NodeList<>();
            return temp;
        }
    }

    public static void main(final String[] args) {
        final int L = 30;

        final NodeList<Integer> n1 = generateNumber(L); // (head 1st) e.g. 3457
        final NodeList<Integer> n2 = generateNumber(L); // (head 1st) e.g. 682

       final Project2 project = new Project2();

        print(project.addition(n1, n2)); //  n1+n2, e.g. 4139

        final NodeList<NodeList<Integer>> listOfLists = new NodeList<>();
        for (int i = 0; i < L; i++) {
            listOfLists.append(generateNumber(L));
        }

        project.save(project.addition(listOfLists.iterator()), "result.bin");
        print(project.load("result.bin"));
    }

    /**
     * Add two very long numbers
     *
     * @param nodeList1 NodeList&lt;Integer&gt;
     * @param nodeList2 NodeList&lt;Integer&gt;
     * @return nodeList representing the sum (add) of nodeList1 and nodeList2, without leading '0'
     */
    public NodeList<Integer> addition(NodeList<Integer> nodeList1, NodeList<Integer> nodeList2) {
        // Step 1: Reverse nodeList1 and nodeList2 (i.e. 123 and 456 become 321 and 654)
        // Step 2: Add the parts to a new NodeList (i.e. 3+6, 5+2, 4+1 makes 975)
        // note: Make sure to take overflow into account! If an added number is GREATER THAN 9, only add the modulus of 10. So, say, 72 would be 72 % 10 = 2.
        // note pt. 2: Then add that thing DIVIDED BY TEN to the next bout of addition. 72 / 10 = 7, so add 7 to the next bit.
        // Step 3: Reverse all three lists now. This pits lists 1 and 2 back in order, and makes the new list their sum.

        //nodeList1;
        //at conference, ask about Iterator<NodeList<Integer>>
        // and how to retrieve values from arrayList without index method

       // int counter = 0;
        if(nodeList1 == null || nodeList2 == null) {
            NodeList<Integer> n1 = reverse(nodeList1.iterator());
            NodeList<Integer> n2 = reverse(nodeList2.iterator());

            System.out.println("Reversed: ");
            print(reverse(nodeList1.iterator()));
            System.out.println("Reversed: ");
            print(reverse(nodeList2.iterator()));
        }
        return null;



       /*  NodeList rest = addition(n1);
        n1.getNext() = nodeList1;
        rest = addition(n2);
        return nodeList1;

        n2.next = nodeList2;
        sum = nodeList1;
        return rest;

        NodeList<Integer> temp = new NodeList<>();
        NodeList<Integer> longer = (nodeList1.getLength() > nodeList2.getLength() ? nodeList1 : nodeList2);
        NodeList<Integer> shorter = (nodeList1.getLength() < nodeList2.getLength() ? nodeList1 : nodeList2);
        Iterator<Integer> longIter = longer.iterator();
        Iterator<Integer> shortIter = shorter.iterator();

        while(longIter.hasNext())
        {
            if(shortIter.hasNext())
            {
                temp.append(longIter.next()+shortIter.next());
            }
            else
            {
                temp.append(longIter.next());
            }
        }*/

        /*
        System.out.println(nodeList1);
        System.out.println(nodeList2);
        reverse(nodeList1);
       reverse(nodeList2);
       */

    }

    /**
     * Add very long numbers
     *
     * @param iterator NodeList&lt;Integer&gt;
     * @return nodeList representing the sum (add) of all very long numbers, without leading '0'
     */
    public NodeList<Integer> addition(Iterator<NodeList<Integer>> iterator) {
        NodeList<Integer> temp = new NodeList<>();
        while(iterator.hasNext())
        {
            final NodeList<Integer> i = iterator.next();
            temp = addition(temp, i);
        }
            return temp;
        }
    /**
     * Saves a very large number as a file
     *
     * @param nodeList NodeList&lt;Integer&gt;
     * @param fileName String
     */
    public void save(NodeList<Integer> nodeList, String fileName) {
        try
        {
            FileOutputStream output = new FileOutputStream("result.bin");
            output.close();
        }
        catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
    }

    /**
     * Loads a very large number from a file
     *
     * @param fileName String
     * @return NodeList&lt;Integer&gt;
     */
    public NodeList<Integer> load(final String fileName) {
        StringBuilder load = new StringBuilder("result.bin");

        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());

        return new NodeList<>();
    }

}
