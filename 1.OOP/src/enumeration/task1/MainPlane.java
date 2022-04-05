package enumeration.task1;

import java.util.Scanner;

public class MainPlane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Plane plane = new Plane("Boeing 777", 960);

        System.out.println("Текущий статус самолета: " + plane.getTrafficStatus());

        System.out.println("Введите статус полета самолета: PARKING, TAKEOFF, FLIGHT, LANDING или введите STOP для завершения полёта");
        while (true) {

            String status = scanner.nextLine();
            if(status.equalsIgnoreCase("PARKING") && plane.getTrafficStatus() == TrafficStatus.LANDING) {
                plane.setTrafficStatus(TrafficStatus.PARKING);
                System.out.println("Самолёт находится на парковочном месте");
            }else if(status.equalsIgnoreCase("TAKEOFF") && plane.getTrafficStatus() == TrafficStatus.PARKING) {
                plane.setTrafficStatus(TrafficStatus.TAKEOFF);
                System.out.println("Самолёт совершает взлёт");
            }else if(status.equalsIgnoreCase("FLIGHT") && plane.getTrafficStatus() == TrafficStatus.TAKEOFF) {
                plane.setTrafficStatus(TrafficStatus.FLIGHT);
                System.out.println("Самолёт взлетел. Происходит полёт к месту назначения");
            }else if(status.equalsIgnoreCase("LANDING") && plane.getTrafficStatus() == TrafficStatus.FLIGHT) {
                plane.setTrafficStatus(TrafficStatus.LANDING);
                System.out.println("Самолет совершает посадку");
                System.out.println("Посадка совершена");
            }else if (status.equalsIgnoreCase("STOP")){
                System.out.println("Полёт окончен");
                break;
            }else {
                System.out.println("Неверный ввод. Проверьте правильность и повторите изменения статуса самолета");
            }
        }

    }
}
