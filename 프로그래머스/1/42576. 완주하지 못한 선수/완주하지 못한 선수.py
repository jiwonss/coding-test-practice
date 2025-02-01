from collections import defaultdict

def solution(participant, completion):
    player = defaultdict(int)
    for p in participant:
        player[p] += 1
    for c in completion:
        player[c] -= 1
        
    answer = ''
    for k, v in player.items():
        if v != 0:
            answer = k
            break
    return answer
