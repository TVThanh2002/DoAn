/*______Ch??ng trình ?i?u khi?n ?èn giao thông
 * Ng??i th?c hi?n:     Tr?n V?n Thanh
 * L?p:                    20CE
 * GVHD:                Nguy?n V? Anh Quang
 */
// PIC18F4550 Configuration Bit Settings

// 'C' source line config statements

// CONFIG1L
#pragma config PLLDIV = 1       // PLL Prescaler Selection bits (No prescale (4 MHz oscillator input drives PLL directly))
#pragma config CPUDIV = OSC1_PLL2// System Clock Postscaler Selection bits ([Primary Oscillator Src: /1][96 MHz PLL Src: /2])
#pragma config USBDIV = 1       // USB Clock Selection bit (used in Full-Speed USB mode only; UCFG:FSEN = 1) (USB clock source comes directly from the primary oscillator block with no postscale)

// CONFIG1H
#pragma config FOSC = INTOSC_EC // Oscillator Selection bits (Internal oscillator, CLKO function on RA6, EC used by USB (INTCKO))
#pragma config FCMEN = OFF      // Fail-Safe Clock Monitor Enable bit (Fail-Safe Clock Monitor disabled)
#pragma config IESO = OFF       // Internal/External Oscillator Switchover bit (Oscillator Switchover mode disabled)

// CONFIG2L
#pragma config PWRT = OFF       // Power-up Timer Enable bit (PWRT disabled)
#pragma config BOR = ON         // Brown-out Reset Enable bits (Brown-out Reset enabled in hardware only (SBOREN is disabled))
#pragma config BORV = 3         // Brown-out Reset Voltage bits (Minimum setting 2.05V)
#pragma config VREGEN = OFF     // USB Voltage Regulator Enable bit (USB voltage regulator disabled)

// CONFIG2H
#pragma config WDT = OFF        // Watchdog Timer Enable bit (WDT disabled (control is placed on the SWDTEN bit))
#pragma config WDTPS = 32768    // Watchdog Timer Postscale Select bits (1:32768)

// CONFIG3H
#pragma config CCP2MX = ON      // CCP2 MUX bit (CCP2 input/output is multiplexed with RC1)
#pragma config PBADEN = OFF     // PORTB A/D Enable bit (PORTB<4:0> pins are configured as digital I/O on Reset)
#pragma config LPT1OSC = OFF    // Low-Power Timer 1 Oscillator Enable bit (Timer1 configured for higher power operation)
#pragma config MCLRE = ON       // MCLR Pin Enable bit (MCLR pin enabled; RE3 input pin disabled)

// CONFIG4L
#pragma config STVREN = ON      // Stack Full/Underflow Reset Enable bit (Stack full/underflow will cause Reset)
#pragma config LVP = ON         // Single-Supply ICSP Enable bit (Single-Supply ICSP enabled)
#pragma config ICPRT = OFF      // Dedicated In-Circuit Debug/Programming Port (ICPORT) Enable bit (ICPORT disabled)
#pragma config XINST = OFF      // Extended Instruction Set Enable bit (Instruction set extension and Indexed Addressing mode disabled (Legacy mode))

// CONFIG5L
#pragma config CP0 = OFF        // Code Protection bit (Block 0 (000800-001FFFh) is not code-protected)
#pragma config CP1 = OFF        // Code Protection bit (Block 1 (002000-003FFFh) is not code-protected)
#pragma config CP2 = OFF        // Code Protection bit (Block 2 (004000-005FFFh) is not code-protected)
#pragma config CP3 = OFF        // Code Protection bit (Block 3 (006000-007FFFh) is not code-protected)

// CONFIG5H
#pragma config CPB = OFF        // Boot Block Code Protection bit (Boot block (000000-0007FFh) is not code-protected)
#pragma config CPD = OFF        // Data EEPROM Code Protection bit (Data EEPROM is not code-protected)

// CONFIG6L
#pragma config WRT0 = OFF       // Write Protection bit (Block 0 (000800-001FFFh) is not write-protected)
#pragma config WRT1 = OFF       // Write Protection bit (Block 1 (002000-003FFFh) is not write-protected)
#pragma config WRT2 = OFF       // Write Protection bit (Block 2 (004000-005FFFh) is not write-protected)
#pragma config WRT3 = OFF       // Write Protection bit (Block 3 (006000-007FFFh) is not write-protected)

// CONFIG6H
#pragma config WRTC = OFF       // Configuration Register Write Protection bit (Configuration registers (300000-3000FFh) are not write-protected)
#pragma config WRTB = OFF       // Boot Block Write Protection bit (Boot block (000000-0007FFh) is not write-protected)
#pragma config WRTD = OFF       // Data EEPROM Write Protection bit (Data EEPROM is not write-protected)

