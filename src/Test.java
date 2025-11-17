import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Mobile m1=new Mobile("Jornandes", Tarif.PRIVATE, "+43123456789", LocalDate.of(2022, 12, 31), 3);
        Mobile m2=new Mobile("Max Mustermann", Tarif.OFFICE, "098767676767", LocalDate.of(2020, 1, 30), 5);
        Mobile m3=Mobile.getHandy("Martin|PRIVATE|0123456789|10.Dez..24|false|10");
        Provider p=new Provider();

        System.out.println("---------------------------------------");
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
        System.out.println("---------------------------------------");
        System.out.println(m1.howLong().toString()+" (Handy 1)\n"+m2.howLong().toString()+" (Handy 2)\n");
        p.add(m1);
        p.add(m2);
        p.add(m3);
        System.out.println("---------------------------------------");
        p.display("+43");
        System.out.println("---------------------------------------");
        p.display("0");
        System.out.println("---------------------------------------");
        p.display(null);
        System.out.println("---------------------------------------");
        p.del(m1);
        p.display(null);
        System.out.println("---------------------------------------");
        p.add(m1);
        List<Mobile> list=p.expiredMobiles();
        System.out.println("#######################################");
        for(Mobile m:list){
            System.out.println(m);
        }
        System.out.println("######################################");
        p.delLockedMobiles();
        p.display(null);
        System.out.println("---------------------------------------");
    }
}