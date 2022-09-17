import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Accounting {
    private final String reppath = "C:\\Users\\User\\IdeaProjects\\automation of accounting\\src\\ReportFiles\\";
    private ArrayList<YearReport> listOfYearReports = new ArrayList<YearReport>();
    private ArrayList<MonthReport> listOfMonthReports = new ArrayList<MonthReport>();

    private String readFileContentsOrNull(String path){
        try{
            return Files.readString(Path.of(path));
        }catch(IOException e){
            System.out.println("Не удалось считать файлб может быть он поврежден");
            return null;
        }
    }
    public void readMonthReports() {

        for (int i = 1; i <= 3; i++) {
            String name = reppath + "m.20210" + i + ".csv";
            MonthReport report = new MonthReport(name);
            String inf = readFileContentsOrNull(name);
            String[] masOfItems = inf.split(";");
            for(int j = 1; j < masOfItems.length; j++ ){
                report.setItem(MonthItem.StringToMonthItem(masOfItems[j]));
            }
            listOfMonthReports.add(report);

        }
    }
    public void readYearReports(){
        String name = reppath + "y.2021.csv";
        YearReport report = new YearReport(name);
        String inf = readFileContentsOrNull(name);
        String[] masOfItems = inf.split(";");
        for(int j = 1; j < masOfItems.length; j++ ){
            report.setItem(YearItem.StringToYearItem(masOfItems[j]));
        }
        listOfYearReports.add(report);
    }

    public boolean compareReports(int month){

       int sumIncome = 0;
       int sumExpenses = 0;
       boolean res = false;
       MonthReport chekingMonthReport = listOfMonthReports.get(month - 1);
       ArrayList<MonthItem> chekingMonth = chekingMonthReport.getReports();
       for(int i = 0; i < chekingMonth.size(); i++){
           MonthItem chekingMonthItem = chekingMonth.get(i);
           if(chekingMonthItem.getIs_expense()){
               sumExpenses += chekingMonthItem.getQuantity() * chekingMonthItem.getSum_of_one();
           }else {
               sumIncome += chekingMonthItem.getQuantity() * chekingMonthItem.getSum_of_one();
           }
       }
        System.out.println(sumExpenses);
        System.out.println(sumIncome);
       YearReport chekingYearReport = listOfYearReports.get(0);
       ArrayList<YearItem> ChekingItemsByMonth = chekingYearReport.getItemsByMonth(month);
       for(YearItem item: ChekingItemsByMonth){
          if(item.getIs_expense()){
              if(sumExpenses == item.getAmount()) res = true;
              else {
                  System.out.println("Несовпадение в" + month + " месяце");
                  return false;
              }
          }else if(sumIncome == item.getAmount()){
                    res = true;
                } else {
                    System.out.println("Несовпадение в" + month + " месяце");
                    return false;
                }
          }
       return res;

    }

    public void monthReportsInfo(){
        for (MonthReport item: listOfMonthReports){
            item.info();
            System.out.println("---------------------------------");
        }
    }
    public void yearReportsInfo(){
        listOfYearReports.get(0).info();
    }
}

