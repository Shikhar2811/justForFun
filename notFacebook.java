import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.regex.Pattern;

public class notFacebook extends Applet implements ActionListener
{
    Button b1,b2;
    TextField t1,t2,t3,t4,t5,t6;
    Choice c1,c2,c3;
    Checkbox cb1,cb2,cb3;
    CheckboxGroup cbg;
    Label l1,l2,l3,l4,l5,l6;
    @Override
    public void init()
    {  
        Color headColor = Color.cyan.darker();
        Color textColor = Color.RED.brighter();
        Color bodyColor = Color.cyan.brighter();
        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        t1 = new TextField();
        t1.setBounds(500,35,150,20);
        t2 = new TextField();
        t2.setEchoChar('*');
        t2.setBounds(660,35,150,20);
        b1 = new Button("Login.");
        b1.setBounds(830,35,40,20);
        b1.addActionListener(this);
        l1 = new Label();
        l1.setBounds(880,35,110,20);
        l1.setBackground(headColor);
        l1.setForeground(textColor);
        t3 = new TextField();
        t3.setBounds(415,140,190,20);
        t4 = new TextField();
        t4.setBounds(625,140,190,20);
        l2 = new Label();
        l2.setBounds(825,140,150,20);
        l2.setBackground(bodyColor);
        l2.setForeground(textColor);
        t5 = new TextField();
        t5.setBounds(415,210,400,20);
        l3 = new Label();
        l3.setBounds(825,210,150,20);
        l3.setBackground(bodyColor);
        l3.setForeground(textColor);
        t6 = new TextField();
        t6.setBounds(415,280,190,20);
        l4 = new Label();
        l4.setBounds(825,280,150,20);
        l4.setBackground(bodyColor);
        l4.setForeground(textColor);
        c1 = new Choice();
        c1.setBounds(415,350,60,20);
        c1.add("Day");
        for(int i=1;i<32;i++)
        {
            c1.add(Integer.toString(i));
        }
        c2 = new Choice();
        c2.setBounds(478,350,60,20);
        c2.add("Month");
        for(String str: months)
        {
            c2.add(str);
        }
        c3 = new Choice();
        c3.setBounds(541,350,60,20);
        c3.add("Year");
        for(int i=1985;i<2004;i++)
        {
            c3.add(Integer.toString(i));
        }
        l5 = new Label();
        l5.setBounds(825,350,150,20);
        l5.setBackground(bodyColor);
        l5.setForeground(textColor);
        cbg = new CheckboxGroup();
        cb1 = new Checkbox("Male",cbg,false);
        cb1.setBounds(415,420,80,20);
        cb2 = new Checkbox("Female",cbg,false);
        cb2.setBounds(500,420,80,20);
        cb3 = new Checkbox("Others",cbg,false);
        cb3.setBounds(585,420,80,20);
        l6 = new Label();
        l6.setBounds(825,420,150,20);
        l6.setBackground(bodyColor);
        l6.setForeground(textColor);
        b2 = new Button("Sign Up");
        b2.setBounds(450,490,70,30);
        b2.addActionListener(this);
        add(t1);
        add(t2);
        add(b1);
        add(l1);
        add(t3);
        add(t4);
        add(l2);
        add(t5);
        add(l3);
        add(t6);
        add(l4);
        add(c1);
        add(c2);
        add(c3);
        add(l5);
        add(cb1);
        add(cb2);
        add(cb3);
        add(l6);
        add(b2);
        setSize(1000,600);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
        {
            l1.setText(null);
            String eMail,passWord;
            eMail = t1.getText();
            passWord = t2.getText();
            int err = 0;
            if("".equals(eMail) || "".equals(passWord))
            {
                l1.setText("Empty Field");
                err = 1;
            }
            
            if(err==0)
            {
                System.out.println("Login Successful");
            }
            
        }else if(e.getSource() == b2)
        {
            l2.setText(null);
            l3.setText(null);
            l4.setText(null);
            l5.setText(null);
            l6.setText(null);
            
            String firstName,lastName,eMail,passWord;
            String day,month,year;
            firstName = t3.getText();
            lastName = t4.getText();
            eMail = t5.getText();
            passWord = t6.getText();
            day = c1.getSelectedItem();
            month = c2.getSelectedItem();
            year = c3.getSelectedItem();
            
            int err = 0;
            
            boolean valFirstName,valLastName,valEmail,valPass;
            valFirstName = Pattern.matches("(\\p{Alpha}){1,20}", firstName);
            valLastName = Pattern.matches("(\\p{Alpha}){0,20}",lastName);
            valEmail = Pattern.matches("((\\p{Alnum}{3,20})||(((\\p{Alnum}+)\\.(\\p{Alnum}+))*)||(((\\p{Alnum}+)\\_(\\p{Alnum}+))*)||(((\\p{Alnum}+)\\-(\\p{Alnum}+))*))\\@([a-z]{3,10})\\.(([a-z]{3})||([a-z]{2}\\.[a-z]{2,3}))",eMail);
            valPass = Pattern.matches("([a-z]||[A-Z]||[0-9]||[~!@#$%^&*_.,:;-]){6,15}",passWord);            
            
            if ( "".equals(firstName) || valFirstName==false || valLastName==false) {
                if("".equals(firstName))
                {
                    l2.setText("Empty Name");
                }else if(valFirstName==false){
                    l2.setText("Invalid First Name");
                }else if(valLastName==false){
                    l2.setText("Invalid Last Name");
                }   
                err = 1;
            } 
            if ("".equals(eMail) || valEmail==false) {
                if("".equals(eMail))
                {
                    l3.setText("Empty Email");
                }else if(valEmail==false)
                {
                    l3.setText("Invalid Email");
                }
                err = 1;
            } 
            if ("".equals(passWord) || valPass==false) {
                if("".equals(passWord))
                {
                    l4.setText("Empty Password");
                }else if(valPass==false){
                    l4.setText("Invalid Password");
                }
                err = 1;
            } 
            if ("Day".equals(day) || "Month".equals(month) || "Year".equals(year)) {
                l5.setText("Invalid Date ");
                err = 1;
            } 
            if (cbg.getSelectedCheckbox() == null) {
                l6.setText("Select a Gender");
                err = 1;
            }
                
            if(err==0)
            {
                System.out.println("SignUp Complete");
            }
        }
    }
    
    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.cyan.darker());
        g.fillRect(0, 0, 1000, 70);  
        g.setColor(Color.cyan.brighter());
        g.fillRect(400,70,600,530);
        Font currentFont = g.getFont();
        g.setColor(Color.WHITE);
        g.setFont(new Font("Ariel",Font.BOLD,40));
        g.drawString("notFacebook",20,50);
        g.setFont(currentFont);
        g.setColor(Color.black);
        g.drawString("Email: ",500,30);
        g.drawString("Password: ",660,30);
        g.setFont(new Font("Ariel",Font.BOLD,30));
        g.drawString("Create an Account.",410,100);
        g.setFont(currentFont);
        g.drawString("First Name",415,133);
        g.drawString("Last Name",625,133);
        g.drawString("Email",415,203);
        g.drawString("Password",415,273);
        g.drawString("DOB (dd/mm/yy)",415,343);
        g.drawString("Gender",415,413);
        g.setColor(Color.darkGray);
        g.fillRoundRect(60, 90, 270, 490, 30, 30);
        g.setColor(Color.WHITE);
        g.fillRect(70,140,250,390);
        g.drawOval(175,535,40,40);
        g.setFont(new Font("Ariel",Font.BOLD,37));
        g.setColor(Color.cyan.darker());
        g.drawString("notFacebook",78,300);
    }
}
