import java.util.ArrayList;

public class Bag {
    private String bagName;
    private ArrayList<String> contents;

    public Bag(String name, ArrayList<String> cont){
        bagName = name;
        if(cont.get(0).equals(" other")){
            contents = new ArrayList<>();
        }
        else{
            contents = cont;
        }
    }

    public Bag(String s){
        bagName = s;
        contents = new ArrayList<>();
    }

    public Bag(){
        bagName = "empty";
        contents = new ArrayList<>();
    }

    public String getBagName(){
        return bagName;
    }

    public ArrayList<String> getContents(){
        return contents;
    }

    public void setBagName(String s){
        bagName = s;
    }

    public void setContents(ArrayList<String> s){
        contents = s;
    }

    public boolean canContain(String s){
        for(int i = 0; i<this.contents.size();i++){
            if(s.equals(this.contents.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "bagName='" + bagName + '\'' +
                ", contents=" + contents +
                '}';
    }
}
