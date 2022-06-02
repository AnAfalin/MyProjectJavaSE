package generalCollectionTasks.task9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Есть ли кандидаты для приема на работу? да / нет");
            if (!scanner.nextLine().equalsIgnoreCase("ДА")) {
                break;
            }
            System.out.println("Введите имя кандидата на прием в компаинию");
            String name = scanner.nextLine();
            System.out.println("Введите возраст кандидата");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Выберите на какую должность трудоустраивается кандидат:\n1. Программист\n2. HR-менеджер\n3. Аналитик");
            DepartmentOffice departmentOffice = null;
            boolean isRightInput = false;
            while (!isRightInput) {

                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1 -> {
                        departmentOffice = DepartmentOffice.PROGRAMMER;
                        isRightInput = true;
                    }
                    case 2 -> {
                        departmentOffice = DepartmentOffice.HR_MANAGER;
                        isRightInput = true;
                    }
                    case 3 -> {
                        departmentOffice = DepartmentOffice.ANALYST;
                        isRightInput = true;
                    }
                    default -> System.out.println("Повторите ввод");
                }

            }
            System.out.println("Сколько лет опыта работы имеет кандидат?");
            int workExperience = Integer.parseInt(scanner.nextLine());
            Worker worker = new Worker(name, age, workExperience, departmentOffice);

            company.interview(worker);
            if (company.isHired(worker)) {
                System.out.println("Бал по окончанию собеседования составил " + worker.getMarkInterview() + ". Кандидат принят на работу: YES");
            }else {
                System.out.println("Бал по окончанию собеседования составил " + worker.getMarkInterview() + ". Кандидат принят на работу: NO");
            }

        }


    }
}

