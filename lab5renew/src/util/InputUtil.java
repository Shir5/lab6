package util;


import collection.*;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputUtil {

    boolean isUserInput;
    Scanner scanner;


    public InputUtil() {
        isUserInput = true;
        scanner = new Scanner(System.in);
    }

    public InputUtil(String script) throws FileNotFoundException {
        isUserInput = false;
        scanner = new Scanner(new FileReader(script));
    }

    public String requestCommand() {
        try {
            if (isUserInput)
                OutputUtil.outputManager("Введите команду: ");
            String command = scanner.nextLine().trim();

            if (command.isEmpty()) {
                OutputUtil.outputManagerLiner("Команда не может быть пустой");
                return requestCommand();
            } else {
                return command;

            }
        } catch (NoSuchElementException e) {
            if (isUserInput) {
                OutputUtil.outputManagerLiner("Поток System.in был закрыт. Выход из программы");
                System.exit(0);
                return null;
            } else {
                throw e;
            }

        }
    }


    public Integer requestKey() {
        try {
            if (isUserInput)
                OutputUtil.outputManager("Введите ключ: ");
            Integer key = Integer.valueOf(scanner.nextLine().trim());
            return key;

        } catch (NoSuchElementException e) {
            if (isUserInput) {
                OutputUtil.outputManagerLiner("Поток System.in был закрыт. Выход из программы");
                System.exit(0);
                return null;
            } else {
                throw e;
            }
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestKey();
        }

    }


    public long requestHeight() {
        try {
            if (isUserInput)
                OutputUtil.outputManager("Введите высоту: ");
            Long height = Long.parseLong(scanner.nextLine().trim());
            if (height <= 0) {
                OutputUtil.outputManagerLiner("Некорректное значение высоты");
                return requestHeight();
            } else {
                return height;
            }
        } catch (NoSuchElementException e) {
            if (isUserInput) {
                OutputUtil.outputManagerLiner("Поток System.in был закрыт. Выход из программы");
                System.exit(0);
                return Long.parseLong(null);
            } else {
                throw e;
            }
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestHeight();
        }
    }

    public Integer requestWeight() {
        try{
            if (isUserInput)
                OutputUtil.outputManager("Введите вес: ");
            Integer weight = Integer.valueOf(scanner.nextLine().trim());
            if (weight <= 0) {
                OutputUtil.outputManagerLiner("Некорректное значение веса");
                return requestWeight();
            } else {
                return weight;
            }
        } catch (NoSuchElementException e) {
            if (isUserInput) {
                OutputUtil.outputManagerLiner("Поток System.in был закрыт. Выход из программы");
                System.exit(0);
                return null;
            } else {
                throw e;
            }
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestWeight();
        }

    }




    public String requestName() {
        try {
            if (isUserInput)
                OutputUtil.outputManager("Введите имя: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty() || name == null) {
                OutputUtil.outputManagerLiner("Подстрока не может быть пустой");
                return requestName();
            }
            return name;
        } catch (NoSuchElementException e) {
            if (isUserInput) {
                OutputUtil.outputManagerLiner("Поток System.in был закрыт. Выход из программы");
                System.exit(0);
                return null;
            } else {
                throw e;
            }
        }
    }

    public float requestX() {
        try {
            if (isUserInput)
                OutputUtil.outputManager("Введите координату x: ");
            float x = Float.parseFloat(scanner.nextLine().trim());
            if (x <= -315) {
                OutputUtil.outputManagerLiner("Задано неверное значение x");
                return requestX();
            }
            return x;
        } catch (NoSuchElementException e) {
            if (isUserInput) {
                OutputUtil.outputManagerLiner("Поток System.in был закрыт. Выход из программы");
                System.exit(0);
                return Float.parseFloat(null);
            } else {
                throw e;
            }
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestX();
        }
    }

    public double requestY() {
        try {
            if (isUserInput)
                OutputUtil.outputManager("Введите координату y: ");
            double y = Double.parseDouble(scanner.nextLine().trim());
            if (y <= -188) {
                OutputUtil.outputManagerLiner("Задано неверное значение y");
                return requestY();
            }
            return y;
        } catch (NoSuchElementException e) {
            if (isUserInput) {
                OutputUtil.outputManagerLiner("Поток System.in был закрыт. Выход из программы");
                System.exit(0);
                return Double.parseDouble(null);
            } else {
                throw e;
            }
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestY();
        }
    }

    public Country requestCountry() {
        try {
            if (isUserInput)
                OutputUtil.outputManager("Доступные варианты национальности: \n" +
                    "UNITED_STATES\n" +
                    "GERMANY\n"+
                    "ITALY\n" +
                    "NORTH_KOREA\n" +
                    "JAPAN\n" +
                    "Введите национальность: ");

            Country country = Country.valueOf(scanner.nextLine().toUpperCase().trim());

            return country;
        } catch (NoSuchElementException e) {
            if (isUserInput) {
                OutputUtil.outputManagerLiner("Поток System.in был закрыт. Выход из программы");
                System.exit(0);
                return null;
            } else {
                throw e;
            }
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неверные данные");
            return requestCountry();
        }
    }

    public Color requestColor() {
        try {
            if (isUserInput)
                OutputUtil.outputManager("Доступные варианты цвета волос: \n" +
                    "RED\n" +
                    "BLUE\n"+
                    "YELLOW\n" +
                    "ORANGE\n" +
                    "WHITE\n" +
                    "Введите цвет волос: ");

            Color color = Color.valueOf(scanner.nextLine().toUpperCase().trim());

            return color;
        } catch (NoSuchElementException e) {
            if (isUserInput) {
                OutputUtil.outputManagerLiner("Поток System.in был закрыт. Выход из программы");
                System.exit(0);
                return null;
            } else {
                throw e;
            }
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неверные данные");
            return requestColor();
        }
    }

    public int requestLX() {
        try{
            if (isUserInput)
                OutputUtil.outputManager("Введите координату x: ");
            int lx = Integer.parseInt(scanner.nextLine().trim());
            return lx;
        } catch (NoSuchElementException e) {
            if (isUserInput) {
                OutputUtil.outputManagerLiner("Поток System.in был закрыт. Выход из программы");
                System.exit(0);
                return Integer.parseInt(null);
            } else {
                throw e;
            }
        } catch (NumberFormatException e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestLX();
        }

    }

    public float requestLY() {
        try {
            if (isUserInput)
                OutputUtil.outputManager("Введите координату y: ");
            float y = Float.parseFloat(scanner.nextLine().trim());
            return y;
        } catch (NoSuchElementException e) {
            if (isUserInput) {
                OutputUtil.outputManagerLiner("Поток System.in был закрыт. Выход из программы");
                System.exit(0);
                return Float.parseFloat(null);
            } else {
                throw e;
            }
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestLY();
        }
    }

    public float requestLZ() {
        try {
            if (isUserInput)
                OutputUtil.outputManager("Введите координату z: ");
            float z = Float.parseFloat(scanner.nextLine().trim());
            return z;
        } catch (NoSuchElementException e) {
            if (isUserInput) {
                OutputUtil.outputManagerLiner("Поток System.in был закрыт. Выход из программы");
                System.exit(0);
                return Float.parseFloat(null);
            } else {
                throw e;
            }
        } catch (Exception e) {
            OutputUtil.outputManagerLiner("Неправильный формат ввода");
            return requestLZ();
        }
    }


}
