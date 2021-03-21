package domain.task.serialization;

import domain.task.Task;


import java.io.*;
import java.util.List;

public class SerializationTask {
    public static final String FILENAME = "schedule.txt";

    public SerializationTask() {
    }

    public static void writeTasks(List<Task> taskList) {
        SerializationAndDeserialization serialization = new SerializationAndDeserialization();
        SerializationAndDeserialization.SerializationObject(taskList, FILENAME);

    }

    public static void readTask(String fileName) {
        try {
            SerializationAndDeserialization deserialization = new SerializationAndDeserialization();
            deserialization.DeserializationObject(FILENAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class SerializationAndDeserialization {

        public SerializationAndDeserialization() {
        }

        public static void SerializationObject(List<Task> taskList, String fileName) {

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(taskList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void DeserializationObject(String fileName) throws ClassNotFoundException {

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));) {
                List<Task> taskList = (List<Task>) ois.readObject();
                System.out.println("---------------Your saved files----------------------");
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

