import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

class ListNode{
    ListNode prev;
    ListNode next;
    String ques;
    String ans;
    String given="";
    String[] opt; 
    ListNode(String ques, String[] opt, String ans){
        this.ques=ques;
        this.ans=ans;
        this.opt=opt; 
        this.prev=null;
        this.next=null;
    }
}



class ProjectGUI {

    JLabel q,marks; 
    JRadioButton opt1, opt2, opt3,opt4;
    JButton start,prev, next, submit;
    JFrame main;
    JPanel qpanel;
    ButtonGroup bg;
    ListNode qpaper=createQuestions();
    ProjectGUI(){
        main=new JFrame("Quiz");
        main.setSize(1550, 1000);
        main.setVisible(true);
        main.setLayout(null);
        main.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        start=new JButton("START QUIZ");
        main.add(start);
        start.setBounds(450, 300, 500,40);
        start.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                generateqp(qpaper);
            }
        });
    }
    static ListNode createQuestions(){
        String[] questions={"Who Invented python?", "Who is tejasree", "who invented Love"}; 
        String[][] options={{"charless babbage","modi", "jagan", "none"},{ "a teacher", "a sadist", "a physco", "not a human"}, {"pavan", "lovers", "romeo", "chilika ran"}};
        String[] answers={options[0][3],options[1][1],options[2][3]};
        ListNode temp, newnode, qpaper;
        temp=new ListNode(questions[0], options[0], answers[0]);
        qpaper=temp;
        for(int i=1;i<questions.length; i++){
            newnode=new ListNode(questions[i], options[i], answers[i]);
            temp.next = newnode;
            newnode.prev=temp;
            temp=temp.next;
        }
        return qpaper;
    }
    public void generateqp(ListNode qpaper){
        qpanel=new JPanel();
        qpanel.setBounds(40, 20, 1350, 800);
        qpanel.setVisible(true);
        qpanel.setLayout(null);
        bg=new ButtonGroup();
        q=new JLabel(qpaper.ques);
        q.setBounds(250, 100, 850, 30);
        q.setFont(new Font("Times New Roman", Font.BOLD, 30));
        opt1=new JRadioButton(qpaper.opt[0]);
        opt1.setBounds(250,150,400,30);
        opt1.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        opt2=new JRadioButton(qpaper.opt[1]);
        opt2.setBounds(670,150,400,30);
        opt2.setFont(new Font("Times New Roman", Font. ITALIC, 20));
        opt3 = new JRadioButton(qpaper.opt[2]);
        opt3.setBounds (250,200,400,30); 
        opt3.setFont(new Font("Times New Roman", Font. ITALIC, 20));
        opt4=new JRadioButton(qpaper.opt[3]);
        opt4.setBounds(670, 200, 400,30);
        opt4. setFont(new Font("Times New Roman", Font. ITALIC, 20));

        prev = new JButton("Previous");
        prev.setBounds(250,300,400,30);
        prev.setFont(new Font("Times New Roman", Font. BOLD, 20));

        next = new JButton("Next");
        next.setBounds(670,300,400,30);
        next.setFont(new Font("Times New Roman", Font. BOLD, 20));

        submit = new JButton("Submit");
        submit.setBounds(670,300,400,30);
        submit.setFont(new Font("Times New Roman", Font. BOLD, 20));

        main.getContentPane().removeAll();
        main.revalidate();
        main.repaint();
        main.add(qpanel);
        bg.add(opt1);
        bg.add(opt2);
        bg.add(opt3);
        bg.add(opt4);
        qpanel.add(q);
        qpanel.add(opt1);
        qpanel.add(opt2);
        qpanel.add(opt3);
        qpanel.add(opt4);

        if(qpaper.prev==null){
            qpanel.add(next);
        }
        else if(qpaper.next==null){
            qpanel.add(prev);
            qpanel.add(submit);
        }
        else{
            qpanel.add(next);
            qpanel.add(prev);
        }
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(opt1.isSelected()){
                    qpaper.given=qpaper.opt[0];
                }
                else if(opt2.isSelected()){
                    qpaper.given=qpaper.opt[1];
                }
                else if(opt3.isSelected()){
                    qpaper.given=qpaper.opt[2];
                }
                else if(opt4.isSelected()){
                    qpaper.given=qpaper.opt[3];
                }
                generateqp(qpaper.next);
            }
        });
        prev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(opt1.isSelected()){
                    qpaper.given=qpaper.opt[0];
                }
                else if(opt2.isSelected()){
                    qpaper.given=qpaper.opt[1];
                }
                else if(opt3.isSelected()){
                    qpaper.given=qpaper.opt[2];
                }
                else if(opt4.isSelected()){
                    qpaper.given=qpaper.opt[3];
                }
                generateqp(qpaper.prev);
            }
        });
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                generatemarks();
            }
        });
    }
    public void generatemarks(){
        int res = 0;
        while(qpaper!=null){
            if(qpaper.given.equals(qpaper.ans)){
                res++;
            }
            qpaper = qpaper.next;
        }
        marks = new JLabel(Integer.toString(res)+"/3");
        marks.setFont(new Font("Times New Roman",Font.BOLD,50));
        marks.setBounds(600,300,200,100);
        qpanel.removeAll();
        qpanel.revalidate();
        qpanel.repaint();
        qpanel.add(marks);
        main.add(qpanel);
    }
    public static void main(String[] args) { 
        new ProjectGUI();
    }
}
