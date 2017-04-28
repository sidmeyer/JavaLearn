package sidmeyer.passportchecker;

import com.google.gson.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
import javax.swing.*;
//import java.applet.Applet;
//import java.applet.AudioClip;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Logger LOG = LogManager.getLogger("PassportChecker");
    private static List<Department> departments;
    private static String filePath = "./PassportChecker/src/main/resources/departments.json";

    private static final JsonParser parser = new JsonParser();
    private static int timeout = 240; // timeout in seconds

    public static void main(String[] args) throws InterruptedException {
        LOG.debug("Start main.");
        while (true) {
            departments = parseDepartmentsFromFile(filePath);

            for (Department department : departments) {
                department.setSlots(getSlots(department));
            }

            LOG.debug("Waiting " + timeout + " seconds...");
            Thread.sleep(timeout * 1000);
        }

        //LOG.debug("Finish main.");
    }

    public static List<Slot> getSlots(final Department department) {
        JsonObject slotsJson = checkDepartment(department);
        LOG.trace(slotsJson.toString());
        List<Slot> slots = new ArrayList<Slot>();
        try {
            if (!department.getType().equals(Department.Type.TWO) && ((JsonArray) slotsJson.get("aDay")).size() > 0) {
                for (JsonElement dayJsonElement : (JsonArray) slotsJson.get("aDay")) {
                    JsonArray daySlots = ((JsonObject) dayJsonElement).get("aSlot").getAsJsonArray();
                    for (JsonElement daySlotJsonElement : daySlots) {
                        slots.add(new Slot(
                                ((JsonObject) dayJsonElement).get("sDate").getAsString(),
                                ((JsonObject) daySlotJsonElement).get("sTime").getAsString()
                        ));
                        LOG.info("Slot added: " + slots.get(slots.size() - 1).getDate() + " " + slots.get(slots.size() - 1).getTime()
                                + " at " + department.getName());
                        new Thread() {
                            public void run() {
                                JOptionPane.showMessageDialog(null, "Free slot found!\n" + department.getName());
                            }
                        }.start();
                    }
                }
            } else if (department.getType().equals(Department.Type.TWO) && slotsJson.toString().length() != 2) {
                for (Map.Entry daySlots : slotsJson.entrySet()) {
                    for (JsonElement daySlotJsonElement : (JsonArray) daySlots.getValue()) {
                        slots.add(new Slot(daySlots.getKey().toString(), ((JsonObject) daySlotJsonElement).get("time").getAsString()));
                        LOG.info("Slot added: " + slots.get(slots.size() - 1).getDate() + " " + slots.get(slots.size() - 1).getTime()
                                + " at " + department.getName());
                        new Thread() {
                            public void run() {
                                JOptionPane.showMessageDialog(null, "Free slot found!\n" + department.getName());
                            }
                        }.start();
                    }
                }
            } else {
                LOG.debug("No free slots at " + department.getName());
            }
        } catch (Exception e) {
            LOG.error("Error in data for " + department.getName() + ": " + slotsJson.toString(), e);
        }
        return slots;
    }

    /*
    type 2 response:
{
  "2017-05-04": [
    {
      "date": "04.05.2017",
      "t_length": 20,
      "time": "14:20:00"
    }
  ]
}
     */

    public static JsonObject checkDepartment(Department department) {
        try {
            URLConnection yc = new URL(department.getUrl()).openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                return parser.parse(inputLine).getAsJsonObject();
            in.close();
        } catch (Exception e) {
            LOG.error("Can't get data for " + department.getName(), e);
        }
        return null;
    }


    public static List<Department> parseDepartmentsFromFile(String filePath) {
        LOG.info("Start reading file " + filePath + ".");

        List<Department> tempDepartments = new ArrayList<Department>();

        JsonObject jsonObject;
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8);
            jsonObject = parser.parse(br).getAsJsonObject();
        } catch (Exception e) {
            LOG.error("Error while parsing file.", e);
            return null;
        }

        JsonArray departmentsJson = jsonObject.getAsJsonArray("departments");

        for (JsonElement departmentJson : departmentsJson) {
            String name = ((JsonObject) departmentJson).get("name").getAsString();
            String url = ((JsonObject) departmentJson).get("url").getAsString();
            Department.Type type = ((JsonObject) departmentJson).get("type").getAsInt() == 1 ? Department.Type.ONE : Department.Type.TWO;

            tempDepartments.add(new Department(name, url, type));
        }

        LOG.info("Finish reading file. Added " + tempDepartments.size() + " departments.");
        return tempDepartments;
    }


    //    private static List<String> readURLs(String filePath) {
//
//        LOG.info("Start reading URLs from file \"" + filePath + "\".");
//
//        List<String> URLs = new ArrayList<String>();
//
//        File f = new File(filePath);
//        try {
//            BufferedReader fin = new BufferedReader(new FileReader(f));
//            String line;
//            int lineIndex = 0;
//            while ((line = fin.readLine()) != null) {
//                lineIndex++;
//                LOG.debug("Processing line " + lineIndex + ": \"" + line + "\".");
//                URLs.add(line);
//            }
//            LOG.info("Finish reading file. " + URLs.size() + " URLs added.");
//            fin.close();
//        } catch (FileNotFoundException e) {
//            LOG.error("Input file not found. " + e.getMessage());
//        } catch (IOException e) {
//            LOG.error("IOException" + e.getMessage());
//        }
//        return URLs;
//    }
//
//    public static void playSound() {
//        try {
//            URL url = new URL("http://www.wavsource.com/snds_2017-03-26_2137986549265739/sfx/applause_y.wav");
//            AudioClip ac = Applet.newAudioClip(url);
//            ac.play();
//
//            System.out.println("Press any key to exit.");
//            System.in.read();
//            ac.stop();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public static void playSound2() {
//        try {
//
//            URL url = new URL("http://freewavesamples.com/files/Alesis-Sanctuary-QCard-AcoustcBas-C2.wav");
//            Clip clip = AudioSystem.getClip();
//            // getAudioInputStream() also accepts a File or InputStream
//            AudioInputStream ais = AudioSystem.
//                    getAudioInputStream(url);
//            clip.open(ais);
//            clip.loop(Clip.LOOP_CONTINUOUSLY);
//            SwingUtilities.invokeLater(new Runnable() {
//                public void run() {
//                    // A GUI element to prevent the Clip's daemon Thread
//                    // from terminating at the end of the main()
//                    JOptionPane.showMessageDialog(null, "Close to exit!");
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
