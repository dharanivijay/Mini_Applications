package NewPro;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.*;
import javax.swing.*;
public class Library {
    static SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
    static String Admin = "Dharani";
    static String Pass = "123456";
    static String ad_name="",br_name="";
    static ArrayList<String> isbn = new ArrayList<String>();
    static ArrayList<ArrayList<String>> bor = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> cost = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> bal = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> adm = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> his = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> cart = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> books = new ArrayList<ArrayList<String>>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        signin();
    }

    private static void signin() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n Welcome to LIBRARY...");
        System.out.println("\n SignIn to Proceed ");
        System.out.println("\n Enter the USERNAME : ");
        String name = sc.next();
        name+=sc.nextLine();
        System.out.println("\n Enter the PASSWORD ");
        String pass = sc.next();
        pass+=sc.nextLine();
        boolean ch1 = false,ch2=false;
        for(int i=0;i<adm.size();i++)
        {
                if(name.equals(adm.get(i).get(0)) && pass.equals(adm.get(i).get(1)))
                {
                    ad_name=name;
                    ch1=true;
                    break;
                }
        }
        for(int i=0;i<bor.size();i++)
        {
                if(name.equals(bor.get(i).get(0)) && pass.equals(bor.get(i).get(1)))
                {
                    br_name=name;
                    ch2=true;
                    break;
                }
        }
        if(name.equals(Admin) && pass.equals(Pass))
        {
            ad_name=name;
            admin_display();
        }
        else if(ch1==true)
        {
            ch1=false;
            admin_display();
        }
        else if(ch2==true)
        {
            ch2=false;
            cart_clean();
        }
        else
        {
            System.out.println("\n Incorrect Password...");
            System.out.println("\n 1. Login Again..");
            if(sc.nextInt()==1)
            {
                signin();
            }
        }
    }
    private static void cart_clean() {
        cart = new ArrayList<ArrayList<String>>();
        bor_display();
    }

    private static void admin_display() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n Welcome to Admin Panel " + ad_name);
        System.out.println("\n 1. Add a Book");
        System.out.println("\n 2. Modify Book Details");
        System.out.println("\n 3. Delete a Book");
        System.out.println("\n 4. Search a Book");
        System.out.println("\n 5. View Books");
        System.out.println("\n 6. Add ADMINS");
        System.out.println("\n 7. Add BORROWERS");
        System.out.println("\n 8. Back");
        switch(sc.nextInt())
        {
            case 1:
            {
                add();
                break;
            }
            case 2:
            {
                modify();
                break;
            }
            case 3:
            {
                delete();
                break;
            }
            case 4:
            {
                search();
                break;
            }
            case 5:
            {
                view();
                break;
            }
            case 6:
            {
               add_admin();;
                break;
            }
            case 7:
            {
                add_borrowers();;
                break;
            }
            case 8:
            {
                signin();
                break;
            }
            default:
            {
                System.out.println("\n Enter the valid Option...");
                break;
            }
        }
    }
    
    private static void search() {
        System.out.print("\033[H\033[2J");
        boolean op = false;
        System.out.println("\n Enter the Option to Search..");
        System.out.println("\n 1. By Name");
        System.out.println("\n 2. By ISBN");
        int jp= sc.nextInt();
        if(jp==1){
            System.out.println("\n Enter the Book Name");
            String name = sc.next();
            name+=sc.nextLine(); 
            for(int i=0;i<books.size();i++)
            {
                if(books.get(i).get(0).equals(name))
                {
                op=true;
                System.out.println("\n ISBN      = " + books.get(i).get(1));
                System.out.println("\n Quantity  = " + books.get(i).get(2));
                break;
                }
            }
        }
        else if(jp==2)
        {
            System.out.println("\n Enter the ISBN ");
            String isbn = sc.next();
            for(int i=0;i<books.size();i++)
            {
                if(books.get(i).get(1).equals(isbn))
                {
                    op=true;
                    System.out.println("\n Book Name = " + books.get(i).get(0));
                    System.out.println("\n Quantity  = " + books.get(i).get(2));
                    break;
                }
            }
        }
        if(op==false)
        {
            System.out.println("Book is Not Available...");
        }
        System.out.println("\n 1. Back");
        if(sc.nextInt()==1)
        {
        admin_display();
        }
    }

    private static void view() {
        try{
        JFrame f = new JFrame();
        int n = books.size();
        int m = books.get(0).size();
        String[] col = {"Book_Name","ISBN","Quantity"};
        String[][] data = new String[n][m];
        for(int i=0;i<books.size();i++)
        {
            for(int j=0;j<books.get(i).size();j++)
            {
                data[i][j] = books.get(i).get(j);
            }
        }
        JTable jt = new JTable(data,col);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(500, 200);
        f.setTitle("Available Books");
        f.setVisible(true);
        admin_display();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}

    private static void add() {
        System.out.print("\033[H\033[2J");
        ArrayList<String> tem = new ArrayList<String>();
        ArrayList<String> temc = new ArrayList<String>();
        System.out.println("\n Enter the Book Name ");
        String b_name = sc.next();
        b_name+=sc.nextLine();
        System.out.println("\n Enter the ISBN (13-DIGIT NUMBER)");
        String isbn = sc.next();
        char[] ch = isbn.toCharArray();
        System.out.println("\n Enter the Quantity");
        String quan = sc.next();
        System.out.println("\n Enter the Actual Cost of the Book...");
        String cost = sc.next();
       if(ch.length==13 && !Library.isbn.contains(isbn)){
           Library.isbn.add(isbn);
        tem.add(b_name);
        tem.add(isbn);
        tem.add(quan);
        books.add(tem);
        temc.add(isbn);
        temc.add(cost);
        Library.cost.add(temc);
        admin_display();
       }
       else{
           System.out.println("\n Enter the 13-DIGIT ISBN Number Correctly..");
           System.out.println("\n 1. Add Again");
           int u = sc.nextInt();
           if(u==1)
           {
               add();
           }
       }
    }

    private static void modify() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n Select the Modify Option");
        System.out.println("\n 1. Change Book Name");
        System.out.println("\n 2. Change ISBN ");
        System.out.println("\n 3. Change Quantity");
        System.out.println("\n 4. Back");
        int p = sc.nextInt();
        switch(p)
        {
            case 1:
            {
                System.out.print("\033[H\033[2J");
                System.out.println("\n Enter the ISBN to Change the Book Name");
                String isbn = sc.next();
                for(int i=0;i<books.size();i++)
                {
                    if(books.get(i).get(1).equals(isbn))
                    {
                        System.out.println("\n Actual Name of the book is = " + books.get(i).get(0));
                        System.out.println("\n Enter the NEW Name of the Book");
                        String b_name = sc.next();
                        b_name+=sc.nextLine();
                        books.get(i).set(0,b_name);
                        break;
                    }
                }
                modify();
                break;
            }
            case 2:
            {
                System.out.print("\033[H\033[2J");
                System.out.println("\n Enter the Book Name to Change the ISBN");
                String bn = sc.next();
                for(int i=0;i<books.size();i++)
                {
                    if(books.get(i).get(0).equals(bn))
                    {
                        System.out.println("\n Actual ISBN is = " + books.get(i).get(1));
                        System.out.println("\n Enter the NEW ISBN");
                        String isbn = sc.next();
                        books.get(i).set(1,isbn);
                        
                        break;
                    }
                }
                modify();
                break;
            }
            case 3:
            {
                System.out.print("\033[H\033[2J");
                System.out.println("\n Enter the ISBN to Change the Quantity of Book ");
                String isbn = sc.next();
                for(int i=0;i<books.size();i++)
                {
                    if(books.get(i).get(1).equals(isbn))
                    {
                        System.out.println("\n Actual Quantity of the book is = " + books.get(i).get(2));
                        System.out.println("\n Enter the NEW Quantity of the Book");
                        String qn = sc.next();
                        books.get(i).set(2,qn);
                        
                        break;
                    }
                }
                modify();
                break;
            }
            case 4:
            {
                admin_display();
            }

        }
    }

    private static void delete() {
        System.out.print("\033[H\033[2J");
        try{
        System.out.println("\n Enter the ISBN to Delete the Book");
        String isbn = sc.next();
        boolean ff = false;
        for(int i=0;i<books.size();i++)
            {
            if(books.get(i).get(1).equals(isbn))
                {
                    ff=true;
                    books.remove(i);
                    Library.isbn.remove(isbn);
                    break;
                }
            }
            if(ff==false)
            {
                System.out.println("\n Book Not Found..");
                System.out.println("\n Enter the ISBN Correctly");
                System.out.println("\n 1. Delete Again");
                System.out.println("\n 2. Back");
                int l = sc.nextInt();
                if(l==1)
                {
                    delete();
                }
                if(l==2)
                {
                    admin_display();
                }
            }else{
                admin_display();
            }
        }
        catch(Exception e)
        {
            admin_display();
        }
    }

    private static void add_admin() {
        System.out.print("\033[H\033[2J");
        try{
        ArrayList<String> tem = new ArrayList<String>();
        boolean oo = false;
        System.out.println("\n Enter the USERNAME ");
        String name = sc.next();
        name+=sc.nextLine();
        System.out.println("\n Enter the PASSWORD");
        String pass = sc.next();
        pass+=sc.nextLine();
        System.out.println("\n Repeat the PASSWORD");
        String c_pass = sc.next();
        c_pass+=sc.nextLine();
        for(int i=0;i<adm.size();i++)
        {
            if(adm.get(i).get(0).equals(name))
            {
                oo = true;
            }
        }
        if(oo==false){
        if(pass.equals(c_pass))
        {
            tem.add(name);
            tem.add(pass);
            adm.add(tem);
            admin_display();
        }
        else{
            System.out.println("\n Password Mismatch");
            System.out.println("\n 1. SignUp Again");
            System.out.println("\n 2. Back");
            if(sc.nextInt()==1)
            {
                add_admin();
            }
            if(sc.nextInt()==2)
            {
                admin_display();
            }
        }
    }else{
        System.out.println("\n Name Already Exists...");
        System.out.println("\n 1. SignUp Again");
            System.out.println("\n 2. Back");
            if(sc.nextInt()==1)
            {
                add_admin();
            }
            else
            {
                admin_display();
            }
    }
}
    catch(Exception e)
    {
        
    }
    }

    private static void add_borrowers() {
        System.out.print("\033[H\033[2J");
        ArrayList<String> tem = new ArrayList<String>();
        System.out.println("\n Enter the USERNAME ");
        String name = sc.next();
        name+=sc.nextLine();
        System.out.println("\n Enter the PASSWORD");
        String pass = sc.next();
        pass+=sc.nextLine();
        System.out.println("\n Repeat the PASSWORD");
        String c_pass = sc.next();
        c_pass+=sc.nextLine();
        if(pass.equals(c_pass))
        {
            tem.add(name);
            tem.add(pass);
            bor.add(tem);
            admin_display();
        }
        else{
            System.out.println("\n Password Mismatch");
            System.out.println("\n 1. SignUp Again");
            System.out.println("\n 2. Back");
            if(sc.nextInt()==1)
            {
                add_borrowers();
            }
            if(sc.nextInt()==2)
            {
                admin_display();
            }
        }
    }

    private static void bor_display() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n Welcome to User Panel " + br_name);
        System.out.println("\n 1. Deposit");
        System.out.println("\n 2. Check Balance");
        System.out.println("\n 3. View Books");
        System.out.println("\n 4. Borrow Book");
        System.out.println("\n 5. Checkout");
        System.out.println("\n 6. Return Book");
        System.out.println("\n 7. History");
        System.out.println("\n 8. Back");
        int cc = sc.nextInt();
        switch(cc)
        {
            case 1:
            {
                deposit();
                break;
            }
            case 2:
            {
                Check_Bal();
                break;
            }
            case 3:
            {
                view1();
                break;
            }
            case 4:
            {
                cart();
                break;
            }
            case 5:
            {
                checkout();
                break;
            }
            case 6:
            {
                Return();
                break;
            }
            case 7:
            {
                history();
                break;
            }
            case 8:
            {
                signin();
                break;
            }
            default:
            {
                System.out.println("\n Enter the Valid Option..");
            }
        }
    }

    private static void view1() {
        try{
        JFrame f = new JFrame();
        int n = books.size();
        int m = books.get(0).size();
        String[] col = {"Book_Name","ISBN","Quantity"};
        String[][] data = new String[n][m];
        for(int i=0;i<books.size();i++)
        {
            for(int j=0;j<books.get(i).size();j++)
            {
                data[i][j] = books.get(i).get(j);
            }
        }
        JTable jt = new JTable(data,col);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(500, 200);
        f.setTitle("Available Books");
        f.setVisible(true);
        bor_display();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}

    private static void deposit() {
        System.out.print("\033[H\033[2J");
        ArrayList<String> tem = new ArrayList<String>();
        System.out.println("\n Enter the Amount to Deposit (MIN.1500) ");
        int amn = sc.nextInt();
        boolean oo = false;
        if(amn>=1500){
            for(int i=0;i<bal.size();i++)
            {
            if(br_name.equals(bal.get(i).get(0)))
            {
                oo = true;
                int old = Integer.parseInt(bal.get(i).get(1));
                int up = old + amn;
                bal.get(i).set(1, Integer.toString(up));
            }
            }
            if(oo==false) {
        tem.add(br_name);
        tem.add(Integer.toString(amn));
        bal.add(tem);
            }
        System.out.println("\n Amount Has Successfully Added...");
        System.out.println("\n 1. Back");
            int h = sc.nextInt();
            if(h==1)
            {
                bor_display();;
            }
        }
        else{
            System.out.println("\n Minimum Amount to be Deposit is 1500");
            System.out.println("\n 1. Deposit Again");
            System.out.println("\n 2. Back");
            int h = sc.nextInt();
            if(h==1)
            {
                deposit();
            }
            if(h==2)
            {
                bor_display();
            }
        }
    }

    private static void Check_Bal() {
        System.out.print("\033[H\033[2J");
        boolean oo = false;
        for(int i=0;i<bal.size();i++)
        {
            if(bal.get(i).get(0).equals(br_name))
            {
                oo = true;
                System.out.println("\n Your Balance is = " + bal.get(i).get(1));
            }
        }
        if(oo==false)
        {
            System.out.println("\n Your Balance is = 0");
        }
        System.out.println("\n 1. Back");
            int h = sc.nextInt();
            if(h==1)
            {
                bor_display();;
            }
    }

    private static void cart() {
        System.out.print("\033[H\033[2J");
        ArrayList<String> tem = new ArrayList<String>();
        System.out.println("\n Enter the ISBN You wish to Borrow");
        String isbn = sc.next();
        System.out.println("\n Enter the Date in Exact Format-(dd/mm/yyyy)");
        String date = sc.next();
        boolean bk = false,qn = false,count=false;
        try{
        for(int i=0;i<books.size();i++)
        {
            if(cart.size()<3)
            {
                count=true;
            if(books.get(i).get(1).equals(isbn))
            {
                bk=true;
                String qq = books.get(i).get(2);
                if(Integer.parseInt(qq)>0)
                {
                    qn=true;
                    System.out.println("\n Do You Want to Borrow " + books.get(i).get(0) + " (y/n)");
                    if(sc.next().equals("y"))
                    {
                        int q = (Integer.parseInt(qq)-1);
                        books.get(i).set(2, Integer.toString(q));
                        tem.add(br_name);
                        tem.add(books.get(i).get(0));
                        tem.add(isbn);
                        tem.add(date);
                        his.add(tem);
                        cart.add(tem);
                    }
                }
            }
        }
        }
    }
    catch(Exception e)
    {
        
    }
        if(count==false){System.out.println("\n Limit is Reached...");}
        else if(bk==false){System.out.println("\n Book not Found...");}
        else if(qn==false){System.out.println("\n Out of Stock...");}
        System.out.println("\n 1. Back");
        if(sc.nextInt()==1)
        {
            bor_display();
        }
    }

    private static void checkout() {
        System.out.print("\033[H\033[2J");
        JFrame f = new JFrame();
        int n = cart.size();
        int m = cart.get(0).size();
        String[] col = {"Borrower Name","Book_Name","ISBN","Date"};
        String[][] data = new String[n][m];
        for(int i=0;i<cart.size();i++)
        {
            for(int j=0;j<cart.get(i).size();j++)
            {
                data[i][j] = cart.get(i).get(j);
            }
        }
        JTable jt = new JTable(data,col);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(500, 200);
        f.setTitle(br_name+"'s' Book List");
        f.setVisible(true);
        for(int i=0;i<bal.size();i++)
        {
            if(bal.get(i).get(0).equals(br_name))
            {
                int amn = Integer.parseInt(bal.get(i).get(1));
                if(amn>500)
                {
                    System.out.println("\n You can Borrow the Book");
                }
                else{
                    System.out.println("\n Your Deposit Amount is Insufficient...");
                }
            }
        }
        System.out.println("\n 1. Back");
        if(sc.nextInt()==1)
        {
            bor_display();
        }
    }

    private static void Return() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n 1. Return Book");
        System.out.println("\n 2. Lost");
        System.out.println("\n 3. Back");
        switch(sc.nextInt())
        {
            case 1:
            {
                System.out.print("\033[H\033[2J");
                System.out.println("\n Enter the ISBN You're Returning");
                String isbn = sc.next();
                System.out.println("\n Enter the Date in Exact Format-(dd/mm/yyyy)");
                String r_date = sc.next();
                String b_date="";
                for(int i=0;i<cart.size();i++)
                {
                    if(isbn.equals(cart.get(i).get(2)))
                    {
                        b_date = cart.get(i).get(3);
                    }
                } 
                try {
                    Date date1 = sd.parse(b_date);
                    Date date2 = sd.parse(r_date);
                    long diff = date2.getTime() - date1.getTime();
                     long dd = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    if(dd>15)
                    {
                        int d = (int)dd-15;
                        int fine = d*2;
                        System.out.println("\n Your Fine Amount is " + fine);
                        for(int i=0;i<bal.size();i++)
                        {
                            if(bal.get(i).get(0).equals(br_name))
                            {
                               int ba = (Integer.parseInt( bal.get(i).get(1)) - fine);
                               bal.get(i).set(1, Integer.toString(ba));
                            }
                        }
                        for(int i=0;i<books.size();i++)
                        {
                            if(books.get(i).get(1).equals(isbn))
                            {
                                int nq = (Integer.parseInt(books.get(i).get(2)) + 1);
                                books.get(i).set(2, Integer.toString(nq));
                            }
                        }
                    }
                    else{
                        System.out.println("\n ThankYou for returning the book On-Time...");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println("\n 1. Back");
                        if(sc.nextInt()==1)
                        {
                             bor_display();
                        }
            }
            case 2:
            {
                System.out.print("\033[H\033[2J");
                System.out.println("\n Enter the ISBN You Lost...");
                String isbn = sc.next();
                for(int i=0;i<cost.size();i++)
                {
                    if(cost.get(i).get(0).equals(isbn))
                    {
                        int cc = Integer.parseInt(cost.get(i).get(1));
                        int fine = cc/2;
                        System.out.println("\n Your Fine Amount is " + fine);
                        for(int p=0;p<bal.size();p++)
                        {
                            if(bal.get(p).get(0).equals(br_name))
                            {
                               int ba = (Integer.parseInt( bal.get(p).get(1)) - fine);
                               bal.get(p).set(1, Integer.toString(ba));
                            }
                        }
                    }
                }
                System.out.println("\n 1. Back");
                        if(sc.nextInt()==1)
                        {
                             bor_display();
                        }
            }
            case 3:
            {
                bor_display();
                break;
            }
        }
    }

    private static void history() {
        System.out.print("\033[H\033[2J");
        try{
        ArrayList<ArrayList<String>> tem = new ArrayList<ArrayList<String>>();
        for(int i=0;i<his.size();i++)
        {
            ArrayList<String> ss = new ArrayList<String>();
            if(br_name.equals(his.get(i).get(0)))
            {
                for(int j=0;j<his.get(i).size();j++)
                {
                    ss.add(his.get(i).get(j));
                }
            }
            tem.add(ss);
        }
        JFrame f = new JFrame();
        int n = tem.size();
        int m = tem.get(0).size();
        String[] col = {"Borrower Name","Book_Name","ISBN","Date"};
        String[][] data = new String[n][m];
        for(int i=0;i<tem.size();i++)
        {
            for(int j=0;j<tem.get(i).size();j++)
            {
                data[i][j] = tem.get(i).get(j);
            }
        }
        JTable jt = new JTable(data,col);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(500, 200);
        f.setTitle(br_name+"'s' History");
        f.setVisible(true);
        System.out.println("\n 1. Back");
        if(sc.nextInt()==1)
        {
            bor_display();
        }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}
    
}