// CONFIG7L
#pragma config EBTR0 = OFF      // Table Read Protection bit (Block 0 (000800-001FFFh) is not protected from table reads executed in other blocks)
#pragma config EBTR1 = OFF      // Table Read Protection bit (Block 1 (002000-003FFFh) is not protected from table reads executed in other blocks)
#pragma config EBTR2 = OFF      // Table Read Protection bit (Block 2 (004000-005FFFh) is not protected from table reads executed in other blocks)
#pragma config EBTR3 = OFF      // Table Read Protection bit (Block 3 (006000-007FFFh) is not protected from table reads executed in other blocks)

// CONFIG7H
#pragma config EBTRB = OFF      // Boot Block Table Read Protection bit (Boot block (000000-0007FFh) is not protected from table reads executed in other blocks)

// #pragma config statements should precede project file includes.
// Use project enums instead of #define for ON and OFF.


#define _XTAL_FREQ 4000000
//#include <stdio.h>
//#include <stdint.h>
#include <xc.h>
//#include <pic18f4550.h>
//#include "I2C.h"
//#define device_id_write 0xD0
//#define device_id_read 0xD1

unsigned char rtc1307_read(unsigned char address);
unsigned char BCD2UpperCh(unsigned char bcd);
unsigned char BCD2LowerCh(unsigned char bcd);
void I2C_Start(void);
void I2C_Restart(void);
void I2C_Stop(void);
void I2C_Wait(void);
void I2C_Send(unsigned char dat);
unsigned char I2C_Read(void);
unsigned char giay,phut,gio;
//void RTC_Read_Clock(char read_clock_address){
//    I2C_Start(device_id_write);
//    I2C_Write(read_clock_address);
//    I2C_Repeated_Start(device_id_read);
//    giay = I2C_Read(0);
//    phut = I2C_Read(0);
//    gio = I2C_Read(1);
//}

int main(){
    //char giays[10],phut[10],gios[10];
    char Clock_type = 0x06;
    char AM_PM = 0x05;
    OSCCON = 0x72;
//    I2C_Init();
    TRISB |= 0x03;
	SSPSTAT |= 0x80; //Slew Rate Disabled
	SSPADD = 119;
	
	SSPCON1 = 0b00101000;			//Master mode
	SSPADD = 119;
//...................................... 
    char a[] = {0xC0,0xF9,0xA4,0xB0,0x99,0x92,0x82,0xF8,0x80,0x90};
    TRISA = 0xFF;
    TRISD = 0;
    TRISB2 = 0;
    TRISB3 = 0;
    TRISB4 = 0;
    TRISB5 = 0;    
    TRISC = 0;
    TRISB0 = 1;
    TRISB1 = 1;
    PORTB=0x00; 
    RA1=RA0=1;
    
       
    while(1){ 
        //Che do ban ngay
            int setmau=1;
            while(1){
                giay = rtc1307_read(0x00);
                phut = rtc1307_read(0x01);
                gio = rtc1307_read(0x02);
                int chuc = gio >> 4;
                int donvi = gio & (0x0F);
                int gios = chuc * 10 + donvi;
                
                
                
                if(gios==22||gios==23||gios==0||gios==1||gios==2||gios==3||gios==4){
                    break;
                }
                
                if(setmau>10){
                    setmau=1;
                }else{
                    setmau++;
                }                
                int dem,i,dem1,sodu1,dem2,sodu2;
                int mau2 = setmau%2;
                if(mau2==0){
                    RC0=1;
                    RC6=1;
                    for(dem=10;dem>=0;dem--){
                    dem1= dem/10;
                    sodu1= dem%10;
                    dem2 = (dem-3)/10;
                    sodu2 = (dem-3)%10;
                        for(i=0;i<40;i++){
                            // quet den do
                            RB2=1;
                            PORTD = a[dem1];
                            __delay_ms(10);
                            RB2=0;
                            RB3=1;
                            PORTD = a[sodu1];
                            __delay_ms(10);
                            RB3=0;
                            //quet den xanh
                            if(dem>3){
                                RB4=1;
                                PORTD = a[dem2];
                                __delay_ms(10);
                                RB4=0;
                                RB5=1;
                                PORTD = a[sodu2];
                                __delay_ms(10);
                                RB5=0;
                            }else{                               
                                RC6 = 0;
                                RC5 = 1;
                                __delay_ms(10);
                            }
                            
                        }
                    }                     
                }
                if(mau2==1){
                    for(dem=10;dem>=0;dem--){
                        dem1= dem/10;
                        sodu1= dem%10;
                        dem2 = (dem-3)/10;
                        sodu2 = (dem-3)%10;
                        RC2=1;
                        RC4=1;
                        for(i=0;i<40;i++){
                            // quet den do
                            RB4=1;
                            PORTD = a[dem1];
                            __delay_ms(10);
                            RB4=0;
                            RB5=1;
                            PORTD = a[sodu1];
                            __delay_ms(10);
                            RB5=0;
                            //quet den xanh
                            if(dem>3){
                                RB2=1;
                                PORTD = a[dem2];
                                __delay_ms(10);
                                RB2=0;
                                RB3=1;
                                PORTD = a[sodu2];
                                __delay_ms(10);
                                RB3=0;
                            }else{
                               
                                RC2 = 0;
                                RC1 = 1;
                                __delay_ms(10);
                            }
                            
                        }
                    }    
                }
                PORTC = 0x00;                
            }  
            
            //che do ban dem
            while(1){
                giay = rtc1307_read(0x00);
                phut = rtc1307_read(0x01);
                gio = rtc1307_read(0x02);
                int chuc = gio >> 4;
                int donvi = gio & (0x0F);
                int gios = chuc * 10 + donvi;
                if(gios==5||gios==6||gios==7||gios==8||gios==9||gios==10||gios==11||gios==12||gios==13||gios==14||gios==15||gios==16||gios==17||gios==18||gios==19||gios==20||gios==21){
                    break;
                }
                RC1 = RC5 = 1;
                __delay_ms(1000);    
                RC1 = RC5 = 0;
                __delay_ms(1000);
                
            }
    }
    return 0;   
}
/****************RTC FUNCTIONS*****************/
unsigned char BCD2UpperCh(unsigned char bcd)
{
	unsigned char temp;
 	temp = bcd >> 4;
 	temp = temp | 0x30;
 	return(temp);	
}
unsigned char BCD2LowerCh(unsigned char bcd)
{
	unsigned char temp;
 	temp = bcd & 0x0F; //Making the Upper 4-bits
 	temp = temp | 0x30;
 	return(temp);
}


