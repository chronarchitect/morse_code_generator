import pygame
import time
pygame.init()

ONE_UNIT = 0.25

CODE = {'A': '.-',     'B': '-...',   'C': '-.-.', 
        'D': '-..',    'E': '.',      'F': '..-.',
        'G': '--.',    'H': '....',   'I': '..',
        'J': '.---',   'K': '-.-',    'L': '.-..',
        'M': '--',     'N': '-.',     'O': '---',
        'P': '.--.',   'Q': '--.-',   'R': '.-.',
     	'S': '...',    'T': '-',      'U': '..-',
        'V': '...-',   'W': '.--',    'X': '-..-',
        'Y': '-.--',   'Z': '--..',
        
        '0': '-----',  '1': '.----',  '2': '..---',
        '3': '...--',  '4': '....-',  '5': '.....',
        '6': '-....',  '7': '--...',  '8': '---..',
        '9': '----.' 
        }

def verify(string):
	keys = CODE.keys()
	for char in string:
		if char.upper() not in keys and char != ' ':
			sys.exit('Error the charcter ' + char + ' cannot be translated to Morse Code')

def main():
    msg = input('Enter Message : ')
    verify(msg)

    for char in msg:
        if char == ' ':
            time.sleep(4 * ONE_UNIT)
            print(' ')
        else:
            #print(CODE[char.upper()], end= " ", flush=True)
            for i in CODE[char.upper()]:
                print(i, end='', flush=True)
                if i == '.':
                    pygame.mixer.music.load('dot.wav')
                    pygame.mixer.music.play()
                    time.sleep(2 * ONE_UNIT)
                elif i == '-':
                    pygame.mixer.music.load('dash.wav')
                    pygame.mixer.music.play()
                    time.sleep(4 * ONE_UNIT)
            print(' ', end='', flush=True)
            time.sleep(2 * ONE_UNIT)

if __name__ == '__main__':
    main()
