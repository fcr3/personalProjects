int n;
char x;
int y = 0;
int myNums[8];

int m;
int c;
int c1;
int c2;
int lightPin = 0;

void setup() {
  // put your setup code here, to run once:
 Serial.begin(9600);
 pinMode(5, OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(5, HIGH);
  while (Serial.available() > 0){
   x = Serial.read();
   myNums[y] = x;
   y++;
   if ( y == 9){
     y = 0;
     myNums[y] = x;
     y++;
   }
   else if ( y == 8) {
    int z;
    for (z = 0; z < 8; z = z + 1){
     if ( myNums[z] == 'a' ){
      Serial.print("a");
      int myLight[8] = {0,1,1,0,0,0,0,1};
      
      digitalWrite(5, LOW);
      delay(100);
      digitalWrite(5, HIGH);
      c1 = analogRead(lightPin);
      c1 = map(c1, 0, 900, 0, 900);
      c1 = constrain(c1, 0, 900);
      //delay(5);
      digitalWrite(5, LOW);
      //delay(5);
      c2 = analogRead(lightPin);
      c2 = map(c2, 0, 900, 0, 900);
      c2 = constrain(c2, 0, 900);
      c = (c1 + c2) / 2;
      
      int i;
      for (i = 0; i < 8; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(100);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(100);
        }
        
        delay(100);
        int lightLevel = analogRead(lightPin);
        lightLevel = map(lightLevel, 0, 900, 0, 900);
        lightLevel = constrain(lightLevel, 0, 900);
    
        if (lightLevel < c or lightLevel == c){
         Serial.print(1);
        }
        else {
         Serial.print(0);
        } 
      }

      
   
     }
     else if ( myNums[z] == 'b' ) {
      Serial.print("b");
      int myLight[8] = {0,1,1,0,0,0,1,0};

      digitalWrite(5, LOW);
      delay(100);
      digitalWrite(5, HIGH);
      c1 = analogRead(lightPin);
      c1 = map(c1, 0, 900, 0, 900);
      c1 = constrain(c1, 0, 900);
      //delay(5);
      digitalWrite(5, LOW);
      //delay(5);
      c2 = analogRead(lightPin);
      c2 = map(c2, 0, 900, 0, 900);
      c2 = constrain(c2, 0, 900);
      c = (c1 + c2) / 2;
      
      int i;
      for (i = 0; i < 8; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(100);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(100);
        }
        
        delay(100);
        int lightLevel = analogRead(lightPin);
        lightLevel = map(lightLevel, 0, 900, 0, 900);
        lightLevel = constrain(lightLevel, 0, 900);
    
        if (lightLevel < c or lightLevel == c){
         Serial.print(1);
        }
        else {
         Serial.print(0);
        } 
      }
     
     }
     else if ( myNums[z] == 'c' ){
      Serial.print("c");
      int myLight[8] = {0,1,1,0,0,0,1,1};

      digitalWrite(5, LOW);
      delay(100);
      digitalWrite(5, HIGH);
      c1 = analogRead(lightPin);
      c1 = map(c1, 0, 900, 0, 900);
      c1 = constrain(c1, 0, 900);
      //delay(5);
      digitalWrite(5, LOW);
      //delay(5);
      c2 = analogRead(lightPin);
      c2 = map(c2, 0, 900, 0, 900);
      c2 = constrain(c2, 0, 900);
      c = (c1 + c2) / 2;
      
      int i;
      for (i = 0; i < 8; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(100);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(100);
        }
        
        delay(100);
        int lightLevel = analogRead(lightPin);
        lightLevel = map(lightLevel, 0, 900, 0, 900);
        lightLevel = constrain(lightLevel, 0, 900);
    
        if (lightLevel < c or lightLevel == c){
         Serial.print(1);
        }
        else {
         Serial.print(0);
        } 
      }
      Serial.println(" ");
     }
     else if ( myNums[z] == 'd' ){
      Serial.print("d");
      int myLight[8] = {0,1,1,0,0,1,0,0};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     
     else if ( myNums[z] == 'e' ){
      Serial.print("e");
      int myLight[8] = {0,1,1,0,0,1,0,1};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     
     else if ( myNums[z] == 'f' ){
      Serial.print("f");
      int myLight[8] = {0,1,1,0,0,1,1,0};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'g' ){
      Serial.print("g");
      int myLight[8] = {0,1,1,0,0,1,1,1};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'h' ){
      Serial.print("h");
      int myLight[8] = {0,1,1,0,1,0,0,0};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'i' ){
      Serial.print("i");
      int myLight[8] = {0,1,1,0,1,0,0,1};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'j' ){
      Serial.print("j");
      int myLight[8] = {0,1,1,0,1,0,1,0};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'k' ){
      Serial.print("k");
      int myLight[8] = {0,1,1,0,1,0,1,1};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'l' ){
      Serial.print("l");
      int myLight[8] = {0,1,1,0,1,1,0,0};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'm' ){
      Serial.print("m");
      int myLight[8] = {0,1,1,0,1,1,0,1};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'n' ){
      Serial.print("n");
      int myLight[8] = {0,1,1,0,1,1,1,0};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'o' ){
      Serial.print("o");
      int myLight[8] = {0,1,1,0,1,1,1,1};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'p' ){
      Serial.print("p");
      int myLight[8] = {0,1,1,1,0,0,0,0};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'q' ){
      Serial.print("q");
      int myLight[8] = {0,1,1,1,0,0,0,1};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'r' ){
      Serial.print("r");
      int myLight[8] = {0,1,1,1,0,0,1,0};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 's' ){
      Serial.print("s");
      int myLight[8] = {0,1,1,1,0,0,1,1};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 't' ){
      Serial.print("t");
      int myLight[8] = {0,1,1,1,0,1,0,0};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'u' ){
      Serial.print("u");
      int myLight[8] = {0,1,1,1,0,1,0,1};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'v' ){
      Serial.print("v");
      int myLight[8] = {0,1,1,1,0,1,1,0};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'w' ){
      Serial.print("w");
      int myLight[8] = {0,1,1,1,0,1,1,1};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'x' ){
      Serial.print("x");
      int myLight[8] = {0,1,1,1,1,0,0,0};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'y' ){
      Serial.print("y");
      int myLight[8] = {0,1,1,1,1,0,0,1};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else if ( myNums[z] == 'z'){
      Serial.print("z");
      int myLight[8] = {0,1,1,1,1,0,1,0};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
     else {
      Serial.print(" ");
      int myLight[8] = {0,1,0,0,0,0,0,0};
      int i;
      for (i = 0; i < 9; i = i + 1){
        if ( myLight[i] == 1){
          //Serial.print("1");
          digitalWrite(5, HIGH);
          delay(10);
        }
        else {
          //Serial.print("0");
          digitalWrite(5, LOW);
          delay(10);
        }
      }
     }
    }
   Serial.println();
   }
   
  }
}
