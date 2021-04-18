//Дисциплина: Java.Уровень 1
//Домашнее задание №: 6 "Продвинутое ООП"
//Студент: Алексей Пирогов
//Дата: 18.04.2021

public class HomeWorkApp_6 {

    public static void main(String[] args) {

        //Создание экзепляра класса Cat
        //Формат: <новый_тип_данных> <имя_экземпляра> = new <вызов_конструктора_класса>;
        System.out.println("Первый котэ: ");
        Cat firstCat = new Cat();   // был создан кот, иллюстрация нахождения кота где-то там
        firstCat.color = "Белый";   // инициализация полей экземпляра класса данными
        firstCat.gender = true;     // инициализация в части пола (самец)
        firstCat.ageMonths = 103;   // инициализация экземпляра класса в части возраста
        firstCat.name = "Толик";    // инициализация экземпляра класса в части имени
        firstCat.show();
        firstCat.voice("громко маяукнул!");     // вызов метода класса Animal
        firstCat.run(0);    // вызов метода класса Animal
        System.out.println();

        System.out.println("Второй котэ: ");    //Создание экзмпляра класса с помощью параметризированного конструктора
        Cat secondCat = new Cat("Маркиза", false, "Дымчатая", 6);
        secondCat.show();       // метод для отображения информации о кошке
        secondCat.voice("тихо мяукнула...");    // метод класса Animal для взаимодействия экземпляра с пользователем
        secondCat.run(200);     // метод отображающий передвижение экземпляра
        secondCat.swim(10);     // метод отображающий возможность (невозможность) плавать
        secondCat.run(-200);    // метод отображающий передвижение экземпляра в обратную сторону
        System.out.println();

        System.out.println("Третий котэ: ");
        Cat thirdCat = new Cat("Лейла", false, "Рыжая", 12);
        thirdCat.show();    // метод класса Animal
        thirdCat.voice();   // метода класса Cat, переопределенный метод класса Animal
        thirdCat.swim(100);
        thirdCat.voice("зашипела ... Ш-ш-ш-ш...");
        thirdCat.run(-250);
        System.out.println();

        System.out.println("Четвёртый котэ: ");
        Cat fouthCat = new Cat();   // создание экзмпляра класса с помощью конструктора из родительского класса Animal
        fouthCat.show();
        fouthCat.voice("Мм-мя-я-я... м-мя-я-я-я... (явно голодный и хочет есть)");
        fouthCat.run(300);
        fouthCat.run(-300);
        fouthCat.voice("Мм-мя-я-я... м-мя-я-я-я... (явно напрашивается ещё поесть)");
        System.out.println();

        System.out.println("Пятый котэ: ");     // пример создания бездомного кота
        Cat fifthCat = new Cat();   // создание экзмпляра класса с помощью конструктора из родительского класса Animal
        fifthCat.show();
        fifthCat.voice("Песни поёт при ходьбе направо, а когда идёт налево, то сказки говорит ... Мя!");
        fifthCat.swim(10);
        Cat.getCountAnimals();

        System.out.println("\n--- Трагическая часть программы ... \n");
        fifthCat.deadAnimal();            // метод экземпляра иллюстрирущий, что жизнь штука хорошая, но ограниченная некторым интервалом времени
        Cat.getCountAnimals();      // метод класса Cat отражающий количество экземпляров класса
        Animal.getCountAnimals();   // метод класса Animal отражающий общее количество экземпляров класса, дочерних классов

        System.out.println();
        firstCat.deadAnimal();  // метод класса Cat, переопределённый метод класса Animal
        Cat.getCountAnimals();
        Animal.getCountAnimals();

        System.out.print("\n------------------------------------------\n\nПервый собакен:\n");
        Dog firstDog = new Dog();   // пример создания экземпляра класса иллюстрирующего создание ничейной собаки
        firstDog.show();
        firstDog.voice();
        firstDog.voice("Воу-воу-воу!");
        firstDog.run(100);  // собака умеет бегать
        firstDog.swim(20);  // и ещё может плавать
        System.out.println();

        System.out.print("Второй собакен:\n");  // пример создания экземпляра класса иллюстрирующего создание домашней собаки
        Dog secondDog = new Dog("Ганс", true, "Серый", 12);
        secondDog.show();
        secondDog.voice();
        secondDog.voice("Очень громко лает!");
        secondDog.swim(15);
        System.out.println();

        System.out.print("Третий собакен:\n");
        Dog thirdDog = new Dog();   // пример создания экземпляра класса иллюстрирующего создание ничейной собаки
        thirdDog.show();
        thirdDog.voice();
        thirdDog.voice("Рычит и лает!");
        thirdDog.run(100);
        thirdDog.run(-200);
        thirdDog.voice("Радуется и лает!");
        System.out.println();

        System.out.print("Четвертый собакен:\n");
        Dog fourthDog = new Dog("Алиса", false, "Белая", 42);
        fourthDog.voice("Воу-у-у-у-у-у... Воу-у-у-у-у-у... Воу-у-у-у-уууууу...");
        fourthDog.run(200);
        fourthDog.voice("Воу-у-у-у-у-у... Воу-у-у-у-у-у... Воу-у-у-у-уууууу...");
        fourthDog.swim(35);
        fourthDog.voice("Воу-у-у-у-у-у... Воу-у-у-у-у-у... Воу-у-у-у-уууууу...");
        System.out.println();

        System.out.print("Пятый собакен:\n");
        Dog fifthDog = new Dog();
        fifthDog.show();
        System.out.print("\nНарекаю тебя песель именем Бобик! И одомашниваю!\n");
        fifthDog.name = "Бобик";
        fifthDog.show();
        fifthDog.voice("Воу-у-у-у-у-у... Воу-у-у-у-у-у... Воу-у-у-у-уууууу...");
        System.out.println();

        System.out.println("\n--- Ещё одна трагическая часть программы ... \n");
        fourthDog.deadAnimal();
        System.out.println();

        Dog.getCountAnimals();
        Cat.getCountAnimals();
        Animal.getCountAnimals();

        System.out.println("\nИгра в некроманта:");
        firstCat.show();    // пример обращения к экземплярам класса существующих лишь в памяти, но не учитывающихся в классах
        fourthDog.show();   // и родительском классе

        Dog.getCountAnimals();
        Cat.getCountAnimals();
        Animal.getCountAnimals();

        System.out.println("\n\nПример создания стаи собак:");
        Dog swarm[] = new Dog[5];
        Dog.createSwarm(swarm, 4);
        Dog.setLeader(swarm);
        Dog.showLeader(swarm, 4);
        Dog.showSwarm(swarm, 4);

        Dog.getCountAnimals();
        Cat.getCountAnimals();
        Animal.getCountAnimals();
    }
}
