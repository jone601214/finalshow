import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class ShootGame  extends JFrame{
    private Container cp;
    private  int count =0;

    private JLabel jlbBackground=new JLabel();  // background
    private JLabel jlbParachute_left=new JLabel(); // parachute_left
    private JLabel jlbParachute_right=new JLabel(); // parachute_right
    private JLabel jlbMissle1=new JLabel(); // missle
    private JLabel jlbMissle2=new JLabel(); // missle
    private JLabel jlbMissle3=new JLabel(); // missle
    private JLabel jlbMissle4=new JLabel(); // missle
    private JLabel jlbMissle5=new JLabel(); // missle
    private JLabel jlbMissle6=new JLabel(); // missle
    private JLabel jlbMissle7=new JLabel(); // missle
    private JLabel jlbMissle8=new JLabel(); // missle
    private JLabel jlbMissle9=new JLabel(); // missle
    private JLabel jlbMissle10=new JLabel(); // missle
    private JLabel jlbboom=new JLabel();//boom
    private JLabel jlbscoreboard=new JLabel("記分板:");
    private JLabel jlbscore=new JLabel("0");
    private boolean flag=false,flag1=false,flag2=false,flag3=false,flag4=false,flag5=false,flag6=false,flag7=false,flag8=false,flag9=false,flag10=false;

    private Random rand = new Random();
    private int xi_m1;
    private int xi_m2;
    private int xi_m3;
    private int xi_m4;
    private int xi_m5;
    private int xi_m6;
    private int xi_m7;
    private int xi_m8;
    private int xi_m9;
    private int xi_m10;
    private int xi_p;
    private int center_xp=0, center_yp=0;
    private int center_xm1=0, center_ym1=0;
    private int center_xm2=0, center_ym2=0;
    private int center_xm3=0, center_ym3=0;
    private int center_xm4=0, center_ym4=0;
    private int center_xm5=0, center_ym5=0;
    private int center_xm6=0, center_ym6=0;
    private int center_xm7=0, center_ym7=0;
    private int center_xm8=0, center_ym8=0;
    private int center_xm9=0, center_ym9=0;
    private int center_xm10=0, center_ym10=0;

    private  Timer t1;
    private  Timer t2;

    private ImageIcon Background=new ImageIcon("thunder.png");
    private ImageIcon imgparachute1=new ImageIcon("parachute_left.png");
    private ImageIcon imgparachute2=new ImageIcon("parachute_right.png");
    private ImageIcon missle1=new ImageIcon("missle.png");
    private ImageIcon missle2=new ImageIcon("missle.png");
    private ImageIcon missle3=new ImageIcon("missle.png");
    private ImageIcon missle4=new ImageIcon("missle.png");
    private ImageIcon missle5=new ImageIcon("missle.png");
    private ImageIcon missle6=new ImageIcon("missle.png");
    private ImageIcon missle7=new ImageIcon("missle.png");
    private ImageIcon missle8=new ImageIcon("missle.png");
    private ImageIcon missle9=new ImageIcon("missle.png");
    private ImageIcon missle10=new ImageIcon("missle.png");
    private ImageIcon boom=new ImageIcon("boom.png");

    private int targetX,targetY;
    private int origX,origY;
    private boolean isobselect=false;

    private AudioClip Bak_music,Boom_Voice;

    public ShootGame() {
        super("跳傘");
        setSize(1000,800);
        Container con=getContentPane();
        con.setLayout(new BorderLayout());

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(300,0,1000,800);
        cp=this.getContentPane();
        cp.setLayout(null);

        URL urlClick_Bak = ShootGame.class.getResource("BM2012.mp3");
        Bak_music = Applet.newAudioClip(urlClick_Bak);
        Bak_music.loop(); // play loop

        URL urlClick_Boom = ShootGame.class.getResource("Boom_Voice.mp3");
        Boom_Voice = Applet.newAudioClip(urlClick_Boom);

        Image img1=imgparachute1.getImage();
        Image img11=img1.getScaledInstance(120,180,Image.SCALE_AREA_AVERAGING);
        imgparachute1.setImage(img11);
        jlbParachute_left.setIcon(imgparachute1);
        jlbParachute_left.setBounds(550,-200,190,187);
        cp.add(jlbParachute_left);

        Image img2=imgparachute2.getImage();
        Image img22=img2.getScaledInstance(120,180,Image.SCALE_AREA_AVERAGING);
        imgparachute2.setImage(img22);
        jlbParachute_right.setIcon(imgparachute2);

        Image img3=missle1.getImage();
        Image img33=img3.getScaledInstance(15,60,Image.SCALE_AREA_AVERAGING);
        jlbMissle1.setIcon(missle1);
        missle1.setImage(img33);
        jlbMissle1.setBounds(350,800,30,60);
        cp.add(jlbMissle1);

        Image img5=missle2.getImage();
        Image img55=img5.getScaledInstance(15,60,Image.SCALE_AREA_AVERAGING);
        jlbMissle2.setIcon(missle2);
        missle2.setImage(img55);
        jlbMissle2.setBounds(350,800,30,60);
        cp.add(jlbMissle2);

        Image img6=missle3.getImage();
        Image img66=img6.getScaledInstance(15,60,Image.SCALE_AREA_AVERAGING);
        jlbMissle3.setIcon(missle3);
        missle3.setImage(img66);
        jlbMissle3.setBounds(350,800,30,60);
        cp.add(jlbMissle3);

        Image img7=missle4.getImage();
        Image img77=img7.getScaledInstance(15,60,Image.SCALE_AREA_AVERAGING);
        jlbMissle4.setIcon(missle4);
        missle4.setImage(img77);
        jlbMissle4.setBounds(350,800,30,60);
        cp.add(jlbMissle4);

        Image img8=missle5.getImage();
        Image img88=img8.getScaledInstance(15,60,Image.SCALE_AREA_AVERAGING);
        jlbMissle5.setIcon(missle5);
        missle5.setImage(img88);
        jlbMissle5.setBounds(350,800,30,60);
        cp.add(jlbMissle5);

        Image img9=missle6.getImage();
        Image img99=img9.getScaledInstance(15,60,Image.SCALE_AREA_AVERAGING);
        jlbMissle6.setIcon(missle6);
        missle6.setImage(img99);
        jlbMissle6.setBounds(350,800,30,60);
        cp.add(jlbMissle6);

        Image img10=missle7.getImage();
        Image img1010=img10.getScaledInstance(15,60,Image.SCALE_AREA_AVERAGING);
        jlbMissle7.setIcon(missle7);
        missle7.setImage(img1010);
        jlbMissle7.setBounds(350,800,30,60);
        cp.add(jlbMissle7);

        Image img11_1=missle8.getImage();
        Image img1111=img11_1.getScaledInstance(15,60,Image.SCALE_AREA_AVERAGING);
        jlbMissle8.setIcon(missle8);
        missle8.setImage(img1111);
        jlbMissle8.setBounds(350,800,30,60);
        cp.add(jlbMissle8);

        Image img12=missle9.getImage();
        Image img1212=img12.getScaledInstance(15,60,Image.SCALE_AREA_AVERAGING);
        jlbMissle9.setIcon(missle9);
        missle9.setImage(img1212);
        jlbMissle9.setBounds(350,800,30,60);
        cp.add(jlbMissle9);

        Image img13=missle10.getImage();
        Image img1313=img13.getScaledInstance(15,60,Image.SCALE_AREA_AVERAGING);
        jlbMissle10.setIcon(missle10);
        missle10.setImage(img1313);
        jlbMissle10.setBounds(350,800,30,60);
        cp.add(jlbMissle10);

        Image img4=boom.getImage();
        Image img44=img4.getScaledInstance(250,250,Image.SCALE_AREA_AVERAGING);
        jlbboom.setIcon(boom);
        boom.setImage(img44);
        cp.add(jlbboom);

        Image imgBack=Background.getImage();
        Image imgBack1=imgBack.getScaledInstance(1000,800,Image.SCALE_AREA_AVERAGING);
        jlbBackground.setIcon(Background);
        Background.setImage(imgBack1);
        jlbBackground.setBounds(0,0,1000,800);

        jlbscoreboard.setBounds(800,20,200,100);
        jlbscoreboard.setFont(new Font("標楷體", Font.BOLD, 25));
        jlbscoreboard.setForeground(Color.white);
        jlbscore.setBounds(900,20,200,100);
        jlbscore.setFont(new Font("標楷體", Font.BOLD, 25));
        jlbscore.setForeground(Color.white);
        cp.add(jlbscoreboard);
        cp.add(jlbscore);
        cp.add(jlbBackground);


        t1=new Timer(50, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jlbMissle1.setLocation(xi_m1,jlbMissle1.getY()-3);
                jlbMissle2.setLocation(xi_m2,jlbMissle2.getY()-2);
                jlbMissle3.setLocation(xi_m3,jlbMissle3.getY()-3);
                jlbMissle4.setLocation(xi_m4,jlbMissle4.getY()-5);
                jlbMissle5.setLocation(xi_m5,jlbMissle5.getY()-5);
                jlbMissle6.setLocation(xi_m6,jlbMissle6.getY()-3);
                jlbMissle7.setLocation(xi_m7,jlbMissle7.getY()-2);
                jlbMissle8.setLocation(xi_m8,jlbMissle8.getY()-3);
                jlbMissle9.setLocation(xi_m9,jlbMissle9.getY()-4);
                jlbMissle10.setLocation(xi_m10,jlbMissle10.getY()-5);

                if (jlbParachute_left.getY()>800){
                    t1.stop();
                    flag1=false;
                    flag2=false;
                    flag3=false;
                    flag4=false;
                    flag5=false;
                    flag6=false;
                    flag7=false;
                    flag8=false;
                    flag9=false;
                    flag10=false;
                }
            }
        });
        t2=new Timer(50, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlbParachute_left.setLocation(jlbParachute_left.getX(),jlbParachute_left.getY()+5);
                center_xp=jlbParachute_left.getX() + jlbParachute_left.getWidth()/2-23;
                center_yp=jlbParachute_left.getY() + jlbParachute_left.getHeight()/2;
                center_xm1=jlbMissle1.getX()+jlbMissle1.getWidth()/2;
                center_ym1=jlbMissle1.getY();
                center_xm2=jlbMissle2.getX()+jlbMissle2.getWidth()/2;
                center_ym2=jlbMissle2.getY();
                center_xm3=jlbMissle3.getX()+jlbMissle3.getWidth()/2;
                center_ym3=jlbMissle3.getY();
                center_xm4=jlbMissle4.getX()+jlbMissle4.getWidth()/2;
                center_ym4=jlbMissle4.getY();
                center_xm5=jlbMissle5.getX()+jlbMissle5.getWidth()/2;
                center_ym5=jlbMissle5.getY();

                center_xm6=jlbMissle6.getX()+jlbMissle6.getWidth()/2;
                center_ym6=jlbMissle6.getY();
                center_xm7=jlbMissle7.getX()+jlbMissle7.getWidth()/2;
                center_ym7=jlbMissle7.getY();
                center_xm8=jlbMissle8.getX()+jlbMissle8.getWidth()/2;
                center_ym8=jlbMissle8.getY();
                center_xm9=jlbMissle9.getX()+jlbMissle9.getWidth()/2;
                center_ym9=jlbMissle9.getY();
                center_xm10=jlbMissle10.getX()+jlbMissle10.getWidth()/2;
                center_ym10=jlbMissle10.getY();

                flag1=Impact(center_xp, center_yp, center_xm1, center_ym1);
                flag2=Impact(center_xp, center_yp, center_xm2, center_ym2);
                flag3=Impact(center_xp, center_yp, center_xm3, center_ym3);
                flag4=Impact(center_xp, center_yp, center_xm4, center_ym4);
                flag5=Impact(center_xp, center_yp, center_xm5, center_ym5);
                flag6=Impact(center_xp, center_yp, center_xm6, center_ym6);
                flag7=Impact(center_xp, center_yp, center_xm7, center_ym7);
                flag8=Impact(center_xp, center_yp, center_xm8, center_ym8);
                flag9=Impact(center_xp, center_yp, center_xm9, center_ym9);
                flag10=Impact(center_xp, center_yp, center_xm10, center_ym10);


                if (flag1||flag2||flag3||flag4||flag5||flag6||flag7||flag8||flag9||flag10 ){
                    jlbboom.setIcon(boom);
                    jlbboom.setBounds(center_xp-140,center_yp-50,300,250);
                    jlbParachute_left.setBounds(350,-200,190,187);
                    jlbParachute_right.setBounds(350,-200,190,187);
                    jlbMissle1.setBounds(350,-200,269,187);
                    jlbMissle2.setBounds(350,-200,269,187);
                    jlbMissle3.setBounds(350,-200,269,187);
                    jlbMissle4.setBounds(350,-200,269,187);
                    jlbMissle5.setBounds(350,-200,269,187);
                    jlbMissle6.setBounds(350,-200,269,187);
                    jlbMissle7.setBounds(350,-200,269,187);
                    jlbMissle8.setBounds(350,-200,269,187);
                    jlbMissle9.setBounds(350,-200,269,187);
                    jlbMissle10.setBounds(350,-200,269,187);
                    t1.stop();
                    t2.stop();
                    Bak_music.stop();
                    Boom_Voice.play();
                    count=0;
                    jlbscore.setText("0");
                    JOptionPane.showMessageDialog(null,"You are dead!  遊戲結束");
                }

                if (jlbParachute_left.getY()>800){
                    t1.stop();
                    t2.stop();
                    flag1=true;
                    flag2=true;
                    flag3=true;
                    flag4=true;
                    flag5=true;
                    flag6=true;
                    flag7=true;
                    flag8=true;
                    flag9=true;
                    flag10=true;
                    count=count+20;
                    jlbscore.setText(Integer.toString(count));

                    // 重置missle的位置
                    jlbMissle1.setBounds(xi_m1,800,30,60);
                    jlbMissle2.setBounds(xi_m2,800,30,60);
                    jlbMissle3.setBounds(xi_m3,800,30,60);
                    jlbMissle4.setBounds(xi_m4,800,30,60);
                    jlbMissle5.setBounds(xi_m5,800,30,60);
                    jlbMissle6.setBounds(xi_m6,800,30,60);
                    jlbMissle7.setBounds(xi_m7,800,30,60);
                    jlbMissle8.setBounds(xi_m8,800,30,60);
                    jlbMissle9.setBounds(xi_m9,800,30,60);
                    jlbMissle10.setBounds(xi_m10,800,30,60);

                    // 更換背景圖檔
                    switch(count){
                        case 0:
                            Background=new ImageIcon("thunder.png");
                            break;
                        case 20:
                            Background=new ImageIcon("Sky1.jpg");
                            break;
                        case 40:
                            Background=new ImageIcon("Sky2.jpg");
                            break;
                        case 60:
                            Background=new ImageIcon("Sky3.jpg");
                            break;
                        case 80:
                            Background=new ImageIcon("Sky4.jpg");
                            break;
                        case 100:
                            Background=new ImageIcon("Sky5.jpg");
                            break;
                    }
                    Image imgBack=Background.getImage();
                    Image imgBack1=imgBack.getScaledInstance(1000,800,Image.SCALE_AREA_AVERAGING);
                    jlbBackground.setIcon(Background);
                    Background.setImage(imgBack1);
                    jlbBackground.setBounds(0,0,1000,800);
                }
                if (count>=100){
                    JOptionPane.showMessageDialog(null," Timeout !  遊戲結束");
                    t1.stop();
                    t2.stop();
                    flag1=false;
                    flag2=false;
                    flag3=false;
                    flag4=false;
                    flag5=false;
                    flag6=false;
                    flag7=false;
                    flag8=false;
                    flag9=false;
                    flag10=false;
                }
            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getExtendedKeyCode());
                switch (e.getKeyCode()){
                    case 37:  // left
                        jlbParachute_left.setIcon(imgparachute1);
                        jlbParachute_left.setLocation(jlbParachute_left.getX()-5,jlbParachute_left.getY());
                        break;
                    case 39: // right
                        jlbParachute_left.setIcon(imgparachute2);
                        jlbParachute_left.setLocation(jlbParachute_left.getX()+5,jlbParachute_left.getY());
                        break;
                    case 90: //  z
                        t1.start();
                        t2.start();
                        xi_m1=rand.nextInt(900)+1;
                        xi_m2=rand.nextInt(900)+1;
                        xi_m3=rand.nextInt(900)+1;
                        xi_m4=rand.nextInt(900)+1;
                        xi_m5=rand.nextInt(900)+1;
                        xi_m6=rand.nextInt(900)+1;
                        xi_m7=rand.nextInt(900)+1;
                        xi_m8=rand.nextInt(900)+1;
                        xi_m9=rand.nextInt(900)+1;
                        xi_m10=rand.nextInt(900)+1;

                        xi_p=rand.nextInt(900)+1;
                        jlbMissle1.setBounds(xi_m1,800,30,60);
                        jlbMissle2.setBounds(xi_m2,800,30,60);
                        jlbMissle3.setBounds(xi_m3,800,30,60);
                        jlbMissle4.setBounds(xi_m4,800,30,60);
                        jlbMissle5.setBounds(xi_m5,800,30,60);
                        jlbMissle6.setBounds(xi_m6,800,30,60);
                        jlbMissle7.setBounds(xi_m7,800,30,60);
                        jlbMissle8.setBounds(xi_m8,800,30,60);
                        jlbMissle9.setBounds(xi_m9,800,30,60);
                        jlbMissle10.setBounds(xi_m10,800,30,60);

                        jlbParachute_left.setBounds(xi_p,-200,190,187);

                        jlbboom.setIcon(null);
                        if (flag){
                            flag=false;
                            flag1=false;
                            flag2=false;
                            flag3=false;
                            flag4=false;
                            flag5=false;
                            flag6=false;
                            flag7=false;
                            flag8=false;
                            flag9=false;
                            flag10=false;
                            Bak_music.loop(); // play loop
                        }
                        break;
                    case 82: // r
                        jlbscore.setText("0");
                        jlbParachute_left.setBounds(350,-200,190,187);
                        jlbMissle1.setBounds(350,800,30,60);
                        jlbMissle2.setBounds(350,800,30,60);
                        jlbMissle3.setBounds(350,800,30,60);
                        jlbMissle4.setBounds(350,800,30,60);
                        jlbMissle5.setBounds(350,800,30,60);
                        jlbMissle6.setBounds(350,800,30,60);
                        jlbMissle7.setBounds(350,800,30,60);
                        jlbMissle8.setBounds(350,800,30,60);
                        jlbMissle9.setBounds(350,800,30,60);
                        jlbMissle10.setBounds(350,800,30,60);

                        jlbboom.setIcon(null);
                        count=0;
                        Bak_music.loop(); // play loop
                        t1.stop();
                        t2.stop();
                }
            }
        });

    }

    static boolean Impact(int xp,int yp, int xm, int ym){
        boolean ImpactFlag=false;
        long dist=1000000;

        System.out.println("xp="+xp+",xm="+xm);
        dist=(xp-xm)*(xp-xm)+(yp-ym)*(yp-ym);

        if (dist <=1500)ImpactFlag=true;

        System.out.println("dist="+dist+",ImpactFlag="+ImpactFlag);
        return ImpactFlag;
    } // End of Impact()
} // End of class ShootGame()