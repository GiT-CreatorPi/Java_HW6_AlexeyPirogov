public class Dog extends Animal{

    protected static int countDog;      //количество объектов дочернего класса Dog

    static {    // зануление количества объектов
        countDog = 0;
    }

    {   // установка статуса для экземпляра, а также инкремент счётчиков отвечающих за количества
        this.typeAnimal = "dog";
        countAnimals++;
        countDog++;
        this.maxDistanceRun = 500;
        this.maxDistanceSwim = 10;
        super.leader = false; // для всех собак устанавливается поле в false
        // установка поля leader в классе Animal
    }

    // конструктор класса непараметризированный для создания диких собак
    public Dog(){
        super();    //явный вызов конструктора родительского класса Animal в соответствии с сигнатурой
        this.maxDistanceRun = 600;  // пусть для диких котов дистанция будет большей
    }

    // конструктор класса параметризированный для создания домашних собак
    public Dog(String name, boolean gender, String color, int age){
        // неявный вызов конструктора Animal() родительского класса Animal в соответствии с сигнатурой
        this.pet = true;    // домашний
        this.name = name;   // установка клички
        this.gender = gender;   // пол
        this.color = color;     // окрас
        this.ageMonths = ageMonths; // установка взраста
        this.maxDistanceRun = 500;  // пусть домашние животные будут менее выносливые
    }

    // метод используемый по умолчанию для класса Dog
    void voice(){
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
    protected static void showLeader(Dog[] swarm, int countDog){
        for (int i = 0; i < countDog; i++){
            if (swarm[i].leader == true)
                System.out.println("Лидер стаи: " + swarm[i].name);
        }
        System.out.println();
    }

    // метод класса Dog для отображения стаи
    protected static void showSwarm(Dog[] swarm, int countDog){
        for (int i = 0; i < 4; i++){
            swarm[i].show();
            System.out.println();
        }
    }

    // метод для отражения смерти собак
    void dead(){
        deadAnimal();
        countDog--;
    }

    // метод для получения количества объектов в классе Dog
    protected static void getCountAnimals(){
        System.out.println("Количество объектов в классе \"Dog\": " + countDog);
    }
}
