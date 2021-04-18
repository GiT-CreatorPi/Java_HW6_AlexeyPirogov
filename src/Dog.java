//Дисциплина: Java.Уровень 1
//Домашнее задание №: 6 "Продвинутое ООП"
//Студент: Алексей Пирогов
//Дата: 18.04.2021

// дочерний класс по отношению к Animal
// для реализации механизма наследования используется ключевое слово extends
// для каждого создаваемого класса можно указать только один суперклассс - в Java не поддерживается множественное наследование
public class Dog extends Animal{

    protected static int counterDog;      //количество объектов дочернего класса Dog

    static {    // зануление количества объектов
        counterDog = 0;
    }

    {   // установка статуса для экземпляра, а также инкремент счётчиков отвечающих за количества
        this.typeAnimal = "dog";    // установка типа элемента
        counterAnimals++;   // инкремент счётчика животных
        counterDog++;       // инкрементк количества собак
        this.maxDistanceSwim = 10;  // установка максимальной дистанции для плаванья
        super.leader = false; // установка поля leader в классе Animal: для всех собак устанавливается поле в false
    }

    // конструктор класса непараметризированный для создания диких собак
    public Dog(){
        super();    //явный вызов конструктора родительского класса Animal в соответствии с сигнатурой
        this.maxDistanceRun = 600;  // пусть для диких котов дистанция будет большей
    }

    // конструктор класса параметризированный для создания домашних собак
    public Dog(String name, boolean gender, String color, int age){
        // неявный вызов конструктора Animal() родительского класса Animal в соответствии с сигнатурой
        this.pet = true;            // домашний
        this.name = name;           // установка клички
        this.gender = gender;       // пол
        this.color = color;         // окрас
        this.ageMonths = ageMonths; // установка взраста
        this.maxDistanceRun = 500;  // пусть домашние животные будут менее выносливые
    }

    // метод используемый по умолчанию для класса Dog
    final void voice(){
        System.out.print(name + " что-то увидел" + correctPrint() + " и издал рычащий звук!\n");
    }

    // метод класса Dog для создания стаи
    protected static void createSwarm(Dog[] swarm, int countDog){
        for (int i = 0; i < countDog; i++){
            swarm[i] = new Dog();
        }
    }

    // метод для установки лидера в стае
    protected static int setLeader(Dog[] swarm){
        int numLeader = (int)Math.random() * 4;
        swarm[numLeader].leader = true;
        System.out.println("Лидер: \n" + swarm[numLeader].name);
        return numLeader;
    }

    // метод класса Dog для отображения лидера
    protected final static void showLeader(Dog[] swarm, int countDog){
        for (int i = 0; i < countDog; i++){
            if (swarm[i].leader == true)
                System.out.println("Лидер стаи: " + swarm[i].name);
        }
        System.out.println();
    }

    // метод класса Dog для отображения стаи
    protected final static void showSwarm(Dog[] swarm, int countDog){
        for (int i = 0; i < 4; i++){
            swarm[i].show();
            System.out.println();
        }
    }

    // перегруженный метод deadAnimal класса Animal в классе Dog
    // метод используется для отражения смерти собак
    final void deadAnimal(){
        super.deadAnimal();     // обращение к методу супер класса
        counterDog--;       // декремент количества объектов класса
    }

    // метод класса Dog для получения количества объектов в классе
    protected static void getCountAnimals(){
        System.out.println("Количество объектов в классе \"Dog\": " + counterDog);
    }
}
