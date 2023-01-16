package bootcamp.spring.trello.Classes;

public enum TaskStatus {
    TODO(0),
    INTEST(1),
    DONE(2),
    FAILED(3);

    private final int intValue;

    TaskStatus(int intValue){
        this.intValue=intValue;
    }
     public int getIntValue(){
        return this.intValue;
     }
}
