import java.util.HashMap;

public class VehicleRegistry {

    private final HashMap<LicensePlate, String> registryData;

    public VehicleRegistry() {
        this.registryData = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String owner){
        if(registryData.keySet().stream().anyMatch(licensePlate1 -> licensePlate1.equals(licensePlate))){
            return false;
        }
        else {
            registryData.put(licensePlate, owner);
            return true;
        }
    }

    public String get(LicensePlate licensePlate){
        //return registryData.containsKey(licensePlate) ? registryData.get(licensePlate) : null;
        if(registryData.containsKey(licensePlate)){
            return registryData.get(licensePlate);
        }
        return null;
    }

    public boolean remove(LicensePlate licensePlate){
        if(registryData.containsKey(licensePlate)){
            registryData.remove(licensePlate);
            return true;
        }
        return false;
    }

    public void printLicensePlates(){
        registryData.keySet().stream().forEach(System.out::println);
    }

    public void printOwners(){
        registryData.values().stream().distinct().forEach(System.out::println);
    }
}
