import java.util.*;
import javax.swing.*;
public class Amazon  {
    static ArrayList<ArrayList<String>> user = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> bill = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> user_his = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> product = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> merch = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> appr = new ArrayList<ArrayList<String>>();
    static Scanner sc = new Scanner(System.in);
    static String m_name="",u_name="";
    static String Name = "Dharani";
    static String Pass = "123456";
    static int amnt=0;public static void main(String[] args)
    {
        display();
    }
    public static void display()
    {
        System.out.print("\033[H\033[2J");
        System.out.println("\n * Welcome to Amazon Shopping *");
        System.out.println("\n 1. Admin Login ");
        System.out.println("\n 2. Merchant Login ");
        System.out.println("\n 3. User Login ");
        int ch = sc.nextInt();
        switch(ch)
        {
            case 1:
            {
                Admin();
                break;
            }
            case 2:
            {
                Merchant_Login();
                break;
            }
            case 3:
            {
                User_Login();
                break;
            }
            default:
            {
                System.out.println("\n Enter the Valid Option...");
            }

        }
    }
    private static void Admin() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n Welcome to ADMIN LOGIN");
        System.out.println("\n\n Enter your Name : ");
        String a_name = sc.next();
        System.out.println(" Enter the Password : ");
        String a_pass = sc.next();
        if(a_name.equals(Name) && a_pass.equals(Pass))
        {
        Admin_Login();
        }
    }
    public static void Admin_Login()
    {
        System.out.print("\033[H\033[2J");
        System.out.println("\n 1. Approve Merchant ");
        System.out.println("\n 2. Remove Merchant ");
        System.out.println("\n 3. View All Products ");
        System.out.println("\n 4. Back");
        int c = sc.nextInt();
        switch(c)
        {
            case 1:
            {
                approve();
                break;
            }
            case 2:
            {
                remove();
                break;
            }
            case 3:
            {
                if(product.size()!=0){
                all_prod();}
                else{
                    System.out.println("\n List is Empty");
                    System.out.println("\n 1. Back");
                int tt = sc.nextInt();
                if(tt==1)
                {
                    display();
                }
                }
                break;
            }
            case 4:
            {
                display();;
                break;
            }
        }
    }
    private static void all_prod() {
        try{
        JFrame f = new JFrame();
        int n = product.size();
        int m = product.get(0).size();
        String[][] data = new String[n][m] ;
        for(int i=0;i<product.size();i++)
        {
            for(int j=0;j<product.get(i).size();j++)
            {
                data[i][j] = product.get(i).get(j);
            }
        }
        String[] column = {"Name","Merchant","Price","Quantity"};
        JTable j  = new JTable(data,column);
        j.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(j);
        f.add(sp);
        f.setSize(500, 200);
        f.setTitle("Available Products");
        f.setVisible(true);
        System.out.print("\033[H\033[2J");
        System.out.println("\n 1. Back");
        int o =sc.nextInt();
        if(o==1)
        {
            Admin_Login();
        }
    }
    catch(Exception e)
    {
        System.out.print("\033[H\033[2J");
        System.out.println("\n 1. Back");
        int o =sc.nextInt();
        if(o==1)
        {
            Admin_Login();
        }
    }
    }
    private static void remove() {
        System.out.print("\033[H\033[2J");
        for(int i=0;i<appr.size();i++)
        {
            System.out.println("\n Do you want to Remove " + appr.get(i).get(0) + " (y/n) ");
            String ans = sc.next();
            if(ans.equals("y"))
            {
                appr.get(i).remove(i);
            }
        }
        System.out.print("\033[H\033[2J");
        System.out.println("List is Empty");
        System.out.println("\n 1. Back");
                int tt = sc.nextInt();
                if(tt==1)
                {
                    display();
                }
    }
    private static void approve() {
        System.out.print("\033[H\033[2J");
        for(int i=0;i<merch.size();i++)
        {
            ArrayList<String> tem = new ArrayList<String>();
            System.out.println("\n Do you want to Approve " + merch.get(i).get(0) + " as a Merchant (y/n) ");
            String s = sc.next();
            String y = "y";
            if(s.equals(y))
            {
                System.out.println("\n SuccessFully Approved...");
                tem.add(merch.get(i).get(0));
                tem.add(merch.get(i).get(1));
                appr.add(tem);
            }
        }
        System.out.print("\033[H\033[2J");
        merch = new ArrayList<ArrayList<String>>();
        System.out.println("\n List is EMPTY...");
        System.out.println("\n 1. Back");
                int tt = sc.nextInt();
                if(tt==1)
                {
                    display();
                }
    }
    public static void Merchant_Login()
    {
        System.out.print("\033[H\033[2J");
        System.out.println("\n 1. New Merchant (Registration) ");
        System.out.println("\n 2. Merchant Login ");
        System.out.println("\n 3. Back");
        int ch = sc.nextInt();
        switch(ch)
        {
            case 1:
            {
                merchant_reg();
                break;
            }
            case 2:
            {
                merchant_login();
                break;
            }
            case 3:
            {
                display();
                break;
            }
        }
        
    }
    private static void merchant_login() 
    {
        System.out.print("\033[H\033[2J");
        try{
        System.out.println("Sign In to Proceed..");
        System.out.println("\n Enter your UserName : ");
        String name = sc.next();
        System.out.println("\n Enter your Password : ");
        String pass = sc.next();
        boolean op = false;
        for(int i=0;i<appr.size();i++)
        {
                String ch1 = appr.get(i).get(0);
                String ch2 = appr.get(i).get(1);
                if(ch1.equals(name) && ch2.equals(pass))
                    {
                        op=true;
                        m_name=name;
                        break;
                    }
        }
        
        if(op==true)
                    {
                        view_merch();
                        
                    }else{
                    System.out.println("\n Invalid Password..");
                    System.out.println("\n 1. Login Again");
                    System.out.println("\n 2. Back ");
                    int uu = sc.nextInt();
                    if(uu==1)
                    {
                        merchant_login();
                    }
                    if(uu==2)
                    {
                        Merchant_Login();
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("\n Invalid Password..");
                System.out.println("\n 1. Login Again");
                System.out.println("\n 2. Back ");
                int uu = sc.nextInt();
                if(uu==1)
                {
                    merchant_login();
                }
                if(uu==2)
                {
                    Merchant_Login();
                }
            }
        
    }
    private static void view_merch() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n 1. Add Products");
        System.out.println("\n 2. View Frequent Customer");
        System.out.println("\n 3. View Most Sold Product");
        System.out.println("\n 4. View Sale History ");
        System.out.println("\n 5. Back");
        int c = sc.nextInt();
        switch(c)
        {
            case 1:
            {
                add_product();
                break;
            }
            case 2:
            {
                freq_cust();
                break;
            }
            case 3:
            {
                most_sold();
                break;
            }
            case 4:
            {
                merch_history();
                break;
            }
            case 5:
            {
                Merchant_Login();
                break;
            }
        }
    }
    private static void merch_history() {
    }
    private static void most_sold() {
    }
    private static void freq_cust() {
    }
    private static void add_product() {
        System.out.print("\033[H\033[2J");
        System.out.println("Enter the No. of Products You gonna add...");
        int n = sc.nextInt();
        for(int i=0;i<n;i++)
        {
            ArrayList<String> list = new ArrayList<String>();
            System.out.println("\n Enter the Product Name ");
            String pname = sc.next();
            pname+=sc.nextLine();
            String mname = m_name;
            System.out.println("\n Enter the " + pname + " Price ");
            String pcost = sc.nextLine();
            System.out.println("\n Enter the Quatity ");
            String pquan = sc.nextLine();
            list.add(pname);
            list.add(mname);
            list.add(pcost);
            list.add(pquan);
            product.add(list);
        }
        view_merch();
        
    }
    private static void merchant_reg() 
    {
        System.out.print("\033[H\033[2J");
        System.out.println("Register Here...");
        System.out.println("\n How many Merchant you Gonna add..");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
                    ArrayList<String> tem = new ArrayList<String>();
                    System.out.println("\nEnter your UserName : ");
                    String name = sc.next();
                    System.out.println("\n Enter your Password : ");
                    String pass = sc.next();
                    System.out.println("\n Enter Confirm Password : ");
                    String c_pass = sc.next();
                    if(pass.equals(c_pass))
                    {
                        System.out.println("\n Your Account has Successfully Registered...");
                        System.out.println(" Wait for Approval...");
                        tem.add(name);
                        tem.add(pass);
                        merch.add(tem);
                        
                    }
                    else
                    {
                        System.out.println("\n Password Mismatch...!");
                        System.out.println("\n\n 1. Register Again...");
                        int jj = sc.nextInt();
                        if(jj==1)
                        {
                            merchant_reg();
                        }
                    }
                }
                Merchant_Login();
    }
    public static void User_Login()
    {
        System.out.print("\033[H\033[2J");
        System.out.println("\n 1. New User ");
        System.out.println("\n 2. Login ");
        int ch = sc.nextInt();
        switch(ch)
        {
            case 1:
            {
                new_user();
                break;
            }
            case 2:
            {
                login();
                break;
            }
            default:
            {
                User_Login();
            }

        }
    }
    public static void new_user()
    {
                    System.out.print("\033[H\033[2J");
                    ArrayList<String> tem = new ArrayList<String>();
                    System.out.println("Register Here...");
                    System.out.println("Enter your UserName : ");
                    String name = sc.next();
                    System.out.println("\n Enter your Password : ");
                    String pass = sc.next();
                    System.out.println("\n Enter Confirm Password : ");
                    String c_pass = sc.next();
                    if(pass.equals(c_pass))
                    {
                        System.out.println("\n Your Account has Successfully Registered...");
                        tem.add(name);
                        tem.add(pass);
                        user.add(tem);
                        User_Login();
                    }
                    else
                    {
                        System.out.println("\n Password Mismatch...!");
                        System.out.println("\n\n 1. Register Again...");
                        int jj = sc.nextInt();
                        if(jj==1)
                        {
                            new_user();
                        }
                    }
    }
    public static void login()
    {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Sign In to Proceed..");
                    System.out.println("\n Enter your UserName : ");
                    String name = sc.next();
                    System.out.println("\n Enter your Password : ");
                    String pass = sc.next();
                    for(int i=0;i<user.size();i++)
                    {
                            String ch1 = user.get(i).get(0);
                            String ch2 = user.get(i).get(1);
                            if(ch1.equals(name) && ch2.equals(pass))
                                {
                                    u_name = name;
                                    view();
                                    break;
                                }
                            else
                            {
                                System.out.println("\n Invalid Password..");
                                System.out.println("\n 1. Login Again");
                                System.out.println("\n 2. Back");
                                int uu = sc.nextInt();
                                if(uu==1)
                                {
                                    login();
                                }
                                else if(uu==2)
                                {
                                    User_Login();
                                }
                            }
                    }
    }
    public static void view()
    {
        System.out.print("\033[H\033[2J");
        System.out.println("\n 1. View Products ");
        System.out.println("\n 2. Compare Prices with Different Merchants");
        System.out.println("\n 3. Add to Cart");
        System.out.println("\n 4. Checkout");
        System.out.println("\n 5. Purchase History");
        System.out.println("\n 6. Back");
        int ch = sc.nextInt();
        switch(ch)
        {
            case 1:
            {
                view_products();
                break;
            }
            case 2:
            {
                compare();
                break;
            }
            case 3:
            {
                add_card();
                break;
            }
            case 4:
            {
                checkout();
                break;
            }
            case 5:
            {
                history();
                break;
            }
            case 6:
            {
                User_Login();
            }

        }
    }
    private static void history() 
    {
        try{
            JFrame f = new JFrame();
            int n = user_his.size();
            int m = user_his.get(0).size();
            String[][] data = new String[n][m] ;
            for(int i=0;i<user_his.size();i++)
            {
                for(int j=0;j<user_his.get(i).size();j++)
                {
                    data[i][j] = user_his.get(i).get(j);
                }
            }
            String[] column = {"User Name","Item","Merchant Name","Quantity","Price"};
            JTable j  = new JTable(data,column);
            j.setBounds(30, 40, 200, 300);
            JScrollPane sp = new JScrollPane(j);
            f.add(sp);
            f.setSize(500, 200);
            f.setTitle(u_name + "'s Purchase History");
            f.setVisible(true);
        }
        catch(Exception e)
        {
            System.out.print("\033[H\033[2J");
            System.out.println("\n\n 1. Back");
            int o =sc.nextInt();
            if(o==1)
            {
               view();
            }
        }
    }
    public static void view_products()
    {
        try{
            JFrame f = new JFrame();
            int n = product.size();
            int m = product.get(0).size();
            String[][] data = new String[n][m] ;
            for(int i=0;i<product.size();i++)
            {
                for(int j=0;j<product.get(i).size();j++)
                {
                    data[i][j] = product.get(i).get(j);
                }
            }
            String[] column = {"Name","Merchant","Price","Quantity"};
            JTable j  = new JTable(data,column);
            j.setBounds(30, 40, 200, 300);
            JScrollPane sp = new JScrollPane(j);
            f.add(sp);
            f.setSize(500, 200);
            f.setTitle("Available Products");
            f.setVisible(true);
            System.out.print("\033[H\033[2J");
            System.out.println("\n 1. Back");
            int o =sc.nextInt();
            if(o==1)
            {
                view();
            }
        }
        catch(Exception e)
        {
            System.out.print("\033[H\033[2J");
            System.out.println("\n 1. Back");
            int o =sc.nextInt();
            if(o==1)
            {
               view();
            }
        }
        
    }
    public static void compare()
    {
        System.out.print("\033[H\033[2J");
        int min=0,count=1;
        String n ="";
        System.out.println("Enter the Item Name to Compare ");
        String it_name = sc.next();
        it_name+=sc.nextLine();
        for(int i=0;i<product.size();i++)
        {
            if(product.get(i).get(0).equals(it_name))
            {
                System.out.println("\n Merchant Name = " + product.get(i).get(1) + " ---- Price = " + product.get(i).get(2));
                if(count==1)
                {
                min = Integer.parseInt(product.get(i).get(2));
                n = product.get(i).get(1);
                count++;
                }
                if(Integer.parseInt(product.get(i).get(2))<min)
                {
                    min = Integer.parseInt(product.get(i).get(2));
                    n = product.get(i).get(1);
                }
            }
        }
        System.out.println("\n\n  When Compare to Others Merchant --" + n + "-- Selling " + it_name + " At Low cost..");
        }
    public static void add_card()
    {
        System.out.print("\033[H\033[2J");
        ArrayList<String> bill1 = new ArrayList<String>();
        System.out.println("\n How many Items you wish to Purchase..?");
        int n = sc.nextInt();
        int tot=0;
        for(int e=0;e<n;e++){
        System.out.println("\n Enter the ITEM Name : ");
        String it_name = sc.next();
        System.out.println("\n Enter the MERCHANT Name : ");
        String it_merch = sc.next();
        System.out.println("\n Enter the Quantity ");
        int q = sc.nextInt();
        int cost = 0;
        for(int i=0;i<product.size();i++)
        {
            if(product.get(i).get(0).equals(it_name))
            {
                if( Integer.parseInt(product.get(i).get(3))>=q)
                {
                    if(product.get(i).get(1).equals(it_merch))
                    {
                        ArrayList<String> amnt = new ArrayList<String>();
                        int p = Integer.parseInt(product.get(i).get(3))-q;
                        String j = Integer.toString(p);
                        product.get(i).add(3, j);
                        cost = cost + (Integer.parseInt(product.get(i).get(2)) * q);
                        tot = tot + cost;
                        amnt.add(u_name);
                        amnt.add(it_name);
                        amnt.add(it_merch);
                        amnt.add(Integer.toString(q));
                        amnt.add(Integer.toString(cost));
                        bill.add(amnt);
                        user_his.add(amnt);
                    }
                }
            }
        }cost = 0;
    }
        bill1.add("---");
        bill1.add("---");
        bill1.add("---");
        bill1.add("Total");
        bill1.add(Integer.toString(tot));
        bill.add(bill1);
        amnt = tot;
        System.out.print("\033[H\033[2J");
        System.out.println("\n 1. Back");
        int o =sc.nextInt();
        if(o==1)
        {
           view();
        }
    }
    public static void checkout()
    {
        try{
            JFrame f = new JFrame();
            int n = bill.size();
            int m = bill.get(0).size();
            String[][] data = new String[n][m] ;
            for(int i=0;i<bill.size();i++)
            {
                for(int j=0;j<bill.get(i).size();j++)
                {
                    data[i][j] = bill.get(i).get(j);
                }
            }
            String[] column = {"User Name","Item","Merchant Name","Quantity","Price"};
            JTable j  = new JTable(data,column);
            j.setBounds(30, 40, 200, 300);
            JScrollPane sp = new JScrollPane(j);
            f.add(sp);
            f.setSize(500, 200);
            f.setTitle(u_name + "'s Bill");
            f.setVisible(true);
            pay();
            
        }
        catch(Exception e)
        {
            System.out.print("\033[H\033[2J");
            System.out.println("\n\n 1. Back");
            int o =sc.nextInt();
            if(o==1)
            {
               view();
            }
        }
    }
    public static void pay()
    {
        System.out.print("\033[H\033[2J");
            System.out.println("Now your BILL is Visible...");
            System.out.println("\n Total Amount : " + amnt);
            System.out.println("\n Enter the Amount You are Paying..");
            int p = sc.nextInt();
            if(p==amnt)
            {
                System.out.println("\n ThankYou...Visit Again..");
                System.out.println("\n\n 1. Back");
                int o =sc.nextInt();
                if(o==1)
            {
                view();
            }
            }
            else if(p>amnt)
            {
                System.out.println("\n Collect Your Change Rs." + (p-amnt));
                System.out.println("\n ThankYou...Visit Again..");
                System.out.println("\n\n 1. Back");
                int o =sc.nextInt();
                if(o==1)
            {
                view();
            }
            }
            else{
                System.out.println("\n Paid Amount is less than Total Amount..");
                System.out.println("\n 1. Pay");
                if(sc.nextInt()==1)
                {
                    pay();
                }
            }
    }
    
}
