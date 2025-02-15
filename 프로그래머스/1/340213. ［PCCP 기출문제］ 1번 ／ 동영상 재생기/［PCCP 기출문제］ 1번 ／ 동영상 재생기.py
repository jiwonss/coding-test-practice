def solution(video_len, pos, op_start, op_end, commands):
    video_split = list(map(int, video_len.split(":")))
    video_time = video_split[0] * 60 + video_split[1];
    
    op_split = [list(map(int, op_start.split(":"))), list(map(int, op_end.split(":")))]
    op_start_time = op_split[0][0] * 60 + op_split[0][1]
    op_end_time = op_split[1][0] * 60 + op_split[1][1]
    
    pos_split = list(map(int, pos.split(":")))
    pos_time = pos_split[0] * 60 + pos_split[1];
    
    if op_start_time <= pos_time <= op_end_time:
        pos_time = op_end_time
    
    for command in commands:
        if command == 'prev':
            pos_time -= 10
            if pos_time < 0:
                pos_time = 0
        if command == 'next':
            pos_time += 10
            if pos_time > video_time:
                pos_time = video_time
        if op_start_time <= pos_time <= op_end_time:
            pos_time = op_end_time

    div, mod = map(str, divmod(pos_time, 60))
    return div.zfill(2) + ":" + mod.zfill(2)