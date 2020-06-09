#include<Servo.h>
byte Flex = A0;

int flex;
Servo servo1;
void setup() {
  // put your setup code here, to run once:
Serial.begin(9600);
servo1.attach(3,650,2350);
  servo1.write(0);
}

void loop() {
  // put your main code here, to run repeatedly:
flex= analogRead(A0);
int servopos;
servopos = map(flex,1021,1023,0,90);
servopos = constrain (servopos,0,90);
Serial.print("sensor: ");
Serial.print(flex);
Serial.print("  Servo: " );
Serial.println(servopos);
servo1.write(servopos);
delay(1200);
}
