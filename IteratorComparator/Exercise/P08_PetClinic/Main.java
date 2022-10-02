package Advanced.IteratorComparator.Exercise.P08_PetClinic;

import java.security.InvalidParameterException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Pet pet = null;
        Clinic clinic = null;
        int n = Integer.parseInt(scanner.nextLine());
        List<Pet> petList = new ArrayList<>();
        List<Clinic> clinicList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputLine = scanner.nextLine().split("\\s+");

            switch (inputLine[0]) {
                case "Create":
                    if (inputLine.length == 4) {
                        String clinicName = inputLine[2];
                        int numberRooms = Integer.parseInt(inputLine[3]);

                        try {
                            if (numberRooms % 2 == 0) {
                                throw new Exception();
                            }
                        } catch (Exception ex) {
                            System.out.println("Invalid Operation!");
                            continue;
                        }

                        clinic = new Clinic(clinicName, numberRooms);
                        clinicList.add(clinic);
                    } else {
                        String petName = inputLine[2];
                        int age = Integer.parseInt(inputLine[3]);
                        String kind = inputLine[4];
                        pet = new Pet(petName, age, kind);
                        petList.add(pet);
                    }
                    break;
                case "Add": {
                    String petName = inputLine[1];
                    String clinicName = inputLine[2];
                    for (Clinic clinic1 : clinicList) {
                        if (clinicName.equals(clinic1.getName())) {
                            if (clinic1.addPetInRoom(petName, clinic1.getRooms())) {
                                System.out.println("true");
                            } else {
                                System.out.println("false");
                            }
                        }
                    }
                    break;
                }
                case "Release": {
                    String clinicName = inputLine[1];
                    for (Clinic clinic1 : clinicList) {
                        if (clinicName.equals(clinic1.getName())) {
                            if (clinic1.release(clinic1.getRooms())) {
                                System.out.println("true");
                            } else {
                                System.out.println("false");
                            }
                        }
                    }
                }
                break;
                case "HasEmptyRooms": {
                    String clinicName = inputLine[1];
                    assert clinic != null;
                   if (clinic.itHasFreeSpace(clinic.getRooms())){
                       System.out.println("true");
                   }else {
                       System.out.println("false");
                   }
                    break;
                }
                case "Print":
                    String clinicName = inputLine[1];
                    if (inputLine.length == 3) {
                        int room = Integer.parseInt(inputLine[2]);
                        assert clinic != null;
                        clinic.getRequireRoom(room,petList);
                    }else {
                        for (Clinic clinic1 : clinicList) {
                            if (clinicName.equals(clinic1.getName())) {
                                clinic1.printAllRoom(clinic1.getRooms(), petList);
                            }
                        }

                    }
                    break;

            }

        }
    }

}
