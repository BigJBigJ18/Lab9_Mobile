import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Provider {
    private List<Mobile> mobiles=new LinkedList<>();

    public int add(Mobile m){
        if(mobiles.contains(m)){
            return -1;
        }
        mobiles.add(m);
        return 0;
    }

    public boolean del(Mobile m){
        return mobiles.remove(m);
    }


}
