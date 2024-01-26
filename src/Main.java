import java.util.ArrayList;
import java.util.List;

// Интерфейс для умных устройств
interface SmartDevice {
    void turnOn();
    void turnOff();
    void connectToInternet();
}

// Абстрактный класс для гаджетов, реализует интерфейс SmartDevice
abstract class Gadget implements SmartDevice {
    abstract void receiveNotification(String message);
    abstract void batteryStatus();
}

// Класс для представления экосистемы умных устройств
class SmartEcosystem {
    private List<SmartDevice> devices = new ArrayList<>();

    // Метод для добавления нового устройства в экосистему
    void addDevice(SmartDevice device) {
        devices.add(device);
    }

    // Метод для взаимодействия между устройствами
    void connectDevices(SmartDevice device1, SmartDevice device2) {
        System.out.println("Connecting devices...");
        // Реализация логики взаимодействия между устройствами
        // Например, передача информации от одного устройства другому
    }
}

// Класс SmartPhone, наследуется от Gadget
class SmartPhone extends Gadget {
    @Override
    public void turnOn() {
        System.out.println("Смартфон включен.");
    }

    @Override
    public void turnOff() {
        System.out.println("Смартфон выключен.");
    }

    @Override
    public void connectToInternet() {
        System.out.println("Смартфон подключен к интернету.");
    }

    @Override
    void receiveNotification(String message) {
        System.out.println("Смартфон получил уведомление: " + message);
    }

    @Override
    void batteryStatus() {
        System.out.println("Заряд батареи смартфона: 70%");
    }

    // Дополнительные методы для SmartPhone
    void makeCall(String number) {
        System.out.println("Совершается звонок на номер " + number + " со смартфона.");
    }

    void sendSMS(String message) {
        System.out.println("Отправляется SMS: " + message);
    }
}

// Класс SmartWatch, наследуется от Gadget
class SmartWatch extends Gadget {
    @Override
    public void turnOn() {
        System.out.println("Смарт-часы включены.");
    }

    @Override
    public void turnOff() {
        System.out.println("Смарт-часы выключены.");
    }

    @Override
    public void connectToInternet() {
        System.out.println("Смарт-часы подключены к интернету.");
    }

    @Override
    void receiveNotification(String message) {
        System.out.println("Смарт-часы получили уведомление: " + message);
    }

    @Override
    void batteryStatus() {
        System.out.println("Заряд батареи смарт-часов: 80%");
    }

    // Дополнительные методы для SmartWatch
    void trackHeartRate() {
        System.out.println("Смарт-часы отслеживают пульс.");
    }

    void showTime() {
        System.out.println("Текущее время: 12:00 дня.");
    }
}

// Класс SmartTV, наследуется от Gadget
class SmartTV extends Gadget {
    @Override
    public void turnOn() {
        System.out.println("Смарт-телевизор включен.");
    }

    @Override
    public void turnOff() {
        System.out.println("Смарт-телевизор выключен.");
    }

    @Override
    public void connectToInternet() {
        System.out.println("Смарт-телевизор подключен к интернету.");
    }

    @Override
    void receiveNotification(String message) {
        System.out.println("Смарт-телевизор получил уведомление: " + message);
    }

    @Override
    void batteryStatus() {
        System.out.println("У смарт-телевизора нет батареи.");
    }

    // Дополнительные методы для SmartTV
    void streamVideo(String url) {
        System.out.println("Воспроизведение видео по URL: " + url);
    }

    void changeChannel(int channel) {
        System.out.println("Переключение телеканала на " + channel);
    }
}

// Главный класс с методом main
public class Main {
    public static void main(String[] args) {
        // Создаем объекты смартфона, смарт-часов и смарт-телевизора
        SmartPhone myPhone1 = new SmartPhone();
        SmartPhone myPhone2 = new SmartPhone();
        SmartWatch myWatch = new SmartWatch();
        SmartTV myTV = new SmartTV();

        // Создаем экосистему и добавляем устройства
        SmartEcosystem ecosystem = new SmartEcosystem();
        ecosystem.addDevice(myPhone1);
        ecosystem.addDevice(myPhone2);
        ecosystem.addDevice(myWatch);
        ecosystem.addDevice(myTV);

        // Используем методы устройств
        System.out.println("=== Взаимодействие с смартфоном 1 ===");
        myPhone1.turnOn();
        myPhone1.makeCall("123456789");
        myPhone1.sendSMS("Привет!");

        System.out.println("\n=== Взаимодействие с смартфоном 2 ===");
        myPhone2.turnOn();
        myPhone2.receiveNotification("Важное уведомление");

        System.out.println("\n=== Взаимодействие с смарт-часами ===");
        myWatch.turnOn();
        myWatch.showTime();
        myWatch.trackHeartRate();

        System.out.println("\n=== Взаимодействие с смарт-телевизором ===");
        myTV.turnOn();
        myTV.streamVideo("https://youtube.com");
        myTV.changeChannel(5);

        // Можем также использовать интер-устройственное соединение
        System.out.println("\n=== Интер-устройственное соединение ===");
        ecosystem.connectDevices(myPhone1, myTV);
        ecosystem.connectDevices(myPhone2, myWatch);

        // Добавим еще одно устройство
        SmartWatch myNewWatch = new SmartWatch();
        ecosystem.addDevice(myNewWatch);

        System.out.println("\n=== Взаимодействие с новыми смарт-часами ===");
        myNewWatch.turnOn();
        myNewWatch.showTime();
        myNewWatch.receiveNotification("Новое уведомление");

        // Можем также использовать интер-устройственное соединение для нового устройства
        System.out.println("\n=== Интер-устройственное соединение для новых смарт-часов ===");
        ecosystem.connectDevices(myNewWatch, myTV);
    }
}

