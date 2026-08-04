def solution(picks, minerals):
    total_picks = sum(picks)
    max_minerals = total_picks * 5
    
    minerals = minerals[:max_minerals]
    
    group = []
    for i in range(0, len(minerals), 5):
        chunk = minerals[i:i + 5]
        group.append([chunk.count("diamond"), chunk.count("iron"), chunk.count("stone")])
        
    group.sort(key = lambda x : (x[0], x[1], x[2]), reverse = True)

    answer = 0
    dia_pick, iron_pick, stone_pick = picks
    for dia, iron, stone in group:
        if dia_pick > 0:
            answer += (dia + iron + stone)
            dia_pick -= 1
        elif iron_pick > 0:
            answer += (dia * 5) + iron + stone
            iron_pick -= 1
        elif stone_pick > 0:
            answer += (dia * 25) + (iron * 5) + stone
            stone_pick -= 1
        else:
            break
    return answer