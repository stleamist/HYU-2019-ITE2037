public class Subject {
    private String name;
    private String tutor;
    private String room;

    String getName() {
        return this.name;
    }
    String getTutor() {
        return this.tutor;
    }
    String getRoom() {
        return this.room;
    }
    
    void setTutor(String tutor) {
        this.tutor = tutor;
    }
    void setRoom(String room) {
        this.room = room;
    }
    
    Subject(String name, String tutor, String room) {
        this.name = name;
        this.tutor = tutor;
        this.room = room;
    }
    Subject(String name) {
        this.name = name;
    }
    Subject(Subject subject) {
        this.name = subject.name;
        this.tutor = subject.tutor;
        this.room = subject.room;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Subject) {
            Subject subject = (Subject)obj;
            if (this.name.equals(subject.name)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
    public String getDetails() {
        return String.format(
                "Name: %s\n" +
                "Tutor: %s\n" +
                "Room: %s",
                this.name, this.tutor, this.room
        );
    }
}