/*
 * File:   newmain.c
 * Author: tranv
 *
 * Created on July 7, 2022, 2:11 PM
 */
#pragma config FOSC = HS 
#pragma config WDTE = OFF 
#pragma config PWRTE = OFF
#pragma config BOREN = ON 
#pragma config LVP = OFF 
#pragma config CPD = OFF 
#pragma config WRT = OFF
#pragma config CP = OFF

#include <xc.h>
#define _XTAL_FREQ 8000000
#include <stdbool.h>
#include <stdio.h>
#include <pic16f887.h>
bool on_off = true;
bool check_auto = true;
ADC_Init(){
    ADCON0 =0x41;
    ADFM = 1;
    VCFG0 = 0;
    VCFG1 = 0;
}

void UART_init(){
    TRISC7 = 1; //RX->input
    TRISC6 = 0; //TX->output
    SPBRG = 51; // F/(16*baudrate)-1
    BRG16 = 0;
    BRGH = 1;// baudrate toc do cao
    SYNC = 0; // che do khong dong bo
    SPEN = 1; // truyen du lieu noi tiep
    CREN = 1;
    TXEN = 1; // cho phep truyen du lieu
    RX9 = 0;
    TX9 = 0; // truyen 8bit
}

float ADC_read(){
    CHS3 = 0;
    CHS2 = 0;
    CHS1 = 0;
    CHS0 = 0;
    ADCON0bits.GO_DONE = 1; // bat dau chuyen doi ADC
    while (ADCON0bits.GO_DONE); //cho chuyen doi ket thuc
    return ((ADRESH << 8) + ADRESL); // return gia tri
}

void UART_sendChar(char bt) 
{
   while (TXIF==0); //lam tre he thong khi bo dem TX dang trong
   TXREG = bt; // ghi gia tri truyen vao thanh ghi TXREG
//   

}
void UART_sendString(char* str) 
{
    while (*str) 
    {
      UART_sendChar(*str++);
    }
}


void Auto(){
     float temp;
    int temp2;
    char temp3[10],*p;
    float value = ADC_read();
    temp = (value*5000)/(1023*10);
    if(temp>30) RB0 = 1;
    else if(temp<30) RB0 = 0;
    temp2 = (int)temp;
    sprintf(temp3, "%d", temp2);
    p = temp3;
    UART_sendString(p);
}

int interup = 0;
void __interrupt() ISR(){
    if(RCIF == 1){
        if(OERR==1){//kiem tra loi tran
           CREN = 0;
           CREN = 1;
        }
        if(RCREG == 'T'){
            T0IE = 1;
            check_auto = true;
        }
        else if(RCREG == 'F'){
            T0IE = 0;
            check_auto = false;
        }
        else if(check_auto == false){
           if(RCREG == '1') on_off = true;
           else if(RCREG == '0') on_off = false;
        }
        RCIF=0;
    }
    if(T0IF == 1){
        TMR0 = 5;
        T0IF = 0;
        interup++;
        if(interup==5000){
           Auto(); 
           interup = 0;
        }
    }
}
void main(void) {
    __delay_ms(3000);
    GIE = 1;  //Ngat toan cuc
    PEIE = 1; //Ngat ngoai vi
    RCIE = 1; // Bat ngat nhan UART
    RCIF = 0; // trang thai thanh ghi rcreg
    
    PSA = 0; // gan Prescaler cho Timer0
    PS2 = 0; 
    PS1 = 1; 
    PS0 = 0; // chon bo chia 8 PS2-PS1
    T0CS = 0;
    T0IF = 0;        
    T0IE = 1; // bat ngat timer0
    
    TRISB = 0;
    TRISD = 0;
    PORTD = 0xff;
    RB0=1;
    UART_init();
    ADC_Init();
    while(1){
        if(check_auto == true){
//            float value = ADC_read();
//            temp = (value*5000)/(1023*10);
////            if(temp>30) RB0 = 1;
////            else if(temp<30) RB0 = 0;
//            temp2 = (int)temp;
//            sprintf(temp3, "%d", temp2);
//            p = temp3;
//            UART_sendString(p);
        }
        else if(check_auto == false){
            if(on_off == true) RB0 = 1;
            else if(on_off == false)RB0 = 0;
        }
    }
    return;
}

