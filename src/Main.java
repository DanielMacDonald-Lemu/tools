
public class Main {
    static  int number;

    public static void main(String[] args) {

        //This is new
        System.out.println("\n");
        System.out.println("\n");
        number = 2;
        create_ProductList();
        create_StockListConfiguration();
        create_ProductListEntry();
        create_StockListEntryConfiguration();
        create_StockListEntryPriceInformation();
    }

    static void create_ProductList(){
        System.out.println(
                "INSERT_UPDATE ProductList; code[unique = true] ; user(uid)[unique = true]; name; lmUserGroup(uid); sharedPermission(code)[default = READ_SHARED]; sharedWithUsers(uid); listType(code); stockListConfiguration(&stockListConfigId)\n" +
                        "; stocklist ; 10fd56807a8b4f14ba29ba52566686a1 ; Bob's stock list ;;;; STOCK_LIST ; slc-1");
        System.out.println("\n");
    }
    static void create_StockListConfiguration(){
        System.out.println(
                "INSERT_UPDATE StockListConfiguration; b2bUnit(uid)[unique = true]; address ; comment; active; totalAmount; lastUpdate[dateformat = dd.MM.yyyy HH:mm:ss]; productList(code)[unique = true]; &stockListConfigId \n" +
                        " ; 0000200001 ; address Test ; comment test ; true ; 1995.2 ; 03.06.2010 10:00:00 ; stocklist ; slc-1");
        System.out.println("\n");
    }

    static void create_ProductListEntry(){
        System.out.println(
                "INSERT_UPDATE ProductListEntry; list(code)[unique = true] ;product(code)[unique = true] ;quantity; customSortIndex; &listEntry; stockListEntryConfiguration(&stockListEntryConfigId); stockListEntryPriceInformation(&priceInfoId)");
        for (int i = 1; i <= number; i++) {
            System.out.println( ";stocklist ;exporttest" + i +";3 ;2; ple-" + i +";slec-" + i + "; price-" + i);
        }
        System.out.println("\n");
    }

    static void create_StockListEntryConfiguration(){
        System.out.println(
                "INSERT_UPDATE StockListEntryConfiguration; minimum; maximum; location        ; productListEntry(&listEntry)[unique = true]; &stockListEntryConfigId");
        for (int i = 1; i <= number; i++) {
            System.out.println(";10 ;999 ;test location ;ple-" + i +"; slec-" + i);
        }
        System.out.println("\n");
    }

    static void create_StockListEntryPriceInformation(){
        System.out.println(
                "INSERT_UPDATE StockListEntryPriceInformation; totalAmount; amountPerUnit; productListEntry(&listEntry)[unique = true]; &priceInfoId");

        for (int i = 1; i <= number; i++) {
            System.out.println(";30 ; 10 ;ple-" + i + " ;price-" + i);
        }
        System.out.println("\n");
    }
}