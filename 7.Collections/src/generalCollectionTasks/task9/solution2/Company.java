package generalCollectionTasks.task9.solution2;

import java.util.*;

public class Company {
    private final static List<? extends Worker> listWorker = new LinkedList<>();
    private final static List<? extends Worker> listNotWorker = new LinkedList<>();

    public void interview(Worker worker) {
        if (worker.getAge() >= 50 || worker.getAge() <= 18) {
            System.out.println("Сожалеем, набор в команду завершен");
            listNotWorker.add(worker);
            return;
        }
        Random random = new Random();
        int markAge;
        int markWorkExperience;
        int markPost;
        if (worker.getAge() <= 30) {
            markAge = random.nextInt(10, 25);
        } else if (worker.getAge() <= 40) {
            markAge = random.nextInt(25, 35);
        } else {
            markAge = random.nextInt(35, 40);
        }
        worker.addMarkInterview(markAge);
        System.out.println("За возраст кандидат получил баллов - " + markAge);

        if (worker.getWorkExperience() <= 10) {
            markWorkExperience = random.nextInt(10, 15);
        } else if (worker.getAge() <= 20) {
            markWorkExperience = random.nextInt(15, 25);
        } else {
            markWorkExperience = random.nextInt(25, 40);
        }
        worker.addMarkInterview(markWorkExperience);
        System.out.println("За стаж работы кандидат получил баллов - " + markWorkExperience);

        if (worker instanceof Programmer) {
            markPost = random.nextInt(10, 19);
        } else if (worker instanceof Analyst) {
            markPost = random.nextInt(18, 25);
        } else {
            markPost = random.nextInt(25, 40);
        }

        System.out.println("За выбранную должность кандидат получил - " + markPost);
        worker.addMarkInterview(markPost);

        int markOralInterview = random.nextInt(10, 40);
        worker.addMarkInterview(markOralInterview);
        System.out.println("За устное интервью получено баллов - " + markOralInterview);
        if (worker.getMarkInterview() >= 65) {
            listWorker.add(worker);
        } else {
            listNotWorker.add(worker);
        }
    }

    public boolean isHired(Worker worker) {
        return worker.getMarkInterview() >= 65;
    }

    public List<Worker> getAllWorker() {
        return listWorker;
    }

    public List<Worker> getProgrammer() {
        List<Worker> list = new ArrayList<>();
        for (Worker worker : listWorker) {
            if (worker instanceof Programmer) {
                list.add(worker);
            }
        }
        return list;
    }

    public List<Worker> getHRManager() {
        List<Worker> list = new ArrayList<>();
        for (Worker worker : listWorker) {
            if (worker instanceof HRManager) {
                list.add(worker);
            }
        }
        return list;
    }

    public List<Worker> getAnalyst() {
        List<Worker> list = new ArrayList<>();
        for (Worker worker : listWorker) {
            if (worker instanceof Analyst) {
                list.add(worker);
            }
        }
        return list;
    }

    public void getBestWorker() {
        Programmer bestProgrammer = null;
        HRManager bestHRManager = null;
        Analyst bestAnalyst = null;

        for (Worker el : listWorker) {
            int elWorkExperience = el.getWorkExperience();
            if (el instanceof Programmer) {
                if (bestProgrammer == null) {
                    bestProgrammer = (Programmer) el;
                    continue;
                }
                if (elWorkExperience > bestProgrammer.getWorkExperience()) {
                    bestProgrammer = (Programmer) el;
                    continue;
                }
            }

            if (el instanceof HRManager) {
                if (bestHRManager == null) {
                    bestHRManager = (HRManager) el;
                    continue;
                }
                if (elWorkExperience > bestHRManager.getWorkExperience()) {
                    bestHRManager = (HRManager) el;
                    continue;
                }
            }

            if (el instanceof Analyst) {
                if (bestAnalyst == null) {
                    bestAnalyst = (Analyst) el;
                    continue;
                }
                if (elWorkExperience > bestAnalyst.getWorkExperience()) {
                    bestAnalyst = (Analyst) el;
                }
            }
        }
        System.out.println("Лучший программист - " + bestProgrammer);
        System.out.println("Лучший HR - " + bestHRManager);
        System.out.println("Лучший аналитик - " + bestAnalyst);

    }

    public List<Worker> getInfo(int number) {
        if (number == 1) {
            return getAllWorker();
        }
        if (number == 2) {
            return getProgrammer();
        }
        if (number == 3) {
            return getHRManager();
        }
        if (number == 4) {
            return getAnalyst();
        }
        return null;
    }

    public void ageAverage() {
        int ageWorker = 0;
        int ageNotWorker = 0;
        for (Worker el : listWorker) {
            ageWorker += el.getAge();
        }
        for (Worker el : listNotWorker) {
            ageNotWorker += el.getAge();
        }
        ageWorker = ageWorker / listWorker.size();
        ageNotWorker = ageNotWorker / listNotWorker.size();
        System.out.println("Средний возраст принятых - " + ageWorker);
        System.out.println("Средний возраст непринятых - " + ageNotWorker);
    }

    public void mergerTwoDepartment() {

    }

    public void listWorkerDepartment(List<? extends Worker> list) {
        Collections.copy(list, listNotWorker);
    }
}

