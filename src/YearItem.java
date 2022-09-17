public class YearItem {
    private String month;
    private int  amount;
    private boolean is_expense;

    YearItem(String month, int amount, boolean is_expense){
        this.month = month;
        this.amount = amount;
        this.is_expense = is_expense;
    }


    public static YearItem StringToYearItem(String str){
        String[] item =  str.split(",");
        return new YearItem(item[0],Integer.parseInt(item[1]), Boolean.parseBoolean(item[2]) );
    }

    public String getMonth() {
        return month;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getIs_expense(){
        return is_expense;
    }
}
