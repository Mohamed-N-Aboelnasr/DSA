package Interval;

import java.util.LinkedList;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class Interval {

    private int start;
    private int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }

    public static List<Interval> mergeInterval(List<Interval> intervals){
        if(intervals.size() < 2){
            return intervals;
        }
        List<Interval> result = new LinkedList<>();
        intervals.sort(comparingInt((interval) -> interval.start));
        Interval first = intervals.get(0);
        int start = first.start;
        int end = first.end;
        for(int i=1; i<intervals.size(); i++){
            Interval current = intervals.get(i);
            if(current.start <= end){
                end = Math.max(end,current.end);
            }else{
                result.add(new Interval(start,end));
                start = current.start;
                end = current.end;
            }
        }
        result.add(new Interval(start,end));
        return result;
    }

    public static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval){
        List<Interval> result = new LinkedList();
        if(intervals.size() ==0 || intervals.isEmpty()){
            result.add(newInterval);
            return result;
        }
        int i=0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            result.add(intervals.get(i));
            i++;
        }
        while(i < intervals.size() && newInterval.end > intervals.get(i).start){
            newInterval.start = Math.min(newInterval.start,intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        result.add(newInterval);
        while(i < intervals.size()){
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
