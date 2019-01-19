/**
 * A morse code to english translator that uses the command line for input
 *                                                                              
 * @author     Wolfe, Conrad
 * @assignment ICS 212 Assignment 15
 * @date       March 13, 2018
 */

#include <stdio.h>  //io stuff
#include <string.h> //used to compare strings
#include <stdlib.h> //used to exit program

#define SIZE 36
#define MIN 2

const char *morseCode[SIZE] = {
    "0 -----",
    "1 .----",
    "2 ..---",
    "3 ...--",
    "4 ....-",
    "5 .....",
    "6 -....",
    "7 --...",
    "8 ---..",
    "9 ----.",
    "a .-",
    "b -...",
    "c -.-.",
    "d -..",
    "e .",
    "f ..-.",
    "g --.",
    "h ....",
    "i ..",
    "j .---",
    "k -.-",
    "l .-..",
    "m --",
    "n -.",
    "o ---",
    "p .--.",
    "q --.-",
    "r .-.",
    "s ...",
    "t -",
    "u ..-",
    "v ...-",
    "w .--",
    "x -..-",
    "y -.--",
    "z --..",
};

int main(int argc, char *argv[]) {
    int i, j;
    //error checking
    if(argc >= MIN){
    //loop through the commandline input (argc)
        for(i = 1; i < argc; i++){
    //loops through j and compares it to the current i
            for(j = 0; j < SIZE; j++){
    //if a match is found, convert Morse Code to letter
                if(!strcmp(argv[i], (morseCode[j] + 2))){
                    printf("%c", morseCode[j][0]);
                }
            }//end j
        }//end i
        printf("\n");
    //error handling
    }else{
        printf("Error: At least 2 commandline arguments are expected, only %i present.\nEnter Morse Code on the commandline.\n", argc);
        exit(EXIT_SUCCESS);
    }
    return 0;
}//end main