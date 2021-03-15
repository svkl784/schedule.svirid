package domain.users.seralization;

import domain.users.User;

import java.io.*;
import java.util.List;

public class SerializationUsers {
    public static final String FILENAME = "users.txt";

    public SerializationUsers() {
    }

    public static void writeUsers(List<User> userList) {
        SerializationAndDeserializationUser serializationUser = new SerializationAndDeserializationUser();
        serializationUser.SerializationObject(userList, FILENAME);

    }

    public static void readUsers(String fileName) {
        try {
            SerializationAndDeserializationUser deserialization = new SerializationAndDeserializationUser();
            deserialization.DeserializationObject(FILENAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class SerializationAndDeserializationUser {

        public SerializationAndDeserializationUser() {
        }

        public static void SerializationObject(List<User> userList, String fileName) {

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(userList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void DeserializationObject(String fileName) throws ClassNotFoundException {

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));) {
                List<User> taskList = (List<User>) ois.readObject();
                System.out.println("---------------Your saved USER----------------------");
                System.out.println(taskList.toString()
                        .replace("[", "")
                        .replace("]", "")
                        .replace(",", "\n"));
                System.out.println("-----------------------------------------------------");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

