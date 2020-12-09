public class Rule {
    private String type;
    private int number;
    public Rule(String s,int n){
        type = s;
        number = n;
    }

    public void setType(String s){
        type = s;
    }

    public String getType(){
        return type;
    }

    public int getNumber(){
        return number;
    }
}
