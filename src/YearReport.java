import java.util.ArrayList;

public class YearReport extends Report{
    private ArrayList<YearItem> reports = new ArrayList<YearItem>();

    YearReport(String name) {
        super(name);
    }

    public void setItem(YearItem item) {
        reports.add(item);
    }

    public ArrayList<YearItem> getItemsByMonth(int month){
        ArrayList<YearItem> ItemsByMonth = new ArrayList<YearItem>();
        for(YearItem report: reports){
            String temp = report.getMonth();
            System.out.println(temp.equals("\n0" + month));
            if(temp.equals("\n0" + month)){
                ItemsByMonth.add(report);
            }
        }
        System.out.println(ItemsByMonth);
        return ItemsByMonth;
    }

    public void info() {
        for(YearItem item : reports){
            System.out.println("Месяц: " + item.getMonth());
            System.out.println("Сумма: " + item.getAmount());
            System.out.println("Тип: " + (item.getIs_expense() ? "траты" : "прибыль"));
            System.out.println("*******************");

        }
    }
}
