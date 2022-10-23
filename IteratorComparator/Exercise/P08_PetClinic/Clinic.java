package Advanced.IteratorComparator.Exercise.P08_PetClinic;

import java.util.List;

public class Clinic {
    private String name;
    private int numberRooms;
    private String[] rooms;

    public Clinic(String name, int numberRooms) {
        this.name = name;
        this.numberRooms = numberRooms;
        this.rooms = new String[numberRooms];
    }

    public String getName() {
        return name;
    }

    public int getNumberRooms() {
        return numberRooms;
    }

    public String[] getRooms() {
        return rooms;
    }

    public boolean addPetInRoom(String petName, String[] rooms) {
        int center = rooms.length / 2;

        if (itHasFreeSpace(rooms)) {
            int hoyManyPets = HowManyPetInRoom(rooms);
            if (hoyManyPets == 0) { //center
                rooms[center] = petName;
                return true;
            } else if (hoyManyPets % 2 != 0) { //left
                for (int i = center - 1; i >= 0; i--) {
                    if (rooms[i] == null) {
                        rooms[i] = petName;
                        return true;
                    }
                }
            } else { //right
                for (int i = center + 1; i <= rooms.length - 1; i++) {
                    if (rooms[i] == null) {
                        rooms[i] = petName;
                        return true;
                    }
                }
            }
        }
        return false;

    }

    private int HowManyPetInRoom(String[] rooms) {
        int pet = 0;
        for (String room : rooms) {
            if (room != null) {
                pet++;
            }
        }
        return pet;
    }

    public boolean itHasFreeSpace(String[] rooms) {
        for (String room : rooms) {
            if (room == null) {
                return true;
            }
        }
        return false;
    }

    public boolean release(String[] rooms) {
        int center = rooms.length / 2;
        if (itHasAnimals(rooms)) {
            for (int i = center; i < rooms.length; i++) {
                if (rooms[i] != null) {
                    rooms[i] = null;
                    return true;
                }
            }
            for (int i = 0; i <= center; i++) {
                if (rooms[i] != null) {
                    rooms[i] = null;
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    private boolean itHasAnimals(String[] rooms) {
        for (String pet : rooms) {
            if (pet != null) {
                return true;
            }
        }
        return false;
    }

    public void printAllRoom(String[] rooms, List<Pet> petList) {
        for (String room : rooms) {
            if (room == null) {
                System.out.println("Room empty");
            } else {
                for (Pet pet : petList) {
                    if (pet.getName().equals(room)){
                        System.out.printf("%s %d %s%n", pet.getName(), pet.getAge(), pet.getKind());
                    }
                }
            }
        }
    }

    public void getRequireRoom(int room, List<Pet> petList) {
        String currentName = rooms[room-1];
        if (currentName!=null){
            for (Pet pet : petList) {
                if (pet.getName().equals(currentName)){
                    System.out.printf("%s %d %s%n", pet.getName(), pet.getAge(), pet.getKind());
                    break;
                }
            }
        }else {
            System.out.println("Room empty");
        }
    }
}
