def solution(video_len, pos, op_start, op_end, commands):
    video = list(map(int, video_len.split(":")))
    video_time = video[0] * 60 + video[1]
    
    op = list(map(int, op_start.split(":"))) + list(map(int, op_end.split(":")))
    op_start_time, op_end_time = op[0] * 60 + op[1], op[2] * 60 + op[3]

    p = list(map(int, pos.split(":")))
    pos_time = p[0] * 60 + p[1]
    
    idx = 0
    while idx < len(commands):
        if op_start_time <= pos_time <= op_end_time:
            pos_time = op_end_time
        
        command = commands[idx]
        if command == 'prev':
            pos_time -= 10
            if pos_time < 10:
                pos_time = 0
        if command == 'next':
            pos_time += 10
            if pos_time > video_time - 10:
                pos_time = video_time
        idx += 1
        
    if op_start_time <= pos_time <= op_end_time:
            pos_time = op_end_time
            
    div, mod = map(str, divmod(pos_time, 60))
    return div.zfill(2) + ":" + mod.zfill(2)