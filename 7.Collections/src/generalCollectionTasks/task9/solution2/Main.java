package generalCollectionTasks.task9.solution2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        List<Programmer> ls = new ArrayList<>();
        company.listWorkerDepartment(ls);
//
//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Есть ли кандидаты для приема на работу? да / нет");
//            if (!scanner.nextLine().equalsIgnoreCase("ДА")) {
//                break;
//            }
//            Worker worker = null;
//            System.out.println("Введите имя кандидата на прием в компаинию");
//            String name = scanner.nextLine();
//            System.out.println("Введите возраст кандидата");
//            int age = Integer.parseInt(scanner.nextLine());
//            System.out.println("Сколько лет опыта работы имеет кандидат?");
//            int workExperience = Integer.parseInt(scanner.nextLine());
//
//            System.out.println("Выберите на какую должность трудоустраивается кандидат:\n1. Программист\n2. HR-менеджер\n3. Аналитик");
//            boolean isRightInput = false;
//            while (!isRightInput) {
//
//                switch (Integer.parseInt(scanner.nextLine())) {
//                    case 1 -> {
//                        worker = new Programmer(name, age, workExperience);
//                        isRightInput = true;
//                    }
//                    case 2 -> {
//                        worker = new HRManager(name, age, workExperience);
//                        isRightInput = true;
//                    }
//                    case 3 -> {
//                        worker = new Analyst(name, age, workExperience);
//                        isRightInput = true;
//                    }
//                    default -> System.out.println("Повторите ввод");
//                }
//            }
//
//            company.interview(worker);
//            if (company.isHired(worker)) {
//                System.out.println("Бал по окончанию собеседования составил " + worker.getMarkInterview() + ". Кандидат принят на работу: YES");
//            } else {
//                System.out.println("Бал по окончанию собеседования составил " + worker.getMarkInterview() + ". Кандидат принят на работу: NO");
//            }
//        }
//
//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Какую информацию Вы хотите получить?\n" +
//                    "1. Получить список всех сотрудников\n" +
//                    "2. Получить список программистов\n" +
//                    "3. Получить список  HR\n" +
//                    "4. Получить список аналитиков\n" +
//                    "5. Узнать лучшего сотрудника\n" +
//                    "6. EXIT");
//            int answer = Integer.parseInt(scanner.nextLine());
//            if (answer == 6) {
//                break;
//            }
//            if (answer <= 4) {
//                System.out.println(company.getInfo(answer));
//            } else {
//                company.getBestWorker();
//            }
//
//        }
    }
}


