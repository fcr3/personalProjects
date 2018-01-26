int m;
int c;
int c1;
int c2;
int lightPin = 0;


void setup() {
  // initialize digital pin 13 as an output.
  pinMode(5, OUTPUT);
  Serial.begin(9600);
}

String bincon(int n) {
  String emp = "";
  while ( n > 0 ) {
    int bt = n % 2;
    emp = String(bt) + emp;
    n = n / 2;
  }
  return emp;
}

// the loop function runs over and over again forever
void loop() {
  //digitalWrite(5, HIGH);
  //digitalWrite(5, LOW);
  
  int dvar = 5; //Controls the delay of flash and read
  digitalWrite(5, HIGH);
  String inp = "";
  String outp = "";
  
  while (Serial.available() > 0){
    //Serial.println("What number do you want?");
    
    m = Serial.read();
    Serial.write(m);
    Serial.println(); // for a new line
    String use = bincon(m);
    
    /*
    int lightSurr = analogRead(lightPin);
    lightSurr = map(lightSurr, 0, 900, 0, 10000);
    lightSurr = constrain(lightSurr, 0, 10000);
    Serial.println(lightSurr);
    */
    for (int i = 0; i < use.length(); i++) {
      digitalWrite(5, LOW);
      delay(dvar);
      digitalWrite(5, HIGH);
      c1 = analogRead(lightPin);
      c1 = map(c1, 0, 900, 0, 900);
      c1 = constrain(c1, 0, 900);
      delay(dvar);
      digitalWrite(5, LOW);
      delay(dvar);
      c2 = analogRead(lightPin);
      c2 = map(c2, 0, 900, 0, 900);
      c2 = constrain(c2, 0, 900);
      c = (c1 + c2) / 2;
      //Serial.println(c);
      
      m = use[i] - 48;
      inp = inp + String(m);
      if (m == 1){
        digitalWrite(5, HIGH);    // turn the LED on (HIGH is the voltage level)
      } 
      else {
        digitalWrite(5, LOW);     // turn the LED off by making the voltage LOW  
      }                        
      
      delay(dvar);
      int lightLevel = analogRead(lightPin);
      lightLevel = map(lightLevel, 0, 900, 0, 900);
      lightLevel = constrain(lightLevel, 0, 900);
      
      //Serial.println(lightLevel);
      if (lightLevel < c or lightLevel == c){
        //Serial.print(1);
        outp = outp + "1";
      }
      else {
        //Serial.print(0);
        outp = outp + "0";
      }
    } //ends for loop
  
    if (Serial.available() == 0) {
         /* Prints useful statements */
        
        Serial.println("Input: " + inp);
        Serial.println("Output: " + outp);
        Serial.print("Same? ");
        if (inp == outp) {
          Serial.println("True");    
        }
        else {
          Serial.println("False");
        }
    }
  
  } //ends serialavailable loop
}
