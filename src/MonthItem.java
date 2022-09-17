public class MonthItem {
    private String item_name;
    private boolean is_expense;
    private int quantity;
    private int sum_of_one;

    MonthItem(String item_name, boolean is_expense, int quantity, int sum_of_one){
        this.item_name = item_name;
        this.is_expense = is_expense;
        this.quantity = quantity;
        this.sum_of_one = sum_of_one;
    }

    public static MonthItem StringToMonthItem(String str){
        String[] item =  str.split(",");
        return new MonthItem(item[0], Boolean.parseBoolean(item[1]), Integer.parseInt(item[2]), Integer.parseInt(item[3]) );
    }
    public boolean getIs_expense(){
        return is_expense;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSum_of_one() {
        return sum_of_one;
    }

    public String getItem_name() {
        return item_name;
    }
}
