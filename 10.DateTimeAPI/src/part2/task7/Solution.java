package part2.task7;

import java.time.ZonedDateTime;

public class Solution {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        System.out.println((zonedDateTime.getOffset().getId()) + " - текущий часовой пояс");
        System.out.println(zonedDateTime.getZone() + " - текущая временная зона");

    }
}
