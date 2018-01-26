// Example 43.1.1
// tronixstuff.com/tutorials > chapter 43
// John Boxall - October 2011
// Digital 0~7 set to outputs, then on/off using port manipulation
int n1;

void setup()
{
  DDRD = B00100000; // set PORTD (digital 7~0) to outputs
}

void loop()
{
  
  PORTD = B00100000;    
  PORTD = B00000000;
  /*
  n1 = random(0,2);
  if (n1 == 1){
  PORTD = B00100000;    
  PORTD = B00000000;
  } 
  else {
  PORTD = B00000000;
  PORTD = B00100000;       
  }
  */
       
  //delay(1000);

  /*
  n1 = random(0,2);
  if (n1 == 1){
  PORTD = B00100000;    
  PORTD = B00000000;
  } 
  else {
  PORTD = B00000000;
  PORTD = B00100000;       
  }     
  //delay(1000);

  n1 = random(0,2);
  if (n1 == 1){
  PORTD = B00100000;    
  PORTD = B00000000;
  } 
  else {
  PORTD = B00000000;
  PORTD = B00100000;       
  }     
  //delay(1000);

  n1 = random(0,2);
  if (n1 == 1){
  PORTD = B00100000;    
  PORTD = B00000000;
  } 
  else {
  PORTD = B00000000;
  PORTD = B00100000;       
  }     
  //delay(1000);

  n1 = random(0,2);
  if (n1 == 1){
  PORTD = B00100000;    
  PORTD = B00000000;
  } 
  else {
  PORTD = B00000000;
  PORTD = B00100000;       
  }     
  //delay(1000);

  n1 = random(0,2);
  if (n1 == 1){
  PORTD = B00100000;    
  PORTD = B00000000;
  } 
  else {
  PORTD = B00000000;
  PORTD = B00100000;       
  }     
  //delay(1000);

  n1 = random(0,2);
  if (n1 == 1){
  PORTD = B00100000;    
  PORTD = B00000000;
  } 
  else {
  PORTD = B00000000;
  PORTD = B00100000;       
  }     
  //delay(1000);

  n1 = random(0,2);
  if (n1 == 1){
  PORTD = B00100000;    
  PORTD = B00000000;
  } 
  else {
  PORTD = B00000000;
  PORTD = B00100000;       
  }     
  //delay(1000);

  n1 = random(0,2);
  if (n1 == 1){
  PORTD = B00100000;    
  PORTD = B00000000;
  } 
  else {
  PORTD = B00000000;
  PORTD = B00100000;       
  }     
  //delay(1000);
  */ 
  //delay(1000);
}
