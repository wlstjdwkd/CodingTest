class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        int last_time = attacks[attacks.length-1][0]; // 마지막 공격 시간
        int now_h = health; // 현재 체력
        int a_idx = 0; // 공격한 횟수
        int h_idx = 0; // 회복한 횟수
        int si_time = bandage[0]; // 시전 시간
        int healing = bandage[1]; // 초당 회복량
        int b_healing = bandage[2]; // 추가 회복량


        // 마지막 공격까지 시간 흐름 i 는 턴을 의미함
        for (int i = 1; i <= last_time ; i++) {
            // 공격 시간과 턴이 같으면
            if (attacks[a_idx][0] == i){
                now_h -= attacks[a_idx][1]; // 현재 체력에서 공격데미지 차감
                a_idx++; // 공격 횟수 +1
                h_idx = 0; // 시전 횟수 초기화
                // 현재 체력이 0 이하 일 경우 사망
                if (now_h <= 0){
                    return -1;
                }
            }
            // 공격을 당하지 않았을 경우
            else {
                // 현재 체력이 총 체력보다 작으면
                if (now_h < health){
                    h_idx++; // 연속 회복 횟수 +1
                    now_h += healing; // 현재 체력에서 초당 회복량 더하기
                    if (h_idx == si_time){
                        now_h += b_healing;
                        h_idx =0;
                    }
                    if (now_h > health){ // 현재 체력이 총 체력 보다 높을 경우
                        now_h = health; // 현재 체력 총 체력과 같음
                    }
                }
            }
        }
        answer = now_h;


        return answer;
    }
}