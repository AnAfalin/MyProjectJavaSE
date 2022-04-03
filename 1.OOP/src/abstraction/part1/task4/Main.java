package abstraction.part1.task4;

public class Main {
    public static void main(String[] args) {
        int kilometers = 870;
        MERCEDES mercedes = new MERCEDES();
        BMW bmw = new BMW();
        Lada lada = new Lada();
        KIA kia = new KIA();

        int disMercedes = kilometers;
        int disBMW = kilometers;
        int disLADA = kilometers;
        int disKIA= kilometers;

        System.out.println("Игровой процесс Mercedes");
        while (disMercedes > 0) {
            disMercedes = mercedes.doStep(disMercedes);
        }
        System.out.println("---------");
        System.out.println("Игровой процесс BMW");
        while (disBMW > 0) {
            disBMW = bmw.doStep(disBMW);
        }
        System.out.println("---------");
        System.out.println("Игровой процесс Lada");
        while (disLADA > 0) {
            disLADA = lada.doStep(disLADA);
        }
        System.out.println("---------");
        System.out.println("Игровой процесс KIA");
        while (disKIA > 0) {
            disKIA = kia.doStep(disKIA);
        }

        if (bmw.getCountStep() < mercedes.getCountStep() && bmw.getCountStep() < lada.getCountStep() && bmw.getCountStep() < kia.getCountStep()){
            System.out.println("Игра окончена. Выиграл BMW");
        }else if (mercedes.getCountStep() < bmw.getCountStep() && mercedes.getCountStep() < lada.getCountStep() && mercedes.getCountStep() < kia.getCountStep()){
            System.out.println("Игра окончена. Выиграл MERCEDES");
        }else if (lada.getCountStep() < mercedes.getCountStep() && lada.getCountStep() < bmw.getCountStep() && lada.getCountStep() < kia.getCountStep()){
            System.out.println("Игра окончена. Выиграла LADA");
        }else if (kia.getCountStep() < mercedes.getCountStep() && kia.getCountStep() < lada.getCountStep() && kia.getCountStep() < bmw.getCountStep()){
            System.out.println("Игра окончена. Выиграла KIA");
        }else {
            System.out.println("ПОБЕДИТЕЛЯ НЕТ");
        }

   }

}
