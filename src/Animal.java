// супер класс Animal, определяющий общие черты для дочерних классов
public class Animal {

    // модификатор доступа default - поля видны всем методам и классам в текущем пакете
    // подкласс будет наследовать члены в соответствии с модификаторами доступа этих членов
    // если у суперкласса будет private поле, то подклас не унаследует это поле
    protected static int countAnimals;  //количество объектов класса Animal

    // ---------------------------------------------------------------------------------
    boolean live;                   // живой/мертвый
    protected boolean pet;          // статус одомашненности
    String typeAnimal;              // вид животного не используется в конструкторе Animal
    protected boolean leader;       // животное лидер в стае, если речь идёт о стае диких животных
    int numSwarm;    // номер стаи для адресации и нициализации элемента в множестве стай
    String name;          // кличка
    String color;         // цвет животного
    int ageMonths;        // возраст в месяцах
    boolean gender;       // пол животного
    int maxDistanceRun;   // максимальная дистанция
    int maxDistanceSwim;  // максимальная дистанция

    static {    //инициализация счётчика с количеством животных
        countAnimals = 0;
    }

    public Animal() {
        this.live = true;   //при вызове конструктора создаётся новый обьект
        this.pet = false;   //при вызове конструкта без параметров
        if (Math.random() * 100 <= 50)   //пол опрелеляется произвольным образом
            this.gender = false;
        else
            this.gender = true;
        this.ageMonths = (int)(Math.random() * 120 + 6);   // установка возраста произвольным образом
        // определение окраса произвольным образом
        String colorAnimal[] = {"Сер", "Бел", "Черн", "Рыж", "Коричнев", "Черепахов", "Двухцветн"};
        if (this.gender == true){
            int num = (int)(Math.random() * 7);
            if (colorAnimal[num] == "Рыж") this.color = colorAnimal[num] + "ий";
            else this.color = colorAnimal[num] + "ый";
        }
        else this.color = colorAnimal[(int)(Math.random() * 7)] + "ая";
        // установка клички для животного в соответствии с окрасом и одомашненностью
        if (this.pet == false) {
            if (this.gender == true) {
                this.name = this.color + " (дикий)";
            } else {
                this.name = this.color + " (дикая)";
            }
        } else {
            if (this.gender == true) {
                this.name = this.color + " (домашний)";
            } else {
                this.name = this.color + " (домашняя)";
            }
        }
    }

    // Методы класса:
    // метод для выода информации о животном с учётом рода
    public String correctPrint(){   // носит вспомогательных характер
        if(this.gender == true) return "";
        else return "a";
    }

    // функция связана с классом по данным
    // вывод информации о экземпляре класса
    public void show(){
        if (name == null) System.out.println("Цвет: " + color + "\nВозраст: " + ageMonths + " мес. (полных лет: " + ageMonths/12 + ")");
        else System.out.println("Кличка питомца: " + name + "\nЦвет: " + color + "\nВозраст: " + ageMonths + " мес. (полных лет: " + ageMonths / 12 + ")");
        if (live == false) {
            System.out.print("Вид животного: ");
            switch (typeAnimal) {
                case "cat": System.out.print("кошачьи\n"); break;
                case "dog": System.out.print("собачьи\n"); break;
            }
            System.out.println("К сожалению, животное уже умерло...\n");
        }
    }

    // метод для извлечения звуков передаваемых в качестве параметра
    public void voice(String animalVoice){
        System.out.println(this.name + " " + animalVoice);
        if(live == false) System.out.println("К сожалению, животное уже умерло...");
    }

    // метод для бега животного
    public final void run(int distance) {
        String gen = correctPrint();
        System.out.print(this.name);
        if(distance < 0) {    //если в функцию передано отрицательное направление движения
            distance = Math.abs(distance);
            System.out.print(" ... подскочил" + gen +" на месте для переориентации в пространстве и времени ... (хочет бежать в обратном направлении)\n" + this.name);
        }
        //Печать перебежек животного на заданную дистанцию:
        int count = (int)(distance / this.maxDistanceRun); // получения числа итераций для цикла с перебежками
        for (int i = 0; i <= count; i++) {  // цикл отражающий перебежки животного
            if(i != 0) System.out.print(this.name);
            //Вывод инфомации если distance == maxDistanceRun, а также если distance == 0
            if ((distance <= this.maxDistanceRun) && (distance > 0)) {
                System.out.print(" побежал" + gen + " " + distance +" метров ... Пробежал" + gen + " " + distance + " метров, устал" + gen + " и захотел" + gen + " на ручки...\n");
                break;
            }
            if (distance == 0) {
                System.out.print(" хотел" + gen +" бежать ..., да не побежал" + gen + " ... (0 метров)\n");
                break;
            }
            if (distance > this.maxDistanceRun) {
                System.out.print(" Побежал" + gen + " " + distance + " метров ... Пробежал" + gen + " " + this.maxDistanceRun + " метров и готовится для следующего рывка...\n");
                distance -= this.maxDistanceRun;
            } else {
                System.out.print(" Побежал" + gen + " " + distance + " метров ... Пробежал" + gen + " " + distance + " метров и пропал" + gen + " где-то там...\n");
            }
        }
    }

    //метод для плавания животного, модификатор final нельзя использовать, т.к. будет переопределён для класса Cat
    public void swim(int distance) {
        String gen = correctPrint();
        System.out.print(this.name);
        if(distance < 0) {    //если в функцию передано отрицательное направление движения
            distance = Math.abs(distance);
            System.out.print(" ... сменил" + gen +" курс на месте для переориентации в пространстве и времени ... (хочет пыть в обратном направлении)\n" + this.name);
        }
        //Печать перебежек животного на заданную дистанцию:
        int count = (int)(distance / this.maxDistanceSwim); // получения числа итераций для цикла с перебежками
        for (int i = 0; i <= count; i++) { // цикл отражающий перебежки животного
            if(i != 0) System.out.print(this.name);
            //Вывод инфомации если distance == maxDistanceRun, а также если distance == 0
            if ((distance <= this.maxDistanceSwim) && (distance > 0)) {
                System.out.print(" Поплыл" + gen + "... Проплыл" + gen + " " + distance + " метров.\n");
                break;
            }
            if (distance == 0) {
                System.out.print(" хотел" + gen +" плыть ..., да не поплыл" + gen + " ... (0 метров)\n");
                break;
            }
            if (distance > this.maxDistanceSwim) {
                System.out.print(" поплыл" + gen + " " + distance + " метров ... Поплыл" + gen + " " + this.maxDistanceSwim + " метров и остановил" + gen + "ся для следующего рывка...\n");
                distance -= this.maxDistanceSwim;
            } else {
                System.out.print(" поплыл" + gen + " " + distance + " метров ... Поплыл" + gen + " " + distance + " метров и остановил" + gen + "ся уже где-то там...\n");
            }
        }
    }

    // метод для отражения смерти животного
    void deadAnimal(){
        this.live = false;
        countAnimals--;
        if(this.gender == true)
            System.out.print(this.name + " умер...");
        else
            System.out.print(this.name + " умерла...");
    }

    //Метод класса для получения информации о всех созданных объектах класса Employer
    protected static void getCountAnimals() {
        System.out.println("Количество объектов в классе \"Аnimal\": " + countAnimals);
    }
}
