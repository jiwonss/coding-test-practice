def solution(N, stages):
    stage_info = {i : 0 for i in range(1, N + 1)}
    for stage in stages:
        if stage == N + 1:
            continue
        stage_info[stage] += 1

    result = []
    player = len(stages)
    for k, v in stage_info.items():
        if v == 0:
            result.append([k, 0])
        else:
            result.append([k, v / player])
        player -= v
        
    answer = []
    for k, v in sorted(result, key=lambda x : (-x[1], x[0])):
        answer.append(k)
    return answer