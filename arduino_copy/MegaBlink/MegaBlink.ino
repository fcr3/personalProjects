void setup() { FastPin<13>::setOutput(); } 
void loop() { while(1) {
    FastPin<13>::hi();
    FastPin<13>::lo();
    FastPin<13>::hi();
    FastPin<13>::lo();
    FastPin<13>::hi();
    FastPin<13>::lo();
}}
