import org.w3c.dom.Node;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Integer.parseInt;

public class ElfCalorieCounter {

    public static void day1() {
        String path = "res/elfcalories.txt";
        File file = new File(path);

        Scanner scr;

        try {
            scr = new Scanner(file);
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        System.out.println("going through");
        int elf = 0;
        int bgElf1 = 0;
        int bgElf2 = 0;
        int bgElf3 = 0;
        while(scr.hasNextLine()) {
            // store next elf each iteration
            String line = scr.nextLine();

            if (!line.isEmpty()) {
                elf += parseInt(line);
                if(!scr.hasNextLine()) {
                    if(elf > bgElf1) {
                        // only keep which is the highest
                        bgElf3 = bgElf2;
                        bgElf2 = bgElf1;
                        bgElf1 = elf;

                    }
                    if(elf > bgElf2) {
                        bgElf3 = bgElf2;
                        bgElf2 = elf;

                    }
                    if(elf > bgElf3) {
                        bgElf3  = elf;

                    }
                    elf = 0;
                }
            }
            if(line.isEmpty()) {
                if(elf > bgElf1) {
                    // only keep which is the highest
                    bgElf3 = bgElf2;
                    bgElf2 = bgElf1;
                    bgElf1 = elf;

                } else if(elf > bgElf2) {
                    bgElf3 = bgElf2;
                    bgElf2 = elf;

                } else if(elf > bgElf3) {
                    bgElf3  = elf;

                }
                elf = 0;
            }
            // compare with biggest elf so far
        }
        System.out.println(bgElf1);
        System.out.println(bgElf2);
        System.out.println(bgElf3);
        System.out.println(bgElf1 + bgElf2 + bgElf3);
    }

    public static void day2() {
        String path = "res/rpsguide.txt";
        File file = new File(path);

        Scanner scr;

        try {
            scr = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int score = 0;
        while(scr.hasNextLine()) {
            String line = scr.nextLine();
            char opp = line.charAt(0);
            char me = line.charAt(2);
            score += determinePoints(opp, me);
        }
        System.out.println(score);
    }
    private static int determinePoints(char opp, char me) {
        switch(opp) {
            case 'A':
                if(me == 'X') {
                    return 0+3;
                } if(me == 'Y') {
                    return 3+1;
                } if(me == 'Z') {
                    return 6+2;
                }
            case 'B':
                if(me == 'X') {
                    return 0+1;
                } if(me == 'Y') {
                    return 3+2;
                } if(me == 'Z') {
                    return 6+3;
                }
            case 'C':
                if(me == 'X') {
                    return 0+2;
                } if(me == 'Y') {
                    return 3+3;
                } if(me == 'Z') {
                    return 6+1;
                }
            default:
                System.out.println("there is a problem");
                return -1;
        }
    }

    private static void day3() {
        String path = "res/rucksacksorting.txt";
        File file = new File(path);

        Scanner scr;

        try {
            scr = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int sum = 0;

        while(scr.hasNextLine()) {
            String firstLn = scr.nextLine();
            String secondLn = scr.nextLine();
            String thirdLn = scr.nextLine();
            char sameType = 0;

                for (int i = 0; i < firstLn.length(); i++) {
                    for (int j = 0; j < secondLn.length(); j++) {
                        for (int k = 0; k < thirdLn.length(); k++) {
                            if (firstLn.charAt(i) == secondLn.charAt(j) && secondLn.charAt(j) == thirdLn.charAt(k)) {
                                sameType = firstLn.charAt(i);
                            }
                        }
                    }
                }


            sum += determinePriority(sameType);
        }
        System.out.println(sum);
    }
    private static int determinePriority(char ch) {
        LinkedList letters = new LinkedList<Character>();
        System.out.println(ch);
        String salphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 52; i++) {
            letters.add(salphabet.charAt(i));
        }
        return letters.indexOf(ch)+1;
    }

    private static void day4() {
        String path = "res/campcleanup.txt";
        File file = new File(path);

        Scanner scr;

        try {
            scr = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int count = 0;
        while(scr.hasNextLine()) {
            String ln = scr.nextLine();
            int[] elf1 = new int[2];
            int[] elf2 = new int[2];


            for (int i = 0; i < ln.length(); i++) {
                if(ln.charAt(i) == '-' || ln.charAt(i) == ',') {
                    continue;
                }
                if(ln.charAt(i) <= '9' && ln.charAt(i) >= '0') {
                    if(i != ln.length()-1 && (ln.charAt(i+1) <= '9' && ln.charAt(i+1) >= '0')) {
                        int i1 = Character.getNumericValue(ln.charAt(i)) * 10 + Character.getNumericValue(ln.charAt(i+1));
                        if(elf1[0] == 0) {
                            elf1[0] = i1;
                        } else if(elf1[1] == 0) {
                            elf1[1] = i1;
                        } else if(elf2[0] == 0) {
                            elf2[0] = i1;
                        } else if(elf2[1] == 0) {
                            elf2[1] = i1;
                        }

                    } else if(i!=0 && ln.charAt(i-1) <= '9' && ln.charAt(i-1) >= '0') {

                    } else {
                        if(elf1[0] == 0) {
                            elf1[0] = Character.getNumericValue(ln.charAt(i));
                        } else if(elf1[1] == 0) {
                            elf1[1] = Character.getNumericValue(ln.charAt(i));
                        } else if(elf2[0] == 0) {
                            elf2[0] = Character.getNumericValue(ln.charAt(i));
                        } else if(elf2[1] == 0) {
                            elf2[1] = Character.getNumericValue(ln.charAt(i));
                        }
                    }

                }
            }

            System.out.println(elf1[0] + " " + elf1[1]);
            System.out.println(elf2[0] + " " + elf2[1]);
            if(isContained(elf1, elf2)) {
                System.out.println("got one");
                count++;
            }
        }
        System.out.println(count);
    }
    private static boolean isContained(int[] a, int[] b) {
        return ((a[0] <= b[1] && a[1] >= b[0]));
    }

    public static void day5() {
        String path = "res/stackinstructionstest.txt";
        File file = new File(path);

        Scanner scr;

        try {
            scr = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //initialize all stacks
        Stack[] stacks = new Stack[9];

        LinkedList[] lists = new LinkedList[9];

        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new Stack<Character>();
            lists[i] = new LinkedList<Character>();
            //read a line of input
        }
        for (int i = 0; i < 8; i++) {
            String line = scr.nextLine();
            int a = 0;
            for (int j = 1; j < line.length(); j+=4) {

                lists[a].add(line.charAt(j));
                a++;
            }
        }

            // put the characters on the correct stacks
        for (int i = 0; i < stacks.length; i++) {
            if(i == 8) {
                for (int j = 4; j >= 0; j--) {
                    stacks[i].push(lists[i].get(j));
                }
            } else {
                for (int j = 7; j >= 0; j--) {
                    if(!(lists[i].get(j).equals(' '))) {
                        stacks[i].push(lists[i].get(j));
                    }
                }
            }
            System.out.println(stacks[i]);
            System.out.println(stacks[i].pop());
        }


            //once all stacks are populated:
            //read a line of input
        while(scr.hasNextLine()) {
            String ln = scr.nextLine();
            int move;
            int passer;
            int receiver;
            if(ln.length() > 17) {
                move = (int)(ln.charAt(5))*10 + (int)(ln.charAt(6));
                passer = (int)(ln.charAt(13));
                receiver = (int)(ln.charAt(18));
            } else {
                move = (int)(ln.charAt(5));
                passer = (int)(ln.charAt(12));
                receiver = (int)(ln.charAt(17));
            }

            for (int i = 0; i <= move; i++) {
                stacks[receiver].push(stacks[passer].pop());
                System.out.println(stacks);
            }
        }

            //perform the line of input

    }

    private static void day7() {
        String path = "res/day7.txt";
        File file = new File(path);

        Scanner scr;

        try {
            scr = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    private class Node {
        private int file;
        private Node parent;
        ArrayList<Node> children = new ArrayList<>();

        Node(int file) {
            this.file = file;
        }

        Node(int file, Node parent) {
            this.file = file;
            this.parent = parent;
        }

        private int getTotal() {
            int sum = 0;
            for (int i = 0; i < children.size(); i++) {
                sum += children.get(i).getTotal();
            }
            return sum;
        }
    }


        public static void main (String[]args){
            day7();

        }
}
