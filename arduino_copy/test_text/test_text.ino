String n;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  while (Serial.available() > 0){
    n = Serial.read();
    /*
    if ( n = "a"){
      Serial.print("a");
    }
    else {
        Serial.print("b");
    }
    
    else if ( n = 99){
        Serial.print("c");
    }
    else if ( n = 100){
        Serial.print("d");
    }
    else if ( n = 101){
        Serial.print("e");
    }
    else if ( n = 102){
        Serial.print("f");
    }
    else if ( n = 103){
        Serial.print("g");
    }
    else if ( n = 104){
        Serial.print("h");
    }
    else if ( n = 105){
        Serial.print("i");
    }
    else if ( n = 106){
        Serial.print("j");
    }
    else if ( n = 107){
        Serial.print("k");
    }
    else if ( n = 108){
        Serial.print("l");
    }
    else if ( n = 109){
        Serial.print("m");
    }
    else if ( n = 110){
        Serial.print("n");
    }
    */
    Serial.println(n);
  }
}
