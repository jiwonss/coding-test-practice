class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] videoSplit = video_len.split(":");
        int videoTime = Integer.parseInt(videoSplit[0]) * 60 + Integer.parseInt(videoSplit[1]);
        
        String[] opStartSplit = op_start.split(":");
        int opStartTime = Integer.parseInt(opStartSplit[0]) * 60 + Integer.parseInt(opStartSplit[1]);
        String[] opEndSplit = op_end.split(":");
        int opEndTime = Integer.parseInt(opEndSplit[0]) * 60 + Integer.parseInt(opEndSplit[1]);
       
        String[] posSplit = pos.split(":");
        int posTime = Integer.parseInt(posSplit[0]) * 60 + Integer.parseInt(posSplit[1]);
        
        if (posTime >= opStartTime && posTime <= opEndTime) {
            posTime = opEndTime;
        }
        
        for (String command : commands) {
            if (command.equals("prev")) {
                posTime -= 10;
                if (posTime < 0) {
                    posTime = 0;
                }
            }
            if (command.equals("next")) {
                posTime += 10;
                if (posTime > videoTime) {
                    posTime = videoTime;
                }
            }
            if (posTime >= opStartTime && posTime <= opEndTime) {
                posTime = opEndTime;
            }
        }
        
        int div = (int) posTime / 60; int mod = posTime % 60;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", div)).append(":").append(String.format("%02d", mod));
        return sb.toString();
    }
}