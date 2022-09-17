import java.util.ArrayList;

public class MonthReport extends Report{
    private ArrayList<MonthItem> reports = new ArrayList<MonthItem>();

    MonthReport(String name){
        super(name);
    }

    public void setItem(MonthItem item) {
        reports.add(item);
    }

    public ArrayList<MonthItem> getReports() {
        return reports;
    }

   public void info(){
        for (MonthItem item : reports){
            System.out.println("************************");
            System.out.println("Наименование:"+ item.getItem_name());
            System.out.println("Тип: " + (item.getIs_expense() ? "трата" : "прибыль"));
            System.out.println("Количество: " + item.getQuantity());
            System.out.println("Цена за шт. :"+ item.getSum_of_one());
        }
   }


}
