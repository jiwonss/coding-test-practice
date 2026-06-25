from math import lcm

def solution(signals):
    processed_signals = [(G, Y, R, G + Y + R) for G, Y, R in signals]
    
    max_time = lcm(*(s[3] for s in processed_signals))
    for t in range(1, max_time + 1):
        check = True
        for G, Y, R, cycle in processed_signals:
            current = (t - 1) % cycle
            if not (G <= current < G + Y):
                check = False
                break
        if check:
            return t 
            
    return -1