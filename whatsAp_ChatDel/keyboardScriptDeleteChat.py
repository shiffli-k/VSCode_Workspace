import keyboard as kb
import time as tm

def doDelete():
    sleepTimer = 0.1
    counter = 0
    print('Starting | Press q to stop')
    while True:
        if kb.is_pressed('q'):
            print('Stopping Loop')
            break
        counter+=1
        print(f'Looping keyboard inputs {counter} \'th time')
        kb.press_and_release('space')
        tm.sleep(sleepTimer)
        kb.press_and_release('down')
        tm.sleep(sleepTimer)


print('Program started')
countDown = 3
while countDown > 0:
    print(f'Inputs starts in {countDown}')
    countDown-=1
    tm.sleep(1)
doDelete()

