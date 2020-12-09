import java.util.ArrayList;

public class InfiniteSatchel {
    private ArrayList<Bag> bagsInSatchel;
    
    public InfiniteSatchel(ArrayList<Bag> bags){
        bagsInSatchel = bags;
    }
    
    public InfiniteSatchel(){
        bagsInSatchel = new ArrayList<>();
    }
    
    public Bag findBag(String s){
        for(Bag bag:bagsInSatchel){
            if(bag.getBagName().equals(s)){
                return bag;
            }
        }
        Bag emptybag = new Bag();
        return emptybag;
    }
}
