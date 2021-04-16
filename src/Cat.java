//Дисциплина: Java.Уровень 1
//Домашнее задание №: 6 "Продвинутое ООП"
//Студент: Алексей Пирогов
//Дата: 16.04.2021

// дочерний класс по отношению к Animal
// для реализации механизма наследования используется ключевое слово extends
// для каждого создаваемого класса можно указать только один суперклассс - в Java не поддерживается множественное наследование
public class Cat extends Animal{

    protected static int countCat;      //количество объектов дочернего класса Cat

    // подклас включает в себя все члены своего сперкласса Animal, поэтому объекты класса
    // будут иметь доступ к методам родительского класса

    static {    //зануление количества объектов
        countCat = 0;
    }

    {   // установка статуса для экземпляра, а также инкремент счётчиков отвечающих за количества
        this.typeAnimal = "cat";
        countAnimals++;
        countCat++;
    }

    // конструктор класса непараметризированный для создания диких котов и кошек
    public Cat(){
        this.maxDistanceRun = 300;  // пусть для диких котов дистанция будет большей
    }

    // конструктор класса параметризированный для создания домашних животных
    public Cat(String name, boolean gender, String color, int ageMonths){
        this.pet = true;    // домашний
        this.name = name;   // установка клички
        this.gender = gender;   // пол
        this.color = color;     // окрас
        this.ageMonths = ageMonths; // установка возраста
        this.maxDistanceRun = 200;  // пусть домашние животные будут менее выносливые
    }

    // перегруженный метод voice в классе Cat
    // метод используемый для класса Cat по умолчанию
    void voice(){
        System.out.print(name + " мяукнул" + correctPrint() + "!\n");
    }

    @Override   //переопределённый метод для плавания котов
    public void swim(int distance){
        String gen = correctPrint();
        System.out.print(name + " увидел" + gen + " воду ... боится воды...\n");
    }

    // метод для отражения смерти котов
    void dead(){
        deadAnimal();
        countCat--;
    }

    // метод для получения количества объектов в классе Cat
    protected static void getCountAnimals(){
        System.out.println("Количество объектов в классе \"Cat\": " + countCat);
    }
}

