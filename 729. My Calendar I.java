import java.util.*;
import random.*;

class L729 {

    class MyCalendar {

        TreeSet<Pair<Integer, Integer>> myCalendars;

        public MyCalendar() {
            myCalendars = new TreeSet<>((a, b) -> {
                var score = Integer.compare(a.p1, b.p1);
                if (score == 0) {
                    score = Integer.compare(a.p2, b.p2);
                }
                return score;
            });
        }

        public boolean book(int start, int end) {
            end--;
            var floor = myCalendars.floor(new Pair<>(start, start));
            var floor2 = myCalendars.floor(new Pair<>(end, end));
            var isStartValid = floor == null || (floor.p1 < start && floor.p2 == 1);
            var isEndValid = floor2 == floor;
            if (isStartValid && isEndValid) {
                myCalendars.add(new Pair<>(start, 0));
                myCalendars.add(new Pair<>(end, 1));
                return true;
            }
            return false;
        }
    }

    class MyCalendar2 {
        TreeMap<Integer, Integer> myCalendars;

        public MyCalendar2() {
            myCalendars = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            var floor = myCalendars.floorEntry(start);
            var isStartValid = floor == null || floor.getValue() <= start;
            var ceiling = myCalendars.ceilingEntry(start);
            var isEndValid = ceiling == null || ceiling.getKey() >= end;

            if (isStartValid && isEndValid) {
                myCalendars.put(start, end);
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        MyCalendar obj = (new L729()).new MyCalendar();
        System.out.println(obj.book(69, 70));
        System.out.println(obj.book(3, 4));
        System.out.println(obj.book(39, 40));
    }
}
