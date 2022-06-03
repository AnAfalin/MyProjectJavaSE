package generalCollectionTasks.task9;

import java.util.*;

public class Company {
    private static final List<Worker> listWorker = new LinkedList<>();
    private static final List<Worker> listNotWorker = new LinkedList<>();

    public void interview(Worker worker){
        if(worker.getAge() >= 50 || worker.getAge() <= 18){
            System.out.println("Сожалеем, набор в команду завершен");
            listNotWorker.add(worker);
            return;
        }
        Random random = new Random();
        int markAge;
        int markWorkExperience;
        int markPost;
        if(worker.getAge() <=30){
            markAge = random.nextInt(10, 25);
        }else if(worker.getAge() <= 40){
            markAge = random.nextInt(25, 35);
        }else {
            markAge = random.nextInt(35, 40);
        }
        worker.addMarkInterview(markAge);
        System.out.println("За возраст кандидат получил баллов - " + markAge);

        if(worker.getWorkExperience() <= 10){
            markWorkExperience = random.nextInt(10, 15);
        }else if(worker.getAge() <= 20){
            markWorkExperience = random.nextInt(15, 25);
        }else {
            markWorkExperience= random.nextInt(25, 40);
        }
        worker.addMarkInterview(markWorkExperience);
        System.out.println("За стаж работы кандидат получил баллов - " + markWorkExperience);

        if(worker.departmentOffice() == DepartmentOffice.PROGRAMMER){
            markPost = random.nextInt(30, 41);
        } else if(worker.departmentOffice() == DepartmentOffice.ANALYST) {
            markPost = random.nextInt(20, 30);
        }else {
            markPost = random.nextInt(10, 25);
        }
        System.out.println("За выбранную должность кандидат получил - " + markPost);
        worker.addMarkInterview(markPost);

        int markOralInterview = random.nextInt(10, 40);
        worker.addMarkInterview(markOralInterview);
        System.out.println("За устное интервью получено баллов - " + markOralInterview);
        if(worker.getMarkInterview() >=65){
            listWorker.add(worker);
        }else {
            listNotWorker.add(worker);
        }
    }

    public boolean isHired(Worker worker){
        return worker.getMarkInterview() >= 65;
    }

    public List<Worker> getAllWorker(){
        return listWorker;
    }

    public List<Worker> getProgrammer(){
        List<Worker> list = new ArrayList<>();
        for (Worker worker:listWorker) {
            if(worker.departmentOffice() == DepartmentOffice.PROGRAMMER){
                list.add(worker);
            }
        }
        return list;
    }

    public List<Worker> getHRManager(){
        List<Worker> list = new ArrayList<>();
        for (Worker worker:listWorker) {
            if(worker.departmentOffice() == DepartmentOffice.HR_MANAGER){
                list.add(worker);
            }
        }
        return list;
    }

    public List<Worker> getAnalyst(){
        List<Worker> list = new ArrayList<>();
        for (Worker worker:listWorker) {
            if(worker.departmentOffice() == DepartmentOffice.ANALYST){
                list.add(worker);
            }
        }
        return list;
    }

    public List<Worker> mergerTwoDepartment(DepartmentOffice departmentOffice1, DepartmentOffice departmentOffice2){
        List<Worker> list = new ArrayList<>();
        for (Worker el:listWorker) {
            if(el.departmentOffice() == departmentOffice1 || el.departmentOffice() == departmentOffice2){
                list.add(el);
            }
        }
        return list;
    }

    public Worker getBestWorker(DepartmentOffice departmentOffice){
        Worker bestWorker = null;
        for (Worker el:listWorker) {
            if(el.departmentOffice() == departmentOffice){
                if(bestWorker != null){
                   if(el.getWorkExperience() > bestWorker.getWorkExperience()){
                       bestWorker = el;
                   }
                }else {
                    bestWorker = el;
                }
            }
        }
        return bestWorker;
    }

    public List<Worker> getInfo(int number){
        if(number == 1){
            return getAllWorker();
        }
        if(number == 2){
            return getProgrammer();
        }
        if(number == 3){
            return getHRManager();
        }
        if(number == 4){
            return getAnalyst();
        }
        return null;
    }

    public void ageAverage(){
        int ageWorker = 0;
        int ageNotWorker = 0;
        for (Worker el:listWorker) {
            ageWorker += el.getAge();
        }
        for (Worker el: listNotWorker) {
            ageNotWorker += el.getAge();
        }
        ageWorker = ageWorker / listWorker.size();
        ageNotWorker = ageNotWorker / listNotWorker.size();
        System.out.println("Средний возраст принятых - " + ageWorker);
        System.out.println("Средний возраст непринятых - " + ageNotWorker);
    }
}
