def solution(lottos, win_nums):
    rank = [6, 6, 5, 4, 3, 2, 1]
    
    match_cnt, zero_cnt = 0, lottos.count(0)
    for n in win_nums:
        match_cnt += lottos.count(n)
    return [rank[match_cnt + zero_cnt], rank[match_cnt]]