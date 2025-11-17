import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Mobile {
    private String owner;
    private Tarif tarif;
    private String phoneNumber;
    private LocalDate dateOfPurchase;
    private boolean locked=false;
    private int runtime;

    public Mobile(String owner, Tarif tarif, String phoneNumber, LocalDate dateOfPurchase, int runtime){
        setOwner(owner);
        setTarif(tarif);
        setPhoneNumber(phoneNumber);
        setDateOfPurchase(dateOfPurchase);
        setRuntime(runtime);
    }

    public void setOwner(String owner) {
        if(owner==null || owner.isBlank()){
            owner="Max Mustermann";
        }
        this.owner = owner;
    }

    public void setTarif(Tarif tarif) {
        if(tarif==null){
            tarif=Tarif.PRIVATE;
        }
        this.tarif = tarif;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber==null || phoneNumber.length()<9){
            phoneNumber="+43123456789";
        }
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        if(dateOfPurchase==null || dateOfPurchase.isAfter(LocalDate.now())){
            dateOfPurchase=LocalDate.of(2024, 1, 1);
        }
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setRuntime(int runtime) {
        if(runtime<0){
            runtime=0;
        }
        this.runtime = runtime;
    }

    public String toString() {
        return owner+"|"+tarif+"|"+phoneNumber+"|"+dateOfPurchase.format(DateTimeFormatter.ofPattern("dd.MMM.yy"))+"|"+locked+"|"+runtime;
    }

    public static Mobile getHandy(String handyString){
        if(handyString==null){
            return null;
        }
        String[] params=handyString.split("\\|");
        if(params.length!=6){
            return null;
        }
        try{
            return new Mobile(params[0], Tarif.valueOf(params[1]), params[2], LocalDate.parse(params[3], DateTimeFormatter.ofPattern("dd.MMM.yy")), Integer.parseInt(params[5]));
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Period howLong(){
        return dateOfPurchase.until(LocalDate.now());
    }

    public Period howMuchLonger(){
        Period t=LocalDate.now().until(dateOfPurchase.plusYears(runtime));
        if(t.getYears()==0 && t.getMonths()==0 && t.getDays()==0){
            return null;
        }
        return t;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mobile mobile = (Mobile) o;
        return locked == mobile.locked && runtime == mobile.runtime && Objects.equals(owner, mobile.owner) && tarif == mobile.tarif && Objects.equals(phoneNumber, mobile.phoneNumber) && Objects.equals(dateOfPurchase, mobile.dateOfPurchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, tarif, phoneNumber, dateOfPurchase, locked, runtime);
    }
}
