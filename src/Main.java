import java.util.ArrayList;
import java.util.List;

interface SmartDevice {
    void turnOn();
    void turnOff();
    void connectToInternet();
    void playVideo(String videoUrl);
}

abstract class Gadget implements SmartDevice {
    abstract void receiveNotification(String message);
    abstract void batteryStatus();

    @Override
    public void playVideo(String videoUrl) {
        System.out.println("Воспроизведение видео: " + videoUrl);
    }
}

class SmartEcosystem {
    private List<SmartDevice> devices = new ArrayList<>();

    void addDevice(SmartDevice device) {
        devices.add(device);
    }

    void connectDevices(SmartDevice device1, SmartDevice device2) {
        System.out.println("Устройства соединяются...");
    }
}

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

    void makeCall(String number) {
        System.out.println("Совершается звонок на номер " + number + " со смартфона.");
    }

    void sendSMS(String message) {
        System.out.println("Отправляется SMS: " + message);
    }

    void findAndShareVideo(String videoUrl, SmartDevice targetDevice) {
        System.out.println("Поиск и передача видео устройству " + targetDevice.getClass().getSimpleName());
        targetDevice.playVideo(videoUrl);
    }
}

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

    void trackHeartRate() {
        System.out.println("Смарт-часы отслеживают пульс.");
    }

    void showTime() {
        System.out.println("Текущее время: 12:00 дня.");
    }
}

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

    void streamVideo(String url) {
        System.out.println("Воспроизведение видео по URL: " + url);
    }

    void changeChannel(int channel) {
        System.out.println("Переключение телеканала на " + channel);
    }

    void shareVideo(String videoUrl, SmartDevice targetDevice) {
        System.out.println("Поделиться видео с " + targetDevice.getClass().getSimpleName());
        targetDevice.playVideo(videoUrl);
    }
}

public class Main {
    public static void main(String[] args) {
        SmartPhone myPhone1 = new SmartPhone();
        SmartPhone myPhone2 = new SmartPhone();
        SmartWatch myWatch = new SmartWatch();
        SmartTV myTV = new SmartTV();

        SmartEcosystem ecosystem = new SmartEcosystem();
        ecosystem.addDevice(myPhone1);
        ecosystem.addDevice(myPhone2);
        ecosystem.addDevice(myWatch);
        ecosystem.addDevice(myTV);

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

        System.out.println("\n=== Устройственное соединение ===");
        ecosystem.connectDevices(myPhone1, myTV);
        ecosystem.connectDevices(myPhone2, myWatch);

        System.out.println("\n=== Взаимодействие с новыми смарт-часами ===");
        SmartWatch myNewWatch = new SmartWatch();
        ecosystem.addDevice(myNewWatch);
        myNewWatch.turnOn();
        myNewWatch.showTime();
        myNewWatch.receiveNotification("Новое уведомление");

        System.out.println("\n=== Устройственное соединение для новых смарт-часов ===");
        ecosystem.connectDevices(myNewWatch, myTV);

        System.out.println("\n=== Поделиться видео от смартфона на смарт-телевизор ===");
        String videoUrl = "https://example.com/video";
        myPhone1.findAndShareVideo(videoUrl, myTV);

        System.out.println("\n=== Поделиться видео от смартфона на смарт-часы ===");
        myPhone1.findAndShareVideo(videoUrl, myWatch);

        System.out.println("\n=== Поделиться видео от смарт-телевизора на смартфон ===");
        myTV.shareVideo(videoUrl, myPhone1);
    }
}
