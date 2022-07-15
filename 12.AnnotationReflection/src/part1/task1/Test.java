package part1.task1;

public class Test {

    @MyAnnotation(author = "Author", year = 2021, description = "Description")
    public void method(){

    }

    //ошибка- не указан какой-то параметр
//    @MyAnnotation(author = "Author", description = "Description")
//    public void method1(){
//
//    }
}

