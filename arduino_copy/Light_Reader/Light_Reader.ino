/*
 * A simple programme that will change the intensity of
 * an LED based  * on the amount of light incident on 
 * the photo resistor.
 * 
 */

//PhotoResistor Pin
int lightPin = 0; //the analog pin the photoresistor is 
                  //connected to
                  //the photoresistor is not calibrated to any units so
                  //this is simply a raw sensor value (relative light)
//LED Pin
int ledPin = 5;   //the pin the LED is connected to
                  //we are controlling brightness so 
                  //we use one of the PWM (pulse width
                  // modulation pins)

int n;
void setup()
{
  pinMode(ledPin, OUTPUT); //sets the led pin to output
  Serial.begin(9600);
}
 /*
 * loop() - this function will start after setup 
 * finishes and then repeat
 */
void loop()
{
 //PORTD = B00100000;    
 //PORTD = B00000000;
 n = random(0,2);
 //n++;
 if (n == 1){
 digitalWrite(5, HIGH);
 }
 else {
 digitalWrite(5, LOW);
 }
 
 int lightLevel = analogRead(lightPin); //Read the
                                        // lightlevel

 //Serial.println(lightLevel);
 //delay(10);
 
 lightLevel = map(lightLevel, 0, 900, 0, 10); 
         //adjust the value 0 to 900 to
         //span 0 to 255



 lightLevel = constrain(lightLevel, 0, 10);//make sure the 
                                           //value is betwween 
                                           //0 and 255

 Serial.println(lightLevel);
 delay(10); 
 //analogWrite(ledPin, lightLevel);  //write the value
}
