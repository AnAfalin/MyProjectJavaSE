package part1.task12;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class Solution {
    public static void main(String[] args) {
        LocalDateTime timeJapan = LocalDateTime.now(ZoneId.of(ZoneId.SHORT_IDS.get("JST")));
        System.out.println(timeJapan.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
    }

}
