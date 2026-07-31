package programmers.level1.Day35;

//매 초(1초 단위)마다 뭔가 일이 일어ska — 붕대 감기로 회복하거나, 몬스터한테 공격당하거나.
//공격당한 그 초에는 회복이 안 되고, 연속 성공 카운트가 0으로 리셋
//t초 연속으로 무사히 붕대를 감으면 추가 회복(y)을 받고 카운트도 리셋
//체력은 최대체력을 못 넘음
//체력이 0 이하가 되면 그 즉시 죽음 → -1 리턴

// 여기서 마지막 시간은 2차원 배열의 마지막 인덱스의 첫번째 인덱스, attacks[attacks.length-1][0]

public class 붕대감기 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int result = -1;
        int lastTime = attacks[attacks.length-1][0];
        int startHealth = health; // 초기 hp
        // 붕대시간, 1초당 회복, 추가회복 : 길이 고정 배열
        int castTime = bandage[0]; // 시전시간(t)
        int healPerSec = bandage[1]; // 초당 회복(x)
        int bonusHeal = bandage[2]; // 추가 회복량(y)

        // attack의 인덱스
        int idx = 0;
        int currentCast = 0; // 연속 시전 시간

        // 초기 시간 0은 초기 상태임으로 스킵
        for(int i = 0; i <= lastTime; i++){
            int attackTime = attacks[idx][0];
            int attackDamage = attacks[idx][1];
            // attacks 각 초에 맞게 공격 들어오고, health가 0 이하면 -1 return
            if(attackTime == i){
                health -= attackDamage;
                if(health <= 0){
                    return -1;
                }
                currentCast = 0;
                idx++;
                continue;
            }

            // 연속 성공, 즉 기술 시간의 누적 -> bandage[0] 보다 작으면 ++, 아니면 0으로 초기화 그리고 누적 회복
            currentCast++;
            if(currentCast < castTime){
                health += healPerSec;
                if(health > startHealth){
                    health = startHealth;
                }
            }else if(currentCast >= castTime){
                currentCast = 0; // 연속 시전시간 됐으면 보너스 heal까지
                health += healPerSec + bonusHeal;
                if(health > startHealth){
                    health = startHealth;
                }
            }
        }
        result = health;
        return result;
    }
    public static void main(String[] args){
        붕대감기 s = new 붕대감기();
        System.out.println(s.solution(new int[]{5,1,5}, 30, new int[][]{{2,10},{9,15},{10,5},{11,5}})); //5
        System.out.println(s.solution(new int[]{3,2,7}, 20, new int[][]{{1,15},{5,16},{8,6}})); //-1
        System.out.println(s.solution(new int[]{4,2,7}, 20, new int[][]{{1,15},{5,16},{8,6}})); //-1
        System.out.println(s.solution(new int[]{1,1,1}, 5, new int[][]{{1,2},{3,2}})); //3
    }
}
