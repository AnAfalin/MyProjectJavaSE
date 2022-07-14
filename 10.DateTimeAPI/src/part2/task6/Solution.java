package part2.task6;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(zoneID -> System.out.println(zoneID + " - " + ZoneId.of(zoneID).getRules().getOffset(LocalDateTime.now())));

    }
}
