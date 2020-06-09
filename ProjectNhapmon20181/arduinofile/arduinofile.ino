#include <Servo.h>
//#include <Arduino_FreeRTOS.h>

int flexNgonCaiin=A1;int flexNgonCaimax=1000;int flexNgonCaimin=900;Servo NgonCai;


int flexNgonTroin=A2;int flexNgonTro1max=1023;int flexNgonTro1min=950;Servo NgonTro;

int flexNgonGiuain=A3;int flexNgonGiua1max=1000;int flexNgonGiua1min=880;Servo NgonGiua;


int flexNgonDeoNhanin=A4;int flexNgonDeoNhan1max=1000;int flexNgonDeoNhan1min=900;Servo NgonDeoNhan;


int flexNgonUtin=A5;int flexNgonUt1max=1023;int flexNgonUt1min=950;Servo NgonUt;
// Khai báo giá trị nhận được từ sensor
double flexNgonCaipos;
double flexNgonTropos;
double flexNgonGiuapos;
double flexNgonDeoNhanpos;
double flexNgonUtpos;

// Khai báo góc quay cua servo
double servoNgonCaipos;
double servoNgonTropos;
double servoNgonGiuapos;
double servoNgonDeoNhanpos;
double servoNgonUtpos;
String s;



void setup() {
  // put your setup code here, to run once:
Serial.begin(9600);
NgonCai.attach(2);
NgonTro.attach(3);
NgonGiua.attach(4);
NgonDeoNhan.attach(5);
NgonUt.attach(6);
NgonCai.write(180);
NgonTro.write(180);
NgonGiua.write(180);
NgonCai.write(180);
NgonUt.write(180);


}

void loop() {
  // Nhan gia tri dong dien
//flexNgonCaipos=analogRead(flexNgonCaiin);
//flexNgonTropos=analogRead(flexNgonTroin);
//flexNgonGiuapos=analogRead(flexNgonGiuain);
//flexNgonDeoNhanpos=analogRead(flexNgonDeoNhanin);
//flexNgonUtpos=analogRead(flexNgonUtin);

 // Chuyen tu gia tri dien sang tin hieu
// servoNgonCaipos=map(flexNgonCaipos,flexNgonCaimin,flexNgonCaimax,0,90);
// servoNgonTropos=map(flexNgonTropos,flexNgonTro1min,flexNgonTro1max,0,90);
// servoNgonGiuapos=map(flexNgonGiuapos,flexNgonGiua1min,flexNgonGiua1max,0,90);
// servoNgonDeoNhanpos=map(flexNgonDeoNhanpos,flexNgonDeoNhan1min,flexNgonDeoNhan1max,0,90);
// servoNgonUtpos=map(flexNgonUtpos,flexNgonUt1min,flexNgonUt1max,0,90);
// Quay dong co
//NgonCai.write(servoNgonCaipos);
//NgonTro.write(servoNgonTropos);
//NgonGiua.write(servoNgonGiuapos);
//NgonDeoNhan.write(servoNgonDeoNhanpos);
//NgonUt.write(servoNgonUtpos);



if(Serial.available()>0)
 {       
       s=Serial.readStringUntil('!');
       Serial.print(s);
//        if(s=="c")
//         {
//           NgonCai.write(45);
//           NgonDeoNhan.write(45);
//           NgonUt.write(45);
//         }
//        if(s=="a")
//         {
//          NgonCai.write(0);
//          NgonDeoNhan.write(0);
//          NgonUt.write(0);
//         }      
       if(s=="d")
       {
        NgonCai.write(180);
        NgonTro.write(180);
        NgonGiua.write(180);
        NgonDeoNhan.write(180);
        NgonUt.write(180);
       }
       if(s=="n")
       {
        NgonCai.write(0);
        NgonTro.write(0);
        NgonGiua.write(0);
        NgonDeoNhan.write(0);
        NgonUt.write(0);
       }
       if(s=="c")
       {
        NgonCai.write(0);
        NgonTro.write(180);
        NgonGiua.write(180);
        NgonDeoNhan.write(0);
        NgonUt.write(0);
       }
       if(s=="h")
       {
        NgonCai.write(180);
        NgonTro.write(180);
        NgonGiua.write(0);
        NgonDeoNhan.write(0);
        NgonUt.write(180);
       }
      
        if(s=="o")
       {
        NgonCai.write(0);
        NgonTro.write(0);
        NgonGiua.write(180);
        NgonDeoNhan.write(180);
        NgonUt.write(180);
       }

        if(s=="l")
       {
        NgonCai.write(180);
        NgonTro.write(0);
        NgonGiua.write(0);
        NgonDeoNhan.write(0);
        NgonUt.write(0);
       }
         
         
      if(s=="nắm tay")
       {
        compare();
       }
       if(s=="open"||s=="thả tay")
       {
        NgonCai.write(180);
        NgonTro.write(180);
        NgonGiua.write(180);
        NgonDeoNhan.write(180);
        NgonUt.write(180);
       }
       if(s=="like")
       {
         NgonCai.write(180);
         NgonTro.write(0);
         NgonGiua.write(0);
         NgonDeoNhan.write(0);
         NgonUt.write(0);
       }
       if(s=="chào")
       {
         NgonCai.write(0);
         NgonTro.write(180);
         NgonGiua.write(180);
         NgonDeoNhan.write(0);
         NgonUt.write(0);
       }
       if(s=="ok")
       {
         NgonCai.write(0);
        NgonTro.write(0);
        NgonGiua.write(180);
        NgonDeoNhan.write(180);
        NgonUt.write(180);
       }
       if(s=="")
       {
          
       }
       
  }
  
 }

 void compare(){
  char s1[10]="nắm tay";
  char s2[10]="open";
  
  for(int i=0; i<10;i++)
  {
    if(s1[i]==s[i]){
       NgonCai.write(0);
        NgonTro.write(0);
        NgonGiua.write(0);
        NgonDeoNhan.write(0);
        NgonUt.write(0);
    }
    else if(s2[i]==s[i]) {
        NgonCai.write(180);
        NgonTro.write(180);
        NgonGiua.write(180);
        NgonDeoNhan.write(180);
        NgonUt.write(180);
    }
  }
}
