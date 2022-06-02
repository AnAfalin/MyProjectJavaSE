package generalCollectionTasks.task9;

import java.util.*;

public class Company {
    private static List<Worker> listWorker = new LinkedList<>();
    private final int MIN_MARK_ORAL_INTERVIEW = 10;
    private final int MAX_MARK_ORAL_INTERVIEW = 40;

    public void interview(Worker worker){
        if(worker.getAge() >= 50 || worker.getAge() <= 18){
            System.out.println("Сожалеем, набор в команду завершен");
            return;
        }
        Random random = new Random();
        int markAge = 0;
        int markWorkExperience = 0;
        int markPost = 0;
        if(worker.getAge() <=30){
            markAge = random.nextInt(10, 20);
        }else if(worker.getAge() <= 40){
            markAge = random.nextInt(20, 30);
        }else {
            markAge = random.nextInt(30, 40);
        }
        worker.addMarkInterview(markAge);
        System.out.println("За возраст кандидат получил баллов - " + markAge);

        if(worker.getWorkExperience() <= 10){
            markWorkExperience = random.nextInt(10, 20);
        }else if(worker.getAge() <= 20){
            markWorkExperience = random.nextInt(20, 30);
        }else {
            markWorkExperience= random.nextInt(30, 40);
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

    public void unification(DepartmentOffice departmentOffice1, DepartmentOffice departmentOffice2){

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
}
