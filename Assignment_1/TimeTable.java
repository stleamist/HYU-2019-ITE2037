import java.util.Arrays;
import java.util.ArrayList;

public class TimeTable {
    private Subject[][] timeTable;
    
    private Subject blankSubject = new Subject("----");
    private Subject breakSubject = new Subject("BREAK");
    private Subject lunchSubject = new Subject("LUNCH");
    
    TimeTable() {
        this.initialize();
    }

    private void initialize() {
        this.timeTable = new Subject[5][10];
        
        for (Subject[] periods : timeTable) {
            Arrays.fill(periods, blankSubject); // FIXME: 반복문으로 변환 필요
            periods[3 - 1] = breakSubject;
            periods[7 - 1] = lunchSubject;
        }
    }

    private int getNumByDay(String day) {
        String normalizedDay = day.toUpperCase();
        switch (normalizedDay) {
            case "MON": return 0;
            case "TUE": return 1;
            case "WED": return 2;
            case "THU": return 3;
            case "FRI": return 4;
            default: return -1;
        }
    }

    public Subject getSchedule(String day, int period) {
        int dayValue = getNumByDay(day);
        
        if (dayValue == -1) {
            System.out.println("You entered invalid day");
            return null;
        }
        
        return this.timeTable[dayValue][period - 1];
    }
    
    public Subject[] getAllSubjects() {
        ArrayList<Subject> list = new ArrayList<>();
        
        for (Subject[] periods : timeTable) {
            for (Subject subj : periods) {
                if (!subj.equals(blankSubject) && !subj.equals(breakSubject) && !subj.equals(lunchSubject)) {
                    list.add(subj);
                }
            }
        }
        
        return list.toArray(new Subject[list.size()]);
    }
    
    public Subject getSubjectByTitle(String title) {
        for (Subject subj : getAllSubjects()) {
            if (subj.getName().equals(title)) {
                return subj;
            }
        }
        return null;
    }

    public Boolean setSchedule(String day, int period, String name, String tutor, String room) {
        int dayValue = getNumByDay(day);
        
        if (dayValue == -1 || period == 3 || period == 7) {
            System.out.println("Class was NOT successfully added");
            return false;
        }

        Subject subject = new Subject(name, tutor, room);
        
        System.out.println(dayValue);
        System.out.println(period);
        
        this.timeTable[dayValue][period - 1] = subject;
        System.out.println("Class successfully added");
        return true;
    }

    public void printTimeTable() {
        String cells[][] = new String[11][6];

        cells[0][0] = "";
        cells[0][1] = "MON";
        cells[0][2] = "TUE";
        cells[0][3] = "WED";
        cells[0][4] = "THU";
        cells[0][5] = "FRI";
        
        for (int i = 1; i <= 10; i++) {
            cells[i][0] = Integer.toString(i);
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                String subjectName = timeTable[i][j].toString();
                subjectName = subjectName.substring(0, Math.min(9, subjectName.length()));
                cells[j+1][i+1] = subjectName;
            }
        }

        String[] rows = new String[11];
        for (int i = 0; i < 11; i++) {
            rows[i] = String.join("\t", cells[i]);
        }

        String timeTableString = String.join("\n", rows);
        
        System.out.println(timeTableString);
    }
}