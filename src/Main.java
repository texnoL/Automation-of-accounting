import java.util.Scanner;

public class Main {
    public static void printMenu(){
        System.out.println("1.Считать месячные отчеты");
        System.out.println("2.Считать годовой отчет");
        System.out.println("3.Сверить отчеты");
        System.out.println("4.Вывести информацию о всех месячных отчетах");
        System.out.println("5.Вывести информацию о годовом отчете");
        System.out.println("6.Выйти из программы");
    }

    public static void main(String[] args){
        Accounting app = new Accounting();
        Scanner scanner = new Scanner(System.in);
        int userInput;
        do{
            printMenu();
            userInput = scanner.nextInt();
            switch (userInput){
                case 1 ->{
                    app.readMonthReports();
                }
                case 2 ->{
                    app.readYearReports();
                }
                case 3 ->{
                    System.out.println("Введите месяц для сверки:");
                    int month = scanner.nextInt();
                    System.out.println(app.compareReports(month));
                }
                case 4 ->{
                    app.monthReportsInfo();
                }
                case 5 ->{
                    app.yearReportsInfo();
                }
                case 0 ->{
                    break;
                }
                default -> {
                    System.out.println("Неверный ввод(0-5)");
                }
            }

        }while(userInput != 0);

    }
}
