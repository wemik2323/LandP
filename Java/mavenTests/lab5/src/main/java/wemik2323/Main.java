package wemik2323;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner systemIn = new Scanner(System.in);
        ArrayList<Appliances> arrAppliances = new ArrayList<Appliances>();
        int amountOfAppliances = 0;

        while(true) {
            cleanScreen();
            menuOutput();
            int choice = readInt(systemIn);
            switch (choice) {
                case (1) :
                    makeAppliances(systemIn, arrAppliances, choice);
                    amountOfAppliances++;
                    break;
                case (2) :
                    makeAppliances(systemIn, arrAppliances, choice);
                    amountOfAppliances++;
                    break;
                case (3) :
                    makeAppliances(systemIn, arrAppliances, choice);
                    amountOfAppliances++;
                    break;
                case (4) :
                    showArrAppliances(arrAppliances, systemIn, amountOfAppliances);
                    pressEnterToContinue(systemIn);
                    break;
                case (5) :
                    amountOfAppliances = deleteAppliances(systemIn, arrAppliances, amountOfAppliances);
                    break;
                case (6) :
                    chooseDevice(systemIn, amountOfAppliances, arrAppliances);
                    break;
                case (0) :
                    System.out.println("Работа выполнена...");
                    return;
            }
        }
    }

    static void menuOutput() {
        System.out.println("================Выберите действие================");
        System.out.println("1. Создать новый класс холодильника");
        System.out.println("2. Создать новый класс стиральной машины");
        System.out.println("3. Создать новый класс посудомоечной машины");
        System.out.println("4. Вывести экземпляры классов в массиве");
        System.out.println("5. Удалить устройство из массива");
        System.out.println("6. Работа с устройствами");
        System.out.println("0. Выход");
        System.out.println("=================================================");
    }

    static void chooseDevice(Scanner systemIn, int amountOfAppliances, ArrayList<Appliances> arrAppliances) {
        while (true) {
            showArrAppliances(arrAppliances, systemIn, amountOfAppliances);
            System.out.println("0. Выход.");
            System.out.println("\nВыберите устроство.");
            int choice = readInt(systemIn);
            choice -= 1;
            if (choice < -1 || choice >= amountOfAppliances) {
                cleanScreen();
                System.out.println("Ошибка ввода!");
                pressEnterToContinue(systemIn);
                cleanScreen();
            } else if (choice == -1){
                break;
            } else {
                deviceFunctions(arrAppliances.get(choice), systemIn);
            }
        }
    }

    static void deviceFunctions(Appliances device, Scanner systemIn) {
        while(true) {
            if (device instanceof Freezer) {
                cleanScreen();
                System.out.println("Холодильник: " + ((Freezer) device).getModelName() + " от компании: " + ((Freezer) device).getBrandName());
                ((Freezer)device).outputCurrentStatus();
                ((Freezer)device).outputCurrentMode();
            } else if (device instanceof Washer) {
                cleanScreen();
                System.out.println("Стиральная машина: " + ((Washer) device).getModelName() + " от компании: " + ((Washer) device).getBrandName());
                ((Washer)device).outputCurrentStatus();
                ((Washer)device).outputCurrentMode();
            } else if (device instanceof Dishwasher) {
                cleanScreen();
                System.out.println("Посудомоечная машина: " + ((Dishwasher) device).getModelName() + " от компании: " + ((Dishwasher) device).getBrandName());
                ((Dishwasher)device).outputCurrentStatus();
                ((Dishwasher)device).outputCurrentMode();
            }
            System.out.println("----------Выберите действие----------");
            if (device.oi == 1) {
                System.out.println("1.Выключить устройство");
                System.out.println("2.Сменить режим работы");
                if (device instanceof Freezer) {
                    System.out.println("3.XXXXXXXXXXXXXXX");
                } else if (device instanceof Washer && ((Washer)device).start == 0) {
                    System.out.println("3.Начать стирку");
                } else if (device instanceof Washer && ((Washer)device).start != 0) {
                    System.out.println("3.Синхронизировать стирку");
                } else if (device instanceof Dishwasher && ((Dishwasher)device).start == 0) {
                    System.out.println("3.Начать мойку");
                } else if (device instanceof Dishwasher && ((Dishwasher)device).start != 0) {
                    System.out.println("3.Синхронизировать мойку");
                }
                System.out.println("0.Выход");
                int choice = readInt(systemIn);
                switch (choice) {
                    case 1:
                        device.toggle();
                        break;
                    case 2:
                        cleanScreen();
                        chooseMode(device, systemIn);
                        break;
                    case 3:
                        if (device instanceof Freezer) {break;}
                        if (device instanceof Washer) {
                            ((Washer) device).startCleaning(System.currentTimeMillis()/1000);
                        }
                        if (device instanceof Dishwasher) {
                            ((Dishwasher) device).startCleaning(System.currentTimeMillis()/1000);
                        }
                        break;
                    case 0:
                        return;
                    default:
                        break;
                }
            } else if (device.oi == 0) {
                System.out.println("1.Включить устройство");
                System.out.println("0.Выход");
                int choice = readInt(systemIn);
                if (choice == 1) {
                    device.toggle();
                } else if (choice == 0) {
                    return;
                } else {
                    System.out.println("Ошибка ввода!");
                    pressEnterToContinue(systemIn);
                }
            }
        }
    }

    static void chooseMode(Appliances device, Scanner systemIn) {
        while (true) {
            cleanScreen();
            System.out.println("Выберите режим работы: ");
            if (device instanceof Freezer) {
                ((Freezer)device).outputAllModes();
                System.out.println();
                ((Freezer)device).outputCurrentMode();
                System.out.println("0.Выход");
                int choice = readInt(systemIn);
                if (choice == 0) {return;}
                ((Freezer)device).changeMode(choice);
            }
            if (device instanceof Washer) {
                ((Washer)device).outputAllModes();
                System.out.println();
                ((Washer)device).outputCurrentMode();
                System.out.println("0.Выход");
                int choice = readInt(systemIn);
                if (choice == 0) {return;}
                ((Washer)device).changeMode(choice);
            }
            if (device instanceof Dishwasher) {
                ((Dishwasher)device).outputAllModes();
                System.out.println();
                ((Dishwasher)device).outputCurrentMode();
                System.out.println("0.Выход");
                int choice = readInt(systemIn);
                if (choice == 0) {return;}
                ((Dishwasher)device).changeMode(choice);
            }
            
        }
    }

    static void makeAppliances(Scanner systemIn, ArrayList<Appliances> arrAppliances, int choice) throws UnsupportedEncodingException {
        cleanScreen();
        if (choice == 1) {
            System.out.println("Введите название модели: ");
            String model = systemIn.nextLine();
            System.out.println("Введите название бренда: ");
            String brand = systemIn.nextLine();
            Freezer appFreezer = new Freezer(model, brand);
            arrAppliances.add(appFreezer);
        }
        if (choice == 2) {
            System.out.println("Введите название модели: ");
            String model = systemIn.nextLine();
            System.out.println("Введите название бренда: ");
            String brand = systemIn.nextLine();
            Washer appWasher = new Washer(model, brand);
            arrAppliances.add(appWasher);
        }
        if (choice == 3) {
            System.out.println("Введите название модели: ");
            String model = systemIn.nextLine();
            System.out.println("Введите название бренда: ");
            String brand = systemIn.nextLine();
            Dishwasher appDishwasher = new Dishwasher(model, brand);
            arrAppliances.add(appDishwasher);
        }
        cleanScreen();
    }

    static void showArrAppliances(ArrayList<Appliances> arrAppliances, Scanner systemIn, int amountOfAppliances) {
        cleanScreen();
        System.out.println("Количество подключенных устройств: " + amountOfAppliances);
        int i = 1;
        for (Appliances app : arrAppliances) {
            System.out.print(i + ". ");
            i++;
            System.out.println("UUID = " + app.getUUID());
            if (app instanceof Freezer) {
                System.out.println("Холодильник: " + ((Freezer) app).getModelName() + ", от компании: " + ((Freezer) app).getBrandName() + "\n");
            }
            if (app instanceof Washer) {
                System.out.println("Стиральная машина: " + ((Washer) app).getModelName() + ", от компании: " + ((Washer) app).getBrandName() + "\n");
            }
            if (app instanceof Dishwasher) {
                System.out.println("Посудомоечная машина: " + ((Dishwasher) app).getModelName() + ", от компании: " + ((Dishwasher) app).getBrandName() + "\n");
            }
        }
    }

    static int deleteAppliances(Scanner systemIn, ArrayList<Appliances> arrApliances, int amountOfAppliances) {
        if(amountOfAppliances == 0) {
            cleanScreen();
            System.out.println("Ошибка. Вы не можете удалять несуществующие устройства!");
            pressEnterToContinue(systemIn);
            return amountOfAppliances;
        }

        int choice = 0;
        System.out.println("Выберите элемент массива: \n");
        showArrAppliances(arrApliances, systemIn, amountOfAppliances);
        choice = readInt(systemIn);
        if (choice < 1 || choice > amountOfAppliances) {
            cleanScreen();
            System.out.println("Ошибка. Вы не можете выбрать несуществующие объекты!");
            pressEnterToContinue(systemIn);
            return amountOfAppliances;
        } else {
            arrApliances.remove(choice-1);
            amountOfAppliances--;
        }
        return amountOfAppliances;
    }

    static int readInt(Scanner systemIn) {
        while(true) {
            if (systemIn.hasNextInt()) {
                int choice = systemIn.nextInt();
                systemIn.nextLine();
                return choice;
            } else {
                System.out.println("Ошибка ввода! Введите число.");
                systemIn.nextLine();
            }
        }
    }

    static void pressEnterToContinue(Scanner systemIn)
    { 
        System.out.println("\nНажмите Enter чтобы продолжить...");
        try {
            System.in.read();
            systemIn.nextLine();
        } catch(Exception e) {
            e.getMessage();
        }  
    }

    static void cleanScreen() {
        System.out.printf("\033[2J");
    }
}
