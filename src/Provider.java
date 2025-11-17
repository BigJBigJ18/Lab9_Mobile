import java.time.LocalDate;
import java.util.*;

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

    public void display(String areaCode){
        if(areaCode==null){
            for (Mobile mobile : mobiles) {
                System.out.println(mobile);
            }
        }else{
            Mobile m;
            for (Mobile mobile : mobiles) {
                m = mobile;
                if (m.getPhoneNumber().startsWith(areaCode)) {
                    System.out.println(m);
                }
            }
        }
    }

    public List<Mobile> expiredMobiles(){
        List<Mobile> returns=new ArrayList<>();
        for (Mobile m:mobiles){
            if(m.getDateOfPurchase().plusYears(m.getRuntime()).isAfter(LocalDate.now())){
                m.setLocked(true);
                returns.add(m);
            }
        }
        return returns;
    }

    public void delLockedMobiles(){
        Iterator iterator=mobiles.iterator();
        while(iterator.hasNext()){
            if(((Mobile)iterator.next()).isLocked()){
                iterator.remove();
            }
        }
    }
}
