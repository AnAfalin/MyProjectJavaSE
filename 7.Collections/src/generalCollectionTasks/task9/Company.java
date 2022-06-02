package generalCollectionTasks.task9;

import java.util.*;

public class Company {
    private static List<Worker> listWorker = new LinkedList<>();
    private final int MIN_MARK_ORAL_INTERVIEW = 10;
    private final int MAX_MARK_ORAL_INTERVIEW = 40;

    public void interview(Worker worker){
        if(worker.getAge() >= 50){
            System.out.println("Сожалеем, набор в команду завершен");
            return;
        }
        Random random = new Random();
        System.out.println("За возраст кандидат получил баллов - " + (int)(worker.getAge() * 1.25));
        worker.addMarkInterview((int)(worker.getAge() * 0.8));

        System.out.println("За стаж работы кандидат получил баллов - " + (int)(worker.getWorkExperience() * 1.33));
        worker.addMarkInterview((int)(worker.getWorkExperience() * 1.33));

        int markPost = 0;
        if(worker.getPostOffice() == PostOffice.PROGRAMMER){
            markPost = random.nextInt(30, 41);
        } else if(worker.getPostOffice() == PostOffice.ANALYST) {
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

    public List<Worker> getAllWorker(){
        return listWorker;
    }

    public List<Worker> getProgrammer(){
        List<Worker> list = new ArrayList<>();
        for (Worker worker:listWorker) {
            if(worker.getPostOffice() == PostOffice.PROGRAMMER){
                list.add(worker);
            }
        }
        return list;
    }

    public List<Worker> getHRManager(){
        List<Worker> list = new ArrayList<>();
        for (Worker worker:listWorker) {
            if(worker.getPostOffice() == PostOffice.HR_MANAGER){
                list.add(worker);
            }
        }
        return list;
    }

    public List<Worker> getAnalyst(){
        List<Worker> list = new ArrayList<>();
        for (Worker worker:listWorker) {
            if(worker.getPostOffice() == PostOffice.ANALYST){
                list.add(worker);
            }
        }
        return list;
    }

    public void unification(PostOffice postOffice1, PostOffice postOffice2){

    }
}
