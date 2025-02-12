def solution(players, callings):
    rank = {p : i for i, p in enumerate(players)}
    for c in callings:
        cur, nxt = rank[c], rank[c] - 1
        rank[players[cur]], rank[players[nxt]] = nxt, cur
        players[cur], players[nxt] = players[nxt], players[cur]
    return players