/****************I2C-Library*******************/

unsigned char rtc1307_read(unsigned char address)
{
	unsigned char temp;
	I2C_Start();
	I2C_Send(0xD0);
	I2C_Send(address);
	I2C_Restart();
	I2C_Send(0xD1);
	temp = I2C_Read();
	I2C_Stop();	//this line is Removed Because it is already included in I2C_read function
	return temp;
}
void I2C_Start(void)
{
	SSPCON2bits.SEN = 1;
	//SSPCON2 bit 0
	while (SSPCON2bits.SEN == 1)
		continue;
	//SEN =1 initiate the Start Condition on SDA and SCL Pins
	//Automatically Cleared by Hardwre
	// 0 for Idle State
}

void I2C_Restart(void)
{
	SSPCON2bits.RSEN = 1;
	//SSPCON2 bit 1
	while (SSPCON2bits.RSEN == 1)
		continue;
	//RSEN = 1 initiate the Restart Condition
	//Automatically Cleared by Hardware
}

void I2C_Stop(void)
{
	SSPCON2bits.PEN=1;
	while(SSPCON2bits.PEN==1)
		continue;
}

void I2C_Wait(void)
{
	while(SSPSTATbits.R_NOT_W == 1)
		continue;
	if(SSPCON2bits.ACKSTAT == 1)
	{
		I2C_Stop();
	}
	//If ACKSTAT bit is 0 Acknowledgment Received Successfully
	//Otherwise Not
}

void I2C_Send(unsigned char dat)
{
	SSPBUF = dat;    /* Move data to SSPBUF */
    while(SSPSTATbits.BF);       /* wait till complete data is sent from buffer */
    I2C_Wait();       /* wait for any pending transfer */
}

unsigned char I2C_Read(void)
{
	unsigned char temp;
    SSPCON2bits.RCEN = 1;        /* Enable data reception */
    while(SSPSTATbits.BF == 0)      /* wait for buffer full */
    	continue;
    temp = SSPBUF;   /* Read serial buffer and store in temp register */
    I2C_Wait();       /* wait to check any pending transfer */
    SSPCON2bits.ACKDT=1;				//send not acknowledge
	SSPCON2bits.ACKEN=1;
	while(SSPCON2bits.ACKEN == 1) 
		continue;
	//I2C_Stop();
    return temp;     /* Return the read data from bus */
}